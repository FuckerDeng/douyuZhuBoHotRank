package df.task;


import df.dao.Dao;
import df.dao.mapper.GrouphotvalueMapper;
import df.dao.mapper.GroupinfoMapper;
import df.dao.mapper.RoomhotvalueMapper;
import df.dao.mapper.RoominfoMapper;
import df.manager.StasticsManager;
import df.structures.BigGroup;
import df.structures.LiveRoom;
import df.utils.MyUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TimerTask;

public class StasticsTask extends TimerTask {
    private Logger logger = LogManager.getLogger(StasticsTask.class);
    ArrayList<String > youxiFenLei = new ArrayList<>();
    public static volatile boolean begin = false;
    private int tian = 1;
    private int ci = 1;
    public StasticsTask() {
    }

    public StasticsTask(ArrayList<String> youxiFenLei) {
        this.youxiFenLei = youxiFenLei;
    }

    public ArrayList<String> getYouxiFenLei() {
        return youxiFenLei;
    }

    public void setYouxiFenLei(ArrayList<String> youxiFenLei) {
        this.youxiFenLei = youxiFenLei;
    }

    @Override
    public void run() {
        begin = true;
        long start = System.currentTimeMillis();
        logger.info("=================================================");
        logger.info(String.format("第  %d  天第  %d  次开始统计。。",tian,ci ));
        ci +=1;
        LocalTime xianzai = LocalTime.now();
        if(xianzai.getHour() == 0 && xianzai.getMinute()<3){
            tian +=1;
            ci = 1;
        }
        logger.info("开始获取游戏详细分类Url，英雄联盟，绝地求生等...");
        ArrayList<BigGroup> allGroups = getAllGroups();

        if(allGroups.size()==0){
            return;
        }
        logger.info("开始统计每个详细分类下的热度前50名...");
        ArrayList<LiveRoom> roomList = new ArrayList<>();
        //统计每个详细分类下前50个热度直播间
        getAllRoomInfo(allGroups,roomList);

        //将分类信息放入统计类中
        for(BigGroup big:allGroups){
            StasticsManager.allGroups.put(big.getName(),big);
        }
        //将房间信息放入统计类中
        ArrayList<LiveRoom> newRoom = new ArrayList<>();
        for( LiveRoom room : roomList){
            //如果之前统计的房间信息中没有，则把新的在放入一个集合中进行存库
            if(!StasticsManager.tongjiRooms.containsKey(new Integer(room.getRoomId()))){
                newRoom.add(room);
            }
            StasticsManager.tongjiRooms.put(new Integer(room.getRoomId()),room);

        }

        long end = System.currentTimeMillis();
        logger.info("分类信息和每个分类前50名房间信息获取完成。用时： "+(end-start)/1000+"  秒！");

        logger.info("统计信息开始入库！");
        long dbStart = System.currentTimeMillis();
        SqlSession sqlSession= Dao.getSqlSession();

        saveGroupInfo(sqlSession,allGroups);
        saveGroupHotValue(sqlSession,allGroups);
        saveRoomInfo(sqlSession,roomList,newRoom);
        updateRoomStasticsCount(sqlSession,roomList);
        saveRoomHotValue(sqlSession);

        sqlSession.close();

        begin = false;
        long dbEnd = System.currentTimeMillis();
        logger.info("数据入库完成。用时： "+(dbEnd-dbStart)/1000+"  秒！");
        StasticsManager.StasticsCount +=1;
        logger.info("已统计  "+StasticsManager.StasticsCount +"  次！");

        //打印前10的房间
        roomList.sort(new Comparator<LiveRoom>() {
            @Override
            public int compare(LiveRoom o1, LiveRoom o2) {
                int result = o2.getHotValue()-o1.getHotValue();
                if(result>0){
                    return 1;
                }else if(result==0){
                    return 0;
                }else {
                    return -1;
                }
            }
        });
        logger.info("此次统计热度前10名的房间如下：");
        for(int i=0;i<10;i++){
            logger.info("第  "+(i+1)+"  名："+roomList.get(i));
        }
    }

