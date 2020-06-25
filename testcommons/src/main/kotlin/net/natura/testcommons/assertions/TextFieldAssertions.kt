package net.natura.testcommons.assertions

import androidx.test.espresso.ViewAssertion
import com.natura.android.textfield.TextField
import org.junit.Assert.assertEquals

fun hasErrorInTextField(expectedText: String) = ViewAssertion { view, noMatchingViewException ->
    noMatchingViewException?.let { throw it }

    if (view !is TextField) {
        throw AssertionError("View is not an instance of TextField")
    }

    assertEquals(TextField.State.ERROR, view.state)
    assertEquals(expectedText, view.error)
}