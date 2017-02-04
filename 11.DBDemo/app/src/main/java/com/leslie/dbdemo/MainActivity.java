package com.leslie.dbdemo;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // write
        SharedPreferences sp = getSharedPreferences("leslie", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("name", "leslie");
        editor.putInt("age", 28);
        editor.putBoolean("flag", true);
        editor.apply();

        // read
        String name = sp.getString("name", null);
        int age = sp.getInt("age", -100);
        Toast.makeText(this, name + " " + age, Toast.LENGTH_SHORT).show();

        MySQLiteHelper sqLiteHelper = new MySQLiteHelper(this, "mydb", null, 1);
        final SQLiteDatabase db = sqLiteHelper.getReadableDatabase(); // 这里会调用 onCreate,而且只会调用一次

        Button btnAdd = (Button) findViewById(R.id.add_user);
        Button btnGetUser = (Button) findViewById(R.id.get_users);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", "房林");
                contentValues.put("age", 28);
                db.insert("user", null, contentValues);
            }
        });
        btnGetUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = db.query("user", null, "id=?", new String[]{"1"}, null, null, null);
                String s = "";
                while (cursor.moveToNext()) {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    int age = cursor.getInt(cursor.getColumnIndex("age")); // 2
                    s += name + ":" + age + "\n";
                }

                cursor.close();

                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }
        });
    }
}






