package app.demo.example.com.footballapp.launch.slide

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import app.demo.example.com.footballapp.R
import app.demo.example.com.footballapp.app.BaseView
import app.demo.example.com.footballapp.loading.LoadingFragment

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

    private var recycler : RecyclerView

    override fun constructView(): View = view

    init{
        var parent = FrameLayout(context)
        view = LayoutInflater.from(context).inflate(R.layout.fragment_launch_slide, parent, true)
        recycler = view.findViewById(R.id.slide_recycler) as RecyclerView
    }

}