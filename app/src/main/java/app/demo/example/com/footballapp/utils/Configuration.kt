package app.demo.example.com.footballapp.utils

import app.demo.example.com.footballapp.BuildConfig

/**
 *
 * Provides the configuration that depends on the build variant
 *
 */
const val FLAVOR_MOCK: String = "footMock"
const val FLAVOR_QA: String = "footQa"
const val FLAVOR_PRODUCTION: String = "footProduction"

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
                FLAVOR_QA -> return "http://api.football-data.org/v2"
                else -> return "http://api.football-data.org/v2"
            }
        }

}