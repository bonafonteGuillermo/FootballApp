package app.demo.example.com.footballapp.launch.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import app.demo.example.com.footballapp.launch.slide.LaunchSlideFragment
import app.demo.example.com.footballapp.model.Area

/**
 *
 * Created by Guillermo Bonafonte Criado on 20-Aug-18.
 * 2018 © Cognizant Technology Solutions
 */
class FragmentViewPagerAdapter(private var parentAreas: List<Area>, fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return LaunchSlideFragment.newInstance(parentAreas[position])
    }

    override fun getCount(): Int {
        return parentAreas.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return parentAreas[position].parentArea
    }
}