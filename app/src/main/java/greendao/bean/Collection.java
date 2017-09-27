package greendao.bean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "COLLECTION".
 */
public class Collection {

    /** Not-null value. */
    private String objectId;
    private String guideType;
    private String collectionTab;
    private String sessionToken;
    private java.util.Date collectionDate;

    public Collection() {
    }

    public Collection(String objectId) {
        this.objectId = objectId;
    }

    public Collection(String objectId, String guideType, String collectionTab, String sessionToken, java.util.Date collectionDate) {
        this.objectId = objectId;
        this.guideType = guideType;
        this.collectionTab = collectionTab;
        this.sessionToken = sessionToken;
        this.collectionDate = collectionDate;
    }

    /** Not-null value. */
    public String getObjectId() {
        return objectId;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getGuideType() {
        return guideType;
    }

    public void setGuideType(String guideType) {
        this.guideType = guideType;
    }

    public String getCollectionTab() {
        return collectionTab;
    }

    public void setCollectionTab(String collectionTab) {
        this.collectionTab = collectionTab;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public java.util.Date getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(java.util.Date collectionDate) {
        this.collectionDate = collectionDate;
    }

}