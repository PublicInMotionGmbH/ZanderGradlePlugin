package com.publicinmotion.gradle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

val givenArtifact = ApkArtifact(
    file = File("src/test/resources/mockartifact.apk"),
    version = "4.2.0",
    releaseNotes = "Some release note",
    buildNumber = "402000"
)

val testLogger: Logger = LoggerFactory.getLogger("test")
