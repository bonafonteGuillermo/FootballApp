package app.demo.example.com.footballapp.app

import android.os.Build
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import app.demo.example.com.footballapp.R
import app.demo.example.com.footballapp.competitions.CompetitionsActivity
import app.demo.example.com.footballapp.launch.LaunchActivity
import javax.inject.Inject

/**
 * Created by Guillermo Bonafonte Criado
 */
abstract class BaseActivity<V : BaseView<P>, P : BasePresenter> : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var view: V

    @Inject
    lateinit var presenter: P

    private val contentView: View
        get() = view.constructView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        view.presenter = presenter
        presenter.onCreate()
        setContentView(contentView)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.navigation_areas -> view.startActivity(LaunchActivity::class.java)
            R.id.navigation_competitions -> view.startActivity(CompetitionsActivity::class.java)
        }
        return true
    }
}