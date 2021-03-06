package net.natura.testcommons.assertions

import androidx.test.espresso.ViewAssertion
import com.natura.android.textfield.TextField
import org.junit.Assert.assertEquals

/**
 * Checks if the TextField is in error state and displays a given error.
 *
 * Example usage:
 * ```
 * onView(withId(R.id.the_textfield_id)).check(hasErrorInTextField("my error message"))
 * ```
 * @param expectedText The text that is expected to be displayed as error message.
 */
fun hasErrorInTextField(expectedText: String) = ViewAssertion { view, noMatchingViewException ->
    noMatchingViewException?.let { throw it }

    if (view !is TextField) {
        throw AssertionError("View is not an instance of TextField")
    }

    assertEquals(TextField.State.ERROR, view.state)
    assertEquals(expectedText, view.error)
}

/**
 * Checks if the TextField has a given text.
 *
 * Example usage:
 * ```
 * onView(withId(R.id.the_textfield_id)).check(hasValueInTextField("my text"))
 * ```
 * @param expectedText The text that is expected to be displayed as content.
 */
fun hasValueInTextField(expectedText: String) = ViewAssertion { view, noMatchingViewException ->
    noMatchingViewException?.let { throw it }

    if (view !is TextField) {
        throw AssertionError("View is not an instance of TextField")
    }

    assertEquals(expectedText, view.editTextView.text.toString())
}

/**
 * Checks if the TextField has a given text as footer.
 *
 * Example usage:
 * ```
 * onView(withId(R.id.the_textfield_id)).check(hasFooterInTextField("my footer message"))
 * ```
 * @param expectedText The text that is expected to be displayed as footer message.
 */
fun hasFooterInTextField(expectedText: String) = ViewAssertion { view, noMatchingViewException ->
    noMatchingViewException?.let { throw it }

    if (view !is TextField) {
        throw AssertionError("View is not an instance of TextField")
    }

    assertEquals(expectedText, view.footer)
}
