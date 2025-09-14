plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.mobile_app_final_assignment"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.mobile_app_final_assignment"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }
        buildTypes {
            release {
                isMinifyEnabled = false
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
        kotlinOptions {
            jvmTarget = "11"
        }

    }

    dependencies {

        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.appcompat)
        implementation(libs.material)
        implementation(libs.androidx.activity)
        implementation(libs.androidx.constraintlayout)
        implementation(libs.androidx.navigation.fragment.ktx)
        implementation(libs.androidx.navigation.ui.ktx)
        implementation(libs.androidx.recyclerview)
        implementation(libs.androidx.fragment)
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")

        // Retrofit dependancies
        implementation("com.squareup.retrofit2:retrofit:2.11.0")
        implementation("com.squareup.retrofit2:converter-moshi:2.11.0")
        implementation("com.squareup.moshi:moshi-kotlin:1.14.0")
        implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")

        // Hilt dependancies
        implementation("com.google.dagger:hilt-android:2.51.1")
        kapt("com.google.dagger:hilt-android-compiler:2.51.1")
        testImplementation(kotlin("test"))
        androidTestImplementation(kotlin("test"))
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

// Coroutines test library
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
// LiveData / Arch components testing
        testImplementation("androidx.arch.core:core-testing:2.2.0")


    }
    tasks.withType<Test> {
    useJUnitPlatform()
    }


// Allow references to generated code
    kapt {
        correctErrorTypes = true
    }
