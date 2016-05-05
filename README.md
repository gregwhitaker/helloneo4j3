helloneo4j3
===

__description__

##API

The API contract for this service uses the Swagger specification and can be found in the [swagger.yml](swagger.yml) file
at the root of this project.

##Versioning

This service uses [Semantic Versioning](http://semver.org).  For detailed information on changes related to a specific
version of the service please refer to the [Change Log](CHANGELOG.md).

##Building the Service

This project supports building the service as a standalone JAR and as a Docker container.

###Jar

The service can be built as a standalone JAR using the following command:

    $ ./gradlew clean build

###Docker Container

The service can be built as a Docker container using the following command:

    $ ./gradlew clean buildDocker

##Running the Service

The service can be ran locally using the supplied run script:

    $ ./run.sh
    
If you wish to debug the service locally you can run the service using the supplied debug script:

    $ ./debug.sh
