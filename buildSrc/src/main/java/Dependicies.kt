object Versions {
    const val core = "1.9.0"
    const val appcompat = "1.5.1"
    const val androidMaterial = "1.6.1"
    const val constraintLayout = "2.1.4"

    const val testImplJunit = "4.13.2"
    const val androidTestImplJunit = "1.1.3"
    const val androidTestEspresso = "3.4.0"

    const val retrofit = "2.9.0"
    const val gsonConvertor = "2.9.0"
    const val okHttp = "4.9.0"
    const val scalerConvertor = "2.1.0"

    const val kotlinCoroutines = "1.6.1"

    const val coroutineLifecycleScope = "2.5.1"

    const val glide = "4.12.0"

    const val viewModelDeligate = "1.6.0"

    const val dagger = "2.44"
    const val hiltCompiler = "1.0.0"

    const val roomVersion = "2.4.3"

    const val swipeRefresh = "1.1.0"

    const val lottieAnimations = "3.4.2"
    const val kotlin = "1.3.21"
    const val gradle = "3.3.2"
    const val retrofitCoroutines = "0.9.2"
    const val retrofitGson = "2.9.0"
    const val gson = "2.8.8"
    const val coroutines = "1.6.0"
    const val koin = "1.0.2"
    const val timber = "4.7.1"
    const val lifecycle = "2.4.0"
    const val nav = "2.5.3"
    const val room = "2.5.0"
    const val safeArgs = "2.4.2"
    const val fragmentTest = "1.1.0-alpha06"
    const val hilt = "2.44"

}

object Deps {

    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val androidMaterial = "com.google.android.material:material:${Versions.androidMaterial}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

}
object Modules{
    const val app = ":app"
    const val common = ":common"
    const val domain = ":domain"
    const val data = ":data"
    const val feature = ":presentation"
    const val navigation= ":navigation"
}

object TestImplementation {

    const val junit = "junit:junit:${Versions.testImplJunit}"
}

object AndroidTestImplementation {

    const val junit = "androidx.test.ext:junit:${Versions.androidTestImplJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.androidTestEspresso}"

}


object Retrofit {
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}"
}

object Coroutines {
    const val coroutineCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
    const val coroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
}

object CoroutinesLifecycleScope {
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.coroutineLifecycleScope}"
    const val lifeCycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.coroutineLifecycleScope}"
}

object Glide {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val annotationProcessor = "com.github.bumptech.glide:compiler:${Versions.glide}"
}

object ViewModelDelegate {
    const val viewModelDeligate = "androidx.activity:activity-ktx:${Versions.viewModelDeligate}"
}

object DaggerHilt {
    const val hilt = "com.google.dagger:hilt-android:${Versions.dagger}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.dagger}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"
}

object Room {
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val room = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val roomRuntime="androidx.room:room-runtime:${Versions.roomVersion}"
}

object CircularProgressBar {
    const val swipeRefresh =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefresh}"
}

object LottieAnimations {
    const val lottieAnimations = "com.airbnb.android:lottie:${Versions.lottieAnimations}"
}

object AndroidLibraries {
    // KOTLIN
    val kotlinCoroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    // ANDROID
    val lifeCycleViewModel = "androidx.lifecycle:lifecycle-viewmodel:${Versions.lifecycle}"
    val lifecycleViewModelExt = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    val navigation = "androidx.navigation:navigation-ui-ktx:${Versions.nav}"
    val navigationFrag = "androidx.navigation:navigation-fragment-ktx:${Versions.nav}"
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"

    val livedata= "androidx.lifecycle:lifecycle-livedata-ktx:2.6.0"
    val viewmodel ="androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.0"

}
object KotlinLibraries {
    val kotlinCoroutineCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
}

object Libraries {
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}"
    val daggerHilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    val daggerHiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
}

object BuildPlugins {
    //All the build plugins are added here
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinJetBrains = "org.jetbrains.kotlin.android"
    const val kotlinKapt = "kotlin-kapt"
    const val Hilt = "com.google.dagger.hilt.android"
    const val DaggerHiltPlugin = "dagger.hilt.android.plugin"
    const val NavSafeArgs = "androidx.navigation.safeargs"
    const val NavSafeArgsKt = "androidx.navigation.safeargs.kotlin"
    const val AndroidLibrary = "com.android.library"
    const val ktlint = "org.jlleitschuh.gradle.ktlint"
    const val kotlinJvm = "org.jetbrains.kotlin.jvm"
}
