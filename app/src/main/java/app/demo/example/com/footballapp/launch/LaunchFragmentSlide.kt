package app.demo.example.com.footballapp.launch

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import app.demo.example.com.footballapp.R
import app.demo.example.com.footballapp.launch.adapter.ParentAreaAdapter
import app.demo.example.com.footballapp.model.Area
import kotlinx.android.synthetic.main.fragment_launch_slide.*
import kotlinx.android.synthetic.main.fragment_launch_slide.view.*

private const val ARG_PARAM1 = "position"
private const val ARG_PARAM2 = "parentAreas"

class LaunchFragmentSlide : Fragment() {

    private var parentAreas: ArrayList<Area> = arrayListOf()
    private var area: Area? = null
    private var listener: OnFragmentInteractionListener? = null
    private val adapter = ParentAreaAdapter { itemClicked(it) }
    private lateinit var myRootView: View
    private lateinit var recycler : RecyclerView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        arguments?.let {
            area = it.getParcelable(ARG_PARAM1)
            parentAreas = it.getParcelableArrayList(ARG_PARAM2)
        }
        var parent = FrameLayout(context)
        myRootView = LayoutInflater.from(context).inflate(R.layout.fragment_launch_slide, parent, true)
        recycler = myRootView.findViewById(R.id.slide_recycler) as RecyclerView
        bindRecyclerViewData(parentAreas)
        return myRootView
    }

    private fun bindRecyclerViewData(areas: ArrayList<Area>) {
        recycler.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        recycler.adapter = adapter
        adapter.data = areas
    }

    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Area, param2 : ArrayList<Area>) =
                LaunchFragmentSlide().apply {
                    arguments = Bundle().apply {
                        putParcelable(ARG_PARAM1, param1)
                        putParcelableArrayList(ARG_PARAM2, param2)
                    }
                }
    }

    private fun itemClicked(item: Area) {
//        presenter?.itemClicked(item)
    }
}
