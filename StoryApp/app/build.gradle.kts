// Impor dotenv
import io.github.cdimascio.dotenv.dotenv

// Baca .env file
val dotenv = dotenv {
    directory = rootProject.projectDir.absolutePath
    ignoreIfMissing = true
}

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp") version "2.0.0-1.0.21" // Untuk Room
    id("kotlin-kapt") // Untuk Hilt
}


android {
    namespace = "id.ac.unpas.storyapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "id.ac.unpas.storyapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }

    buildTypes {
        debug {
            buildConfigField("String", "API_URL", "\"${dotenv["API_URL_DEBUG"] ?: "https://api-dev.example.com/v1/"}\"")
        }
        release {
            buildConfigField("String", "API_URL", "\"${dotenv["API_URL_RELEASE"] ?: "https://api.example.com/v1/"}\"")
            // Konfigurasi release lainnya
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {

    // Jetpack Compose - untuk membuat UI
    implementation(libs.androidx.activity.compose.v182)      // Activity Compose
    implementation(libs.ui)                 // Compose UI
    implementation(libs.ui.graphics)        // Graphics
    implementation(libs.material3)   // Material Design 3

    // Navigation - untuk perpindahan antar halaman
    implementation(libs.androidx.navigation.compose)

    // ViewModel - untuk state management
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // Room - untuk database lokal
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    // Retrofit - untuk network calls
    implementation(libs.retrofit)        // Library utama
    implementation(libs.converter.gson)  // Konverter JSON
    implementation(libs.logging.interceptor) // Logging

    // DataStore - untuk penyimpanan kecil seperti token
    implementation(libs.androidx.datastore.preferences)

    // WorkManager - untuk background tasks
    implementation(libs.androidx.work.runtime.ktx)

    // Hilt - untuk dependency injection
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)


}

