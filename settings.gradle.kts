@file:Suppress("UnstableApiUsage")

dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
  }
}

rootProject.name = "lol-training-app"

include(":app")

include(":core")
