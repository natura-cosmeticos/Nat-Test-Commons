# Nat Test Commons Android

![release](https://img.shields.io/github/v/tag/natura-cosmeticos/Nat-Test-Commons?color=F4AB34&style=for-the-badge)

### What for
Library with helper functions designed to speed up the test-creating process.

### Documentation
Example usages can be found in [our Wiki](https://github.com/natura-cosmeticos/Nat-Test-Commons/wiki). If you want to generate the documentation on your own run the following command:

    make documentation

The Markdown files will be available at `$BUILD_DIR/dokka/testcommons/`

## How to contribute
You can contribute submitting [pull requests](https://github.com/natura-cosmeticos/Nat-Test-Commons/pulls).

**Pull Request Best Practices**
- If your Pull Request adds a new behavior or changes an existing one, you must update the documentation, following the instructions [here](#documentation).
- If your change needs to generate a new release of this library, change the version as described in the session [below](#how-to-create-a-new-version).

### How to create a new version
In the file **publish.gradle** update field in the method **getVersionName** with the new version number. Example, for the version 1.0.1:

    def getVersionName = { ->
        return "1.0.1"
    }

## How to use

Copy and paste the **github_credentials.properties.sample** file and rename it to **github_credentials.properties**. Updating the fields **github.username** and **github.password**. For getting your GitHub password see the [Tutorial](https://help.github.com/en/github/authenticating-to-github/creating-a-personal-access-token-for-the-command-line). Its important to check **read:packages** when generating you password.

**Important:** The **github_credentials.properties** file can not be committed.

In the build.gradle file, insert the following:

    repositories {
        maven {
            name = "nat-test-commons"
            url = uri("https://maven.pkg.github.com/natura-cosmeticos/Nat-Test-Commons")
            credentials {
                username = githubProperties['github.username'] ?: System.getenv("GITHUB_USERNAME")
                password = githubProperties['github.password'] ?: System.getenv("GITHUB_API_KEY")
            }
        }    
    }

And:

    dependencies {
        androidTestImplementation "com.natura.android:testcommons:<version>"
        testImplementation "com.natura.android:testcommons:<version>"    
    }
