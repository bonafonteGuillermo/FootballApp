package app.demo.example.com.footballapp.launch

import android.os.Bundle
import android.os.Parcelable
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import app.demo.example.com.footballapp.R
import app.demo.example.com.footballapp.app.App
import app.demo.example.com.footballapp.app.BaseActivity
import app.demo.example.com.footballapp.areas.AreasFragment
import app.demo.example.com.footballapp.launch.injection.DaggerLaunchComponent
import app.demo.example.com.footballapp.launch.injection.LaunchContextModule
import app.demo.example.com.footballapp.model.Area
import javax.inject.Inject

/**
 *
 * Splash screen.ore proceeding.
 *
 * Created by Guillermo Bonafonte Criado
 */
class LaunchActivity : BaseActivity<ILaunchView, ILaunchPresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerLaunchComponent.builder()
                .appComponent(App.appComponent)
                .launchContextModule(LaunchContextModule(this))
                .build()
                .inject(this)

        super.onCreate(savedInstanceState)
        setContentView(view.constructView())
        renderBottomNavigationBar()
        view.presenter = presenter
        presenter.onCreate()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    private fun renderBottomNavigationBar() {
        val bottomNavigationBar: BottomNavigationView = findViewById(R.id.bottom_navigation_bar)
        //Avoid reselect on bottomNavigationBar
        bottomNavigationBar.setOnNavigationItemReselectedListener {}
        bottomNavigationBar.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_areas -> addFragment(AreasFragment())
//                R.id.navigation_competitions ->
            }
            true
        }
    }

    fun addFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .addToBackStack(fragment.javaClass.simpleName)
                .replace(R.id.fragment_container, fragment)
                .commitAllowingStateLoss()
    }
}