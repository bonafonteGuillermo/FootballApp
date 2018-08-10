package app.demo.example.com.footballapp.splash

import android.app.LauncherActivity
import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import app.demo.example.com.footballapp.R
import app.demo.example.com.footballapp.loading.LoadingFragment
import app.demo.example.com.footballapp.model.Area
import app.demo.example.com.footballapp.launch.LaunchActivity

/**
 *
 * View for splash screen
 *
 * Created by Guillermo Bonafonte Criado
 */
class SplashView(context: AppCompatActivity) : ISplashView {

    var view: View

    override var context: Context = context
    override var presenter: ISplashPresenter? = null
    override var loading: LoadingFragment? = null


    override fun constructView(): View = view

    init {
        val parent = FrameLayout(context)
        parent.layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        view = LayoutInflater.from(context).inflate(R.layout.activity_splash, parent, true)
    }

    override fun navigateToLaunchActivity(areas: List<Area>) {
        var extras = Bundle().apply {
            putParcelableArrayList("areas", ArrayList<Parcelable>(areas))
        }
        startActivity(LaunchActivity::class.java, extras)
    }
}