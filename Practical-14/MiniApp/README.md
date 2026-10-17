# Student Management MiniApp

A Java console app for adding students, listing them, and showing the current student count.

## Requirements

- JDK 17 or newer
- Maven 3.9 or newer (or an IDE with Maven support)

Open this `MiniApp` folder as the Maven project in IntelliJ IDEA, Eclipse, or VS Code with the Java and Maven extensions. Production code is under `src/main/java`; the JUnit test is under `src/test/java`. Maven downloads JUnit 5 on the first build.

## Run the app

From this folder, compile and launch the console app:

```sh
mvn compile
java -cp target/classes Main
```

Alternatively, compile and run directly with the JDK, without Maven:

```sh
javac -d target/classes src/main/java/*.java
java -cp target/classes Main
```

## Run unit tests

```sh
mvn test
```

JUnit tests are in `src/test/java/StudentServiceTest.java`.
