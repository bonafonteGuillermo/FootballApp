package app.demo.example.com.footballapp.launch.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import app.demo.example.com.footballapp.launch.LaunchFragmentSlide

/**
 *
 * Created by Guillermo Bonafonte Criado on 20-Aug-18.
 * 2018 © Cognizant Technology Solutions
 */
class FragmentViewPagerAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return LaunchFragmentSlide.newInstance("","")
    }

    override fun getCount(): Int {
        return 5
    }
}