    private void updateRoomStasticsCount(SqlSession sqlSession, ArrayList<LiveRoom> roomList) {
        try {
            RoominfoMapper roominfoMapper = sqlSession.getMapper(RoominfoMapper.class);
            roominfoMapper.updateBatch(roomList);
            sqlSession.commit();
            logger.info("房间热度统计次数更新完成！");
        }catch (Exception e){
            sqlSession.rollback();
            logger.error("第  "+StasticsManager.StasticsCount+"  次房间热度统计次数入库失败！");
            logger.error("",e);

        }
    }

    private void saveRoomHotValue(SqlSession sqlSession) {
        try {
            RoomhotvalueMapper roomhotvalueMapper = sqlSession.getMapper(RoomhotvalueMapper.class);
            roomhotvalueMapper.insertBatch(new ArrayList<LiveRoom>(StasticsManager.tongjiRooms.values()));
            sqlSession.commit();
            logger.info("房间热度信息入库完成！");
        }catch (Exception e){
            sqlSession.rollback();
            logger.error("第  "+StasticsManager.StasticsCount+"  次房间热度信息入库失败！");
            logger.error("",e);

        }

    }

    private void saveRoomInfo(SqlSession sqlSession, ArrayList<LiveRoom> roomList, ArrayList<LiveRoom> newRoom) {
        try {
            logger.info("新增加的房间数量为：  "+newRoom.size());
            RoominfoMapper roominfoMapper = sqlSession.getMapper(RoominfoMapper.class);
            if(StasticsManager.StasticsCount == 0){
                roominfoMapper.insertBatch(roomList);
            }else if(newRoom.size()>0){
                roominfoMapper.insertBatch(newRoom);
            }
            sqlSession.commit();
            logger.info("房间信息入库完成！");
        }catch (Exception e){
            sqlSession.rollback();
            logger.error("第  "+StasticsManager.StasticsCount+"  次房间信息入库失败！");
            logger.error("",e);

        }
    }

    private void saveGroupHotValue(SqlSession sqlSession, ArrayList<BigGroup> allGroups) {
        try {
            GrouphotvalueMapper grouphotvalueMapper = sqlSession.getMapper(GrouphotvalueMapper.class);
            grouphotvalueMapper.insertBatch(allGroups);
            sqlSession.commit();
            logger.info("分类信息热度入库完成！");
        }catch (Exception e){
            sqlSession.rollback();
            logger.error("第  "+StasticsManager.StasticsCount+"  次分类信息热度入库失败！");
            logger.error("",e);
        }

    }

    private void saveGroupInfo(SqlSession sqlSession,ArrayList<BigGroup> allGroups) {
        try {
            if(!StasticsManager.groupIsSaved){
                GroupinfoMapper groupinfoMapper = sqlSession.getMapper(GroupinfoMapper.class);
                groupinfoMapper.insertBatch(allGroups);
                sqlSession.commit();
                StasticsManager.groupIsSaved = true;
                logger.info("分类信息入库完成！");
            }
        }catch (Exception e){
            sqlSession.rollback();
            logger.error("第  "+StasticsManager.StasticsCount+"  次分类信息入库失败！");
            logger.error("",e);
        }

    }

    //统计游戏详细分类Url，英雄联盟，绝地求生等...
    public ArrayList<BigGroup> getAllGroups(){
        ArrayList<BigGroup> allGroups = new ArrayList<>();
        for(String fenleiUrl:youxiFenLei){
            MyUtils.dengdeng(100);
            String groupHtml = MyUtils.getHtml(fenleiUrl);
            if(groupHtml.equals("")){
                logger.error("详细分类Url获取异常，网页文本未正常获取！");
                return allGroups;

            }
            Document groupDocument = Jsoup.parse(groupHtml);
            Elements lis = groupDocument.select(".layout-Classify-list> li");
            lis.stream().forEach(li ->{
                String litGroupUrl = "https://www.douyu.com"+li.select("a").get(0).attr("href");
//                System.out.println(litGroupUrl);
                String iconUrl = li.select("a img").get(0).attr("src");
                String name = li.select("a > strong").get(0).text();
                String hot = li.select("a > div > span").get(0).text();
                int hotValue = 0;
                if(hot.contains("万")){
                    hotValue = (int)Float.parseFloat(hot.substring(0, hot.length() - 1)) * 10000;
                }else {
                    if(hot.equals("")){
                        hotValue = 0;
                    }else {
                        hotValue = Integer.parseInt(hot);
                    }
                }

                BigGroup bigGroup = new BigGroup(name,iconUrl,litGroupUrl,hotValue);
                allGroups.add(bigGroup);

            });
        }
        return allGroups;
    }

