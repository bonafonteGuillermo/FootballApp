package app.demo.example.com.footballapp.areas.slide

import app.demo.example.com.footballapp.app.BasePresenter
import app.demo.example.com.footballapp.app.BaseView
import app.demo.example.com.footballapp.model.Area

/**
 *
 * Created by Guillermo Bonafonte Criado on 21-Aug-18.
 * 2018 © Cognizant Technology Solutions
 */

interface ILaunchSlidePresenter : BasePresenter {
    fun onCreate(parentArea: Area)
    fun itemClicked(item : Area)
}

interface ILaunchSlideView : BaseView<ILaunchSlidePresenter> {
    fun bindRecyclerViewData(areas: List<Area>)
}