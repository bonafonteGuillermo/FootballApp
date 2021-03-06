package app.demo.example.com.footballapp.loading

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.app.DialogFragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.demo.example.com.footballapp.R

/**
 * A simple [Fragment] subclass.
 * Use the [LoadingFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class LoadingFragment : DialogFragment() {
    private var parent: ConstraintLayout? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_splash, parent, true)
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoadingFragment()
    }

}
