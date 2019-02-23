object Deps {
    private val kotlin_version = "1.3.21"
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"

    val appcompat = "androidx.appcompat:appcompat:1.0.0"
    val material = "com.google.android.material:material:1.0.0"
    val constraintlayout = "androidx.constraintlayout:constraintlayout:1.1.3"
    val core_ktx = "androidx.core:core-ktx:1.0.0"

    private val nav_version = "1.0.0-beta01"
    val navigation_fragment = "android.arch.navigation:navigation-fragment:$nav_version"
    val navigation_fragment_ktx = "android.arch.navigation:navigation-fragment-ktx:$nav_version"
    val navigation_ui = "android.arch.navigation:navigation-ui:$nav_version"
    val navigation_ui_ktx = "android.arch.navigation:navigation-ui-ktx:$nav_version"

    private val room_version = "2.1.0-alpha01"
    val room_rxjava = "androidx.room:room-rxjava2:$room_version"
    val room_runtime = "androidx.room:room-runtime:$room_version"
    val room_compiler = "androidx.room:room-compiler:$room_version"

    val retrofit = "com.squareup.retrofit2:retrofit:2.4.0"
    val retrofit_gson = "com.squareup.retrofit2:converter-gson:2.4.0"
    val retrofit_rxjava = "com.squareup.retrofit2:adapter-rxjava2:2.4.0"

    private val dagger_version = "2.18"
    val dagger_android = "com.google.dagger:dagger-android:$dagger_version"
    val dagger_android_support = "com.google.dagger:dagger-android-support:$dagger_version"
    val dagger_android_processor = "com.google.dagger:dagger-android-processor:$dagger_version"
    val dagger_compiler = "com.google.dagger:dagger-compiler:$dagger_version"

    val assisted_inject = "com.squareup.inject:assisted-inject-annotations-dagger2:0.3.2"
    val assisted_inject_processor = "com.squareup.inject:assisted-inject-processor-dagger2:0.3.2"

    val javax_inject = "javax.inject:javax.inject:1"

    private val groupie_version = "2.1.0"
    val groupie = "com.xwray:groupie:$groupie_version"
    val groupie_ext = "com.xwray:groupie-kotlin-android-extensions:$groupie_version"
    val groupie_databinding = "com.xwray:groupie-databinding:$groupie_version"

    val rxjava = "io.reactivex.rxjava2:rxjava:2.2.3"
    val rxkotlin = "io.reactivex.rxjava2:rxkotlin:2.3.0"
    val rxandroid = "io.reactivex.rxjava2:rxandroid:2.1.0"

    val gson = "com.google.code.gson:gson:2.8.5"

    val joda_time = "joda-time:joda-time:2.10"
}
