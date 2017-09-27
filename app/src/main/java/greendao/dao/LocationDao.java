package greendao.dao;

import android.database.Cursor;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.database.Database;
import de.greenrobot.dao.database.DatabaseStatement;
import de.greenrobot.dao.internal.DaoConfig;
import greendao.bean.Location;


// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "LOCATION".
*/
public class LocationDao extends AbstractDao<Location, String> {

    public static final String TABLENAME = "LOCATION";

    /**
     * Properties of entity Location.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property CloudId = new Property(0, String.class, "cloudId", true, "CLOUD_ID");
        public final static Property CountryCode = new Property(1, String.class, "countryCode", false, "COUNTRY_CODE");
        public final static Property RowStatus = new Property(2, String.class, "rowStatus", false, "ROW_STATUS");
        public final static Property Type = new Property(3, String.class, "type", false, "TYPE");
        public final static Property NameCn = new Property(4, String.class, "nameCn", false, "NAME_CN");
        public final static Property Name = new Property(5, String.class, "name", false, "NAME");
        public final static Property Parent = new Property(6, String.class, "parent", false, "PARENT");
        public final static Property City = new Property(7, String.class, "city", false, "CITY");
        public final static Property Region = new Property(8, String.class, "region", false, "REGION");
        public final static Property Country = new Property(9, String.class, "country", false, "COUNTRY");
        public final static Property LocalId = new Property(10, Integer.class, "localId", false, "LOCAL_ID");
    };


    public LocationDao(DaoConfig config) {
        super(config);
    }
    
    public LocationDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"LOCATION\" (" + //
                "\"CLOUD_ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: cloudId
                "\"COUNTRY_CODE\" TEXT," + // 1: countryCode
                "\"ROW_STATUS\" TEXT," + // 2: rowStatus
                "\"TYPE\" TEXT," + // 3: type
                "\"NAME_CN\" TEXT," + // 4: nameCn
                "\"NAME\" TEXT," + // 5: name
                "\"PARENT\" TEXT," + // 6: parent
                "\"CITY\" TEXT," + // 7: city
                "\"REGION\" TEXT," + // 8: region
                "\"COUNTRY\" TEXT," + // 9: country
                "\"LOCAL_ID\" INTEGER);"); // 10: localId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LOCATION\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(DatabaseStatement stmt, Location entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getCloudId());
 
        String countryCode = entity.getCountryCode();
        if (countryCode != null) {
            stmt.bindString(2, countryCode);
        }
 
        String rowStatus = entity.getRowStatus();
        if (rowStatus != null) {
            stmt.bindString(3, rowStatus);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(4, type);
        }
 
        String nameCn = entity.getNameCn();
        if (nameCn != null) {
            stmt.bindString(5, nameCn);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(6, name);
        }
 
        String parent = entity.getParent();
        if (parent != null) {
            stmt.bindString(7, parent);
        }
 
        String city = entity.getCity();
        if (city != null) {
            stmt.bindString(8, city);
        }
 
        String region = entity.getRegion();
        if (region != null) {
            stmt.bindString(9, region);
        }
 
        String country = entity.getCountry();
        if (country != null) {
            stmt.bindString(10, country);
        }
 
        Integer localId = entity.getLocalId();
        if (localId != null) {
            stmt.bindLong(11, localId);
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Location readEntity(Cursor cursor, int offset) {
        Location entity = new Location( //
            cursor.getString(offset + 0), // cloudId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // countryCode
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // rowStatus
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // type
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // nameCn
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // name
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // parent
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // city
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // region
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // country
            cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10) // localId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Location entity, int offset) {
        entity.setCloudId(cursor.getString(offset + 0));
        entity.setCountryCode(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setRowStatus(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setType(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setNameCn(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setName(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setParent(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setCity(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setRegion(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setCountry(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setLocalId(cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(Location entity, long rowId) {
        return entity.getCloudId();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(Location entity) {
        if(entity != null) {
            return entity.getCloudId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
