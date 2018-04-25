package id.doelmi.praktikumppb7;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;

public class ModelUser {
    SQLiteDatabase db;

    String TABLE_NAME = "user";

    public ModelUser(SQLiteDatabase db) {
        this.db = db;
    }

    public void insert(String username, String password){
        String query = "insert into "+TABLE_NAME+"(username, password) values('"+username+"', '"+password+"')";
        db.execSQL(query);
    }

    public void update(int id, String username, String password){
        String query = "update "+TABLE_NAME+" SET username = '"+username+"', password = '"+password+"' where id = "+id+";";
        db.execSQL(query);
    }

    public void delete(int id){
        String query = "delete from "+TABLE_NAME+" where id = "+id+";";
        db.execSQL(query);
    }

    public ArrayList<String> select(){
        ArrayList<String> username = new ArrayList<>();

        String query = "select * from "+TABLE_NAME+";";

        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()){
            String nama_user = cursor.getString(1);
            username.add(nama_user);
        }

        cursor.close();

        return username;
    }

    public User selectByID(int ID){
        User user = null;
        String query = "select * from "+TABLE_NAME+" where id = "+ID+";";
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String username = cursor.getString(1);
            String password = cursor.getString(2);
            user = new User(id, username, password);
        }
        return user;
    }
}