    //统计每个详细分类下的热度前50名..
    public void getAllRoomInfo(ArrayList<BigGroup> allGroups,ArrayList<LiveRoom> tongjiRooms){
        HashSet<Integer> allRoomIds = new HashSet<>();
        for(BigGroup g:allGroups){
            MyUtils.dengdeng(100);
            //获取当前分类下第一页的所有房间信息
            String roomHtml = MyUtils.getHtml(g.getGrouUrl());
            if(roomHtml.equals("")){
                logger.error(g.getName()+"  获取页面异常，无法获取此分类下的房间热度");
                continue;
            }
            Document roomDocument = Jsoup.parse(roomHtml);
            Elements roomLis = roomDocument.select(".layout-Cover-list > li");
            ArrayList<LiveRoom> liveRooms = new ArrayList<>();
            for(Element li : roomLis){
                String href = li.select("div > a").first().attr("href");
                String roomUrl = "https://www.douyu.com"+href;
                int roomId = 0;
                try {
                    roomId = Integer.parseInt(href.substring(1));
                }catch (Exception e){
                    logger.error(g.getName()+"  获取房间ID失败："+roomUrl);
                    continue;
                }

                String roomType = g.getName();
                String hotStr = li.select("div > a > .DyListCover-content > div > .DyListCover-hot").text();
                int roomHot = 0;
                if(hotStr.contains("万")){
                    roomHot = (int)Float.parseFloat(hotStr.substring(0, hotStr.length() - 1)) * 10000;
                }else {
                    roomHot = Integer.parseInt(hotStr);
                }
                String zbName = li.select("div > a > .DyListCover-content > div > .DyListCover-user").text();
                liveRooms.add(new LiveRoom(zbName,roomUrl,roomId,roomHot,roomType));
            }
            logger.info(g.getName()+"  分类下的房间热度获取完成。。。");

            //对获取到的房间信息按热度从大到小排序
            liveRooms.sort(new Comparator<LiveRoom>() {
                @Override
                public int compare(LiveRoom o1, LiveRoom o2) {
                    if(o2.getHotValue()>o1.getHotValue()){
                        return 1;
                    }else if(o2.getHotValue()==o1.getHotValue()){
                        return 0;
                    }else {
                        return -1;
                    }
                }
            });
            //如果这分类下的房间数小于50个，则全部放进统计集合中，如果大于50个，则只要热度最高的50个房间
            int size = liveRooms.size()<50?liveRooms.size():50;
//            统计集合中没有数据时，直接把排名靠前的加进去
            if(tongjiRooms.size()==0){
                for(int i = 0;i<size;i++){
                    LiveRoom r = liveRooms.get(i);
                    tongjiRooms.add(r);
                    allRoomIds.add(r.getRoomId());
                }
            }
            //统计集合中有数据时，需要
            //检查下roomId是否有重复的，有的话就不加入，因为有些官方直播间再不同的游戏分类下都有，比如暴雪的直播间在
            //炉石传说和风暴英雄分类下都有
            for(int i =0;i<size;i++){
                LiveRoom newRoom = liveRooms.get(i);
                if(!allRoomIds.contains(newRoom.getRoomId())){
                    tongjiRooms.add(newRoom);
                    allRoomIds.add(newRoom.getRoomId());
                }
            }


        }

    }
}
