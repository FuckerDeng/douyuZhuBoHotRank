package df;

import df.task.StasticsTask;
import df.utils.MyUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalTime;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    private final static Logger LOGGER = LogManager.getLogger(App.class);
    public static void main(String[] args) {

        //获取所有大分组：网游竞技，单机热游等，“正能量” 大分组舍弃了，感觉这个分组里也没啥热度，不统计了
        ArrayList<String > youxiFenLei = getFenLeiUrl();
        Timer timer = new Timer();
        TimerTask task = new StasticsTask(youxiFenLei);

//        程序运行后计算开始统计的时间点
        LocalTime now = LocalTime.now();
        int minutes = now.getMinute();
        int seconds = now.getSecond();

        int delay = 0;
        int fen = 0;
        if(minutes<20){
            fen = 20-minutes-1;
            delay = fen*60+ (60-seconds);
        }else {
            fen  = 20-minutes%20 -1;
            delay = fen*60+ (60-seconds);
        }
        LOGGER.info("数据统计将在  "+ fen +"  分  "+(60-seconds) +"  秒后开始,每隔20min统计一次。。。");
//        每隔20min统计一次，每个小时的0，20，40处进行统计
        timer.schedule(task,delay*1000,20*60*1000);
//        timer.schedule(task,5000,180000);

        Properties config = new Properties();
        String daysStr = "-";
        int days  = 30;
        String configPath = System.getProperty("user.dir")+ File.separator+"config"+File.separator+"config.properties";
        try {
            config.load(new FileInputStream(new File(configPath)));
            daysStr = config.getProperty("StasticsDays");
            try {
                days = Integer.valueOf(daysStr);
            }catch (Exception e){
                LOGGER.error("配置的天数不正确，请重新配置！");
                System.exit(-1);
                e.printStackTrace();
            }

        }catch (Exception e){
            LOGGER.error("统计天数的配置文件不存在，默认统计30天。");
            e.printStackTrace();
        }





        long start = System.currentTimeMillis();
        long end = 0;
        while (true){
            if(config.getProperty("StasticsDays").equals("-999")){
                MyUtils.dengdeng(10 * 60* 1000);
                continue;
            }
            end = System.currentTimeMillis();
            long gone = end-start;
            if(gone>days*24*60*60*1000){
                while (true){
                    if(StasticsTask.begin){
                        MyUtils.dengdeng(1000);
                        continue;
                    }else {
                        timer.cancel();
                        break;
                    }
                }
                break;
            }

            MyUtils.dengdeng(10 * 60* 1000);
        }
    }

    //获取所有大分组：网游竞技，单机热游等，“正能量” 大分组舍弃了，感觉这个分组里也没啥热度，不统计了
    public static ArrayList<String> getFenLeiUrl(){
        LOGGER.info("开始获取游戏分类Url，网游竞技，单机热游等，“正能量” 大分组舍弃了...");
        String startUrl = "https://www.douyu.com/directory/all";
        String html = MyUtils.getHtml(startUrl);
        Document d = Jsoup.parse(html);
        Elements elements = d.select(".Aside-view > .Aside-menu > .Aside-menu-block");
        elements.remove(elements.size()-1);

        ArrayList<String > youxiFenLei = new ArrayList<>();
        elements.stream().forEach(element -> {
            // /directory?shortName=PCgame
            String grouUrl = element.select(".Aside-menu-head > .Aside-menu-whole").get(0).attr("href");
            youxiFenLei.add("https://www.douyu.com"+grouUrl);

        });
        return youxiFenLei;
    }

}
