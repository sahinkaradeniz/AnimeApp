plugins {
    id(BuildPlugins.AndroidLibrary)
    id(BuildPlugins.kotlinJetBrains)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.DaggerHiltPlugin)
    id(BuildPlugins.NavSafeArgs)
}

android {
    namespace = "com.example.presentation"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.0")
    testImplementation(TestImplementation.junit)

    implementation (DaggerHilt.hilt)
    kapt(DaggerHilt.hiltCompiler)
    kapt(DaggerHilt.hiltAndroidCompiler)

    implementation(AndroidLibraries.navigationFrag)
    implementation(AndroidLibraries.navigation)
    implementation(AndroidLibraries.livedata)
    implementation(AndroidLibraries.viewmodel)


    implementation(project(Modules.common))
    implementation(project(Modules.data))
    implementation(project(Modules.domain))
}