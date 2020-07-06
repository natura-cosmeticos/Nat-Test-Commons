package net.natura.testcommons.rules

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.Module

/**
 * A JUnit4 rule that starts and stops Koin instance between tests.
 *
 * Example usage:
 * ```
 * class MyActivityTest {
 *
 *     @get:Rule
 *     val koinRule = KoinRule()
 * }
 * ```
 * @param injectedModule Module that can be injected at start (optional).
 */
class KoinRule(private val injectedModule: Module? = null) : TestRule {

    override fun apply(base: Statement?, description: Description?) = object : Statement() {
        override fun evaluate() {
            try {
                startKoin {
                    injectedModule?.let(::modules)
                }

                base?.evaluate()
            } finally {
                stopKoin()
            }
        }
    }
}
