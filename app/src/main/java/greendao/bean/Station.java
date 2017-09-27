package greendao.bean;

import de.greenrobot.dao.DaoException;
import greendao.dao.DaoSession;
import greendao.dao.PlaceDao;
import greendao.dao.StationDao;


// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

/**
 * Entity mapped to table "STATION".
 */
public class Station {

    /** Not-null value. */
    private String objectId;
    private String notes;
    private String updatedAt;
    private String createdAt;
    private String desc;
    private String placeId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient StationDao myDao;

    private Place place;
    private String place__resolvedKey;


    public Station() {
    }

    public Station(String objectId) {
        this.objectId = objectId;
    }

    public Station(String objectId, String notes, String updatedAt, String createdAt, String desc, String placeId) {
        this.objectId = objectId;
        this.notes = notes;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.desc = desc;
        this.placeId = placeId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStationDao() : null;
    }

    /** Not-null value. */
    public String getObjectId() {
        return objectId;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
