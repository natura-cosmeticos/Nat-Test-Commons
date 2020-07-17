package net.natura.testcommons.assertions

import android.view.View
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import com.natura.android.expansionPanel.ExpansionPanel
import org.junit.Assert.assertEquals

/**
 * Checks if the ExpansionPanel is expanded.
 *
 * Example usage:
 * ```
 * onView(withId(R.id.the_expansionpanel_id)).check(expansionPanelIsExpanded())
 * ```
 */
fun expansionPanelIsExpanded() = ExpansionPanelVisibilityAssertion(isExpectedToBeExpanded = true)

/**
 * Checks if the ExpansionPanel is collapsed.
 *
 * Example usage:
 * ```
 * onView(withId(R.id.the_expansionpanel_id)).check(expansionPanelIsCollapsed())
 * ```
 */
fun expansionPanelIsCollapsed() = ExpansionPanelVisibilityAssertion(isExpectedToBeExpanded = false)

class ExpansionPanelVisibilityAssertion(
    private val isExpectedToBeExpanded: Boolean
) : ViewAssertion {

    override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
        noViewFoundException?.let { throw it }

        if (view !is ExpansionPanel) {
            throw AssertionError("View is not an instance of ExpansionPanel")
        }

        assertEquals(isExpectedToBeExpanded, view.isExpanded)
    }
}
