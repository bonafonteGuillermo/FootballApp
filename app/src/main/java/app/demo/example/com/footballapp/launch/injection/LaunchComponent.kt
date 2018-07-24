package app.demo.example.com.footballapp.launch.injection

import app.demo.example.com.footballapp.app.injection.AppComponent
import app.demo.example.com.footballapp.launch.LaunchActivity
import dagger.Component

/**
 *
 * Dagger component for Splash screen. Depends on AppComponent.
 *
 */
@LaunchScope
@Component(modules = [(LaunchContextModule::class), (LaunchModule::class)], dependencies = [(AppComponent::class)])
interface LaunchComponent {
    fun inject(activity: LaunchActivity)
}