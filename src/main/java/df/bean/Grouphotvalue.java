package df.bean;

public class Grouphotvalue {
    private String name;

    private Integer hotvalue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getHotvalue() {
        return hotvalue;
    }

    public void setHotvalue(Integer hotvalue) {
        this.hotvalue = hotvalue;
    }
}