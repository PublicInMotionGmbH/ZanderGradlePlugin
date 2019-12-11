package com.publicinmotion.gradle

import FakeVariant
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class CreateUrlForVariantUseCaseTest : StringSpec({
    "it should format url according to application id"{
        val givenVariant = FakeVariant(givenApplicationId = "com.publicinmotion.application.debug")
        val givenBaseUrl = "https://zander.domain.com"
        val useCase = CreateUrlForVariantUseCase()

        val result = useCase.execute(givenBaseUrl, givenVariant)

        result shouldBe "https://zander.domain.com/apps/bundleId/com.publicinmotion.application.debug/builds/upload"
    }
})
