package com.hollysmart.startmodule.common

import android.app.Activity

/**
 * 启动模块配置
 */
object StartModuleConfig {

    //启动页加载展示时长
    var SPLASH_LOAD_DURATION = 1000L

    //启动页背景图片资源ID
    var SPLASH_LOAD_BG_RESOURCE_ID:Int = 0

    //是否有广告页
    var HAS_AD = false

    //本地加载广告
    val AD_LOAD_TYPE_LOCAL = 1

    //网络加载广告
    val AD_LOAD_TYPE_NET = 2

    //广告加载方式
    var AD_LOAD_TYPE = AD_LOAD_TYPE_LOCAL

    //广告展示时间
    var AD_SHOW_DURATION = 1000L

    //广告网络Url
    lateinit var AD_NET_URL: String

    //广告本地资源ID
    var AD_LOCAL_RESOURCE_ID = 0L

    //是否可点击跳转广告详情
    var AD_CAN_CLICK = false

    //广告详情url
    lateinit var AD_DETAIL_URL: String

    //是否有引导页
    var HAS_GUIDE = false

    //引导页背景图片资源ID
    lateinit var GUIDE_RESOURCEID:List<Int>

    //跳转页面
    lateinit var STARTPAGE:Class<*>


}