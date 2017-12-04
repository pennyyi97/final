package com.example.sec.jimin;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Fragment6 extends Fragment {
    TextView Date, Gre;
    UsedAsync asyncTask;
    ProgressHandler handler;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String time;

    public Fragment6() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_fragment6, container, false);

        Date = (TextView) view.findViewById(R.id.Date);
        Gre = (TextView) view.findViewById(R.id.Gre);

        handler = new ProgressHandler();
        runTime();
        return view;
    }

    public void runTime() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        time = sdf.format(new Date(System.currentTimeMillis()));

                        Message message = handler.obtainMessage();
                        handler.sendMessage(message);

                        Thread.sleep(1000);
                    } catch (InterruptedException ie) {}

                }
            }
        });
        thread.start();

        asyncTask = new UsedAsync();
        asyncTask.execute();
    }

    class ProgressHandler extends Handler{
        @Override
        public void handleMessage(Message msg){
            Date.setText(time);
        }
    }

    class UsedAsync extends AsyncTask<Integer, Integer, Integer>{
        Calendar cal;
        String timeGre;

        @Override
        protected Integer doInBackground(Integer... params) {
            while (isCancelled() == false){
                cal = new GregorianCalendar();
                timeGre = String.format("%d/%d/%d  %d:%d:%d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1,
                        cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE),
                        cal.get(Calendar.SECOND));
                publishProgress();
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException ie) {}
            }
            return null;
        }

        @Override
        protected void onPreExecute(){
            cal = new GregorianCalendar();
            timeGre = String.format("%d/%d/%d  %d:%d:%d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1,
                    cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE),
                    cal.get(Calendar.SECOND));
            Gre.setText(timeGre);

            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Integer integer){
            super.onPostExecute(integer);
        }

        @Override
        protected void onProgressUpdate(Integer...values){
            Gre.setText(timeGre);

            super.onProgressUpdate(values);
        }
    }
}

