package app.demo.example.com.footballapp.launch

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import app.demo.example.com.footballapp.R
import app.demo.example.com.footballapp.launch.adapter.AreaFilterAdapter
import app.demo.example.com.footballapp.launch.adapter.DateAdapter
import app.demo.example.com.footballapp.launch.adapter.ParentAreaAdapter
import app.demo.example.com.footballapp.loading.LoadingFragment
import app.demo.example.com.footballapp.model.Area
import kotlinx.android.synthetic.main.activity_launch.view.*
import java.util.*
import android.util.Log
import com.bumptech.glide.Glide.init
import android.support.v7.widget.RecyclerView
import android.util.DisplayMetrics




/**
 *
 * View for splash screen
 *
 * Created by Guillermo Bonafonte Criado
 */
class LaunchView(context: AppCompatActivity) : ILaunchView {

    var view: View
    private val adapter = ParentAreaAdapter { itemClicked(it) }
    private val filterAdapter = AreaFilterAdapter { filterItemClicked(it) }
    private val dateFilterAdapter = DateAdapter { date: Date, position: Int -> dateFilterItemClicked(date, position) }


    override var context: Context = context
    override var presenter: ILaunchPresenter? = null
    override var loading: LoadingFragment? = null

    val snapHelper = LinearSnapHelper()

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

    override fun bindDateFilterRecyclerViewData(dates: List<Date>) {
        var mLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        view.horizontal_recycler.layoutManager = mLayoutManager
        view.horizontal_recycler.adapter = dateFilterAdapter
        dateFilterAdapter.data = dates
        snapHelper.attachToRecyclerView(view.horizontal_recycler)
        view.horizontal_recycler.smoothScrollToPosition(12)


        view.horizontal_recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val centerView = snapHelper.findSnapView(mLayoutManager)
                    val pos = mLayoutManager.getPosition(centerView)
                    Log.e("Snapped Item Position:", "" + pos)
                }
            }
        })
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

    private fun dateFilterItemClicked(date: Date, position: Int) {
        presenter?.dateFilterItemClicked(date, position)
    }

    override fun navigateToPosition(position: Int) {
        val smoothScroller: RecyclerView.SmoothScroller = object : LinearSmoothScroller(context) {
            override fun calculateDtToFit(viewStart: Int, viewEnd: Int, boxStart: Int, boxEnd: Int, snapPreference: Int): Int =
                    (boxStart + (boxEnd - boxStart) / 2) - (viewStart + (viewEnd - viewStart) / 2)

            override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics): Float {
                return 200f / displayMetrics.densityDpi
            }
        }
        smoothScroller.targetPosition = position
        view.horizontal_recycler.layoutManager?.startSmoothScroll(smoothScroller)
    }
}