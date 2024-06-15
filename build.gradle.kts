plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    id("com.google.devtools.ksp") version "1.9.23-1.0.20" apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
    id("com.squareup.sqldelight") version "1.5.3" apply false
}
