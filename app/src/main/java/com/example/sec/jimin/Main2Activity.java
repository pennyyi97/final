package com.example.sec.jimin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void learn(View v){
        Intent i =new Intent(this, Main3Activity.class);
        startActivity(i);

        Toast.makeText(this, "박지민이라는 사람은 어떤 사람일까요?", Toast.LENGTH_SHORT).show();
    }
}
