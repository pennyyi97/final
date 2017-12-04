package com.example.sec.jimin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enter(View v){
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);

        Toast.makeText(this, "어서오세요", Toast.LENGTH_SHORT).show();
    }
}
