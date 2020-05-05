package com.example.servicebestpractice

interface DownloadListener {
    fun onProgress(progress : Int)
    fun onSuccess()
    fun onFailed()
    fun onPaused()
    fun onCanceled()
}