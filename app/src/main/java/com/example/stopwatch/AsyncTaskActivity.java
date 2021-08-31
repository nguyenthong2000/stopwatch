package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

public class AsyncTaskActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        new ProgressAsyncTask().execute();


    }
    private class ProgressAsyncTask extends AsyncTask<Void,Integer,String>{

        @Override
        protected String doInBackground(Void... voids) {
            for(int i=0;i<=100;i++){
                publishProgress(i);
                try{
                    Thread.sleep(20);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            return "Done";
        }
        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(AsyncTaskActivity.this, s, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(AsyncTaskActivity.this, MainActivity.class);
            startActivity(intent);

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            //cap nhat giao dien thanh progressbar
            progressBar.setProgress(values[0]);
        }
    }

}