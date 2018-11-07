package app.demo.example.com.footballapp.areas.slide.injection

import app.demo.example.com.footballapp.app.injection.AppComponent
import app.demo.example.com.footballapp.areas.slide.LaunchSlideFragment
import dagger.Component

/**
 *
 * Created by Guillermo Bonafonte Criado on 21-Aug-18.
 * 2018 © Cognizant Technology Solutions
 */

@AreasSlideScope
@Component(modules = [(AreasSlideModule::class),(AreasSlideContextModule::class)],dependencies = [AppComponent::class])
interface AreasSlideComponent {
    fun inject(fragment : LaunchSlideFragment)
}