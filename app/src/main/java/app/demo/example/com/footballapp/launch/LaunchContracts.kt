package app.demo.example.com.footballapp.launch


import app.demo.example.com.footballapp.app.BasePresenter
import app.demo.example.com.footballapp.app.BaseView
import app.demo.example.com.footballapp.model.Area

/**
 *
 * Contracts for splash view and splash presenter
 *
 * Created by Guillermo Bonafonte Criado
 */
interface ILaunchPresenter : BasePresenter {
    fun onCreate(areas: List<Area>)
    fun itemClicked(item: Area)
    fun filterItemClicked(item: Area)
    fun currentCenterItem(pos: Area)
}

interface ILaunchView : BaseView<ILaunchPresenter> {
    fun bindRecyclerViewData(areas: List<Area>)
    fun bindFilterRecyclerViewData(areas: List<Area>)
    fun navigateToPosition(position: Int)
}