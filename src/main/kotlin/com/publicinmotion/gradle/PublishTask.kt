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

    init {
        group = "publishing"
    }

    private val networkResponseMapper = NetworkResponseMapper()

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
        ).let(networkResponseMapper::map)

        when (response) {
            is ZanderResponse.Success -> {
                logger.log(LogLevel.WARN, "Uploaded file to ${response.downloadUrl}")
                logger.info("Build upload info: $response")
            }
            is ZanderResponse.Error -> {
                logger.log(LogLevel.WARN, "Upload failed")
                throw TaskExecutionException(
                    this,
                    Error("Failed to publish APK: ${response.errorCode}, ${response.message}")
                )
            }
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
