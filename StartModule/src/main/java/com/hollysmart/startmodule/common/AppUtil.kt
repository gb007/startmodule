package com.hollysmart.startmodule.common

import android.content.Context
import android.content.pm.PackageManager


/**
 * APP工具类
 */
object AppUtil {

    /**
     * 获取当前APP的versionCode
     *
     * @return currentversioncode ：Int
     */
    fun getCurrentversioncode(context: Context): Int {
        var currentversioncode = 0
        val packageManager = context.packageManager
        try {
            val packageInfo = packageManager.getPackageInfo(context.packageName, 0)
            currentversioncode = packageInfo.versionCode
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return currentversioncode
    }

}