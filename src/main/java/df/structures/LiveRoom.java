package df.structures;

public class LiveRoom {
    private String zbName;
    private String roomUrl;
    private int roomId;
    private int hotValue;
    private int stasticsCount;
    private String liveType;

    public LiveRoom() {
    }

    public LiveRoom(String zbName, String roomUrl, int roomId, int hotValue, String liveType) {
        this.zbName = zbName;
        this.roomUrl = roomUrl;
        this.roomId = roomId;
        this.hotValue = hotValue;
        this.liveType = liveType;
    }

    @Override
    public String toString() {
        return "LiveRoom{" +
                "zbName='" + zbName + '\'' +
                ", roomUrl='" + roomUrl + '\'' +
                ", roomId=" + roomId +
                ", hotValue=" + hotValue +
                ", liveType='" + liveType + '\'' +
                '}';
    }

    public int getStasticsCount() {
        return stasticsCount;
    }

    public void setStasticsCount(int stasticsCount) {
        this.stasticsCount = stasticsCount;
    }

    public String getZbName() {
        return zbName;
    }

    public void setZbName(String zbName) {
        this.zbName = zbName;
    }

    public String getRoomUrl() {
        return roomUrl;
    }

    public void setRoomUrl(String roomUrl) {
        this.roomUrl = roomUrl;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getHotValue() {
        return hotValue;
    }

    public void setHotValue(int hotValue) {
        this.hotValue = hotValue;
    }

    public String getLiveType() {
        return liveType;
    }

    public void setLiveType(String liveType) {
        this.liveType = liveType;
    }
}
