package net.natura.testcommons.extensions

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext

/**
 * A JUnit5 test extension to allows testing coroutines that use the main dispatcher. Without this you'd run into
 * "java.lang.IllegalStateException: Module with the Main dispatcher had failed to initialize. For tests
 * Dispatchers.setMain from kotlinx-coroutines-test module can be used"
 *
 * Example usage:
 * ```kotlin
 * @ExtendWith(CoroutinesExtension::class)
 * class MyTest {
 * }
 * ```
 *
 * See also [https://gist.github.com/AniketSK/0fd48da9ed969eee307f92457115612a]
 */
@ExperimentalCoroutinesApi
class CoroutinesExtension : BeforeEachCallback, AfterEachCallback {

    private val dispatcher = TestCoroutineDispatcher()

    override fun beforeEach(context: ExtensionContext?) {
        Dispatchers.setMain(dispatcher)
    }

    override fun afterEach(context: ExtensionContext?) {
        Dispatchers.resetMain()
    }
}
