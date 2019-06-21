package df.bean;

public class Groupinfo {
    private String name;

    private String iconurl;

    private String groupurl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIconurl() {
        return iconurl;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl == null ? null : iconurl.trim();
    }

    public String getGroupurl() {
        return groupurl;
    }

    public void setGroupurl(String groupurl) {
        this.groupurl = groupurl == null ? null : groupurl.trim();
    }
}