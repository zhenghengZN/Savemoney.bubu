package greendao.bean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Entity mapped to table "LOCATION".
 */
public class Location implements Parcelable {

    /** Not-null value. */
    private String cloudId;
    private String countryCode;
    private String rowStatus;
    private String type;
    private String nameCn;
    private String name;
    private String parent;
    private String city;
    private String region;
    private String country;
    private Integer localId;

    public Location() {
    }

    public Location(String cloudId) {
        this.cloudId = cloudId;
    }

    public Location(String cloudId, String countryCode, String rowStatus, String type, String nameCn, String name, String parent, String city, String region, String country, Integer localId) {
        this.cloudId = cloudId;
        this.countryCode = countryCode;
        this.rowStatus = rowStatus;
        this.type = type;
        this.nameCn = nameCn;
        this.name = name;
        this.parent = parent;
        this.city = city;
        this.region = region;
        this.country = country;
        this.localId = localId;
    }

    /** Not-null value. */
    public String getCloudId() {
        return cloudId;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setCloudId(String cloudId) {
        this.cloudId = cloudId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(String rowStatus) {
        this.rowStatus = rowStatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getLocalId() {
        return localId;
    }

    public void setLocalId(Integer localId) {
        this.localId = localId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.cloudId);
        dest.writeString(this.countryCode);
        dest.writeString(this.rowStatus);
        dest.writeString(this.type);
        dest.writeString(this.nameCn);
        dest.writeString(this.name);
        dest.writeString(this.parent);
        dest.writeString(this.city);
        dest.writeString(this.region);
        dest.writeString(this.country);
        dest.writeValue(this.localId);
    }

    protected Location(Parcel in) {
        this.cloudId = in.readString();
        this.countryCode = in.readString();
        this.rowStatus = in.readString();
        this.type = in.readString();
        this.nameCn = in.readString();
        this.name = in.readString();
        this.parent = in.readString();
        this.city = in.readString();
        this.region = in.readString();
        this.country = in.readString();
        this.localId = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel source) {
            return new Location(source);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

}
