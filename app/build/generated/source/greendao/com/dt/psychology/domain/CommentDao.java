package com.dt.psychology.domain;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "COMMENT".
*/
public class CommentDao extends AbstractDao<Comment, Long> {

    public static final String TABLENAME = "COMMENT";

    /**
     * Properties of entity Comment.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property CommentId = new Property(0, Long.class, "commentId", true, "_id");
        public final static Property FatherId = new Property(1, Long.class, "fatherId", false, "FATHER_ID");
        public final static Property CommentCategory = new Property(2, Byte.class, "commentCategory", false, "COMMENT_CATEGORY");
        public final static Property CreateTime = new Property(3, java.util.Date.class, "createTime", false, "CREATE_TIME");
        public final static Property UserId = new Property(4, Long.class, "userId", false, "USER_ID");
        public final static Property Content = new Property(5, String.class, "content", false, "CONTENT");
    }

    private DaoSession daoSession;


    public CommentDao(DaoConfig config) {
        super(config);
    }
    
    public CommentDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"COMMENT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: commentId
                "\"FATHER_ID\" INTEGER," + // 1: fatherId
                "\"COMMENT_CATEGORY\" INTEGER," + // 2: commentCategory
                "\"CREATE_TIME\" INTEGER," + // 3: createTime
                "\"USER_ID\" INTEGER," + // 4: userId
                "\"CONTENT\" TEXT);"); // 5: content
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"COMMENT\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Comment entity) {
        stmt.clearBindings();
 
        Long commentId = entity.getCommentId();
        if (commentId != null) {
            stmt.bindLong(1, commentId);
        }
 
        Long fatherId = entity.getFatherId();
        if (fatherId != null) {
            stmt.bindLong(2, fatherId);
        }
 
        Byte commentCategory = entity.getCommentCategory();
        if (commentCategory != null) {
            stmt.bindLong(3, commentCategory);
        }
 
        java.util.Date createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindLong(4, createTime.getTime());
        }
 
        Long userId = entity.getUserId();
        if (userId != null) {
            stmt.bindLong(5, userId);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(6, content);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Comment entity) {
        stmt.clearBindings();
 
        Long commentId = entity.getCommentId();
        if (commentId != null) {
            stmt.bindLong(1, commentId);
        }
 
        Long fatherId = entity.getFatherId();
        if (fatherId != null) {
            stmt.bindLong(2, fatherId);
        }
 
        Byte commentCategory = entity.getCommentCategory();
        if (commentCategory != null) {
            stmt.bindLong(3, commentCategory);
        }
 
        java.util.Date createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindLong(4, createTime.getTime());
        }
 
        Long userId = entity.getUserId();
        if (userId != null) {
            stmt.bindLong(5, userId);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(6, content);
        }
    }

    @Override
    protected final void attachEntity(Comment entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Comment readEntity(Cursor cursor, int offset) {
        Comment entity = new Comment( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // commentId
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // fatherId
            cursor.isNull(offset + 2) ? null : (byte) cursor.getShort(offset + 2), // commentCategory
            cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)), // createTime
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // userId
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // content
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Comment entity, int offset) {
        entity.setCommentId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setFatherId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setCommentCategory(cursor.isNull(offset + 2) ? null : (byte) cursor.getShort(offset + 2));
        entity.setCreateTime(cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)));
        entity.setUserId(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setContent(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Comment entity, long rowId) {
        entity.setCommentId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Comment entity) {
        if(entity != null) {
            return entity.getCommentId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Comment entity) {
        return entity.getCommentId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getUserDao().getAllColumns());
            builder.append(" FROM COMMENT T");
            builder.append(" LEFT JOIN USER T0 ON T.\"USER_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Comment loadCurrentDeep(Cursor cursor, boolean lock) {
        Comment entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        User user = loadCurrentOther(daoSession.getUserDao(), cursor, offset);
        entity.setUser(user);

        return entity;    
    }

    public Comment loadDeep(Long key) {
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
    public List<Comment> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Comment> list = new ArrayList<Comment>(count);
        
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
    
    protected List<Comment> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Comment> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
