package sg.edu.rp.c346.id22021506.song;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class DBhelper {

    //start version with 1
    //increment by 1 whenever db schema changes
    private static final int DATABASE_VER = 1;
    //filename of the database
    private static final String DATABASE_NAME ="Song.db";
    private static final String TABLE_SONG = "Song";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_SONG = "Song";
    private static final String COLUMN_SINGER = "Singer";
    private static final String COLUMN_YEAR = "Year";

    private static final String COLUMN_STARS = "Stars";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create your table(s) here
        String createTableSQL = "CREATE TABLE " + TABLE_SONG + "("
                + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_SONG + "TEXT,"
                + COLUMN_SINGER + "TEXT,"
                + COLUMN_YEAR + "INTEGER,"
                + COLUMN_STARS + "INTEGER )";

        db.execSQL(createTableSQL);
        Log.i("info" ,"created tables");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            // Drop the table if it exists
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_SONG);
            // Call onCreate to recreate the table
            onCreate(db);
        }
    }

    public void insertSong(String title, String singers, int year, int stars){
        //get an instance of the database for writing
        SQLiteDatabase db = this.getWritableDatabase();
        //we use ContentValues object to store the values for the db operation
        ContentValues values = new ContentValues();
        //store the column name as key and the title as value
        values.put(COLUMN_SONG, song);
        //store the column name as key and the singer as value
        values.put(COLUMN_SINGER, singers);
        //store the column name as key and the year as value
        values.put(COLUMN_YEAR, year);
        //store the column name as key and the stars as value
        values.put(COLUMN_STARS, stars);
        //insert the row into the TABLE_SONG
        db.insert(TABLE_SONG, null, values);
        //close the database connection
        db.close();

        public ArrayList<String> getSongContent() {
            //create an ArrayList that holds String objects
            ArrayList<String> songs = new ArrayList<String>();
            //get the instance of database to read
            SQLiteDatabase db = this.getReadableDatabase();
            String[] columns = {COLUMN_ID, COLUMN_SONG, COLUMN_SINGER, COLUMN_YEAR, COLUMN_STARS};
            //run the query and get back the Cursor object
            Cursor cursor = db.query(TABLE_SONG, columns, null, null, null, null, null, null);

            //moveToFirst() moves to first row, null if no records
            if (cursor.moveToFirst()) {
                //loop while moveToNext() points to next row and returns true; moveToNext() returns false
                //when no more next row to move to
                do {
                    //add the task content to the ArrayList object getString(0) retrieves first column data
                    //getString(1) return second column data getInt(0) if data is an integer value
                    songs.add(cursor.getString(1));
                } while (cursor.moveToNext());
            }
        }
            //close connection
            cursor.close();
            db.close();

            return song;
    }

}
