package com.example.stopwatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Trace;
import android.text.style.UpdateAppearance;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_thoigian ;
    Button btn_batdau,btn_datlai;
    Handler handler;
    public boolean running;
    public int seconds;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_thoigian=(TextView)findViewById(R.id.tv_thoigian);
        btn_batdau=(Button)findViewById(R.id.btn_batdau);
        btn_datlai=(Button)findViewById(R.id.bnt_datlai);
        btn_batdau.setOnClickListener(this);
        btn_datlai.setOnClickListener(this);
        start();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_batdau:
                running=!running;
                if(running){
                    btn_batdau.setText("Tạm dừng");
                }else {
                    btn_batdau.setText("Bắt đầu");
                }
                break;
            case R.id.bnt_datlai:
                running=false;
                seconds=0;
                btn_batdau.setText("Bắt đầu");
                break;
            default:
                break;
        }
    }
            
    private void start(){
        handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes=(seconds%3600)/60;
                int secs=seconds%60;
                String time=String.format("%02d:%02d,%02d",hours,minutes,secs);
                tv_thoigian.setText(time);

                if (running){
                    seconds++;
                }
                handler.postDelayed(this,0);

            }
        });
    }

}