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
import greendao.bean.Menu;
import greendao.bean.Restaurant;


// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "MENU".
*/
public class MenuDao extends AbstractDao<Menu, String> {

    public static final String TABLENAME = "MENU";

    /**
     * Properties of entity Menu.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property ObjectId = new Property(0, String.class, "objectId", true, "OBJECT_ID");
        public final static Property Desc = new Property(1, String.class, "desc", false, "DESC");
        public final static Property NameCn = new Property(2, String.class, "nameCn", false, "NAME_CN");
        public final static Property Name = new Property(3, String.class, "name", false, "NAME");
        public final static Property DescCn = new Property(4, String.class, "descCn", false, "DESC_CN");
        public final static Property RowStatus = new Property(5, String.class, "rowStatus", false, "ROW_STATUS");
        public final static Property Sections = new Property(6, String.class, "sections", false, "SECTIONS");
        public final static Property CreatedAt = new Property(7, String.class, "createdAt", false, "CREATED_AT");
        public final static Property UpdatedAt = new Property(8, String.class, "updatedAt", false, "UPDATED_AT");
        public final static Property RestaurantId = new Property(9, String.class, "restaurantId", false, "RESTAURANT_ID");
    };

    private DaoSession daoSession;

    private Query<Menu> restaurant_MenuListQuery;

    public MenuDao(DaoConfig config) {
        super(config);
    }
    
    public MenuDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MENU\" (" + //
                "\"OBJECT_ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: objectId
                "\"DESC\" TEXT," + // 1: desc
                "\"NAME_CN\" TEXT," + // 2: nameCn
                "\"NAME\" TEXT," + // 3: name
                "\"DESC_CN\" TEXT," + // 4: descCn
                "\"ROW_STATUS\" TEXT," + // 5: rowStatus
                "\"SECTIONS\" TEXT," + // 6: sections
                "\"CREATED_AT\" TEXT," + // 7: createdAt
                "\"UPDATED_AT\" TEXT," + // 8: updatedAt
                "\"RESTAURANT_ID\" TEXT);"); // 9: restaurantId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MENU\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(DatabaseStatement stmt, Menu entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getObjectId());
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(2, desc);
        }
 
        String nameCn = entity.getNameCn();
        if (nameCn != null) {
            stmt.bindString(3, nameCn);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
 
        String descCn = entity.getDescCn();
        if (descCn != null) {
            stmt.bindString(5, descCn);
        }
 
        String rowStatus = entity.getRowStatus();
        if (rowStatus != null) {
            stmt.bindString(6, rowStatus);
        }
 
        String sections = entity.getSections();
        if (sections != null) {
            stmt.bindString(7, sections);
        }
 
        String createdAt = entity.getCreatedAt();
        if (createdAt != null) {
            stmt.bindString(8, createdAt);
        }
 
        String updatedAt = entity.getUpdatedAt();
        if (updatedAt != null) {
            stmt.bindString(9, updatedAt);
        }
 
        String restaurantId = entity.getRestaurantId();
        if (restaurantId != null) {
            stmt.bindString(10, restaurantId);
        }
    }

    @Override
    protected void attachEntity(Menu entity) {
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
    public Menu readEntity(Cursor cursor, int offset) {
        Menu entity = new Menu( //
            cursor.getString(offset + 0), // objectId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // desc
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // nameCn
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // name
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // descCn
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // rowStatus
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // sections
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // createdAt
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // updatedAt
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9) // restaurantId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Menu entity, int offset) {
        entity.setObjectId(cursor.getString(offset + 0));
        entity.setDesc(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setNameCn(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDescCn(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setRowStatus(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setSections(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setCreatedAt(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setUpdatedAt(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setRestaurantId(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(Menu entity, long rowId) {
        return entity.getObjectId();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(Menu entity) {
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
    
    /** Internal query to resolve the "menuList" to-many relationship of Restaurant. */
    public List<Menu> _queryRestaurant_MenuList(String restaurantId) {
        synchronized (this) {
            if (restaurant_MenuListQuery == null) {
                QueryBuilder<Menu> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.RestaurantId.eq(null));
                restaurant_MenuListQuery = queryBuilder.build();
            }
        }
        Query<Menu> query = restaurant_MenuListQuery.forCurrentThread();
        query.setParameter(0, restaurantId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getRestaurantDao().getAllColumns());
            builder.append(" FROM MENU T");
            builder.append(" LEFT JOIN RESTAURANT T0 ON T.\"RESTAURANT_ID\"=T0.\"OBJECT_ID\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Menu loadCurrentDeep(Cursor cursor, boolean lock) {
        Menu entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Restaurant restaurant = loadCurrentOther(daoSession.getRestaurantDao(), cursor, offset);
        entity.setRestaurant(restaurant);

        return entity;    
    }

    public Menu loadDeep(Long key) {
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
    public List<Menu> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Menu> list = new ArrayList<Menu>(count);
        
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
    
    protected List<Menu> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Menu> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
