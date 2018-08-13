package app.demo.example.com.footballapp.launch

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import app.demo.example.com.footballapp.R
import app.demo.example.com.footballapp.launch.adapter.ParentAreaAdapter
import app.demo.example.com.footballapp.launch.adapter.AreaFilterAdapter
import app.demo.example.com.footballapp.loading.LoadingFragment
import app.demo.example.com.footballapp.model.Area
import kotlinx.android.synthetic.main.activity_launch.view.*



/**
 *
 * View for splash screen
 *
 * Created by Guillermo Bonafonte Criado
 */
class LaunchView(context: AppCompatActivity) : ILaunchView {

    var view: View
    private val adapter = ParentAreaAdapter{ itemClicked(it) }
    private val filterAdapter = AreaFilterAdapter{ filterItemClicked(it) }

    override var context: Context = context
    override var presenter: ILaunchPresenter? = null
    override var loading: LoadingFragment? = null

    override fun constructView(): View = view

    init {
        val parent = FrameLayout(context)
        parent.layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        view = LayoutInflater.from(context).inflate(R.layout.activity_launch, parent, true)
    }

    override fun bindFilterRecyclerViewData(areas: List<Area>) {
        view.horizontal_recycler.adapter = filterAdapter
        filterAdapter.data = areas
    }

    override fun bindRecyclerViewData(areas: List<Area>) {
        view.recycler.addItemDecoration(DividerItemDecoration(view.recycler.context, DividerItemDecoration.VERTICAL))
        view.recycler.adapter = adapter
        adapter.data = areas
    }

    private fun itemClicked(item: Area) {
        presenter?.itemClicked(item)
    }

    private fun filterItemClicked(item: Area) {
        presenter?.filterItemClicked(item)
    }
}