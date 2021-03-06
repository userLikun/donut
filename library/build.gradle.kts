import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.library")
    id("kotlin-android")
}

group = ProjectSettings.group
version = ProjectSettings.version

android {
    compileSdkVersion(ProjectSettings.targetSdk)

    defaultConfig {
        minSdkVersion(ProjectSettings.minSdk)
        targetSdkVersion(ProjectSettings.targetSdk)
    }

    sourceSets {
        getByName("main").java.srcDir("src/main/kotlin")
    }
}

dependencies {
    implementation(kotlin(Deps.Kotlin.stdlib, KotlinCompilerVersion.VERSION))
    implementation(Deps.AndroidX.ktx)
}

project.apply {
    extensions.add("artifact", ProjectSettings.Donut.artifact)
    extensions.add("libraryName", ProjectSettings.Donut.artifact)
    extensions.add("libraryDescription", ProjectSettings.Donut.libraryDescription)
}

apply("../publish.script.gradle")
