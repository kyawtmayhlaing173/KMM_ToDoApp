
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("com.squareup.sqldelight")
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
            linkerOpts.add("-lsqlite3")
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation("com.squareup.sqldelight:runtime:1.5.3")
            implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.0")
        }
        androidMain.dependencies {
            implementation("com.squareup.sqldelight:android-driver:1.5.3")
        }
        iosMain.dependencies {
            implementation("com.squareup.sqldelight:native-driver:1.5.3")
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

sqldelight {
    database("NoteDatabase") {
        packageName = "com.example.notesappkotlin"
        sourceFolders = listOf("sqldelight")
    }
    linkSqlite = true
}

android {
    namespace = "com.example.notesappkotlin"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
