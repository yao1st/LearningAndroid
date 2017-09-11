package com.example.yao.servicebesttest;

/**
 * Created by Yao on 2017/9/11.
 */

public interface DownloadListener {
    void onProgress(int progress);
    void onSuccess();
    void onFailed();
    void onPaused();
    void onCancled();
}
