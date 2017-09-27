package greendao.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.dao.DaoException;
import greendao.dao.ActivityDao;
import greendao.dao.AppDao;
import greendao.dao.ArticleDao;
import greendao.dao.ContactDao;
import greendao.dao.DaoSession;
import greendao.dao.FoodDao;
import greendao.dao.GuideDao;
import greendao.dao.GuideGroupDao;
import greendao.dao.PlaceDao;
import greendao.dao.ProductDao;
import greendao.dao.RouteDao;
import greendao.dao.VisaDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit.

/**
 * Entity mapped to table "GUIDE".
 */
public class Guide implements Parcelable {

    /** Not-null value. */
    private String objectId;
    private String desc;
    private String type;
    private String title;
    private Integer weight;
    private String rowStatus;
    private Boolean isFeature;
    private String objects;
    private String backgroundImage;
    private String location;
    private String icon;
    private String iconUrl;
    private String guideUrl;
    private String createdAt;
    private String updatedAt;
    private String guideGroupId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient GuideDao myDao;

    private GuideGroup guideGroup;
    private String guideGroup__resolvedKey;

    private List<Visa> visaList;
    private List<Article> articlesList;
    private List<Food> foodList;
    private List<Contact> contactList;
    private List<App> appList;
    private List<Product> productList;
    private List<Route> routeList;
    private List<Place> placeList;
    private List<Activity> activityList;

    public Guide() {
    }

    public Guide(String objectId) {
        this.objectId = objectId;
    }

    public Guide(String objectId, String desc, String type, String title, Integer weight, String rowStatus, Boolean isFeature, String objects, String backgroundImage, String location, String icon, String iconUrl, String guideUrl, String createdAt, String updatedAt, String guideGroupId) {
        this.objectId = objectId;
        this.desc = desc;
        this.type = type;
        this.title = title;
        this.weight = weight;
        this.rowStatus = rowStatus;
        this.isFeature = isFeature;
        this.objects = objects;
        this.backgroundImage = backgroundImage;
        this.location = location;
        this.icon = icon;
        this.iconUrl = iconUrl;
        this.guideUrl = guideUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.guideGroupId = guideGroupId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getGuideDao() : null;
    }

