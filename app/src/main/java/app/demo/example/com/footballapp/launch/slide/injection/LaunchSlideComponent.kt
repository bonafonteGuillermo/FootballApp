package app.demo.example.com.footballapp.launch.slide.injection

import app.demo.example.com.footballapp.app.injection.AppComponent
import app.demo.example.com.footballapp.launch.slide.LaunchSlideFragment
import dagger.Component

/**
 *
 * Created by Guillermo Bonafonte Criado on 21-Aug-18.
 * 2018 © Cognizant Technology Solutions
 */

@LaunchSlideScope
@Component(modules = [(LaunchSlideModule::class),(LaunchSlideContextModule::class)],dependencies = [AppComponent::class])
interface LaunchSlideComponent {
    fun inject(fragment : LaunchSlideFragment)
}