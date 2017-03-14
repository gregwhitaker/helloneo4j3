# Blueprint SpringBoot Reactive Rest Template
This project provides you with a starting point for developing reactive restful web services.

## What does this template provide?

* Standard SpringBoot deployment as a JAR or a Docker container
* Standard error handling, messages, and error codes
* Standard application health check
* Built-in support for service discovery via Netflix's Eureka
* Built-in support for HATEOAS
* Standard support for metrics delivery to DataDog

## FAQ
The following are frequently asked questions about the usage of the template as well as building and deploying Blueprint template applications.

### Build and Deploy

* **How do I change the version of my service?**
  
    You can change the version of your service by changing the value of the `version` property in the [gradle.properties](gradle.properties) file.


* **My service keeps building with a SNAPSHOT version.  How do I build a release version?**

	The template is designed to build SNAPSHOT versions of your service by default.  When you are ready to build a release version you must supply the `releaseType` parameter to Gradle.
	
		$ ./gradlew clean build -PreleaseType=release
