import java.io.FileInputStream
import java.util.*

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    id("maven-publish")
}
repositories {
    jcenter()
}

android {
    compileSdkVersion(29)
    defaultConfig {
        minSdkVersion(23)
        targetSdkVersion(29)
        versionCode = 1
        versionName = getVersionName()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

}


/**Create github.properties in root project folder file with gpr.usr=GITHUB_USER_ID  & gpr.key=PERSONAL_ACCESS_TOKEN**/
val githubProperties = Properties()
githubProperties.load(FileInputStream(rootProject.file("github.properties")))

fun getVersionName(): String {
    return "1.0.7" // Replace with version Name
}

fun getArtificatId(): String {
    return "sampleandroidlib2" // Replace with library name ID
}

publishing {
    publications {
        create<MavenPublication>("gpr") {
            run {
                groupId = "com.enefce.libraries"
                artifactId = getArtificatId()
                version = getVersionName()
                artifact("$buildDir/outputs/aar/${getArtificatId()}-debug.aar")
            }
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            /** Configure path of your package repository on Github
             *  Replace GITHUB_USERID with your/organisation Github userID and REPOSITORY with the repository name on GitHub
             */
            url = uri("https://maven.pkg.github.com/AndroidPharos/Utility-Android")
            credentials {
                /**Create github.properties in root project folder file with gpr.usr=GITHUB_USER_ID  & gpr.key=PERSONAL_ACCESS_TOKEN
                 * OR
                 * Set environment variables
                 */
                username = "ramyfarah"
                password = "8dae8439da01333aa092ca222e09eea961aa6daa"

            }
        }
    }
}


dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.61")
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.core:core-ktx:1.1.0")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}
