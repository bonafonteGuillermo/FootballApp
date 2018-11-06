package app.demo.example.com.footballapp.competitions.injection

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 *
 * Scope for Competitions activity
 *
 * Created by Guillermo Bonafonte Criado
 */
@Scope
@Retention(RetentionPolicy.CLASS)
annotation class CompetitionsScope
