package com.hollysmart.startmodule.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResID())
        findView()
        init()
    }

    /**
     * layout绑定
     */
    abstract fun layoutResID(): Int


    /**
     * 页面控件
     */
    abstract fun findView()


    /**
     * 逻辑操作
     */
    abstract fun init()


    fun startPage(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }
}