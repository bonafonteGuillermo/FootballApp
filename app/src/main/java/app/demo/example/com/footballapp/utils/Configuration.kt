package app.demo.example.com.footballapp.utils

import app.demo.example.com.footballapp.BuildConfig

/**
 *
 * Provides the configuration that depends on the build variant
 *
 * Created by Jorge Para on 10/30/17.
 * 2017 © Cognizant Technology Solutions
 */
const val FLAVOR_MOCK: String = "cjMock"
const val FLAVOR_QA: String = "cjQa"
const val FLAVOR_PRODUCTION: String = "cjProduction"

class Configuration {

    enum class Variant {
        MOCK, QA, PRODUCTION;
    }

    val Environment : Variant
        get() {
            when (BuildConfig.FLAVOR) {
                FLAVOR_MOCK -> return Variant.MOCK
                FLAVOR_QA -> return Variant.QA
                else -> return Variant.PRODUCTION
            }
        }

    val BaseUrl : String
        get() {
            when (BuildConfig.FLAVOR) {
                FLAVOR_MOCK -> return "https://www.example.com"
                FLAVOR_QA -> return "https://candidatejourneyapi-int.azurewebsites.net"
                else -> return "https://candidatejourneyapi.azurewebsites.net"
            }
        }

}