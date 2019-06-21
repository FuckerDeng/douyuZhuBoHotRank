package df.manager;

import df.structures.BigGroup;
import df.structures.LiveRoom;

import java.util.HashMap;

public class StasticsManager {
    public static int StasticsCount = 0;
    public static boolean groupIsSaved = false;
    //所有的详细分类信息
    public static HashMap<String, BigGroup> allGroups = new HashMap<String, df.structures.BigGroup>();

    //所有房间的详细信息
    public static HashMap<Integer, LiveRoom> tongjiRooms = new HashMap<Integer, df.structures.LiveRoom>();

    //所有房间的热度统计次数
    public static HashMap<Integer,Integer> roomStasticsCount = new HashMap<>();

    public static int groupSize(){
        return allGroups.size();
    }

    public static int roomSize(){
        return tongjiRooms.size();
    }
}
