package com.example.servicebestpractice

import android.os.AsyncTask
import android.os.Environment
import java.io.File
import java.io.InputStream
import java.lang.Exception

class DownloadTask(listener: DownloadListener) : AsyncTask<String, Int, Int>() {

    val TYPE_SUCCESS = 0
    val TYPE_FAILED = 1
    val TYPE_PAUSED = 2
    val TYPE_CANCELED = 3

    lateinit var downloadListener: DownloadListener

    var isCanceled = false
    var isPaused = false

    var lastProgress = 0

    init {
        downloadListener = listener
    }

    //在子线程中进行，处理耗时任务
    override fun doInBackground(vararg params: String?): Int {

        var input: InputStream
        var saveFile: RandomAccess
        var file: File

        try {
            var downloadedLength: Long = 0
            var downloadUrl = params[0]
            var fileName = downloadUrl?.substring(downloadUrl.lastIndexOf("/"))
            var directory =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).path

        } catch (e: Exception) {
            e.printStackTrace()
        } finally {

        }
        return 1
    }

    //在后天调用publishProgress（）方法后，这个方法很快被调用
    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
    }

    //后台任务执行完毕后，通过return语句返回时，调用这个方法
    override fun onPostExecute(result: Int?) {
        super.onPostExecute(result)
    }
}