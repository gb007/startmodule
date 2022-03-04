package com.hollysmart.startmodule

import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.hollysmart.startmodule.base.BaseActivity
import com.hollysmart.startmodule.common.AppUtil
import com.hollysmart.startmodule.common.ShareUtil
import com.hollysmart.startmodule.common.StartModuleConfig

/**
 * 启动页
 */
class SplashActivity : BaseActivity() {


    @BindView(R2.id.splash_bg)
    lateinit var splash_bg: ImageView

    override fun layoutResID(): Int {
        return R.layout.start_module_activity_splash
    }

    override fun findView() {
        ButterKnife.bind(this)
    }

    override fun init() {
        splash_bg.setImageResource(StartModuleConfig.SPLASH_LOAD_BG_RESOURCE_ID)
        Handler().postDelayed(Runnable {
            startNextPage()
            finish()
        }, StartModuleConfig.SPLASH_LOAD_DURATION)
    }

    /**
     * 根据广告页，引导页，启动模块结束跳转页面配置情况，判断页面跳转
     */
    private fun startNextPage() {
        if (StartModuleConfig.HAS_AD) {//有广告页
            startPage(ADActivity::class.java)
        } else {//无广告页
            if (StartModuleConfig.HAS_GUIDE) {//有引导页
               var versionCode  = ShareUtil.getInt("versionCode",this);
                if(AppUtil.getCurrentversioncode(this) > versionCode){//首次启动
                    startPage(GuideActivity::class.java)
                }else{
                    startPage(StartModuleConfig.STARTPAGE)
                }
            } else {//无引导页
                startPage(StartModuleConfig.STARTPAGE)
            }
        }
    }


}