package net.natura.testcommons.rules

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

/**
 * A JUnit4 test rule to allows testing coroutines that use the main dispatcher. Without this you'd run into
 * "java.lang.IllegalStateException: Module with the Main dispatcher had failed to initialize. For tests
 * Dispatchers.setMain from kotlinx-coroutines-test module can be used"
 *
 * Example usage:
 * ```kotlin
 * class MyTest {
 *
 *     @ExperimentalCoroutinesApi
 *     @get:Rule
 *     val coroutinesRule = CoroutinesRule()
 * }
 * ```
 *
 * See also [https://gist.github.com/AniketSK/0fd48da9ed969eee307f92457115612a]
 */
class CoroutinesRule : TestRule {

    @ExperimentalCoroutinesApi
    override fun apply(base: Statement?, description: Description?) = object : Statement() {

        private val dispatcher = TestCoroutineDispatcher()

        override fun evaluate() {
            try {
                Dispatchers.setMain(dispatcher)
                base?.evaluate()
            } finally {
                Dispatchers.resetMain()
            }
        }
    }
}
