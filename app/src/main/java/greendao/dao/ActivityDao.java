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
import greendao.bean.Activity;
import greendao.bean.Guide;


// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "ACTIVITY".
*/
public class ActivityDao extends AbstractDao<Activity, String> {

    public static final String TABLENAME = "ACTIVITY";

    /**
     * Properties of entity Activity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property ObjectId = new Property(0, String.class, "objectId", true, "OBJECT_ID");
        public final static Property City = new Property(1, String.class, "city", false, "CITY");
        public final static Property Rating = new Property(2, Double.class, "rating", false, "RATING");
        public final static Property Subcategory = new Property(3, String.class, "subcategory", false, "SUBCATEGORY");
        public final static Property Place = new Property(4, String.class, "place", false, "PLACE");
        public final static Property Weight = new Property(5, Integer.class, "weight", false, "WEIGHT");
        public final static Property Title = new Property(6, String.class, "title", false, "TITLE");
        public final static Property Highlights = new Property(7, String.class, "highlights", false, "HIGHLIGHTS");
        public final static Property Notes = new Property(8, String.class, "notes", false, "NOTES");
        public final static Property Comments = new Property(9, Integer.class, "comments", false, "COMMENTS");
        public final static Property Photos = new Property(10, String.class, "photos", false, "PHOTOS");
        public final static Property RowStatus = new Property(11, String.class, "rowStatus", false, "ROW_STATUS");
        public final static Property Likes = new Property(12, Integer.class, "likes", false, "LIKES");
        public final static Property UpdatedAt = new Property(13, String.class, "updatedAt", false, "UPDATED_AT");
        public final static Property Desc = new Property(14, String.class, "desc", false, "DESC");
        public final static Property Urls = new Property(15, String.class, "urls", false, "URLS");
        public final static Property CreatedAt = new Property(16, String.class, "createdAt", false, "CREATED_AT");
        public final static Property BestTime = new Property(17, String.class, "bestTime", false, "BEST_TIME");
        public final static Property GuideId = new Property(18, String.class, "guideId", false, "GUIDE_ID");
    };

    private DaoSession daoSession;

    private Query<Activity> guide_ActivityListQuery;

    public ActivityDao(DaoConfig config) {
        super(config);
    }
    
    public ActivityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ACTIVITY\" (" + //
                "\"OBJECT_ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: objectId
                "\"CITY\" TEXT," + // 1: city
                "\"RATING\" REAL," + // 2: rating
                "\"SUBCATEGORY\" TEXT," + // 3: subcategory
                "\"PLACE\" TEXT," + // 4: place
                "\"WEIGHT\" INTEGER," + // 5: weight
                "\"TITLE\" TEXT," + // 6: title
                "\"HIGHLIGHTS\" TEXT," + // 7: highlights
                "\"NOTES\" TEXT," + // 8: notes
                "\"COMMENTS\" INTEGER," + // 9: comments
                "\"PHOTOS\" TEXT," + // 10: photos
                "\"ROW_STATUS\" TEXT," + // 11: rowStatus
                "\"LIKES\" INTEGER," + // 12: likes
                "\"UPDATED_AT\" TEXT," + // 13: updatedAt
                "\"DESC\" TEXT," + // 14: desc
                "\"URLS\" TEXT," + // 15: urls
                "\"CREATED_AT\" TEXT," + // 16: createdAt
                "\"BEST_TIME\" TEXT," + // 17: bestTime
                "\"GUIDE_ID\" TEXT);"); // 18: guideId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ACTIVITY\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(DatabaseStatement stmt, Activity entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getObjectId());
 
        String city = entity.getCity();
        if (city != null) {
            stmt.bindString(2, city);
        }
 
        Double rating = entity.getRating();
        if (rating != null) {
            stmt.bindDouble(3, rating);
        }
 
        String subcategory = entity.getSubcategory();
        if (subcategory != null) {
            stmt.bindString(4, subcategory);
        }
 
        String place = entity.getPlace();
        if (place != null) {
            stmt.bindString(5, place);
        }
 
        Integer weight = entity.getWeight();
        if (weight != null) {
            stmt.bindLong(6, weight);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(7, title);
        }
 
        String highlights = entity.getHighlights();
        if (highlights != null) {
            stmt.bindString(8, highlights);
        }
 
        String notes = entity.getNotes();
        if (notes != null) {
            stmt.bindString(9, notes);
        }
 
        Integer comments = entity.getComments();
        if (comments != null) {
            stmt.bindLong(10, comments);
        }
 
        String photos = entity.getPhotos();
        if (photos != null) {
            stmt.bindString(11, photos);
        }
 
        String rowStatus = entity.getRowStatus();
        if (rowStatus != null) {
            stmt.bindString(12, rowStatus);
        }
 
        Integer likes = entity.getLikes();
        if (likes != null) {
            stmt.bindLong(13, likes);
        }
 
        String updatedAt = entity.getUpdatedAt();
        if (updatedAt != null) {
            stmt.bindString(14, updatedAt);
        }
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(15, desc);
        }
 
        String urls = entity.getUrls();
        if (urls != null) {
            stmt.bindString(16, urls);
        }
 
        String createdAt = entity.getCreatedAt();
        if (createdAt != null) {
            stmt.bindString(17, createdAt);
        }
 
        String bestTime = entity.getBestTime();
        if (bestTime != null) {
            stmt.bindString(18, bestTime);
        }
 
        String guideId = entity.getGuideId();
        if (guideId != null) {
            stmt.bindString(19, guideId);
        }
    }

    @Override
    protected void attachEntity(Activity entity) {
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
    public Activity readEntity(Cursor cursor, int offset) {
        Activity entity = new Activity( //
            cursor.getString(offset + 0), // objectId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // city
            cursor.isNull(offset + 2) ? null : cursor.getDouble(offset + 2), // rating
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // subcategory
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // place
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // weight
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // title
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // highlights
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // notes
            cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9), // comments
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // photos
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // rowStatus
            cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12), // likes
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // updatedAt
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // desc
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // urls
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // createdAt
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // bestTime
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18) // guideId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Activity entity, int offset) {
        entity.setObjectId(cursor.getString(offset + 0));
        entity.setCity(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setRating(cursor.isNull(offset + 2) ? null : cursor.getDouble(offset + 2));
        entity.setSubcategory(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPlace(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setWeight(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setTitle(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setHighlights(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setNotes(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setComments(cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9));
        entity.setPhotos(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setRowStatus(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setLikes(cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12));
        entity.setUpdatedAt(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setDesc(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setUrls(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setCreatedAt(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setBestTime(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setGuideId(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(Activity entity, long rowId) {
        return entity.getObjectId();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(Activity entity) {
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
    
    /** Internal query to resolve the "activityList" to-many relationship of Guide. */
    public List<Activity> _queryGuide_ActivityList(String guideId) {
        synchronized (this) {
            if (guide_ActivityListQuery == null) {
                QueryBuilder<Activity> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.GuideId.eq(null));
                guide_ActivityListQuery = queryBuilder.build();
            }
        }
        Query<Activity> query = guide_ActivityListQuery.forCurrentThread();
        query.setParameter(0, guideId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getGuideDao().getAllColumns());
            builder.append(" FROM ACTIVITY T");
            builder.append(" LEFT JOIN GUIDE T0 ON T.\"GUIDE_ID\"=T0.\"OBJECT_ID\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Activity loadCurrentDeep(Cursor cursor, boolean lock) {
        Activity entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Guide guide = loadCurrentOther(daoSession.getGuideDao(), cursor, offset);
        entity.setGuide(guide);

        return entity;    
    }

    public Activity loadDeep(Long key) {
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
    public List<Activity> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Activity> list = new ArrayList<Activity>(count);
        
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
    
    protected List<Activity> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Activity> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
