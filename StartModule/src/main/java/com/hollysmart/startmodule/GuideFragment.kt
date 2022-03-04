package com.hollysmart.startmodule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.hollysmart.startmodule.common.StartModuleConfig

/**
 * 引导页
 */
class GuideFragment(position: Int) : Fragment() {


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

        val view:View = inflater.inflate(R.layout.start_module_fragment_guide, container, false)
        val img:ImageView = view.findViewById(R.id.guide_image)
        img.setImageResource(StartModuleConfig.GUIDE_RESOURCEID[index])
        return view


    }
}