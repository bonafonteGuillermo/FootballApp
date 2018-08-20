package app.demo.example.com.footballapp.launch

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearSnapHelper
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import app.demo.example.com.footballapp.R
import app.demo.example.com.footballapp.launch.adapter.AreaFilterAdapter
import app.demo.example.com.footballapp.launch.adapter.ParentAreaAdapter
import app.demo.example.com.footballapp.loading.LoadingFragment
import app.demo.example.com.footballapp.model.Area
import app.demo.example.com.footballapp.utils.getCustomSmoothScroller
import kotlinx.android.synthetic.main.activity_launch.view.*


/**
 *
 * View for splash screen
 *
 * Created by Guillermo Bonafonte Criado
 */
class LaunchView(context: AppCompatActivity) : ILaunchView {

    var view: View
    private val adapter = ParentAreaAdapter { itemClicked(it) }
    private val filterAdapter = AreaFilterAdapter { area: Area, position: Int ->  filterItemClicked(area,position) }

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
        val linearSnapHelper = LinearSnapHelper()
        linearSnapHelper.attachToRecyclerView(view.horizontal_recycler)

        view.horizontal_recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val centerView = linearSnapHelper .findSnapView(view.horizontal_recycler.layoutManager) as TextView
                val pos = view.horizontal_recycler.layoutManager.getPosition(centerView)
                if (newState == RecyclerView.SCROLL_STATE_IDLE || newState == RecyclerView.SCROLL_STATE_DRAGGING || newState == RecyclerView.SCROLL_STATE_SETTLING) {
                    centerView.background = context.getDrawable(R.drawable.circle_shape)
                    centerView.setTextColor(ContextCompat.getColor(context,R.color.white))
                }else{
                    centerView.background = context.getDrawable(R.drawable.circle_shape_white)
                    centerView.setTextColor(ContextCompat.getColor(context,R.color.grey))
                }
            }
        })
        navigateToPosition(2)
    }

    override fun bindRecyclerViewData(areas: List<Area>) {
        view.recycler.addItemDecoration(DividerItemDecoration(view.recycler.context, DividerItemDecoration.VERTICAL))
        view.recycler.adapter = adapter
        adapter.data = areas
    }

    private fun itemClicked(item: Area) {
        presenter?.itemClicked(item)
    }

    private fun filterItemClicked(item: Area, position: Int) {
        presenter?.filterItemClicked(item)
        navigateToPosition(position)
    }

    override fun navigateToPosition(position: Int) {
        val smoothScroller = view.horizontal_recycler.getCustomSmoothScroller()
        smoothScroller.targetPosition = position
        view.horizontal_recycler.layoutManager?.startSmoothScroll(smoothScroller)
    }
}