package com.example.sec.jimin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public void setTitle(View v){
        EditText tit = (EditText)findViewById(R.id.title);

        TextView show = (TextView)findViewById(R.id.titleView);
        show.setText("title : "+tit.getText());
    }

    public void next(View b){
        Intent ne = new Intent(this, Main5Activity.class);
        startActivity(ne);
    }

    public void home(View v){
        Intent i =new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void back(View a){
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }
}
