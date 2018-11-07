package app.demo.example.com.footballapp.areas

import android.support.test.espresso.intent.Intents
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.*
import org.junit.runner.RunWith


/**
 *
 * Created by Guillermo Bonafonte Criado
 *
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class AreasScreenTest {

    @Rule
    @JvmField
    val activity = ActivityTestRule<AreasFragment>(AreasFragment::class.java)

    @Before
    fun testSetup() = Intents.init()

    @After
    fun finishTest() = Intents.release()

    //TODO Add dependencies
    /*

    androidTestImplementation "com.android.support.test:runner:1.0.1"
    androidTestImplementation "com.android.support.test:rules:1.0.1"

    // Espresso UI Testing dependencies.
    androidTestImplementation "com.android.support.test.espresso:espresso-core:3.0.1"
    androidTestImplementation "com.android.support.test.espresso:espresso-contrib:3.0.1"
    androidTestImplementation "com.android.support.test.espresso:espresso-intents:3.0.1"

    //UIAutomator dependency
    androidTestImplementation 'com.android.support.test.uiautomator:uiautomator-v18:2.1.3'

    */

}