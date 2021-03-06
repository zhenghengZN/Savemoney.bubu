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
import greendao.bean.Contact;
import greendao.bean.Guide;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "CONTACT".
*/
public class ContactDao extends AbstractDao<Contact, String> {

    public static final String TABLENAME = "CONTACT";

    /**
     * Properties of entity Contact.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property ObjectId = new Property(0, String.class, "objectId", true, "OBJECT_ID");
        public final static Property Address = new Property(1, String.class, "address", false, "ADDRESS");
        public final static Property Fax = new Property(2, String.class, "fax", false, "FAX");
        public final static Property Email = new Property(3, String.class, "email", false, "EMAIL");
        public final static Property Desc = new Property(4, String.class, "desc", false, "DESC");
        public final static Property Index = new Property(5, Integer.class, "index", false, "INDEX");
        public final static Property Telephone = new Property(6, String.class, "telephone", false, "TELEPHONE");
        public final static Property Title = new Property(7, String.class, "title", false, "TITLE");
        public final static Property Website = new Property(8, String.class, "website", false, "WEBSITE");
        public final static Property RowStatus = new Property(9, String.class, "rowStatus", false, "ROW_STATUS");
        public final static Property CreatedAt = new Property(10, String.class, "createdAt", false, "CREATED_AT");
        public final static Property UpdatedAt = new Property(11, String.class, "updatedAt", false, "UPDATED_AT");
        public final static Property GuideId = new Property(12, String.class, "guideId", false, "GUIDE_ID");
    };

    private DaoSession daoSession;

    private Query<Contact> guide_ContactListQuery;

    public ContactDao(DaoConfig config) {
        super(config);
    }
    
    public ContactDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CONTACT\" (" + //
                "\"OBJECT_ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: objectId
                "\"ADDRESS\" TEXT," + // 1: address
                "\"FAX\" TEXT," + // 2: fax
                "\"EMAIL\" TEXT," + // 3: email
                "\"DESC\" TEXT," + // 4: desc
                "\"INDEX\" INTEGER," + // 5: index
                "\"TELEPHONE\" TEXT," + // 6: telephone
                "\"TITLE\" TEXT," + // 7: title
                "\"WEBSITE\" TEXT," + // 8: website
                "\"ROW_STATUS\" TEXT," + // 9: rowStatus
                "\"CREATED_AT\" TEXT," + // 10: createdAt
                "\"UPDATED_AT\" TEXT," + // 11: updatedAt
                "\"GUIDE_ID\" TEXT);"); // 12: guideId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CONTACT\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(DatabaseStatement stmt, Contact entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getObjectId());
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(2, address);
        }
 
        String fax = entity.getFax();
        if (fax != null) {
            stmt.bindString(3, fax);
        }
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(4, email);
        }
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(5, desc);
        }
 
        Integer index = entity.getIndex();
        if (index != null) {
            stmt.bindLong(6, index);
        }
 
        String telephone = entity.getTelephone();
        if (telephone != null) {
            stmt.bindString(7, telephone);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(8, title);
        }
 
        String website = entity.getWebsite();
        if (website != null) {
            stmt.bindString(9, website);
        }
 
        String rowStatus = entity.getRowStatus();
        if (rowStatus != null) {
            stmt.bindString(10, rowStatus);
        }
 
        String createdAt = entity.getCreatedAt();
        if (createdAt != null) {
            stmt.bindString(11, createdAt);
        }
 
        String updatedAt = entity.getUpdatedAt();
        if (updatedAt != null) {
            stmt.bindString(12, updatedAt);
        }
 
        String guideId = entity.getGuideId();
        if (guideId != null) {
            stmt.bindString(13, guideId);
        }
    }

    @Override
    protected void attachEntity(Contact entity) {
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
    public Contact readEntity(Cursor cursor, int offset) {
        Contact entity = new Contact( //
            cursor.getString(offset + 0), // objectId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // address
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // fax
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // email
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // desc
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // index
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // telephone
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // title
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // website
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // rowStatus
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // createdAt
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // updatedAt
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12) // guideId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Contact entity, int offset) {
        entity.setObjectId(cursor.getString(offset + 0));
        entity.setAddress(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setFax(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setEmail(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDesc(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setIndex(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setTelephone(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setTitle(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setWebsite(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setRowStatus(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setCreatedAt(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setUpdatedAt(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setGuideId(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(Contact entity, long rowId) {
        return entity.getObjectId();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(Contact entity) {
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
    
    /** Internal query to resolve the "contactList" to-many relationship of Guide. */
    public List<Contact> _queryGuide_ContactList(String guideId) {
        synchronized (this) {
            if (guide_ContactListQuery == null) {
                QueryBuilder<Contact> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.GuideId.eq(null));
                guide_ContactListQuery = queryBuilder.build();
            }
        }
        Query<Contact> query = guide_ContactListQuery.forCurrentThread();
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
            builder.append(" FROM CONTACT T");
            builder.append(" LEFT JOIN GUIDE T0 ON T.\"GUIDE_ID\"=T0.\"OBJECT_ID\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Contact loadCurrentDeep(Cursor cursor, boolean lock) {
        Contact entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Guide guide = loadCurrentOther(daoSession.getGuideDao(), cursor, offset);
        entity.setGuide(guide);

        return entity;    
    }

    public Contact loadDeep(Long key) {
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
    public List<Contact> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Contact> list = new ArrayList<Contact>(count);
        
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
    
    protected List<Contact> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Contact> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
