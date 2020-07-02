package net.natura.testcommons.matchers

import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.graphics.drawable.toBitmap
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

/**
 * Checks if the view is displaying a given drawable.
 *
 * Example usage:
 * ```
 * onView(withId(R.id.the_imageview)).check(matches(withDrawable(R.drawable.my_drawable)))
 * ```
 * @param id The drawable's resource id
 */
fun withDrawable(@DrawableRes id: Int) = object : TypeSafeMatcher<View>() {

    override fun describeTo(description: Description) {
        description.appendText("ImageView has drawable with id $id")
    }

    override fun matchesSafely(view: View): Boolean {
        val context = view.context
        val expectedBitmap = context.getDrawable(id)?.toBitmap()

        return view is ImageView && view.drawable.toBitmap().sameAs(expectedBitmap)
    }
}