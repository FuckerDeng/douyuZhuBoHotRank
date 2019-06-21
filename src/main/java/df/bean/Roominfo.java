package df.bean;

public class Roominfo {
    private Integer roomid;

    private String zbname;

    private String livetype;

    private Integer stasticscount;

    private String roomurl;

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public String getZbname() {
        return zbname;
    }

    public void setZbname(String zbname) {
        this.zbname = zbname == null ? null : zbname.trim();
    }

    public String getLivetype() {
        return livetype;
    }

    public void setLivetype(String livetype) {
        this.livetype = livetype == null ? null : livetype.trim();
    }

    public Integer getStasticscount() {
        return stasticscount;
    }

    public void setStasticscount(Integer stasticscount) {
        this.stasticscount = stasticscount;
    }

    public String getRoomurl() {
        return roomurl;
    }

    public void setRoomurl(String roomurl) {
        this.roomurl = roomurl == null ? null : roomurl.trim();
    }
}