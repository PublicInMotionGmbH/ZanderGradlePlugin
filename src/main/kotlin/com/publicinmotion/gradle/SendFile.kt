package com.publicinmotion.gradle

import okhttp3.CacheControl
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.slf4j.Logger
import java.util.concurrent.TimeUnit

class SendFile(
    val url: String,
    val globalLogger: Logger,
    val authorization: String,
    connectTimeoutSeconds: Long
) {

    private val httpLogger: HttpLoggingInterceptor.Logger = object : HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
            globalLogger.info(message)
        }
    }

    private val client = OkHttpClient()
        .newBuilder()
        .callTimeout(connectTimeoutSeconds, TimeUnit.SECONDS)
        .writeTimeout(connectTimeoutSeconds, TimeUnit.SECONDS)
        .readTimeout(connectTimeoutSeconds, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor(httpLogger).apply {
            level = HttpLoggingInterceptor.Level.HEADERS
        })
        .build()

    fun execute(artifact: ApkArtifact): Response {
        val formBody = MultipartBody.Builder()
            .setType("multipart/form-data".toMediaType())
            .addFormDataPart(
                "ipaFile",
                artifact.file.name,
                artifact.file.asRequestBody("application/octet-stream".toMediaType())
            )
            .addFormDataPart("buildNumber", artifact.buildNumber)
            .addFormDataPart("releaseNotes", artifact.releaseNotes)
            .addFormDataPart("version", artifact.version)
            .build()

        val request = Request.Builder()
            .header("Authorization", "Basic $authorization")
            .header("Accept-Encoding", "gzip, deflate")
            .header("Accept", "*/*")
            .header("User-Agent", "Zander Gradle Plugin")
            .cacheControl(CacheControl.FORCE_NETWORK)
            .url(url)
            .post(formBody)
            .build()

        globalLogger.warn("Starting upload...")

        return client.newCall(request).execute()
    }
}
