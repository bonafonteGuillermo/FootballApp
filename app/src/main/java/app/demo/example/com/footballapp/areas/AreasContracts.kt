package app.demo.example.com.footballapp.areas

import app.demo.example.com.footballapp.app.BasePresenter
import app.demo.example.com.footballapp.app.BaseView
import app.demo.example.com.footballapp.model.Area

/**
 *
 * Contracts for areas view and areas presenter
 *
 * Created by Guillermo Bonafonte Criado
 */
interface IAreasPresenter : BasePresenter {
    fun itemClicked(item: Area)
}

interface IAreasView : BaseView<IAreasPresenter> {
    fun bindViewPager(areas: List<Area>)
    fun bindTabLayout(areas: List<Area>)

}