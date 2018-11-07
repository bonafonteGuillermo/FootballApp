package app.demo.example.com.footballapp.areas.slide

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.demo.example.com.footballapp.app.App
import app.demo.example.com.footballapp.areas.slide.injection.AreasSlideContextModule
import app.demo.example.com.footballapp.areas.slide.injection.DaggerAreasSlideComponent
import app.demo.example.com.footballapp.model.Area
import javax.inject.Inject

private const val ARG_PARAM1 = "position"
private const val ARG_PARAM2 = "parentAreas"

class LaunchSlideFragment : Fragment() {

    @Inject
    lateinit var view: ILaunchSlideView
    @Inject
    lateinit var presenter: ILaunchSlidePresenter

    private var areas: ArrayList<Area> = arrayListOf()
    private lateinit var parentArea: Area
    private var listener: OnFragmentInteractionListener? = null

    companion object {
        @JvmStatic
        fun newInstance(param1: Area) =
                LaunchSlideFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable(ARG_PARAM1, param1)
                    }
                }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        arguments?.let {
            parentArea = it.getParcelable(ARG_PARAM1)
        }

        DaggerAreasSlideComponent.builder()
                .appComponent(App.appComponent)
                .areasSlideContextModule(AreasSlideContextModule(activity as AppCompatActivity))
                .build()
                .inject(this)

        view.presenter = presenter
        presenter.onCreate(parentArea)

        return view.constructView()
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
}