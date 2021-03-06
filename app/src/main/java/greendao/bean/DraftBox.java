package greendao.bean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

import java.io.Serializable;

/**
 * Entity mapped to table "DRAFT_BOX".
 */
public class DraftBox implements Serializable {

    private Long id;
    private String title;
    private String channelId;
    private String content;
    private String address;
    private Double latitude;
    private Double longitude;
    private Double price;
    private String imgList;
    private String userId;
    private String type;
    private String tags;
    private String purchaseChannel;
    private String departureAirprtId;
    private String arrivalAirportId;
    private String departureAirprtName;
    private String arrivalAirportName;
    private String departureTimeZoneName;
    private String arrivalTimeZoneName;
    private java.util.Date createAt;
    private java.util.Date startTime;
    private java.util.Date endTime;
    private java.util.Date departureTime;
    private java.util.Date arrivalTime;
    private Integer duration;
    private java.util.Date updateAt;

    public DraftBox() {
    }

    public DraftBox(Long id) {
        this.id = id;
    }

    public DraftBox(Long id, String title, String channelId, String content, String address, Double latitude, Double longitude, Double price, String imgList, String userId, String type, String tags, String purchaseChannel, String departureAirprtId, String arrivalAirportId, String departureAirprtName, String arrivalAirportName, String departureTimeZoneName, String arrivalTimeZoneName, java.util.Date createAt, java.util.Date startTime, java.util.Date endTime, java.util.Date departureTime, java.util.Date arrivalTime, Integer duration, java.util.Date updateAt) {
        this.id = id;
        this.title = title;
        this.channelId = channelId;
        this.content = content;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.price = price;
        this.imgList = imgList;
        this.userId = userId;
        this.type = type;
        this.tags = tags;
        this.purchaseChannel = purchaseChannel;
        this.departureAirprtId = departureAirprtId;
        this.arrivalAirportId = arrivalAirportId;
        this.departureAirprtName = departureAirprtName;
        this.arrivalAirportName = arrivalAirportName;
        this.departureTimeZoneName = departureTimeZoneName;
        this.arrivalTimeZoneName = arrivalTimeZoneName;
        this.createAt = createAt;
        this.startTime = startTime;
        this.endTime = endTime;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgList() {
        return imgList;
    }

    public void setImgList(String imgList) {
        this.imgList = imgList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPurchaseChannel() {
        return purchaseChannel;
    }

    public void setPurchaseChannel(String purchaseChannel) {
        this.purchaseChannel = purchaseChannel;
    }

    public String getDepartureAirprtId() {
        return departureAirprtId;
    }

    public void setDepartureAirprtId(String departureAirprtId) {
        this.departureAirprtId = departureAirprtId;
    }

    public String getArrivalAirportId() {
        return arrivalAirportId;
    }

    public void setArrivalAirportId(String arrivalAirportId) {
        this.arrivalAirportId = arrivalAirportId;
    }

    public String getDepartureAirprtName() {
        return departureAirprtName;
    }

    public void setDepartureAirprtName(String departureAirprtName) {
        this.departureAirprtName = departureAirprtName;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public String getDepartureTimeZoneName() {
        return departureTimeZoneName;
    }

    public void setDepartureTimeZoneName(String departureTimeZoneName) {
        this.departureTimeZoneName = departureTimeZoneName;
    }

    public String getArrivalTimeZoneName() {
        return arrivalTimeZoneName;
    }

    public void setArrivalTimeZoneName(String arrivalTimeZoneName) {
        this.arrivalTimeZoneName = arrivalTimeZoneName;
    }

    public java.util.Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(java.util.Date createAt) {
        this.createAt = createAt;
    }

    public java.util.Date getStartTime() {
        return startTime;
    }

    public void setStartTime(java.util.Date startTime) {
        this.startTime = startTime;
    }

    public java.util.Date getEndTime() {
        return endTime;
    }

    public void setEndTime(java.util.Date endTime) {
        this.endTime = endTime;
    }

    public java.util.Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(java.util.Date departureTime) {
        this.departureTime = departureTime;
    }

    public java.util.Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(java.util.Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public java.util.Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(java.util.Date updateAt) {
        this.updateAt = updateAt;
    }

}
