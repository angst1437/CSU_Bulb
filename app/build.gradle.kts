//noinspection UseTomlInstead

buildscript {
    repositories {
        google()
    }
    dependencies {
        val navigationVersion = "2.9.6"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion")
    }
}


plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp") version "2.3.3"
    kotlin("plugin.serialization") version "2.0.21"
    id("androidx.navigation.safeargs") version "2.9.6"
}

android {
    namespace = "com.example.csu_bulb"
    compileSdk {
        version = release(36)
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
        }
    }

    defaultConfig {
        applicationId = "com.example.csu_bulb"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String", "API_URL", "\"http://195.133.53.179:1337\"")
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
        android.buildFeatures.buildConfig = true
        buildConfig = true
    }

    buildTypes {
        debug {
            buildConfigField("String", "API_URL", "\"http://195.133.53.179:1337\"")
        }
        release {
            isMinifyEnabled = false
            buildConfigField("String", "API_URL", "\"http://195.133.53.179:1337\"")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

//noinspection UseTomlInstead
dependencies {
    val navigationVersion = "2.9.6"
    val lifecycleVersion = "2.10.0"

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("com.squareup.retrofit2:retrofit:3.0.0")
    implementation("com.squareup.retrofit2:converter-scalars:3.0.0")
    implementation("com.squareup.retrofit2:converter-gson:3.0.0")
    implementation("com.google.dagger:dagger:2.57.2")
    ksp("com.google.dagger:dagger-compiler:2.57.2")
    implementation("androidx.navigation:navigation-compose:$navigationVersion")
    implementation("androidx.navigation:navigation-fragment:$navigationVersion")
    implementation("androidx.navigation:navigation-ui:$navigationVersion")
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$navigationVersion")
    implementation("dev.androidbroadcast.vbpd:vbpd:2.0.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.2")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${lifecycleVersion}")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${lifecycleVersion}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${lifecycleVersion}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:${lifecycleVersion}")

}