package net.natura.testcommons.extensions

import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.Module

/**
 * A JUnit5 extension that starts and stops Koin instance between tests.
 *
 * Example usage:
 *
 * Static call
 * ```kotlin
 * class MyTest {
 *     companion object {
 *         @JvmField
 *         @RegisterExtension
 *         val koinExtension = KoinExtension(yourKoinModule)
 *     }
 * }
 * ```
 * Dynamic call:
 * ```kotlin
 * class MyTest {
 *     @JvmField
 *     @RegisterExtension
 *     val koinExtension = KoinExtension(listOf(koinModule1, koinModule2))
 * }
 * ```
 * When no parameters are needed:
 * ```kotlin
 * @ExtendWith(KoinExtension::class)
 * class MyTest {
 * }
 * ```
 * @param injectedModuleList List of modules that can be injected at start (optional);
 * @param injectedModule Module that can be injected at start (optional).
 */
class KoinExtension(
    private val injectedModuleList: List<Module> = listOf()
) : BeforeEachCallback, AfterEachCallback {

    constructor(injectedModule: Module) : this(listOf(injectedModule))

    override fun beforeEach(context: ExtensionContext?) {
        startKoin {
            modules(injectedModuleList)
        }
    }

    override fun afterEach(context: ExtensionContext?) {
        stopKoin()
    }
}
