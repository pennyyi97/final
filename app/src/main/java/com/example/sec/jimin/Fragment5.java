package com.example.sec.jimin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;


public class Fragment5 extends Fragment {
    //웹뷰 전역변수 설정
    private WebView wv;

    public Fragment5() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //xml의 웹뷰를 감싼 framelayout불러오기
        FrameLayout fl = (FrameLayout) inflater.inflate(R.layout.fragment_fragment5,container,false);

        //fragment는 가끔 웹뷰가 중복되어 에러가나기때문에 웹뷰를 리셋한다.
        if (wv != null){wv.destroy();}
        //웹뷰 불러오기
        wv = (WebView) fl.findViewById(R.id.webview);
        setWebView1(); //웹뷰 세팅

        return fl;
    }

    private void setWebView1() {
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setDefaultTextEncodingName("UTF-8");
        wv.setWebViewClient(new WebViewClient());

        wv.addJavascriptInterface(new JavaScriptInterface(getActivity()),"android");
        wv.loadUrl("http://www.google.com");
    }

    private class JavaScriptInterface {
        Context context;
        JavaScriptInterface(Context c){context = c;}
        @JavascriptInterface
        public void changePage(String idx){
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fragment_container2,new Fragment5()).commit();
        }
    }
}
