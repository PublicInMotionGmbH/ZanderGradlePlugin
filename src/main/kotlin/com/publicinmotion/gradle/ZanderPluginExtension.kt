package com.publicinmotion.gradle

import org.gradle.api.model.ObjectFactory
import javax.inject.Inject

@Suppress("UnstableApiUsage")
open class ZanderPluginExtension @Inject constructor(
    private val objectFactory: ObjectFactory
) {
    var url: String = ""
    var oAuthCredentials: String = ""
    var buildNumber: String = ""
    var releaseNotes: String = ""
    var version: String = ""
    var timeoutSeconds: Long = DEFAULT_TIMEOUT_SECONDS

    fun oAuthCredentials(credentials: String) {
        oAuthCredentials = credentials
    }

    fun url(url: String) {
        this.url = url
    }

    fun buildNumber(buildNumber: String) {
        this.buildNumber = buildNumber
    }

    fun releaseNotes(releaseNotes: String) {
        this.releaseNotes = releaseNotes
    }

    fun version(version: String) {
        this.version = version
    }

    companion object {
        private const val DEFAULT_TIMEOUT_SECONDS = 30L
    }
}
