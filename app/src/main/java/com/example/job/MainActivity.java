package com.example.job;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Button button1;
    EditText cname, cphnum;
    public static final String SHARED_PREFS="shared prefs";
    public static final String TEXT1="text1";
    public static final String TEXT2="text2";
    String text1=" ";
    String text2=" ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.button);
        cname=findViewById(R.id.Name);
        cphnum=findViewById(R.id.Phnum);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
        load();
        update();
    }
    public void save() {
        SharedPreferences sf=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor ed=sf.edit();
        ed.putString(TEXT1,cname.getText().toString());
        ed.putString(TEXT2,cphnum.getText().toString());
        ed.apply();
        Toast.makeText(this,"SAVED THE DATA",Toast.LENGTH_SHORT).show();
    }
    public void update() {
        cname.setText(text1);
        cphnum.setText(text2);
    }
    public void load() {
        SharedPreferences sf=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        text1= sf.getString(TEXT1," ");
        text2= sf.getString(TEXT2," ");
    }
}