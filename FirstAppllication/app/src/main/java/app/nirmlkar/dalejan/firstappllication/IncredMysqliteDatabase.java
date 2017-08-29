package app.nirmlkar.dalejan.firstappllication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dalejan on 29/8/17.
 */

public class IncredMysqliteDatabase extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "UserManager.db";

    // User table name
    private static final String TABLE_USER = "user";
    private static final String TABLE_USER_EDU = "user_Edu";


    // User Table Columns names
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";

    private static final String COLUMN_USER_EDU_ID = "user_edu_id";
    private static final String COLUMN_USER_EDU_NAME = "user_edu_name";
    private static final String COLUMN_USER_EDU_PM= "user_pm";
    private static final String COLUMN_USER_EDU_SEC = "user_sec";
    private static final String COLUMN_USER_EDU_GR = "user_gr";
    private static final String COLUMN_USER_EDU_PGR= "user_pgr";
    private static final String COLUMN_USER_EDU_DIP = "user_dip";
    private static final String COLUMN_USER_EDU_PHD = "user_phd";



    // create table sql query
    private String CREATE_USER_EDU_TABLE = "CREATE TABLE " + TABLE_USER_EDU + "("
            + COLUMN_USER_EDU_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_EDU_NAME + " TEXT,"
            + COLUMN_USER_EDU_PM + " TEXT," + COLUMN_USER_EDU_SEC + " TEXT," + COLUMN_USER_EDU_GR + " TEXT," +" TEXT,"
            + COLUMN_USER_EDU_PGR + " TEXT," +" TEXT,"
            + COLUMN_USER_EDU_DIP + " TEXT," + COLUMN_USER_EDU_PHD + " TEXT" + ")";

    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;
    private String DROP_USER_EDU_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER_EDU;

    /**
     * Constructor
     *
     * @param context
     */
    public IncredMysqliteDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_USER_EDU_TABLE);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);
        db.execSQL(DROP_USER_EDU_TABLE);

        // Create tables again
        onCreate(db);

    }

    /**
     * This method is to create user record
     *
     * @param user
     */
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }




    public void addUseredu(UserEdu user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_EDU_NAME, user.getName());
        values.put(COLUMN_USER_EDU_PM, user.getPm());
        values.put(COLUMN_USER_EDU_SEC, user.getSec());
        values.put(COLUMN_USER_EDU_GR, user.getGr());
        values.put(COLUMN_USER_EDU_PGR, user.getPgr());
        values.put(COLUMN_USER_EDU_DIP, user.getDip());
        values.put(COLUMN_USER_EDU_PHD, user.getPhd());

        // Inserting Row
        db.insert(TABLE_USER_EDU, null, values);
        db.close();
    }


    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_EMAIL,
                COLUMN_USER_NAME,
                COLUMN_USER_PASSWORD
        };
        // sorting orders
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }



    public List<UserEdu> getAlledu() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_EDU_ID,
                COLUMN_USER_EDU_NAME,
                COLUMN_USER_EDU_PM,
                COLUMN_USER_EDU_SEC,
                COLUMN_USER_EDU_GR,
                COLUMN_USER_EDU_PGR,
                COLUMN_USER_EDU_DIP,
                COLUMN_USER_EDU_PHD
        };
        // sorting orders
        String sortOrder =
                COLUMN_USER_EDU_NAME + " ASC";
        List<UserEdu> userList = new ArrayList<UserEdu>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {


                UserEdu user = new UserEdu();
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EDU_NAME)));
                user.setPm(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EDU_PM)));
                user.setSec(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EDU_SEC)));
                user.setGr(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EDU_GR)));
                user.setPgr(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EDU_PGR)));
                user.setDip(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EDU_DIP)));
                user.setPhd(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EDU_PHD)));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }






    public boolean checkUser(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }


}
