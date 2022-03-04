package com.hollysmart.moduleintegrate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import java.lang.Thread.sleep


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        Thread {
            //耗时任务，比如加载网络数据
            runOnUiThread { // 这里可以睡几秒钟，如果要放广告的话
                 sleep(3000);

            }
        }.start()



    setContentView(R.layout.activity_main)


}
}