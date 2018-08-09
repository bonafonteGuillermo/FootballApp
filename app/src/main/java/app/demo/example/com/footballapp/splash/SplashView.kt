package app.demo.example.com.footballapp.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.support.v7.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import app.demo.example.com.footballapp.R

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
    override fun constructView(): View = view

    init {
        val parent = FrameLayout(context)
        parent.layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        view = LayoutInflater.from(context).inflate(R.layout.activity_splash, parent, true)
    }
}