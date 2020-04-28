/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.simpleasynctask;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

/**
 * The SimpleAsyncTask class extends AsyncTask to perform a very simple
 * background task -- in this case, it just sleeps for a random amount of time.
 */

public class SimpleAsyncTask extends AsyncTask<Void,Integer, String> {

    // The TextView where we will show results
    private WeakReference<TextView> mTextView;
    private WeakReference<ProgressBar> mpb;
    // Constructor that provides a reference to the TextView from the MainActivity
    SimpleAsyncTask(TextView tv, ProgressBar pb) {
            mTextView = new WeakReference<>(tv);
            mpb = new WeakReference<>(pb);
    }

    /**
     * Runs on the background thread.
     *
     * @param voids No parameters in this use case.
     * @return Returns the string including the amount of time that
     * the background thread slept.
     */
    @Override
    protected String doInBackground(Void... voids) {
        int progress = 0;
        // Generate a random number between 0 and 10.
        Random r = new Random();
        int n = r.nextInt(11);

        // Make the task take long enough that we have
        // time to rotate the phone while it is running.
        int s = n * 200;

        // Sleep for the random amount of time// .
        while(progress < 100) {
            try {
                Thread.sleep(s / 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            progress += 20;
            publishProgress(Integer.valueOf(progress));
        }
        // Return a String result.
        return "Awake at last after sleeping for " + s + " milliseconds!";
    }

    @Override
    protected void onPreExecute() {
        mpb.get().setVisibility(View.VISIBLE);
        mpb.get().setProgress(0);
        super.onPreExecute();

    }

    @Override
    protected void onProgressUpdate(Integer... values) {

        super.onProgressUpdate(values);

        mpb.get().setProgress(values[0]);
}

    /**
     * Does something with the result on the UI thread; in this case
     * updates the TextView.
     */

    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
    }
}
