package df.structures;

public class BigGroup {
    private String name;
    private String iconUrl;
    private String groupUrl;
    private int hotValue;

    public BigGroup(String name, String iconUrl, String grouUrl, int hotValue) {
        this.name = name;
        this.iconUrl = iconUrl;
        this.groupUrl = grouUrl;
        this.hotValue = hotValue;
    }

    @Override
    public String toString() {
        return "BigGroup{" +
                "name='" + name + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", grouUrl='" + groupUrl + '\'' +
                ", hotValue=" + hotValue +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getGrouUrl() {
        return groupUrl;
    }

    public void setGrouUrl(String grouUrl) {
        this.groupUrl = grouUrl;
    }

    public int getHotValue() {
        return hotValue;
    }

    public void setHotValue(int hotValue) {
        this.hotValue = hotValue;
    }
}
