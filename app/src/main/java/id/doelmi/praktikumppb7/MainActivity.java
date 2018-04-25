package id.doelmi.praktikumppb7;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ListView list_user;

    ArrayList<String> dataUser;

    SQLiteOpenHelper helper;

    SQLiteDatabase db;

    ModelUser modelUser;

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_user = findViewById(R.id.list_user);

        helper = new SQLiteHelper(getApplicationContext());
        db = helper.getReadableDatabase();

        modelUser = new ModelUser(db);

        modelUser.update(1, "admin123", "admin123");

        modelUser.delete(2);

        dataUser = modelUser.select();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dataUser);

        list_user.setAdapter(adapter);

    }
}