    /** Not-null value. */
    public String getObjectId() {
        return objectId;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(String rowStatus) {
        this.rowStatus = rowStatus;
    }

    public Boolean getIsFeature() {
        return isFeature;
    }

    public void setIsFeature(Boolean isFeature) {
        this.isFeature = isFeature;
    }

    public String getObjects() {
        return objects;
    }

    public void setObjects(String objects) {
        this.objects = objects;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getGuideUrl() {
        return guideUrl;
    }

    public void setGuideUrl(String guideUrl) {
        this.guideUrl = guideUrl;
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

    public String getGuideGroupId() {
        return guideGroupId;
    }

    public void setGuideGroupId(String guideGroupId) {
        this.guideGroupId = guideGroupId;
    }

    /** To-one relationship, resolved on first access. */
    public GuideGroup getGuideGroup() {
        String __key = this.guideGroupId;
        if (guideGroup__resolvedKey == null || guideGroup__resolvedKey != __key) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            GuideGroupDao targetDao = daoSession.getGuideGroupDao();
            GuideGroup guideGroupNew = targetDao.load(__key);
            synchronized (this) {
                guideGroup = guideGroupNew;
                guideGroup__resolvedKey = __key;
            }
        }
        return guideGroup;
    }

    public void setGuideGroup(GuideGroup guideGroup) {
        synchronized (this) {
            this.guideGroup = guideGroup;
            guideGroupId = guideGroup == null ? null : guideGroup.getObjectId();
            guideGroup__resolvedKey = guideGroupId;
        }
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Visa> getVisaList() {
        if (visaList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            VisaDao targetDao = daoSession.getVisaDao();
            List<Visa> visaListNew = targetDao._queryGuide_VisaList(objectId);
            synchronized (this) {
                if(visaList == null) {
                    visaList = visaListNew;
                }
            }
        }
        return visaList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetVisaList() {
        visaList = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Article> getArticlesList() {
        if (articlesList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ArticleDao targetDao = daoSession.getArticleDao();
            List<Article> articlesListNew = targetDao._queryGuide_ArticlesList(objectId);
            synchronized (this) {
                if(articlesList == null) {
                    articlesList = articlesListNew;
                }
            }
        }
        return articlesList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetArticlesList() {
        articlesList = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Food> getFoodList() {
        if (foodList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FoodDao targetDao = daoSession.getFoodDao();
            List<Food> foodListNew = targetDao._queryGuide_FoodList(objectId);
            synchronized (this) {
                if(foodList == null) {
                    foodList = foodListNew;
                }
            }
        }
        return foodList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetFoodList() {
        foodList = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Contact> getContactList() {
        if (contactList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ContactDao targetDao = daoSession.getContactDao();
            List<Contact> contactListNew = targetDao._queryGuide_ContactList(objectId);
            synchronized (this) {
                if(contactList == null) {
                    contactList = contactListNew;
                }
            }
        }
        return contactList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetContactList() {
        contactList = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<App> getAppList() {
        if (appList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AppDao targetDao = daoSession.getAppDao();
            List<App> appListNew = targetDao._queryGuide_AppList(objectId);
            synchronized (this) {
                if(appList == null) {
                    appList = appListNew;
                }
            }
        }
        return appList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetAppList() {
        appList = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Product> getProductList() {
        if (productList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ProductDao targetDao = daoSession.getProductDao();
            List<Product> productListNew = targetDao._queryGuide_ProductList(objectId);
            synchronized (this) {
                if(productList == null) {
                    productList = productListNew;
                }
            }
        }
        return productList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetProductList() {
        productList = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Route> getRouteList() {
        if (routeList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            RouteDao targetDao = daoSession.getRouteDao();
            List<Route> routeListNew = targetDao._queryGuide_RouteList(objectId);
            synchronized (this) {
                if(routeList == null) {
                    routeList = routeListNew;
                }
            }
        }
        return routeList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetRouteList() {
        routeList = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Place> getPlaceList() {
        if (placeList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PlaceDao targetDao = daoSession.getPlaceDao();
            List<Place> placeListNew = targetDao._queryGuide_PlaceList(objectId);
            synchronized (this) {
                if(placeList == null) {
                    placeList = placeListNew;
                }
            }
        }
        return placeList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetPlaceList() {
        placeList = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Activity> getActivityList() {
        if (activityList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ActivityDao targetDao = daoSession.getActivityDao();
            List<Activity> activityListNew = targetDao._queryGuide_ActivityList(objectId);
            synchronized (this) {
                if(activityList == null) {
                    activityList = activityListNew;
                }
            }
        }
        return activityList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetActivityList() {
        activityList = null;
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.objectId);
        dest.writeString(this.desc);
        dest.writeString(this.type);
        dest.writeString(this.title);
        dest.writeValue(this.weight);
        dest.writeString(this.rowStatus);
        dest.writeValue(this.isFeature);
        dest.writeString(this.objects);
        dest.writeString(this.backgroundImage);
        dest.writeString(this.location);
        dest.writeString(this.icon);
        dest.writeString(this.iconUrl);
        dest.writeString(this.guideUrl);
        dest.writeString(this.createdAt);
        dest.writeString(this.updatedAt);
        dest.writeString(this.guideGroupId);
        dest.writeParcelable(this.guideGroup, flags);
        dest.writeString(this.guideGroup__resolvedKey);
        dest.writeList(this.visaList);
        dest.writeList(this.articlesList);
        dest.writeList(this.foodList);
        dest.writeList(this.contactList);
        dest.writeList(this.appList);
        dest.writeTypedList(this.productList);
        dest.writeList(this.routeList);
        dest.writeTypedList(this.placeList);
        dest.writeList(this.activityList);
    }

    protected Guide(Parcel in) {
        this.objectId = in.readString();
        this.desc = in.readString();
        this.type = in.readString();
        this.title = in.readString();
        this.weight = (Integer) in.readValue(Integer.class.getClassLoader());
        this.rowStatus = in.readString();
        this.isFeature = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.objects = in.readString();
        this.backgroundImage = in.readString();
        this.location = in.readString();
        this.icon = in.readString();
        this.iconUrl = in.readString();
        this.guideUrl = in.readString();
        this.createdAt = in.readString();
        this.updatedAt = in.readString();
        this.guideGroupId = in.readString();
        this.guideGroup = in.readParcelable(GuideGroup.class.getClassLoader());
        this.guideGroup__resolvedKey = in.readString();
        this.visaList = new ArrayList<Visa>();
        in.readList(this.visaList, Visa.class.getClassLoader());
        this.articlesList = new ArrayList<Article>();
        in.readList(this.articlesList, Article.class.getClassLoader());
        this.foodList = new ArrayList<Food>();
        in.readList(this.foodList, Food.class.getClassLoader());
        this.contactList = new ArrayList<Contact>();
        in.readList(this.contactList, Contact.class.getClassLoader());
        this.appList = new ArrayList<App>();
        in.readList(this.appList, App.class.getClassLoader());
        this.productList = in.createTypedArrayList(Product.CREATOR);
        this.routeList = new ArrayList<Route>();
        in.readList(this.routeList, Route.class.getClassLoader());
        this.placeList = in.createTypedArrayList(Place.CREATOR);
        this.activityList = new ArrayList<Activity>();
        in.readList(this.activityList, Activity.class.getClassLoader());
    }

    public static final Creator<Guide> CREATOR = new Creator<Guide>() {
        @Override
        public Guide createFromParcel(Parcel source) {
            return new Guide(source);
        }

        @Override
        public Guide[] newArray(int size) {
            return new Guide[size];
        }
    };

}