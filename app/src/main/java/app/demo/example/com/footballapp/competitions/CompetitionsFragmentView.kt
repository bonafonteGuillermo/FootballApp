package app.demo.example.com.footballapp.competitions

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import app.demo.example.com.footballapp.R
import app.demo.example.com.footballapp.loading.LoadingFragment

/**
 *
 * View for competitions screen
 *
 * Created by Guillermo Bonafonte Criado
 */
class CompetitionsFragmentView(context: AppCompatActivity) : ICompetitionsView {
    var view: View

    override var context: Context = context
    override var presenter: ICompetitionsPresenter? = null
    override var loading: LoadingFragment? = null
    override fun constructView(): View = view

    init {
        val parent = FrameLayout(context)
        parent.layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        view = LayoutInflater.from(context).inflate(R.layout.fragment_competitions, parent, true)
    }
}