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
import greendao.bean.Airline;
import greendao.bean.Route;


// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "AIRLINE".
*/
public class AirlineDao extends AbstractDao<Airline, String> {

    public static final String TABLENAME = "AIRLINE";

    /**
     * Properties of entity Airline.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property ObjectId = new Property(0, String.class, "objectId", true, "OBJECT_ID");
        public final static Property NameCn = new Property(1, String.class, "nameCn", false, "NAME_CN");
        public final static Property IataCode = new Property(2, String.class, "iataCode", false, "IATA_CODE");
        public final static Property CreatedAt = new Property(3, String.class, "createdAt", false, "CREATED_AT");
        public final static Property UpdatedAt = new Property(4, String.class, "updatedAt", false, "UPDATED_AT");
        public final static Property IcaoCode = new Property(5, String.class, "icaoCode", false, "ICAO_CODE");
        public final static Property Name = new Property(6, String.class, "name", false, "NAME");
        public final static Property Country = new Property(7, String.class, "country", false, "COUNTRY");
        public final static Property OpenFlightId = new Property(8, Integer.class, "openFlightId", false, "OPEN_FLIGHT_ID");
        public final static Property CallSign = new Property(9, String.class, "callSign", false, "CALL_SIGN");
        public final static Property CountryCn = new Property(10, String.class, "countryCn", false, "COUNTRY_CN");
        public final static Property RouteId = new Property(11, String.class, "routeId", false, "ROUTE_ID");
    };

    private DaoSession daoSession;

    private Query<Airline> route_AirlineListQuery;

    public AirlineDao(DaoConfig config) {
        super(config);
    }
    
    public AirlineDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"AIRLINE\" (" + //
                "\"OBJECT_ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: objectId
                "\"NAME_CN\" TEXT," + // 1: nameCn
                "\"IATA_CODE\" TEXT," + // 2: iataCode
                "\"CREATED_AT\" TEXT," + // 3: createdAt
                "\"UPDATED_AT\" TEXT," + // 4: updatedAt
                "\"ICAO_CODE\" TEXT," + // 5: icaoCode
                "\"NAME\" TEXT," + // 6: name
                "\"COUNTRY\" TEXT," + // 7: country
                "\"OPEN_FLIGHT_ID\" INTEGER," + // 8: openFlightId
                "\"CALL_SIGN\" TEXT," + // 9: callSign
                "\"COUNTRY_CN\" TEXT," + // 10: countryCn
                "\"ROUTE_ID\" TEXT);"); // 11: routeId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"AIRLINE\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(DatabaseStatement stmt, Airline entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getObjectId());
 
        String nameCn = entity.getNameCn();
        if (nameCn != null) {
            stmt.bindString(2, nameCn);
        }
 
        String iataCode = entity.getIataCode();
        if (iataCode != null) {
            stmt.bindString(3, iataCode);
        }
 
        String createdAt = entity.getCreatedAt();
        if (createdAt != null) {
            stmt.bindString(4, createdAt);
        }
 
        String updatedAt = entity.getUpdatedAt();
        if (updatedAt != null) {
            stmt.bindString(5, updatedAt);
        }
 
        String icaoCode = entity.getIcaoCode();
        if (icaoCode != null) {
            stmt.bindString(6, icaoCode);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(7, name);
        }
 
        String country = entity.getCountry();
        if (country != null) {
            stmt.bindString(8, country);
        }
 
        Integer openFlightId = entity.getOpenFlightId();
        if (openFlightId != null) {
            stmt.bindLong(9, openFlightId);
        }
 
        String callSign = entity.getCallSign();
        if (callSign != null) {
            stmt.bindString(10, callSign);
        }
 
        String countryCn = entity.getCountryCn();
        if (countryCn != null) {
            stmt.bindString(11, countryCn);
        }
 
        String routeId = entity.getRouteId();
        if (routeId != null) {
            stmt.bindString(12, routeId);
        }
    }

    @Override
    protected void attachEntity(Airline entity) {
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
    public Airline readEntity(Cursor cursor, int offset) {
        Airline entity = new Airline( //
            cursor.getString(offset + 0), // objectId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // nameCn
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // iataCode
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // createdAt
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // updatedAt
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // icaoCode
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // name
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // country
            cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8), // openFlightId
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // callSign
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // countryCn
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11) // routeId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Airline entity, int offset) {
        entity.setObjectId(cursor.getString(offset + 0));
        entity.setNameCn(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setIataCode(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCreatedAt(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setUpdatedAt(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setIcaoCode(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setName(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setCountry(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setOpenFlightId(cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8));
        entity.setCallSign(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setCountryCn(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setRouteId(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(Airline entity, long rowId) {
        return entity.getObjectId();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(Airline entity) {
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
    
    /** Internal query to resolve the "airlineList" to-many relationship of Route. */
    public List<Airline> _queryRoute_AirlineList(String routeId) {
        synchronized (this) {
            if (route_AirlineListQuery == null) {
                QueryBuilder<Airline> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.RouteId.eq(null));
                route_AirlineListQuery = queryBuilder.build();
            }
        }
        Query<Airline> query = route_AirlineListQuery.forCurrentThread();
        query.setParameter(0, routeId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getRouteDao().getAllColumns());
            builder.append(" FROM AIRLINE T");
            builder.append(" LEFT JOIN ROUTE T0 ON T.\"ROUTE_ID\"=T0.\"OBJECT_ID\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Airline loadCurrentDeep(Cursor cursor, boolean lock) {
        Airline entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Route route = loadCurrentOther(daoSession.getRouteDao(), cursor, offset);
        entity.setRoute(route);

        return entity;    
    }

    public Airline loadDeep(Long key) {
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
    public List<Airline> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Airline> list = new ArrayList<Airline>(count);
        
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
    
    protected List<Airline> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Airline> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
