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

class SendFile(val url: String, val globalLogger: Logger, val authorization: String) {

    private val httpLogger: HttpLoggingInterceptor.Logger = object : HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
            globalLogger.info(message)
        }
    }

    private val client = OkHttpClient()
        .newBuilder()
        .callTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
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
/**
 * Response:
 * {
    "downloadUrl": "url//DBFFED33-4521-4D09-A330-B7A7669087C5/app-branding-debug-4.8.0.localBuild.apk",
    "buildMetadata": {
    "version": "4.7",
    "buildNumber": "1",
    "updatedAt": "2019-12-10T15:36:17Z",
    "id": "DBFFED33-4521-4D09-A330-B7A7669087C5",
    "appId": "869D9853-C270-4687-9BF2-4019242ADA84",
    "releaseNotes": "Test",
    "createdAt": "2019-12-10T15:36:16Z",
    "buildFileName": "app-branding-debug-4.8.0.localBuild.apk",
    "buildUploadDate": "2019-12-10T15:36:17Z"
}
}
 */
