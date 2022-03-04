package com.hollysmart.startmodule

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import butterknife.BindView
import butterknife.ButterKnife
import com.hollysmart.startmodule.base.BaseActivity
import com.hollysmart.startmodule.common.StartModuleConfig
import android.view.ViewGroup

import android.widget.LinearLayout


import android.widget.ImageView
import com.hollysmart.startmodule.R2.*


class GuideActivity : BaseActivity() {

    @BindView(id.guide_pager_view)
    lateinit var viewPager: ViewPager

    @BindView(id.viewGroup_index)
    lateinit var viewGroup: ViewGroup


    private var guideAdapter: GuideAdapter? = null

    override fun layoutResID(): Int {
        return R.layout.start_module_activity_guide
    }

    override fun findView() {
        ButterKnife.bind(this)
    }


    override fun init() {

        guideAdapter = GuideAdapter(supportFragmentManager)
        viewPager.adapter = guideAdapter

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                setIndexImageBackground(position)
            }
        })

        initViewpagerIndexIcon()
    }


    private class GuideAdapter(fm: FragmentManager?) :
        FragmentPagerAdapter(fm!!) {
        override fun getCount(): Int {
            return StartModuleConfig.GUIDE_RESOURCEID.size
        }

        override fun getItem(position: Int): Fragment {
            when (position) {
                StartModuleConfig.GUIDE_RESOURCEID.size - 1 -> return GuideFragmentLast(position)
            }
            return GuideFragment(position)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return null
        }

    }


    /**
     * 初始化底部索引
     */
    private fun initViewpagerIndexIcon() {
        //将点点的图添加到视图ViewGroup中
        for (i in 0 until StartModuleConfig.GUIDE_RESOURCEID.size) {
            val imageView = ImageView(this)
            //设置图片的宽高 为10像素
            imageView.setLayoutParams(ViewGroup.LayoutParams(20, 20))
            if (i == 0) {
                //第一个为默认选中状态
                imageView.setImageResource(R.drawable.start_module_icon_page_select)
            } else {
                imageView.setImageResource(R.drawable.start_module_icon_page_normal)
            }
            val params = LinearLayout.LayoutParams(
                20, 20
            )
            params.leftMargin = 5
            params.rightMargin = 5
            viewGroup.addView(imageView, params)
        }
    }


    /**
     * 改变索引点的切换效果
     *
     * @param selectItem 当前选中的页面索引
     */
    fun setIndexImageBackground(selectItem: Int) {
        for (i in 0 until StartModuleConfig.GUIDE_RESOURCEID.size) {
            val imageView = viewGroup.getChildAt(i) as ImageView
            imageView.background = null
            if (i == selectItem) {
                imageView.setImageResource(R.drawable.start_module_icon_page_select)
            } else {
                imageView.setImageResource(R.drawable.start_module_icon_page_normal)
            }
        }
    }


}