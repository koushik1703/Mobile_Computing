package com.example.filedownload;

import android.os.RemoteException;

public class FileDownloadServiceImpl extends IFileDownloadService.Stub{

    @Override
    public void downloadFile() throws RemoteException {

        final DownloadTask downloadTask = new DownloadTask();
        downloadTask.execute("http://archive.apache.org/dist/maven/binaries/maven-1.1.tar.gz");
    }
}
