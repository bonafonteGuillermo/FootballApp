package app.demo.example.com.footballapp.launch

import android.util.Log
import app.demo.example.com.footballapp.model.Area
import app.demo.example.com.footballapp.repository.IRepository
import app.demo.example.com.footballapp.rx.Schedulers
import io.reactivex.disposables.Disposable
import java.text.SimpleDateFormat
import java.util.*



/**
 *
 * Presenter for Splash screen.
 *
 * Created by Guillermo Bonafonte Criado
 */
class LaunchPresenter(private var view: ILaunchView, override var repository: IRepository, private var schedulers: Schedulers) : ILaunchPresenter {

    private lateinit var subscription: Disposable
    var areas : List<Area> = emptyList()

    override fun onCreate() {

    }

    override fun onCreate(areas: List<Area>) {
        this.areas = areas.toList()
        view.bindRecyclerViewData(this.areas)
//        view.bindFilterRecyclerViewData(this.areas)
        view.bindDateFilterRecyclerViewData(getCalendarDates())
    }

    override fun onDestroy() {}

    override fun itemClicked(item: Area) {
        Log.d("--->", item.parentArea)
    }

    override fun filterItemClicked(item: Area) {
        Log.d("--->", item.parentArea)
    }

    override fun dateFilterItemClicked(date: Date) {
        Log.d("--->", date.toString())
    }

    private fun getCalendarDates() : List<Date> {

        var datesList = mutableListOf<Date>()
        val calendar = Calendar.getInstance()
        calendar.firstDayOfWeek = Calendar.MONDAY
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)

        //Add three days before current
//        for (i in -3..-1) {
        for (i in -11..-1) {
            calendar.add(Calendar.DAY_OF_MONTH, i)
            datesList.add(calendar.time)
            calendar.add(Calendar.DAY_OF_MONTH, -i)
        }

        //Add the current date and three days after current
//        for (i in 0..3) {
        for (i in 0..11) {
            datesList.add(calendar.time)
            calendar.add(Calendar.DAY_OF_MONTH, 1)
        }

        return datesList.toList()

    }
}