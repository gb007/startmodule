package com.hollysmart.startmodule

import android.os.Bundle
import android.os.PersistableBundle
import butterknife.ButterKnife
import com.hollysmart.startmodule.base.BaseActivity

class ADActivity :BaseActivity() {
    override fun layoutResID(): Int {
       return R.layout.start_module_activity_ad
    }


    override fun findView() {
        ButterKnife.bind(this)
    }
    override fun init() {

    }


}