package app.demo.example.com.footballapp.splash.injection

import app.demo.example.com.footballapp.app.injection.AppComponent
import app.demo.example.com.footballapp.splash.SplashActivity
import dagger.Component

/**
 *
 * Dagger component for Splash screen. Depends on AppComponent.
 *
 */
@SplashScope
@Component(modules = arrayOf(SplashContextModule::class, SplashModule::class), dependencies = arrayOf(AppComponent::class))
interface SplashComponent {
    fun inject(activity: SplashActivity)
}