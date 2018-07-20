package app.demo.example.com.footballapp.app

import android.app.Activity
import android.content.*
import android.os.Bundle
import android.view.View

/**
 * Created by Guillermo Bonafonte Criado
 */
interface BaseView<P : BasePresenter> {

    var presenter: P?
    var context: Context

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
}