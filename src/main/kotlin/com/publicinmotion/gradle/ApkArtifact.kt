package com.publicinmotion.gradle

import java.io.File

data class ApkArtifact(val file: File, val buildNumber: String, val releaseNotes: String, val version: String)
