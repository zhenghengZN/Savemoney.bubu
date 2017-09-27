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
import greendao.bean.GuideGroup;
import greendao.bean.Location;
import greendao.bean.Place;


// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "GUIDE_GROUP".
*/
public class GuideGroupDao extends AbstractDao<GuideGroup, String> {

    public static final String TABLENAME = "GUIDE_GROUP";

    /**
     * Properties of entity GuideGroup.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property ObjectId = new Property(0, String.class, "objectId", true, "OBJECT_ID");
        public final static Property Index = new Property(1, String.class, "index", false, "INDEX");
        public final static Property Title = new Property(2, String.class, "title", false, "TITLE");
        public final static Property IsCityGuideTab = new Property(3, Boolean.class, "isCityGuideTab", false, "IS_CITY_GUIDE_TAB");
        public final static Property RowStatus = new Property(4, String.class, "rowStatus", false, "ROW_STATUS");
        public final static Property City = new Property(5, String.class, "city", false, "CITY");
        public final static Property Guides = new Property(6, String.class, "guides", false, "GUIDES");
        public final static Property CreatedAt = new Property(7, String.class, "createdAt", false, "CREATED_AT");
        public final static Property UpdatedAt = new Property(8, String.class, "updatedAt", false, "UPDATED_AT");
        public final static Property CloudId = new Property(9, String.class, "cloudId", false, "CLOUD_ID");
        public final static Property PlaceId = new Property(10, String.class, "placeId", false, "PLACE_ID");
    };

    private DaoSession daoSession;

    private Query<GuideGroup> place_GuideGroupListQuery;

    public GuideGroupDao(DaoConfig config) {
        super(config);
    }
    
    public GuideGroupDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"GUIDE_GROUP\" (" + //
                "\"OBJECT_ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: objectId
                "\"INDEX\" TEXT," + // 1: index
                "\"TITLE\" TEXT," + // 2: title
                "\"IS_CITY_GUIDE_TAB\" INTEGER," + // 3: isCityGuideTab
                "\"ROW_STATUS\" TEXT," + // 4: rowStatus
                "\"CITY\" TEXT," + // 5: city
                "\"GUIDES\" TEXT," + // 6: guides
                "\"CREATED_AT\" TEXT," + // 7: createdAt
                "\"UPDATED_AT\" TEXT," + // 8: updatedAt
                "\"CLOUD_ID\" TEXT," + // 9: cloudId
                "\"PLACE_ID\" TEXT);"); // 10: placeId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"GUIDE_GROUP\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(DatabaseStatement stmt, GuideGroup entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getObjectId());
 
        String index = entity.getIndex();
        if (index != null) {
            stmt.bindString(2, index);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
 
        Boolean isCityGuideTab = entity.getIsCityGuideTab();
        if (isCityGuideTab != null) {
            stmt.bindLong(4, isCityGuideTab ? 1L: 0L);
        }
 
        String rowStatus = entity.getRowStatus();
        if (rowStatus != null) {
            stmt.bindString(5, rowStatus);
        }
 
        String city = entity.getCity();
        if (city != null) {
            stmt.bindString(6, city);
        }
 
        String guides = entity.getGuides();
        if (guides != null) {
            stmt.bindString(7, guides);
        }
 
        String createdAt = entity.getCreatedAt();
        if (createdAt != null) {
            stmt.bindString(8, createdAt);
        }
 
        String updatedAt = entity.getUpdatedAt();
        if (updatedAt != null) {
            stmt.bindString(9, updatedAt);
        }
 
        String cloudId = entity.getCloudId();
        if (cloudId != null) {
            stmt.bindString(10, cloudId);
        }
 
        String placeId = entity.getPlaceId();
        if (placeId != null) {
            stmt.bindString(11, placeId);
        }
    }

    @Override
    protected void attachEntity(GuideGroup entity) {
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
    public GuideGroup readEntity(Cursor cursor, int offset) {
        GuideGroup entity = new GuideGroup( //
            cursor.getString(offset + 0), // objectId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // index
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // title
            cursor.isNull(offset + 3) ? null : cursor.getShort(offset + 3) != 0, // isCityGuideTab
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // rowStatus
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // city
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // guides
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // createdAt
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // updatedAt
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // cloudId
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10) // placeId
        );

        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, GuideGroup entity, int offset) {
        entity.setObjectId(cursor.getString(offset + 0));
        entity.setIndex(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTitle(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setIsCityGuideTab(cursor.isNull(offset + 3) ? null : cursor.getShort(offset + 3) != 0);
        entity.setRowStatus(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setCity(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setGuides(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setCreatedAt(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setUpdatedAt(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setCloudId(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setPlaceId(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(GuideGroup entity, long rowId) {
        return entity.getObjectId();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(GuideGroup entity) {
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
    
    /** Internal query to resolve the "guideGroupList" to-many relationship of Place. */
    public List<GuideGroup> _queryPlace_GuideGroupList(String placeId) {
        synchronized (this) {
            if (place_GuideGroupListQuery == null) {
                QueryBuilder<GuideGroup> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.PlaceId.eq(null));
                place_GuideGroupListQuery = queryBuilder.build();
            }
        }
        Query<GuideGroup> query = place_GuideGroupListQuery.forCurrentThread();
        query.setParameter(0, placeId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getLocationDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getPlaceDao().getAllColumns());
            builder.append(" FROM GUIDE_GROUP T");
            builder.append(" LEFT JOIN LOCATION T0 ON T.\"CLOUD_ID\"=T0.\"CLOUD_ID\"");
            builder.append(" LEFT JOIN PLACE T1 ON T.\"PLACE_ID\"=T1.\"OBJECT_ID\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected GuideGroup loadCurrentDeep(Cursor cursor, boolean lock) {
        GuideGroup entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Location location = loadCurrentOther(daoSession.getLocationDao(), cursor, offset);
        entity.setLocation(location);
        offset += daoSession.getLocationDao().getAllColumns().length;

        Place place = loadCurrentOther(daoSession.getPlaceDao(), cursor, offset);
        entity.setPlace(place);

        return entity;    
    }

    public GuideGroup loadDeep(Long key) {
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
    public List<GuideGroup> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<GuideGroup> list = new ArrayList<GuideGroup>(count);
        
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
    
    protected List<GuideGroup> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<GuideGroup> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }

}
