public class Address {
    private String city;
    private String district;
    private String ward;
    private String addressDetail;
    private boolean isApply;

    public Address(String city, String district, String ward, String addressDetail, boolean isApply) {
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.addressDetail = addressDetail;
        this.isApply = isApply;
    }

    public boolean isApply() {
        return isApply;
    }

    public void setApply(boolean apply) {
        isApply = apply;
    }
}
