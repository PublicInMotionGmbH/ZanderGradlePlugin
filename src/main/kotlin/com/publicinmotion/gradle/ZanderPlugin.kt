package com.publicinmotion.gradle

import com.android.build.gradle.AppExtension
import com.android.build.gradle.api.ApplicationVariant
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create

fun Project.android(): AppExtension = project.extensions.findByName("android") as AppExtension

class ZanderPlugin : Plugin<Project> {
    override fun apply(p0: Project) {
        with(p0) {
            val resolveAndroidPlugin = runCatching { android() }
            require(resolveAndroidPlugin.isSuccess) {
                "Android application plugin is required for ZanderDistributionPlugin"
            }

            val extension = extensions.create("zander", ZanderPluginExtension::class)
            resolveAndroidPlugin.getOrThrow().applicationVariants.whenObjectAdded {
                createTaskForVariant(p0, extension)
            }
        }
    }

    private fun ApplicationVariant.createTaskForVariant(project: Project, extension: ZanderPluginExtension) {
        project.tasks.register(
            "zanderDistribute${name.capitalize()}",
            PublishTask::class.java,
            *arrayOf(extension, this)
        )
    }
}
