plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.consultaproductosrest_semana4"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.example.consultaproductosrest_semana4"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    // Retrofit — Cliente para consumir API REST
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // Convertidor — Transforma JSON a objetos Java automáticamente
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    // OkHttp — Maneja la conexión a Internet
    implementation("com.squareup.okhttp3:okhttp:4.9.3")
    // Librería de compatibilidad
    implementation("androidx.appcompat:appcompat:1.6.1")
}