package com.hollysmart.moduleintegrate

import android.app.Application
import android.content.Context
import com.hollysmart.startmodule.common.StartModuleConfig

class IntegrateApplication : Application() {

    companion object {
        lateinit private var context: Context
        fun getAPPContext() = context!!
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        initStartModule()
    }

    private fun initStartModule(){
        //启动页加载展示时长
        StartModuleConfig.SPLASH_LOAD_DURATION = 3000L
        //启动页背景图片资源ID
        StartModuleConfig.SPLASH_LOAD_BG_RESOURCE_ID = R.mipmap.bg_splash

        //是否有引导页
        StartModuleConfig.HAS_GUIDE = true

        //引导页背景图片资源ID（List<Int>）
        StartModuleConfig.GUIDE_RESOURCEID = listOf(R.mipmap.icon_guide,R.mipmap.icon_guide_2,R.mipmap.icon_guide,R.mipmap.icon_guide_2,)
        //启动模块结束后，跳转的Activity页面
        StartModuleConfig.STARTPAGE = LoginActivity::class.java

    }

}