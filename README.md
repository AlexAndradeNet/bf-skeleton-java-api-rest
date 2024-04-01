# REST ASSURED API TESTING FOR THE STAR WARS DATABASE

This robot uses JSON Schema validations of Star Wars API database (Swapi) responses. This helps
detect any changes and assess their impact on other projects.

---

## ✏️ HOW TO CONTRIBUTE

See [CONTRIBUTE.md](CONTRIBUTE.md)

---

## 🧰 TECH STACK

### Requirements

* Java 17
* Maven
* Serenity BDD
* Cucumber
* RestAssured
* JUnit5
* NodeJS (optional)
* SonarQube (optional)

### IDE Plugins

* JUnit
* Cucumber-java
* Gherkin
* Maven
* Lombok
* Sonarlint (optional)

---

## 📗 DOCUMENTATION

PENDING.

---

## 🚀 EXECUTION

### Run all tests

```bash
mvn clean verify
```

### Run a specific test

You have two options. You can do it through the command line:

```bash
mvn clean verify -Dcucumber.options="--tags @tag"
```

You can do it through the IDE by opening the feature file and clicking on the play
button.

### Open the test report

After the execution with the command line, you can open the report in the
following
path [target/site/serenity/index.html](target/site/serenity/index.html).

---

## 🔧 TROUBLESHOOTING

If, during a commit, you get an error like this:

### Pre-commit hook failed

```
[ERROR] fatal: cannot run .git/hooks/pre-commit: No such file or directory
```

You can fix it by running the following commands:

```bash
mvn com.rudikershaw.gitbuildhook:git-build-hook-maven-plugin:install
chmod +x .git/hooks/pre-commit
```

---

## ✏️ SERENITY + SCREENPLAY PATTERN

**Want to learn more?** For more information about Serenity BDD, you can read
the [Serenity BDD Book](https://serenity-bdd.github.io/theserenitybook/latest/index.html),
the official online Serenity documentation source. Other sources include:

* [Byte-sized Serenity BDD](https://www.youtube.com/channel/UCav6-dPEUiLbnu-rgpy7_bw/featured)
  tips and tricks about Serenity BDD
* [Serenity BDD Blog](https://johnfergusonsmart.com/category/serenity-bdd/)
  regular articles
  about Serenity BDD
* [The Serenity Dojo](https://www.serenity-dojo.com) - Tailored BDD and Test
  Automation Training and Mentoring
