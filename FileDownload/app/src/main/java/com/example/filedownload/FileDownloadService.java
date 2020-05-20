package com.example.filedownload;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class FileDownloadService extends Service {

    FileDownloadServiceImpl fileDownloadServiceImpl = null;

    @Override
    public void onCreate() {
        super.onCreate();
        fileDownloadServiceImpl = new FileDownloadServiceImpl();
        DownloadTask.context = getBaseContext();
        DownloadTask.updateToActivity = new UpdateToActivity(getBaseContext());
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return fileDownloadServiceImpl;
    }
}
