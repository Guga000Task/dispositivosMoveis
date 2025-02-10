pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "TabelaTaco"
include(":app")
include( ":paint")
include( ":listagemdados")
include( ":listagem-nomes")
include( ":launcher")
include( ":sqliteex")
include( ":sensores")
include( ":tabelanutricional")