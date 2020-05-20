package com.example.filedownload;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadTask extends AsyncTask<String, Integer, String> {

    static Context context;
    static UpdateToActivity updateToActivity;
    private static final int MEGABYTE = 1024 * 1024;

    @Override
    protected String doInBackground(String... sUrl) {
        try {
            URL url = new URL(sUrl[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(new File(context.getExternalFilesDir(null), "maven-1.1.tar.gz"));

            byte[] buffer = new byte[MEGABYTE];
            int bufferLength = 0;
            while ((bufferLength = inputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, bufferLength);
            }

            fileOutputStream.close();
            updateToActivity.updateToUI("DOWNLOAD COMPLETED");
        } catch (IOException e) {
            updateToActivity.updateToUI("DOWNLOAD FAILED");
            e.printStackTrace();
        }
        return null;
    }
}
