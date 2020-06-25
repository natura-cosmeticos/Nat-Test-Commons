package net.natura.testcommons.rules

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.Module

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
