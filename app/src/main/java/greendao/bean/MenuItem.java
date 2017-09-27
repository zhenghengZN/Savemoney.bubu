package greendao.bean;

import java.util.List;

import de.greenrobot.dao.DaoException;
import greendao.dao.DaoSession;
import greendao.dao.MenuItemDao;
import greendao.dao.MenuItemOptionDao;
import greendao.dao.MenuSectionDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

/**
 * Entity mapped to table "MENU_ITEM".
 */
public class MenuItem {

    /** Not-null value. */
    private String objectId;
    private String desc;
    private String descCn;
    private String title;
    private String titleCn;
    private String price;
    private String section;
    private String options;
    private String rowStatus;
    private String createdAt;
    private String updatedAt;
    private String menuSectionId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient MenuItemDao myDao;

    private MenuSection menuSection;
    private String menuSection__resolvedKey;

    private List<MenuItemOption> menuItemOptionList;

    public MenuItem() {
    }

    public MenuItem(String objectId) {
        this.objectId = objectId;
    }

    public MenuItem(String objectId, String desc, String descCn, String title, String titleCn, String price, String section, String options, String rowStatus, String createdAt, String updatedAt, String menuSectionId) {
        this.objectId = objectId;
        this.desc = desc;
        this.descCn = descCn;
        this.title = title;
        this.titleCn = titleCn;
        this.price = price;
        this.section = section;
        this.options = options;
        this.rowStatus = rowStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.menuSectionId = menuSectionId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMenuItemDao() : null;
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

    public String getDescCn() {
        return descCn;
    }

    public void setDescCn(String descCn) {
        this.descCn = descCn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleCn() {
        return titleCn;
    }

    public void setTitleCn(String titleCn) {
        this.titleCn = titleCn;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(String rowStatus) {
        this.rowStatus = rowStatus;
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

    public String getMenuSectionId() {
        return menuSectionId;
    }

    public void setMenuSectionId(String menuSectionId) {
        this.menuSectionId = menuSectionId;
    }

    /** To-one relationship, resolved on first access. */
    public MenuSection getMenuSection() {
        String __key = this.menuSectionId;
        if (menuSection__resolvedKey == null || menuSection__resolvedKey != __key) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MenuSectionDao targetDao = daoSession.getMenuSectionDao();
            MenuSection menuSectionNew = targetDao.load(__key);
            synchronized (this) {
                menuSection = menuSectionNew;
            	menuSection__resolvedKey = __key;
            }
        }
        return menuSection;
    }

    public void setMenuSection(MenuSection menuSection) {
        synchronized (this) {
            this.menuSection = menuSection;
            menuSectionId = menuSection == null ? null : menuSection.getObjectId();
            menuSection__resolvedKey = menuSectionId;
        }
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<MenuItemOption> getMenuItemOptionList() {
        if (menuItemOptionList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MenuItemOptionDao targetDao = daoSession.getMenuItemOptionDao();
            List<MenuItemOption> menuItemOptionListNew = targetDao._queryMenuItem_MenuItemOptionList(objectId);
            synchronized (this) {
                if(menuItemOptionList == null) {
                    menuItemOptionList = menuItemOptionListNew;
                }
            }
        }
        return menuItemOptionList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetMenuItemOptionList() {
        menuItemOptionList = null;
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
