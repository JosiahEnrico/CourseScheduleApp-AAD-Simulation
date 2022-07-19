import android.app.Activity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import androidx.test.runner.lifecycle.Stage
import com.aadexercise.courseschedule.R
import com.aadexercise.courseschedule.ui.add.AddCourseActivity
import com.aadexercise.courseschedule.ui.home.HomeActivity
import junit.framework.TestCase
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)
    var addCourseAct: Activity? = null

    @Test
    fun homeActivityTest() {
        onView(withId(R.id.action_add)).check(matches(isDisplayed())).perform(click())
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            run {
                addCourseAct = ActivityLifecycleMonitorRegistry.getInstance()
                    .getActivitiesInStage(Stage.RESUMED).elementAtOrNull(0)
                TestCase.assertTrue(addCourseAct?.javaClass == AddCourseActivity::class.java)
            }
        }
    }
}