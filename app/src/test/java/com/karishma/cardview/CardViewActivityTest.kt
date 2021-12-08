package com.karishma.cardview

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CardViewActivityTest {
    private lateinit var fragment: CardViewFragment2

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule(CardViewActivity::class.java)

    @Before
    fun setUp() {
        activityTestRule.activity.fragmentManager.beginTransaction()
        fragment = activityTestRule.activity.fragmentManager
            .findFragmentById(R.id.container) as CardViewFragment2
    }

    @Test
    fun testPreconditions() {
        assertNotNull(activityTestRule.activity)
        assertNotNull(fragment)
        assertNotNull(fragment.radiusSeekBar)
        assertNotNull(fragment.elevationSeekBar)
    }

    @Test
    fun testRadiusSeekbarChangesRadiusOfCardView() {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            val radius = 50.0f
            fragment.radiusSeekBar.progress = radius.toInt()
            assertEquals(radius, fragment.cardView.radius)
        }
    }

    @Test
    fun testElevationSeekbarChangesElevationOfCardView() {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            val elevation = 40.0f
            fragment.elevationSeekBar.progress = elevation.toInt()
            assertEquals(elevation, fragment.cardView.elevation)
        }
    }

}
