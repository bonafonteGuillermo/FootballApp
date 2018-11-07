package app.demo.example.com.footballapp.areas.injection

import app.demo.example.com.footballapp.app.injection.AppComponent
import app.demo.example.com.footballapp.areas.AreasFragment
import dagger.Component

/**
 *
 * Dagger component for Areas screen. Depends on AppComponent.
 *
 */
@AreasScope
@Component(modules = arrayOf(AreasContextModule::class, AreasModule::class), dependencies = arrayOf(AppComponent::class))
interface AreasComponent {
    fun inject(activity: AreasFragment)
}