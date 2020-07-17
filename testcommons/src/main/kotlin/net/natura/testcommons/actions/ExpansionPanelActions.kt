package net.natura.testcommons.actions

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import com.natura.android.expansionPanel.ExpansionPanel
import net.natura.testcommons.R
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher

/**
 * Click on the ExpansionPanel.
 *
 * Example usage:
 * ```kotlin
 * onView(withId(R.id.the_expansionpanel_id)).perform(clickOnExpansionPanel())
 * ```
 */
fun clickOnExpansionPanel() = object : ViewAction {

    override fun getDescription(): String = "click on the ExpansionPanel"

    override fun getConstraints(): Matcher<View> {
        return allOf(
                withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE),
                isAssignableFrom(ExpansionPanel::class.java)
        )
    }

    override fun perform(uiController: UiController?, view: View?) {
        val expansionPanelContainer = (view as ExpansionPanel).findViewById<ConstraintLayout>(R.id.ds_expansion_panel_content_area)
        expansionPanelContainer.callOnClick()
    }
}

/**
 * Expand the ExpansionPanel.
 *
 * Example usage:
 * ```kotlin
 * onView(withId(R.id.the_expansionpanel_id)).perform(expandExpansionPanel())
 * ```
 */
fun expandExpansionPanel() = ExpansionPanelVisibilityAction(expand = true)

/**
 * Collapse on the ExpansionPanel.
 *
 * Example usage:
 * ```kotlin
 * onView(withId(R.id.the_expansionpanel_id)).perform(collapseExpansionPanel())
 * ```
 */
fun collapseExpansionPanel() = ExpansionPanelVisibilityAction(expand = false)

class ExpansionPanelVisibilityAction(private val expand: Boolean) : ViewAction {

    override fun getDescription(): String = "set the ExpansionPanel as ${if (expand) "expanded" else "collapsed"}"

    override fun getConstraints(): Matcher<View> {
        return allOf(
            withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE),
            isAssignableFrom(ExpansionPanel::class.java)
        )
    }

    override fun perform(uiController: UiController?, view: View?) {
        (view as ExpansionPanel).isExpanded = expand
    }
}
