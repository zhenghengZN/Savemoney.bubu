package bean;

/**
 * Created by zhengheng on 17/9/13.
 */
public class TaobaoContentBean {

    private String category;
    private int couponAmount;
    private float couponRemain;
    private String couponShareUrl;
    private int couponTotal;
    private String discountPrice;
    private String finalPrice;
    private String id;
    private String picUrl;
    private String platform;
    private String title;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(float finalPrice) {
        String s = String.valueOf(finalPrice);
        if (s.endsWith(".0")) {
            s = s.substring(0, s.length() - 2);
        }
        this.finalPrice = s;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(float discountPrice) {
        String s = String.valueOf(discountPrice);
        if (s.endsWith(".0")) {
            s = s.substring(0, s.length() - 2);
        }
        this.discountPrice = s;
    }

    public int getCouponTotal() {
        return couponTotal;
    }

    public int getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(int couponAmount) {
        this.couponAmount = couponAmount;
    }

    public float getCouponRemain() {
        return couponRemain;
    }

    public void setCouponRemain(float couponRemain) {
        this.couponRemain = couponRemain;
    }

    public String getCouponShareUrl() {
        return couponShareUrl;
    }

    public void setCouponShareUrl(String couponShareUrl) {
        this.couponShareUrl = couponShareUrl;
    }

    public void setCouponTotal(int couponTotal) {
        this.couponTotal = couponTotal;

    }
}
