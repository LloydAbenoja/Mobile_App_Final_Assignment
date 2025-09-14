package com.example.mobile_app_final_assignment.util

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.ExtensionContext

class InstantTaskExecutorExtension : BeforeAllCallback, AfterAllCallback {
    private val executor = object : TaskExecutor() {
        override fun executeOnDiskIO(runnable: Runnable) = runnable.run()
        override fun postToMainThread(runnable: Runnable) = runnable.run()
        override fun isMainThread() = true
    }

    override fun beforeAll(context: ExtensionContext?) {
        ArchTaskExecutor.getInstance().setDelegate(executor)
    }

    override fun afterAll(context: ExtensionContext?) {
        ArchTaskExecutor.getInstance().setDelegate(null)
    }
}
