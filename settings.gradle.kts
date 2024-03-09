pluginManagement {
    repositories {
        maven(uri("https://maven.aliyun.com/repository/central"))
        maven(uri("https://maven.aliyun.com/repository/public"))
        maven(uri("https://maven.aliyun.com/repository/gradle-plugin"))
        maven(uri("https://maven.aliyun.com/repository/google"))
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven(uri("https://maven.aliyun.com/repository/central"))
        maven(uri("https://maven.aliyun.com/repository/public"))
        maven(uri("https://maven.aliyun.com/repository/gradle-plugin"))
        maven(uri("https://maven.aliyun.com/repository/google"))
        google()
        mavenCentral()
        maven(uri("https://jitpack.io"))
    }
}

rootProject.name = "clipboard_tool"
include(":app")
 