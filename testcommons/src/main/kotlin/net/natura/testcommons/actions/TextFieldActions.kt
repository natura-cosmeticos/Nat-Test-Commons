package net.natura.testcommons.actions

import android.view.View
import android.widget.EditText
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import com.natura.android.textfield.TextField
import net.natura.testcommons.R
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher

/**
 * Set a value to the EditText inside the [TextField].
 *
 * Example usage:
 * ```
 * onView(withId(R.id.the_textfield_id)).perform(typeValueInTextField("my text"))
 * ```
 * @param text the string to be set.
 */
fun typeValueInTextField(text: String) = object : ViewAction {

    override fun getDescription(): String = "type $text in TextField"

    override fun getConstraints(): Matcher<View> {
        return allOf(
                withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE),
                isAssignableFrom(TextField::class.java)
        )
    }

    override fun perform(uiController: UiController?, view: View?) {
        val editText = (view as TextField).findViewById<EditText>(R.id.text_field_input_value)
        editText.setText(text)
    }
}
