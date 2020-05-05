package com.example.tencoll

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var textView1: TextView

//    private var handle = object : Handler() {
//        override fun handleMessage(msg: Message) {
//            super.handleMessage(msg)
//            if (msg.what == 1) {
//                textView1.text = "Nice to meet you"
//            }
//        }
//
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView1 = textview
        button.setOnClickListener {
//            Thread(Runnable {
//                var message = Message()
//                message.what = 1
//                handle.sendMessage(message)
//            }).start()

            var stu = Stu("lisi",12)
            var intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("instance",stu)
            this.startActivity(intent)
        }
    }



}
