package app.demo.example.com.footballapp.areas

import android.content.Context
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import app.demo.example.com.footballapp.R
import app.demo.example.com.footballapp.areas.adapter.FragmentViewPagerAdapter
import app.demo.example.com.footballapp.areas.slide.LaunchSlideFragment
import app.demo.example.com.footballapp.loading.LoadingFragment
import app.demo.example.com.footballapp.model.Area
import kotlinx.android.synthetic.main.fragment_areas.view.*
import kotlinx.android.synthetic.main.item_tab_layout.view.*

/**
 *
 * View for areas screen
 *
 * Created by Guillermo Bonafonte Criado
 */
class AreasView(context: AppCompatActivity) : IAreasView, LaunchSlideFragment.OnFragmentInteractionListener {

    var view: View

    private var pagerAdapter : FragmentViewPagerAdapter? = null
    private val fm = context.supportFragmentManager


    override var context: Context = context
    override var presenter: IAreasPresenter? = null
    override fun constructView(): View = view
    override var loading: LoadingFragment? = null

    init {
        val parent = FrameLayout(context)
        parent.layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        view = LayoutInflater.from(context).inflate(R.layout.fragment_areas, parent, true)
    }

    override fun bindViewPager(areas: List<Area>) {
        pagerAdapter = FragmentViewPagerAdapter(areas, fm)
        view.pager.adapter = pagerAdapter
    }

    override fun bindTabLayout(areas: List<Area>) {
        view.tablayout.setupWithViewPager(view.pager)


        // Iterate over all tabs and set the custom view
        for (i in 0 until view.tablayout.tabCount) {
            val tab = view.tablayout.getTabAt(i)
            val customTabLayoutView = LayoutInflater.from(context).inflate(R.layout.item_tab_layout, null)
            tab?.customView = customTabLayoutView
            tab?.customView?.tv_tab_layout?.text = areas[i].parentArea
        }

    }

    override fun onFragmentInteraction(uri: Uri) {}
}