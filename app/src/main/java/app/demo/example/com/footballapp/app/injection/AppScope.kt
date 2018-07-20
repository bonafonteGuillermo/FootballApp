package app.demo.example.com.footballapp.app.injection

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 *
 * App scope
 *
 * Created by Guillermo Bonafonte Criado
 */
@Scope
@Retention(RetentionPolicy.CLASS)
annotation class AppScope