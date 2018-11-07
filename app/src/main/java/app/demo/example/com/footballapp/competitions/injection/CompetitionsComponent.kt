package app.demo.example.com.footballapp.competitions.injection

import app.demo.example.com.footballapp.app.injection.AppComponent
import app.demo.example.com.footballapp.competitions.CompetitionsFragment
import dagger.Component

/**
 *
 * Dagger component for Competitions screen. Depends on AppComponent.
 *
 */
@CompetitionsScope
@Component(modules = arrayOf(CompetitionsContextModule::class, CompetitionsModule::class), dependencies = arrayOf(AppComponent::class))
interface CompetitionsComponent {
    fun inject(fragment: CompetitionsFragment)
}