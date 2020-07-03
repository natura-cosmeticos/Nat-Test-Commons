# Nat Test Commons Android

### What for
Library with helper functions designed to speed up the test-creating process.

### Setup
Copy and paste the file **github_credentials.properties.sample** and rename it to **github_credentials.properties**. Updating the fields **github.username** and **github.password**. For getting your GitHub password see the [Tutorial](https://help.github.com/en/github/authenticating-to-github/creating-a-personal-access-token-for-the-command-line). Its important to check **read:packages** and when generating you password.

**Important:** The file **github_credentials.properties** can not be committed.

### Documentation
Example usages can be found as comments on top of every class and function. For a complete report with all functions run the following command:

    make documentation

The report will be available at `testcommons/build/dokka/testcommons/index.html`

## How to contribute
You can contribute submitting [pull requests](https://github.com/natura-cosmeticos/Nat-Test-Commons/pulls).

### How to create a new version
In the file **publish.gradle** update field in the method **getVersionName** with the new version number. Example, for the version 1.0.1:

    def getVersionName = { ->
        return "1.0.1"
    }

## How to use
Copy and paste the file **github_credentials.properties.sample** and rename it to **github_credentials.properties**. Updating the fields **github.username** and **github.password**. For getting your GitHub password see the [Tutorial](https://help.github.com/en/github/authenticating-to-github/creating-a-personal-access-token-for-the-command-line). Its important to check **read:packages** when generating you password.
In the file build.gradle, insert the informations:

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
        androidTestImplementation "com.natura.android:test-commons:<version>"
        testImplementation "com.natura.android:test-commons:<version>"    
    }
