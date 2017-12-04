package com.example.sec.jimin;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main5Activity extends AppCompatActivity implements View.OnClickListener{
    private final int FRAGMENT5 = 5;
    private final int FRAGMENT6 = 6;
    private final int FRAGMENT7 = 7;
    private final int FRAGMENT8 = 8;

    private Button bt_tab5, bt_tab6, bt_tab7, bt_tab8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        bt_tab5 = (Button)findViewById(R.id.bt_tab5);
        bt_tab6 = (Button)findViewById(R.id.bt_tab6);
        bt_tab7 = (Button)findViewById(R.id.bt_tab7);
        bt_tab8 = (Button)findViewById(R.id.bt_tab8);

        bt_tab5.setOnClickListener(this);
        bt_tab6.setOnClickListener(this);
        bt_tab7.setOnClickListener(this);
        bt_tab8.setOnClickListener(this);

        callFragment(FRAGMENT5);
    }

    private void callFragment(int fragment_no) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (fragment_no) {
            case 5:

                //fragment1 호출
                Fragment5 fragment5 = new Fragment5();
                transaction.replace(R.id.fragment_container2, fragment5);
                transaction.commit();
                break;
            case 6:

                //fragment1 호출
                Fragment6 fragment6 = new Fragment6();
                transaction.replace(R.id.fragment_container2, fragment6);
                transaction.commit();
                break;

            case 7:

                //fragment1 호출
                Fragment7 fragment7 = new Fragment7();
                transaction.replace(R.id.fragment_container2, fragment7);
                transaction.commit();
                break;

            case 8:

                //fragment1 호출
                Fragment8 fragment8 = new Fragment8();
                transaction.replace(R.id.fragment_container2, fragment8);
                transaction.commit();
                break;
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bt_tab5:
                //'버튼1'클릭 시 프래그먼트1 호출
                callFragment(FRAGMENT5);
                break;

            case R.id.bt_tab6:

                callFragment(FRAGMENT6);
                break;
            case R.id.bt_tab7:

                callFragment(FRAGMENT7);
                break;
            case R.id.bt_tab8:

                callFragment(FRAGMENT8);
                break;

        }

    }
}
