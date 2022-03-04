package com.hollysmart.startmodule

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.hollysmart.startmodule.common.AppUtil
import com.hollysmart.startmodule.common.ShareUtil
import com.hollysmart.startmodule.common.StartModuleConfig

/**
 * 引导页最后一页页面，点击跳转
 */
class GuideFragmentLast(position: Int) : Fragment() {
    var index: Int = position;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =
            inflater.inflate(R.layout.start_module_fragment_guide_last, container, false)
        val img: ImageView = view.findViewById(R.id.guide_image)
        img.setImageResource(StartModuleConfig.GUIDE_RESOURCEID[index])

        val iv_bottom: ImageView = view.findViewById(R.id.iv_bottom)
        iv_bottom.setOnClickListener(View.OnClickListener {
            activity?.let { it1 -> ShareUtil.putInt("versionCode", AppUtil.getCurrentversioncode(it1), it1)}
            val intent = Intent(this.context, StartModuleConfig.STARTPAGE)
            startActivity(intent)
            activity?.finish()
        })
        return view

    }
}