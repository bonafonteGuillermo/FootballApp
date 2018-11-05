package app.demo.example.com.footballapp.launch

import android.content.Context
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import app.demo.example.com.footballapp.R
import app.demo.example.com.footballapp.launch.adapter.FragmentViewPagerAdapter
import app.demo.example.com.footballapp.launch.slide.LaunchSlideFragment
import app.demo.example.com.footballapp.loading.LoadingFragment
import app.demo.example.com.footballapp.model.Area
import kotlinx.android.synthetic.main.activity_launch.view.*


/**
 *
 * View for splash screen
 *
 * Created by Guillermo Bonafonte Criado
 */
class LaunchView(context: AppCompatActivity) : ILaunchView, LaunchSlideFragment.OnFragmentInteractionListener {

    var view: View

    private var pagerAdapter : FragmentViewPagerAdapter? = null
    private val fm = context.supportFragmentManager

    override var context: Context = context
    override var presenter: ILaunchPresenter? = null
    override var loading: LoadingFragment? = null

    override fun constructView(): View = view

    init {
        val parent = FrameLayout(context)
        parent.layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        view = LayoutInflater.from(context).inflate(R.layout.activity_launch, parent, true)
    }

    override fun bindViewPager(areas: ArrayList<Area>) {
        pagerAdapter = FragmentViewPagerAdapter(areas,fm)
        view.pager.adapter = pagerAdapter
    }

    override fun bindTabLayout() {
        view.tablayout.setupWithViewPager(view.pager)

        // Iterate over all tabs and set the custom view
        for (i in 0 until view.tablayout.tabCount) {
            val tab = view.tablayout.getTabAt(i)
            tab?.customView = LayoutInflater.from(context).inflate(R.layout.item_tab_layout, null)
        }

    }

    override fun onFragmentInteraction(uri: Uri) {}
}