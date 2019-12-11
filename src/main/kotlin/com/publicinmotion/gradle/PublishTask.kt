package com.publicinmotion.gradle

import com.android.build.gradle.api.ApplicationVariant
import org.gradle.api.DefaultTask
import org.gradle.api.logging.LogLevel
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.TaskExecutionException
import java.io.File
import javax.inject.Inject

abstract class PublishTask @Inject constructor(
    private val extension: ZanderPluginExtension,
    private val variant: ApplicationVariant
) : DefaultTask() {

    private val sendFileUseCase = SendFile(
        url = CreateUrlForVariantUseCase().execute(extension.url, variant),
        authorization = extension.oAuthCredentials,
        globalLogger = logger
    )

    @TaskAction
    fun publishApk() {

        val mainOutputFile = variant.getApkFileForVariant()
        logger.log(LogLevel.WARN, "Found output file: ${mainOutputFile.absolutePath}")

        logger.log(LogLevel.WARN, "Publishing apk for ${variant.name}")

        val response = sendFileUseCase.execute(
            ApkArtifact(
                file = mainOutputFile,
                buildNumber = extension.buildNumber,
                releaseNotes = extension.releaseNotes,
                version = extension.version
            )
        )

        if (response.isSuccessful) {
            logger.log(LogLevel.WARN, "Uploaded file to ${response.body?.string()}")
        } else {
            throw TaskExecutionException(this, Error("Failed to publish APK: ${response.message}"))
        }
    }

    private fun ApplicationVariant.getApkFileForVariant(): File {
        val file = outputs.first().outputFile
        require(file != null) {
            "Couldn't find file for variant ${this.name}. Make sure that file was previously built."
        }
        return file
    }
}
