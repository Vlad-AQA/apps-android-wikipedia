package org.wikipedia.lesson27.homework

import android.util.Log
import org.junit.AssumptionViolatedException
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class DeprecatedSkipRule : TestRule {
    override fun apply(
        base: Statement?,
        description: Description?
    ): Statement {
        return object : Statement() {
            override fun evaluate() {
                val deprecated = description?.getAnnotation(Deprecated::class.java)
                if (deprecated != null) {
                    Log.i("KASPRESSO", "Skip deprecated test: ${description.displayName}")
                    throw AssumptionViolatedException(
                        "Test is deprecated: ${deprecated.message}"
                    )
                }
                base?.evaluate()
            }
        }
    }
}
