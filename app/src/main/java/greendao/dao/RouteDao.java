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
import greendao.bean.Guide;
import greendao.bean.Place;
import greendao.bean.Route;


// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "ROUTE".
*/
public class RouteDao extends AbstractDao<Route, String> {

    public static final String TABLENAME = "ROUTE";

    /**
     * Properties of entity Route.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property ObjectId = new Property(0, String.class, "objectId", true, "OBJECT_ID");
        public final static Property Desc = new Property(1, String.class, "desc", false, "DESC");
        public final static Property Index = new Property(2, Integer.class, "index", false, "INDEX");
        public final static Property Comments = new Property(3, Integer.class, "comments", false, "COMMENTS");
        public final static Property Likes = new Property(4, Integer.class, "likes", false, "LIKES");
        public final static Property Departure = new Property(5, String.class, "departure", false, "DEPARTURE");
        public final static Property Arrival = new Property(6, String.class, "arrival", false, "ARRIVAL");
        public final static Property Type = new Property(7, String.class, "type", false, "TYPE");
        public final static Property RowStatus = new Property(8, String.class, "rowStatus", false, "ROW_STATUS");
        public final static Property Airlines = new Property(9, String.class, "airlines", false, "AIRLINES");
        public final static Property Photos = new Property(10, String.class, "photos", false, "PHOTOS");
        public final static Property Urls = new Property(11, String.class, "urls", false, "URLS");
        public final static Property Places = new Property(12, String.class, "places", false, "PLACES");
        public final static Property CreatedAt = new Property(13, String.class, "createdAt", false, "CREATED_AT");
        public final static Property UpdatedAt = new Property(14, String.class, "updatedAt", false, "UPDATED_AT");
        public final static Property GuideId = new Property(15, String.class, "guideId", false, "GUIDE_ID");
        public final static Property PlaceId = new Property(16, String.class, "placeId", false, "PLACE_ID");
    };

    private DaoSession daoSession;

    private Query<Route> guide_RouteListQuery;
    private Query<Route> place_PlaceListQuery;

    public RouteDao(DaoConfig config) {
        super(config);
    }
    
    public RouteDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ROUTE\" (" + //
                "\"OBJECT_ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: objectId
                "\"DESC\" TEXT," + // 1: desc
                "\"INDEX\" INTEGER," + // 2: index
                "\"COMMENTS\" INTEGER," + // 3: comments
                "\"LIKES\" INTEGER," + // 4: likes
                "\"DEPARTURE\" TEXT," + // 5: departure
                "\"ARRIVAL\" TEXT," + // 6: arrival
                "\"TYPE\" TEXT," + // 7: type
                "\"ROW_STATUS\" TEXT," + // 8: rowStatus
                "\"AIRLINES\" TEXT," + // 9: airlines
                "\"PHOTOS\" TEXT," + // 10: photos
                "\"URLS\" TEXT," + // 11: urls
                "\"PLACES\" TEXT," + // 12: places
                "\"CREATED_AT\" TEXT," + // 13: createdAt
                "\"UPDATED_AT\" TEXT," + // 14: updatedAt
                "\"GUIDE_ID\" TEXT," + // 15: guideId
                "\"PLACE_ID\" TEXT);"); // 16: placeId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ROUTE\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(DatabaseStatement stmt, Route entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getObjectId());
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(2, desc);
        }
 
        Integer index = entity.getIndex();
        if (index != null) {
            stmt.bindLong(3, index);
        }
 
        Integer comments = entity.getComments();
        if (comments != null) {
            stmt.bindLong(4, comments);
        }
 
        Integer likes = entity.getLikes();
        if (likes != null) {
            stmt.bindLong(5, likes);
        }
 
        String departure = entity.getDeparture();
        if (departure != null) {
            stmt.bindString(6, departure);
        }
 
        String arrival = entity.getArrival();
        if (arrival != null) {
            stmt.bindString(7, arrival);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(8, type);
        }
 
        String rowStatus = entity.getRowStatus();
        if (rowStatus != null) {
            stmt.bindString(9, rowStatus);
        }
 
        String airlines = entity.getAirlines();
        if (airlines != null) {
            stmt.bindString(10, airlines);
        }
 
        String photos = entity.getPhotos();
        if (photos != null) {
            stmt.bindString(11, photos);
        }
 
        String urls = entity.getUrls();
        if (urls != null) {
            stmt.bindString(12, urls);
        }
 
        String places = entity.getPlaces();
        if (places != null) {
            stmt.bindString(13, places);
        }
 
        String createdAt = entity.getCreatedAt();
        if (createdAt != null) {
            stmt.bindString(14, createdAt);
        }
 
        String updatedAt = entity.getUpdatedAt();
        if (updatedAt != null) {
            stmt.bindString(15, updatedAt);
        }
 
        String guideId = entity.getGuideId();
        if (guideId != null) {
            stmt.bindString(16, guideId);
        }
 
        String placeId = entity.getPlaceId();
        if (placeId != null) {
            stmt.bindString(17, placeId);
        }
    }

    @Override
    protected void attachEntity(Route entity) {
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
    public Route readEntity(Cursor cursor, int offset) {
        Route entity = new Route( //
            cursor.getString(offset + 0), // objectId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // desc
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // index
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // comments
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // likes
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // departure
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // arrival
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // type
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // rowStatus
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // airlines
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // photos
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // urls
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // places
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // createdAt
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // updatedAt
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // guideId
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16) // placeId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Route entity, int offset) {
        entity.setObjectId(cursor.getString(offset + 0));
        entity.setDesc(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setIndex(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setComments(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setLikes(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setDeparture(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setArrival(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setType(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setRowStatus(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setAirlines(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setPhotos(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setUrls(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setPlaces(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setCreatedAt(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setUpdatedAt(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setGuideId(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setPlaceId(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(Route entity, long rowId) {
        return entity.getObjectId();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(Route entity) {
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
    
    /** Internal query to resolve the "routeList" to-many relationship of Guide. */
    public List<Route> _queryGuide_RouteList(String guideId) {
        synchronized (this) {
            if (guide_RouteListQuery == null) {
                QueryBuilder<Route> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.GuideId.eq(null));
                guide_RouteListQuery = queryBuilder.build();
            }
        }
        Query<Route> query = guide_RouteListQuery.forCurrentThread();
        query.setParameter(0, guideId);
        return query.list();
    }

    /** Internal query to resolve the "placeList" to-many relationship of Place. */
    public List<Route> _queryPlace_PlaceList(String placeId) {
        synchronized (this) {
            if (place_PlaceListQuery == null) {
                QueryBuilder<Route> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.PlaceId.eq(null));
                place_PlaceListQuery = queryBuilder.build();
            }
        }
        Query<Route> query = place_PlaceListQuery.forCurrentThread();
        query.setParameter(0, placeId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getGuideDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getPlaceDao().getAllColumns());
            builder.append(" FROM ROUTE T");
            builder.append(" LEFT JOIN GUIDE T0 ON T.\"GUIDE_ID\"=T0.\"OBJECT_ID\"");
            builder.append(" LEFT JOIN PLACE T1 ON T.\"PLACE_ID\"=T1.\"OBJECT_ID\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Route loadCurrentDeep(Cursor cursor, boolean lock) {
        Route entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Guide guide = loadCurrentOther(daoSession.getGuideDao(), cursor, offset);
        entity.setGuide(guide);
        offset += daoSession.getGuideDao().getAllColumns().length;

        Place place = loadCurrentOther(daoSession.getPlaceDao(), cursor, offset);
        entity.setPlace(place);

        return entity;    
    }

    public Route loadDeep(Long key) {
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
    public List<Route> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Route> list = new ArrayList<Route>(count);
        
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
    
    protected List<Route> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Route> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
