public class SaleCode {
    private int id;
    private String name;
    private String code;
    private float percent;

    public SaleCode(int id, String name, String code, float percent) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.percent = percent;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPercent() {
        return percent;
    }

    public String getCode() {
        return code;
    }
}
