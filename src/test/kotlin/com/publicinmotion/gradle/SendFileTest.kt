package com.publicinmotion.gradle

import io.kotlintest.assertSoftly
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import okhttp3.MultipartBody

class SendFileTest : StringSpec({

    "it should send file with proper headers"{
        val useCase = SendFile(
            url = "https://zander.domain.com",
            authorization = "asd123",
            globalLogger = testLogger,
            connectTimeoutSeconds = 30
        )

        val headers = useCase.execute(givenArtifact).request.headers

        assertSoftly {
            headers["Authorization"] shouldBe "Basic asd123"
            headers["Accept-Encoding"] shouldBe "gzip, deflate"
            headers["Accept"] shouldBe "*/*"
            headers["User-Agent"] shouldBe "Zander Gradle Plugin"
            headers["Cache-Control"] shouldBe "no-cache"
        }
    }

    "it should send file with multipart body"{
        val useCase = SendFile(
            url = "https://zander.domain.com",
            authorization = "asd123",
            globalLogger = testLogger,
            connectTimeoutSeconds = 30
        )

        val request = useCase.execute(givenArtifact).request
        val contentType = request.body?.contentType()
        val requestBody = request.body!!

        assertSoftly {
            contentType?.type shouldBe "multipart"
            contentType?.subtype shouldBe "form-data"
            requestBody::class.java shouldBe MultipartBody::class.java
        }
    }
})
