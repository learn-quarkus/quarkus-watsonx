# quarkus-watsonx

A sample application to work with Watson X

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-watsonx-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Provided Code

### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)





# DIY

## Setup Quarkus project
* quarkus create app quarkus-watsonx
```
[SUCCESS] ✅  quarkus project has been successfully generated in:
--> /Users/jbaskara/Documents/GitHub/learn-quarkus/quarkus-watsonx
```
* quarkus ext add quarkus-langchain4j-watsonx
```
[SUCCESS] ✅  Platform io.quarkus.platform:quarkus-langchain4j-bom has been installed
[SUCCESS] ✅  Extension io.quarkiverse.langchain4j:quarkus-langchain4j-watsonx has been installed
```

* Edit `application.properties` file to add the necessary config
```
# IBM watsonx settings
quarkus.langchain4j.watsonx.base-url=${BASE_URL}
quarkus.langchain4j.watsonx.api-key=${API_KEY}
quarkus.langchain4j.watsonx.project-id=${PROJECT_ID}
quarkus.langchain4j.watsonx.generation-model.model-name=ibm-granite/granite-4.0-h-small
quarkus.langchain4j.watsonx.mode=generation
```

## Create account with WatsonX Trial

* Signup for a 30 days free trial
* Under `Developer access` select the Project ID
*  Make a note of the  Project ID and BASE URL
* Create API Key and make a note of it


## Setup following environment variable

```
export BASE_URL=<get from watsonx>
export API_KEY=<get from watsonx>
export PROJECT_ID=<get from watsonx>
```
## Run the app

* Run Quarkus
```
quakus dev
```

.Output
```

2025-10-24 08:49:15,560 INFO  [io.quarkus] (Quarkus Main Thread) quarkus-watsonx 1.0.0-SNAPSHOT on JVM (powered by Quarkus 3.28.5) started in 1.049s. Listening on: http://localhost:8080

2025-10-24 08:49:15,561 INFO  [io.quarkus] (Quarkus Main Thread) Profile dev activated. Live Coding activated.
2025-10-24 08:49:15,562 INFO  [io.quarkus] (Quarkus Main Thread) Installed features: [cdi, langchain4j, langchain4j-watsonx, qute, rest, rest-client, rest-client-jackson, rest-client-jaxb, smallrye-context-propagation, vertx]
```

* Access http://localhost:8080/hello. You would see `Hello from Quarkus REST` on the browser window.

## Setup Watson X

* Create new `GreetingAssistant.java` class
    * `@RegisterAiService` annotation provide a declarative mechanism for interacting with LLMs, abstracting complexities behind annotated interfaces
