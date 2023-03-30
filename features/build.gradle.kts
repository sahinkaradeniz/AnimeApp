
    plugins {
        id(BuildPlugins.AndroidLibrary)
        id(BuildPlugins.kotlinJetBrains)
        id(BuildPlugins.kotlinAndroid)
        id(BuildPlugins.kotlinKapt)
        id(BuildPlugins.DaggerHiltPlugin)
        id(BuildPlugins.NavSafeArgs)
    }

    android {
        namespace = "com.example.features"
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
        testImplementation(TestImplementation.junit)

        implementation(DaggerHilt.hilt)
        kapt(DaggerHilt.hiltCompiler)
        kapt(DaggerHilt.hiltAndroidCompiler)

        implementation(AndroidLibraries.lifeCycleViewModel)
        implementation(AndroidLibraries.lifeCycleViewModel)
        implementation(AndroidLibraries.navigation)
        implementation(AndroidLibraries.navigationFrag)
        implementation(AndroidLibraries.lifecycleRuntime)

        implementation(project(Modules.common))
        implementation(project(Modules.data))
        implementation(project(Modules.domain))
    }
