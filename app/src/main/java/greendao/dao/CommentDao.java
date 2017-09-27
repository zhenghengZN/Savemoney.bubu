package greendao.dao;

import android.database.Cursor;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.database.Database;
import de.greenrobot.dao.database.DatabaseStatement;
import de.greenrobot.dao.internal.DaoConfig;
import greendao.bean.Comment;


// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "COMMENT".
*/
public class CommentDao extends AbstractDao<Comment, String> {

    public static final String TABLENAME = "COMMENT";

    /**
     * Properties of entity Comment.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property ObjectId = new Property(0, String.class, "objectId", true, "OBJECT_ID");
        public final static Property Content = new Property(1, String.class, "content", false, "CONTENT");
        public final static Property Type = new Property(2, String.class, "type", false, "TYPE");
        public final static Property ReferenceId = new Property(3, String.class, "referenceId", false, "REFERENCE_ID");
        public final static Property Source = new Property(4, String.class, "source", false, "SOURCE");
        public final static Property Event = new Property(5, String.class, "event", false, "EVENT");
        public final static Property RowStatus = new Property(6, String.class, "rowStatus", false, "ROW_STATUS");
        public final static Property Destination = new Property(7, String.class, "destination", false, "DESTINATION");
        public final static Property CreatedAt = new Property(8, String.class, "createdAt", false, "CREATED_AT");
        public final static Property UpdatedAt = new Property(9, String.class, "updatedAt", false, "UPDATED_AT");
    };


    public CommentDao(DaoConfig config) {
        super(config);
    }
    
    public CommentDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"COMMENT\" (" + //
                "\"OBJECT_ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: objectId
                "\"CONTENT\" TEXT," + // 1: content
                "\"TYPE\" TEXT," + // 2: type
                "\"REFERENCE_ID\" TEXT," + // 3: referenceId
                "\"SOURCE\" TEXT," + // 4: source
                "\"EVENT\" TEXT," + // 5: event
                "\"ROW_STATUS\" TEXT," + // 6: rowStatus
                "\"DESTINATION\" TEXT," + // 7: destination
                "\"CREATED_AT\" TEXT," + // 8: createdAt
                "\"UPDATED_AT\" TEXT);"); // 9: updatedAt
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"COMMENT\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(DatabaseStatement stmt, Comment entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getObjectId());
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(2, content);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(3, type);
        }
 
        String referenceId = entity.getReferenceId();
        if (referenceId != null) {
            stmt.bindString(4, referenceId);
        }
 
        String source = entity.getSource();
        if (source != null) {
            stmt.bindString(5, source);
        }
 
        String event = entity.getEvent();
        if (event != null) {
            stmt.bindString(6, event);
        }
 
        String rowStatus = entity.getRowStatus();
        if (rowStatus != null) {
            stmt.bindString(7, rowStatus);
        }
 
        String destination = entity.getDestination();
        if (destination != null) {
            stmt.bindString(8, destination);
        }
 
        String createdAt = entity.getCreatedAt();
        if (createdAt != null) {
            stmt.bindString(9, createdAt);
        }
 
        String updatedAt = entity.getUpdatedAt();
        if (updatedAt != null) {
            stmt.bindString(10, updatedAt);
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Comment readEntity(Cursor cursor, int offset) {
        Comment entity = new Comment( //
            cursor.getString(offset + 0), // objectId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // content
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // type
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // referenceId
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // source
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // event
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // rowStatus
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // destination
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // createdAt
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9) // updatedAt
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Comment entity, int offset) {
        entity.setObjectId(cursor.getString(offset + 0));
        entity.setContent(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setType(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setReferenceId(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setSource(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setEvent(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setRowStatus(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setDestination(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setCreatedAt(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setUpdatedAt(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(Comment entity, long rowId) {
        return entity.getObjectId();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(Comment entity) {
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
    
}