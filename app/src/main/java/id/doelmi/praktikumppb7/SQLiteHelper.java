package id.doelmi.praktikumppb7;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "praktikumppb7";
    private static final int DATABASE_VERSION = 1;

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE user(id INTEGER PRIMARY KEY, username TEXT, password TEXT);";
        db.execSQL(query);

        ModelUser modelUser = new ModelUser(db);
        modelUser.insert("admin", "admin");
        modelUser.insert("user", "user");
        modelUser.insert("labtia", "labtia");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
