package com.enefce.samples.androidlibdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.enefce.libraries.sampleandroidlib2.SampleAndroidLibMain
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialise the main class from the Sample Android Library module
        val sampleAndroidLibMain = SampleAndroidLibMain()
        tv_welcome.text = sampleAndroidLibMain.welcomeString
    }
}
