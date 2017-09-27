package greendao.bean;

import de.greenrobot.dao.DaoException;
import greendao.dao.DaoSession;
import greendao.dao.HotelDao;
import greendao.dao.PlaceDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

/**
 * Entity mapped to table "HOTEL".
 */
public class Hotel {

    /** Not-null value. */
    private String objectId;
    private Integer rooms;
    private String features;
    private String desc;
    private String photos;
    private String booking;
    private String checkout;
    private String checkin;
    private String agoda;
    private Double minrate;
    private Double maxrate;
    private String createdAt;
    private String updatedAt;
    private String placeId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient HotelDao myDao;

    private Place place;
    private String place__resolvedKey;


    public Hotel() {
    }

    public Hotel(String objectId) {
        this.objectId = objectId;
    }

    public Hotel(String objectId, Integer rooms, String features, String desc, String photos, String booking, String checkout, String checkin, String agoda, Double minrate, Double maxrate, String createdAt, String updatedAt, String placeId) {
        this.objectId = objectId;
        this.rooms = rooms;
        this.features = features;
        this.desc = desc;
        this.photos = photos;
        this.booking = booking;
        this.checkout = checkout;
        this.checkin = checkin;
        this.agoda = agoda;
        this.minrate = minrate;
        this.maxrate = maxrate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.placeId = placeId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getHotelDao() : null;
    }

    /** Not-null value. */
    public String getObjectId() {
        return objectId;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getBooking() {
        return booking;
    }

    public void setBooking(String booking) {
        this.booking = booking;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getAgoda() {
        return agoda;
    }

    public void setAgoda(String agoda) {
        this.agoda = agoda;
    }

    public Double getMinrate() {
        return minrate;
    }

    public void setMinrate(Double minrate) {
        this.minrate = minrate;
    }

    public Double getMaxrate() {
        return maxrate;
    }

    public void setMaxrate(Double maxrate) {
        this.maxrate = maxrate;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    /** To-one relationship, resolved on first access. */
    public Place getPlace() {
        String __key = this.placeId;
        if (place__resolvedKey == null || place__resolvedKey != __key) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PlaceDao targetDao = daoSession.getPlaceDao();
            Place placeNew = targetDao.load(__key);
            synchronized (this) {
                place = placeNew;
            	place__resolvedKey = __key;
            }
        }
        return place;
    }

    public void setPlace(Place place) {
        synchronized (this) {
            this.place = place;
            placeId = place == null ? null : place.getObjectId();
            place__resolvedKey = placeId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
