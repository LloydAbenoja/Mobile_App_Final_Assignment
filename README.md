📐 Mobile App Final Assignment

A Kotlin-based Android app displaying architectural landmarks in a dashboard and detailed view, integrating REST API data with MVVM architecture.

📝 Features

- Login with username and password via API.
- Dashboard: RecyclerView listing landmark names.
- Details Screen: Shows full information for selected landmark.
- Navigation: SafeArgs navigation and back button.
- Material Design: Uses Material3 components and ConstraintLayout.

🏗 Architecture

- Pattern: MVVM
- Networking: Retrofit + OkHttp
- JSON Parsing: Moshi
- Dependency Injection: Hilt
- Async: Kotlin Coroutines + Flow
- UI Updates: LiveData

📋 Requirements
- Android Studio Narwhale 2025 1.3
- Gradle version SDK 21.0.7

📝 Dependencies

    // --- Networking / Retrofit ---
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.11.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.14.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")

    // --- Dependency Injection (Hilt) ---
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")

    // --- Unit Testing ---
    testImplementation ("junit:junit:4.13.2")
    testImplementation ("androidx.arch.core:core-testing:2.2.0")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
    testImplementation ("io.mockk:mockk:1.13.11")

    // --- Android Instrumentation Tests ---
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")

⚡ Setup

1. Clone the repository:
git clone <repo-url>
2. Open in Android Studio.
3. Sync Gradle and install dependencies.
4. Run on emulator or physical device (API 33+ recommended).

🚀 Usage

- Launch the app.
- Enter username & password → tap Login.
- View landmarks in Dashboard.
- Tap Show Description → navigate to Details screen.
- Use Back button to return to Dashboard.
