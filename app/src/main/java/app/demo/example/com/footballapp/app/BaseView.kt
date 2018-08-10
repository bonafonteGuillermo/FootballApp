package app.demo.example.com.footballapp.app

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import app.demo.example.com.footballapp.loading.LoadingFragment

/**
 * Created by Guillermo Bonafonte Criado
 */
interface BaseView<P : BasePresenter> {

    var presenter: P?
    var context: Context
    var loading : LoadingFragment?

    fun constructView(): View

    fun startActivity(activityClass: Class<*>,
                      finish: Boolean,
                      extras: Bundle?
    ) {
        val intent = Intent(context, activityClass)
        if (extras != null) intent.putExtras(extras)
        context.startActivity(intent)
        if (finish) (context as Activity).finish()
    }

    fun startActivity(activityClass: Class<*>,
                      extras: Bundle
    ) = startActivity(activityClass, true, extras)

    fun startActivity(activityClass: Class<*>) = startActivity(activityClass, true, null)

    fun showLoadingFragment() {
        if (loading == null) {
            loading = LoadingFragment.newInstance()
        }
        (context as Activity).fragmentManager.beginTransaction().add(android.R.id.content, loading)
                .commit()
    }

    fun hideLoadingFragment() {
        loading?.dismiss()
        loading = null
    }
}