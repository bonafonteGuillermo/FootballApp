package app.demo.example.com.footballapp.launch.slide

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import app.demo.example.com.footballapp.R
import app.demo.example.com.footballapp.app.BaseView
import app.demo.example.com.footballapp.launch.adapter.ParentAreaAdapter
import app.demo.example.com.footballapp.loading.LoadingFragment
import app.demo.example.com.footballapp.model.Area

/**
 *
 * Created by Guillermo Bonafonte Criado on 21-Aug-18.
 * 2018 © Cognizant Technology Solutions
 */
class LaunchSlideView(context : AppCompatActivity) : ILaunchSlideView {

    var view : View

    override var context: Context = context
    override var loading: LoadingFragment? = null
    override var presenter: ILaunchSlidePresenter? = null

    private val adapter = ParentAreaAdapter { itemClicked(it) }

    override fun constructView(): View = view

    init{
        var parent = FrameLayout(context)
        view = LayoutInflater.from(context).inflate(R.layout.fragment_launch_slide, parent, true)
    }

    override fun bindRecyclerViewData(areas: ArrayList<Area>) {
        val recycler = view.findViewById(R.id.slide_recycler) as RecyclerView
        recycler.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        recycler.adapter = adapter
        adapter.data = areas
    }

    private fun itemClicked(item: Area) {
//        presenter?.itemClicked(item)
    }

}