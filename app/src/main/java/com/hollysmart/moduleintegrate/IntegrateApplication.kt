package com.hollysmart.moduleintegrate

import android.app.Application
import android.content.Context
import android.content.Intent
import com.facebook.drawee.backends.pipeline.Fresco
import com.google.gson.Gson
import com.hollysmart.loginmodule.activity.LoginActivity
import com.hollysmart.loginmodule.common.ConFig
import com.hollysmart.loginmodule.common.LoginConfig
import com.hollysmart.loginmodule.common.PrivacyConfig
import com.hollysmart.loginmodule.common.ThirdAuthConfig
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
        Fresco.initialize(this);
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
        StartModuleConfig.STARTPAGE = LoginActivity2::class.java//MainActivity


    }


    private fun setLoginModuleConfig(){

        //登录页面设置
        var loginConfig = LoginConfig()
        //登录页面顶部logo图案
        loginConfig.topLogoResourceId = R.mipmap.icon_login_head
        //输入框标题（用户名或手机号）
        loginConfig.userNameTitle = "用户名"
        //输入框标题（密码或验证码）
        loginConfig.passwordTitle = "密码"
        //登录类型（用户名或手机号）  INPUTMODEL_USER，INPUTMODEL_PHONE
        loginConfig.inputModel = ConFig.INPUTMODEL_USER
        //弹出隐私提示框设置
        var privacyConfig = PrivacyConfig()
        //隐私政策名称
        privacyConfig.privacyTitle = "杨柳飞絮防治隐私政策"
        //服务协议名称
        privacyConfig.serviceTitle = "杨柳飞絮防治服务"
        //弹窗内容
        privacyConfig.content = "感谢您信任并使用杨柳飞絮防治的产品和服务！" +
                "\n" +
                "\n" +
                "我们依据最新的法律法规、监管政策要求，更新了《杨柳飞絮防治服务协议》，特向您推送本提示，请您仔细阅读并充分理解相关条款。" +
                "\n" +
                "\n" +
                "本次我们就《杨柳飞絮防治服务协议》更新的条款主要包括：进一步明确用户不可以通过机关服务平台提供的产品和服务谈论和传播涉密及敏感信息(第三部分4)。" +
                "\n" +
                "\n" +
                "您可通过《杨柳飞絮防治服务》和《杨柳飞絮防治隐私政策》查阅完整的协议内容。"
        //隐私政策点击跳转详情页面url
        privacyConfig.privacyUrl =
            "https://qnimg.daolan.com.cn/yangliufeixufangzhiyinsizhengce.html"
        //服务协议点击跳转详情页面url
        privacyConfig.serviceUrl = "https://qnimg.daolan.com.cn/yangliufeixufuwuxieyi.html"

        //第三方登录设置
        var thirdAuthConfig = ThirdAuthConfig()
        //友盟APP_KEY
        thirdAuthConfig.umenG_APP_KEY = "23964aa317aa87760aaa122"
        //微信appid
        thirdAuthConfig.wechaT_APP_ID = "wx19d82d4e169d37c5"
        //微信app_secret
        thirdAuthConfig.wechaT_APP_SECRET = "45ed3b39c5b023ef56bea4142948a614"
        //qq app_id
        thirdAuthConfig.qQ_APP_ID = "1112189842"
        //qq app_secret
        thirdAuthConfig.qQ_APP_SECRET = "T4cChe0BvGGfRM56"

        val intent = Intent(this, LoginActivity::class.java)

        intent.putExtra("loginConfig", Gson().toJson(loginConfig))
        intent.putExtra("privacyConfig", Gson().toJson(privacyConfig))
        intent.putExtra("thirdAuthConfig", Gson().toJson(thirdAuthConfig))
//      startActivity(intent)


    }
}