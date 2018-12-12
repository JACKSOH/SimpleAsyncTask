package com.example.taruc.simpleasynctask;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {
    private WeakReference<TextView> mTextView;
    ProgressDialog pd;

    Handler handler = new Handler();

    Runnable runnable = new Runnable()
    {
        @Override
        public void run()
        {

            handler.postDelayed(this,s);
        }
    };
    int s=0;

    SimpleAsyncTask(TextView tv) {
        mTextView = new WeakReference<>(tv);
    }


    @Override
    protected  void onProgressUpdate(Void... voids){


       //  mTextView.get().setText(s);

    }
    @Override
    protected String doInBackground(Void... voids) {
       // handler.postDelayed(r,)
      //  onProgressUpdate();
        // Generate a random number between 0 and 10
        Random r = new Random();
        int n = r.nextInt(11);

        // Make the task take long enough that we have
        // time to rotate the phone while it is running
        s = n * 300;

        // Sleep for the random amount of time
        Thread thread = new Thread(runnable);

        try {
            thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Return a String result
        return "Awake at last after sleeping for " + s + " milliseconds!";
    }
    @Override
    protected void onPostExecute(String result) {

       // pd.dismiss();
        mTextView.get().setText(result);
    }



}
