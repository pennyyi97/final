package com.example.sec.jimin;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener{

    private final int FRAGMENT1 = 1;
    private final int FRAGMENT2 = 2;
    private final int FRAGMENT3 = 3;
    private final int FRAGMENT4 = 4;

    private Button bt_tab1, bt_tab2, bt_tab3, bt_tab4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //위젯에 대한 참조
        bt_tab1 = (Button)findViewById(R.id.bt_tab1);
        bt_tab2 = (Button)findViewById(R.id.bt_tab2);
        bt_tab3 = (Button)findViewById(R.id.bt_tab3);
        bt_tab4 = (Button)findViewById(R.id.bt_tab4);

        //탭 버튼에 대한 리스너 연결
        bt_tab1.setOnClickListener(this);
        bt_tab2.setOnClickListener(this);
        bt_tab3.setOnClickListener(this);
        bt_tab4.setOnClickListener(this);

        //임의로 액티비티 호출 시점에 어느 fragment를 프레임 레이아웃에 띄울 것인지를 정함
        callFragment(FRAGMENT4);
    }

    private void callFragment(int fragment_no) {

        //fragment사용을 위해
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (fragment_no){
            case 1:

                //fragment1 호출
                Fragment1 fragment1 = new Fragment1();
                transaction.replace(R.id.fragment_container, fragment1);
                transaction.commit();
                break;
            case 2:

                //fragment1 호출
                Fragment2 fragment2 = new Fragment2();
                transaction.replace(R.id.fragment_container, fragment2);
                transaction.commit();
                break;

            case 3:

                //fragment1 호출
                Fragment3 fragment3 = new Fragment3();
                transaction.replace(R.id.fragment_container, fragment3);
                transaction.commit();
                break;

            case 4:

                //fragment1 호출
                Fragment4 fragment4 = new Fragment4();
                transaction.replace(R.id.fragment_container, fragment4);
                transaction.commit();
                break;
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_tab1:
                //'버튼1'클릭 시 프래그먼트1 호출
                callFragment(FRAGMENT1);

                break;

            case R.id.bt_tab2:

                callFragment(FRAGMENT2);
                break;
            case R.id.bt_tab3:

                callFragment(FRAGMENT3);
                break;
            case R.id.bt_tab4:

                callFragment(FRAGMENT4);
                break;

        }
    }

    public void lookAround(View v){
        Intent i =new Intent(this, Main4Activity.class);
        startActivity(i);
    }

}
