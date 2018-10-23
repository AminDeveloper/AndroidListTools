package com.paraxco.basictools.listTools.activity

import android.content.Intent
import android.os.Bundle
import com.paraxco.basictools.R
import com.paraxco.commontools.Activities.BaseActivity
import com.paraxco.commontools.Utils.SmartLogger
import kotlinx.android.synthetic.main.main_activity.*


/**
 * Created by Amin on 18/11/2017.
 */

class MainActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SmartLogger.initLogger(applicationContext)
        setContentView(R.layout.main_activity)
        showListToolsTest.setOnClickListener {
            startListToolsTest()
        }


    }



    private fun startListToolsTest() {
        val myIntent = Intent(this, ListToolsTest::class.java)
//        myIntent.putExtra("key", value) //Optional parameters
        this.startActivity(myIntent)

    }
}