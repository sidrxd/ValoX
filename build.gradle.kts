plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    kotlin("multiplatform").apply(false)
    id("com.android.application").apply(false)
    id("com.android.library").apply(false)
    id("org.jetbrains.compose").apply(false)
}

subprojects {
    afterEvaluate{
        tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).configureEach {
            if (project.plugins.hasPlugin("com.android.application") || project.plugins.hasPlugin("com.android.library")) {
                kotlinOptions.jvmTarget = "17"
            } else {
                kotlinOptions.jvmTarget = "17"
            }
        }
    }
}