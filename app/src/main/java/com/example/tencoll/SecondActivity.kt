package com.example.tencoll

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val stu = intent.getParcelableExtra<Stu>("instance")
        Log.d("TAG",stu.toString())
    }
}
