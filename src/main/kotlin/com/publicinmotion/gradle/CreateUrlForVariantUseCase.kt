package com.publicinmotion.gradle

import com.android.build.gradle.api.ApplicationVariant

class CreateUrlForVariantUseCase() {
    fun execute(base: String, variant: ApplicationVariant): String {
        return "$base/apps/bundleId/${variant.applicationId}/builds/upload"
    }
}
