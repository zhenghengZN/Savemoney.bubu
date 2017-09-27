package greendao.dao;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.database.Database;
import de.greenrobot.dao.database.DatabaseStatement;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;
import greendao.bean.MenuItem;
import greendao.bean.MenuItemOption;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "MENU_ITEM_OPTION".
*/
public class MenuItemOptionDao extends AbstractDao<MenuItemOption, String> {

    public static final String TABLENAME = "MENU_ITEM_OPTION";

    /**
     * Properties of entity MenuItemOption.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property ObjectId = new Property(0, String.class, "objectId", true, "OBJECT_ID");
        public final static Property TitleCn = new Property(1, String.class, "titleCn", false, "TITLE_CN");
        public final static Property Title = new Property(2, String.class, "title", false, "TITLE");
        public final static Property RowStatus = new Property(3, String.class, "rowStatus", false, "ROW_STATUS");
        public final static Property Item = new Property(4, String.class, "item", false, "ITEM");
        public final static Property CreatedAt = new Property(5, String.class, "createdAt", false, "CREATED_AT");
        public final static Property UpdatedAt = new Property(6, String.class, "updatedAt", false, "UPDATED_AT");
        public final static Property MenuItemId = new Property(7, String.class, "menuItemId", false, "MENU_ITEM_ID");
    };

    private DaoSession daoSession;

    private Query<MenuItemOption> menuItem_MenuItemOptionListQuery;

    public MenuItemOptionDao(DaoConfig config) {
        super(config);
    }
    
    public MenuItemOptionDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MENU_ITEM_OPTION\" (" + //
                "\"OBJECT_ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: objectId
                "\"TITLE_CN\" TEXT," + // 1: titleCn
                "\"TITLE\" TEXT," + // 2: title
                "\"ROW_STATUS\" TEXT," + // 3: rowStatus
                "\"ITEM\" TEXT," + // 4: item
                "\"CREATED_AT\" TEXT," + // 5: createdAt
                "\"UPDATED_AT\" TEXT," + // 6: updatedAt
                "\"MENU_ITEM_ID\" TEXT);"); // 7: menuItemId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MENU_ITEM_OPTION\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(DatabaseStatement stmt, MenuItemOption entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getObjectId());
 
        String titleCn = entity.getTitleCn();
        if (titleCn != null) {
            stmt.bindString(2, titleCn);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
 
        String rowStatus = entity.getRowStatus();
        if (rowStatus != null) {
            stmt.bindString(4, rowStatus);
        }
 
        String item = entity.getItem();
        if (item != null) {
            stmt.bindString(5, item);
        }
 
        String createdAt = entity.getCreatedAt();
        if (createdAt != null) {
            stmt.bindString(6, createdAt);
        }
 
        String updatedAt = entity.getUpdatedAt();
        if (updatedAt != null) {
            stmt.bindString(7, updatedAt);
        }
 
        String menuItemId = entity.getMenuItemId();
        if (menuItemId != null) {
            stmt.bindString(8, menuItemId);
        }
    }

    @Override
    protected void attachEntity(MenuItemOption entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public MenuItemOption readEntity(Cursor cursor, int offset) {
        MenuItemOption entity = new MenuItemOption( //
            cursor.getString(offset + 0), // objectId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // titleCn
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // title
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // rowStatus
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // item
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // createdAt
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // updatedAt
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7) // menuItemId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, MenuItemOption entity, int offset) {
        entity.setObjectId(cursor.getString(offset + 0));
        entity.setTitleCn(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTitle(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setRowStatus(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setItem(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setCreatedAt(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setUpdatedAt(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setMenuItemId(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(MenuItemOption entity, long rowId) {
        return entity.getObjectId();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(MenuItemOption entity) {
        if(entity != null) {
            return entity.getObjectId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "menuItemOptionList" to-many relationship of MenuItem. */
    public List<MenuItemOption> _queryMenuItem_MenuItemOptionList(String menuItemId) {
        synchronized (this) {
            if (menuItem_MenuItemOptionListQuery == null) {
                QueryBuilder<MenuItemOption> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.MenuItemId.eq(null));
                menuItem_MenuItemOptionListQuery = queryBuilder.build();
            }
        }
        Query<MenuItemOption> query = menuItem_MenuItemOptionListQuery.forCurrentThread();
        query.setParameter(0, menuItemId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getMenuItemDao().getAllColumns());
            builder.append(" FROM MENU_ITEM_OPTION T");
            builder.append(" LEFT JOIN MENU_ITEM T0 ON T.\"MENU_ITEM_ID\"=T0.\"OBJECT_ID\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected MenuItemOption loadCurrentDeep(Cursor cursor, boolean lock) {
        MenuItemOption entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        MenuItem menuItem = loadCurrentOther(daoSession.getMenuItemDao(), cursor, offset);
        entity.setMenuItem(menuItem);

        return entity;    
    }

    public MenuItemOption loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<MenuItemOption> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<MenuItemOption> list = new ArrayList<MenuItemOption>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<MenuItemOption> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<MenuItemOption> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
