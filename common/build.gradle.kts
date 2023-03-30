plugins {
    id(BuildPlugins.AndroidLibrary)
    id(BuildPlugins.kotlinJetBrains)
    id(BuildPlugins.NavSafeArgs)
}
android {
    namespace = "com.example.common"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding=true
    }
}

dependencies {
    implementation(Deps.appCompat)
    implementation(Deps.core)
    implementation(Deps.androidMaterial)
    api(Glide.glide)
    implementation(Glide.annotationProcessor)
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    testImplementation(TestImplementation.junit)
}