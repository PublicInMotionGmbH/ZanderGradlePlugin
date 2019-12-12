package com.publicinmotion.gradle

sealed class ZanderResponse() {
    data class Success(
        val downloadUrl: String,
        val buildMetadata: BuildMetadata
    ) : ZanderResponse()

    data class Error(val errorCode: Int, val message: String) : ZanderResponse()
}

data class BuildMetadata(
    val version: String,
    val buildNumber: String,
    val updatedAt: String,
    val id: String,
    val appId: String,
    val releaseNotes: String,
    val createdAt: String,
    val buildFileName: String,
    val buildUploadDate: String
)

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
