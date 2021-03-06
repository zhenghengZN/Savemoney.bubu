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
import greendao.bean.Article;
import greendao.bean.Guide;
import greendao.bean.Visa;


// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "ARTICLE".
*/
public class ArticleDao extends AbstractDao<Article, String> {

    public static final String TABLENAME = "ARTICLE";

    /**
     * Properties of entity Article.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property ObjectId = new Property(0, String.class, "objectId", true, "OBJECT_ID");
        public final static Property Index = new Property(1, Integer.class, "index", false, "INDEX");
        public final static Property Comments = new Property(2, Integer.class, "comments", false, "COMMENTS");
        public final static Property Likes = new Property(3, Integer.class, "likes", false, "LIKES");
        public final static Property Title = new Property(4, String.class, "title", false, "TITLE");
        public final static Property RowStatus = new Property(5, String.class, "rowStatus", false, "ROW_STATUS");
        public final static Property Notes = new Property(6, String.class, "notes", false, "NOTES");
        public final static Property Desc = new Property(7, String.class, "desc", false, "DESC");
        public final static Property AllDay = new Property(8, Integer.class, "allDay", false, "ALL_DAY");
        public final static Property Day = new Property(9, Integer.class, "day", false, "DAY");
        public final static Property Links = new Property(10, String.class, "links", false, "LINKS");
        public final static Property Photos = new Property(11, String.class, "photos", false, "PHOTOS");
        public final static Property CheckListItems = new Property(12, String.class, "checkListItems", false, "CHECK_LIST_ITEMS");
        public final static Property Place = new Property(13, String.class, "place", false, "PLACE");
        public final static Property BestTime = new Property(14, String.class, "bestTime", false, "BEST_TIME");
        public final static Property Category = new Property(15, String.class, "category", false, "CATEGORY");
        public final static Property Urls = new Property(16, String.class, "urls", false, "URLS");
        public final static Property Tips = new Property(17, String.class, "tips", false, "TIPS");
        public final static Property ItineraryId = new Property(18, String.class, "itineraryId", false, "ITINERARY_ID");
        public final static Property CreatedAt = new Property(19, String.class, "createdAt", false, "CREATED_AT");
        public final static Property UpdatedAt = new Property(20, String.class, "updatedAt", false, "UPDATED_AT");
        public final static Property VisaId = new Property(21, String.class, "visaId", false, "VISA_ID");
        public final static Property GuideId = new Property(22, String.class, "guideId", false, "GUIDE_ID");
    };

    private DaoSession daoSession;

    private Query<Article> visa_ArticlesListQuery;
    private Query<Article> guide_ArticlesListQuery;

    public ArticleDao(DaoConfig config) {
        super(config);
    }
    
    public ArticleDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ARTICLE\" (" + //
                "\"OBJECT_ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: objectId
                "\"INDEX\" INTEGER," + // 1: index
                "\"COMMENTS\" INTEGER," + // 2: comments
                "\"LIKES\" INTEGER," + // 3: likes
                "\"TITLE\" TEXT," + // 4: title
                "\"ROW_STATUS\" TEXT," + // 5: rowStatus
                "\"NOTES\" TEXT," + // 6: notes
                "\"DESC\" TEXT," + // 7: desc
                "\"ALL_DAY\" INTEGER," + // 8: allDay
                "\"DAY\" INTEGER," + // 9: day
                "\"LINKS\" TEXT," + // 10: links
                "\"PHOTOS\" TEXT," + // 11: photos
                "\"CHECK_LIST_ITEMS\" TEXT," + // 12: checkListItems
                "\"PLACE\" TEXT," + // 13: place
                "\"BEST_TIME\" TEXT," + // 14: bestTime
                "\"CATEGORY\" TEXT," + // 15: category
                "\"URLS\" TEXT," + // 16: urls
                "\"TIPS\" TEXT," + // 17: tips
                "\"ITINERARY_ID\" TEXT," + // 18: itineraryId
                "\"CREATED_AT\" TEXT," + // 19: createdAt
                "\"UPDATED_AT\" TEXT," + // 20: updatedAt
                "\"VISA_ID\" TEXT," + // 21: visaId
                "\"GUIDE_ID\" TEXT);"); // 22: guideId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ARTICLE\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(DatabaseStatement stmt, Article entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getObjectId());
 
        Integer index = entity.getIndex();
        if (index != null) {
            stmt.bindLong(2, index);
        }
 
        Integer comments = entity.getComments();
        if (comments != null) {
            stmt.bindLong(3, comments);
        }
 
        Integer likes = entity.getLikes();
        if (likes != null) {
            stmt.bindLong(4, likes);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(5, title);
        }
 
        String rowStatus = entity.getRowStatus();
        if (rowStatus != null) {
            stmt.bindString(6, rowStatus);
        }
 
        String notes = entity.getNotes();
        if (notes != null) {
            stmt.bindString(7, notes);
        }
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(8, desc);
        }
 
        Integer allDay = entity.getAllDay();
        if (allDay != null) {
            stmt.bindLong(9, allDay);
        }
 
        Integer day = entity.getDay();
        if (day != null) {
            stmt.bindLong(10, day);
        }
 
        String links = entity.getLinks();
        if (links != null) {
            stmt.bindString(11, links);
        }
 
        String photos = entity.getPhotos();
        if (photos != null) {
            stmt.bindString(12, photos);
        }
 
        String checkListItems = entity.getCheckListItems();
        if (checkListItems != null) {
            stmt.bindString(13, checkListItems);
        }
 
        String place = entity.getPlace();
        if (place != null) {
            stmt.bindString(14, place);
        }
 
        String bestTime = entity.getBestTime();
        if (bestTime != null) {
            stmt.bindString(15, bestTime);
        }
 
        String category = entity.getCategory();
        if (category != null) {
            stmt.bindString(16, category);
        }
 
        String urls = entity.getUrls();
        if (urls != null) {
            stmt.bindString(17, urls);
        }
 
        String tips = entity.getTips();
        if (tips != null) {
            stmt.bindString(18, tips);
        }
 
        String itineraryId = entity.getItineraryId();
        if (itineraryId != null) {
            stmt.bindString(19, itineraryId);
        }
 
        String createdAt = entity.getCreatedAt();
        if (createdAt != null) {
            stmt.bindString(20, createdAt);
        }
 
        String updatedAt = entity.getUpdatedAt();
        if (updatedAt != null) {
            stmt.bindString(21, updatedAt);
        }
 
        String visaId = entity.getVisaId();
        if (visaId != null) {
            stmt.bindString(22, visaId);
        }
 
        String guideId = entity.getGuideId();
        if (guideId != null) {
            stmt.bindString(23, guideId);
        }
    }

    @Override
    protected void attachEntity(Article entity) {
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
    public Article readEntity(Cursor cursor, int offset) {
        Article entity = new Article( //
            cursor.getString(offset + 0), // objectId
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // index
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // comments
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // likes
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // title
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // rowStatus
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // notes
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // desc
            cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8), // allDay
            cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9), // day
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // links
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // photos
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // checkListItems
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // place
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // bestTime
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // category
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // urls
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // tips
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // itineraryId
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // createdAt
            cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), // updatedAt
            cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), // visaId
            cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22) // guideId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Article entity, int offset) {
        entity.setObjectId(cursor.getString(offset + 0));
        entity.setIndex(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setComments(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setLikes(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setTitle(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setRowStatus(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setNotes(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setDesc(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setAllDay(cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8));
        entity.setDay(cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9));
        entity.setLinks(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setPhotos(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setCheckListItems(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setPlace(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setBestTime(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setCategory(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setUrls(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setTips(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setItineraryId(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setCreatedAt(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setUpdatedAt(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setVisaId(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setGuideId(cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(Article entity, long rowId) {
        return entity.getObjectId();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(Article entity) {
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
    
    /** Internal query to resolve the "articlesList" to-many relationship of Visa. */
    public List<Article> _queryVisa_ArticlesList(String visaId) {
        synchronized (this) {
            if (visa_ArticlesListQuery == null) {
                QueryBuilder<Article> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.VisaId.eq(null));
                visa_ArticlesListQuery = queryBuilder.build();
            }
        }
        Query<Article> query = visa_ArticlesListQuery.forCurrentThread();
        query.setParameter(0, visaId);
        return query.list();
    }

    /** Internal query to resolve the "articlesList" to-many relationship of Guide. */
    public List<Article> _queryGuide_ArticlesList(String guideId) {
        synchronized (this) {
            if (guide_ArticlesListQuery == null) {
                QueryBuilder<Article> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.GuideId.eq(null));
                guide_ArticlesListQuery = queryBuilder.build();
            }
        }
        Query<Article> query = guide_ArticlesListQuery.forCurrentThread();
        query.setParameter(0, guideId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getVisaDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getGuideDao().getAllColumns());
            builder.append(" FROM ARTICLE T");
            builder.append(" LEFT JOIN VISA T0 ON T.\"VISA_ID\"=T0.\"OBJECT_ID\"");
            builder.append(" LEFT JOIN GUIDE T1 ON T.\"GUIDE_ID\"=T1.\"OBJECT_ID\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Article loadCurrentDeep(Cursor cursor, boolean lock) {
        Article entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Visa visa = loadCurrentOther(daoSession.getVisaDao(), cursor, offset);
        entity.setVisa(visa);
        offset += daoSession.getVisaDao().getAllColumns().length;

        Guide guide = loadCurrentOther(daoSession.getGuideDao(), cursor, offset);
        entity.setGuide(guide);

        return entity;    
    }

    public Article loadDeep(Long key) {
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
    public List<Article> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Article> list = new ArrayList<Article>(count);
        
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
    
    protected List<Article> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Article> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
