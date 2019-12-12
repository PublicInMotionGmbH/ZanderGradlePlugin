package com.publicinmotion.gradle

import io.kotlintest.assertSoftly
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer


class NetworkResponseMapperTest : StringSpec({
    "it should map successful response to ZanderResponse.Success"{

        val body = """
            {
                "downloadUrl": "http://zander.test/DBFFED33-4521-4D09-A330-B7A7669087C5/app-branding-debug-4.8.0.localBuild.apk",
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
        """.trimIndent()

        val givenResponse = MockResponse()
            .setBody(body)
            .setResponseCode(200)

        val mockWebServer = MockWebServer().apply {
            url("http://zander.test/")
        }
        val baseUrl = mockWebServer.url("/upload")

        mockWebServer.enqueue(givenResponse)
        val sendFile = SendFile(
            url = baseUrl.toString(),
            authorization = "asd123",
            globalLogger = testLogger
        )

        val response = sendFile.execute(givenArtifact)

        val result = NetworkResponseMapper().map(response)

        assertSoftly {
            val success = result as ZanderResponse.Success
            success.downloadUrl shouldBe "http://zander.test/DBFFED33-4521-4D09-A330-B7A7669087C5/app-branding-debug-4.8.0.localBuild.apk"
            success.buildMetadata shouldBe BuildMetadata(
                version = "4.7",
                buildNumber = "1",
                updatedAt = "2019-12-10T15:36:17Z",
                id = "DBFFED33-4521-4D09-A330-B7A7669087C5",
                appId = "869D9853-C270-4687-9BF2-4019242ADA84",
                releaseNotes = "Test",
                createdAt = "2019-12-10T15:36:16Z",
                buildFileName = "app-branding-debug-4.8.0.localBuild.apk",
                buildUploadDate = "2019-12-10T15:36:17Z"
            )
        }
    }

    "it should map error response to ZanderResponse.Error"{
        val givenResponse = MockResponse()
            .setResponseCode(500)

        val mockWebServer = MockWebServer().apply {
            url("http://zander.test/")
        }
        val baseUrl = mockWebServer.url("/upload")

        mockWebServer.enqueue(givenResponse)
        val sendFile = SendFile(
            url = baseUrl.toString(),
            authorization = "asd123",
            globalLogger = testLogger
        )

        val response = sendFile.execute(givenArtifact)

        val result = NetworkResponseMapper().map(response)

        val error = (result as ZanderResponse.Error)
        assertSoftly {
            error.errorCode shouldBe 500
            error.message shouldBe "Server Error"
        }
    }
})
