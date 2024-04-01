# HOW TO CONTRIBUTE

How to contribute to this repo.

---

## 🏆 DEVELOPER GOOD PRACTICES

Code is communication. We need to write code that is easy to read and
understand. For that reason, we need to follow some good practices:

1. Small commits: Keep It So Simple (KISS).
   Read [“The Power of Small Commits.”](https://levelup.gitconnected.com/the-power-of-working-in-small-commits-8bae57ecfbda)
2. Use [GitMoji](https://gitmoji.dev/)  to add emojis to our commit messages and
   make it easier to identify the purpose or intention of a commit.
3. Submit a PR with one solution at a time. If you need to refactor, do it in
   another PR.
4. Unit tests are part of the Definition of Done in Agile practices. It doesn't
   matter if you write them first (as in Test-Driven Development or TDD) or before the final commit.
5. Run the linters.
6. Run a SonarQube analysis and fix its recommendations before posting a PR.
7. Use TDD for bugs: write a unit test to reproduce the actual behavior (red),
   modify that unit test to reflect the expected behavior (green), then refactor
   the code to solve the bug and meet the unit test (blue).

---

## 📝 Git workflow

### Branches

⚠️ You never push directly to the `main` and `develop` branches. You must create
a new branch and ask for a PR.

Follow this naming convention for branches:

* `main`: the main branch. It contains the latest release.
* `develop`: the development branch. It includes the latest development version.
* `feature/xxx`: a feature branch. It consists of a new feature.
* `bugfix/xxx`: a bugfix branch. It contains a bug fix.
* `hotfix/xxx`: a hotfix branch. It consists of a hotfix.
* `docs/xxx`: a documentation branch. It consists of a documentation change.
* `refactor/xxx`: a refactoring branch. It consists of a refactoring change.
* `test/xxx`: a test branch. It consists of a test change.
* `ci/xxx`: a CI branch. It consists of a CI change.

#### Commit messages

* Use [GitMoji](https://gitmoji.dev/)  to add emojis to our commit messages and
  make it easier to identify the purpose or intention of a commit.
* Use the imperative, present tense: "change," not "changed," nor "changes".
* Use the imperative, present tense: "fix," not "fixed" nor "fixes".
* Use the imperative, present tense: "add," not "added," nor "adds".
* Use the imperative, present tense: "remove," not "removed," nor "removes".

#### Pull requests

* Use the imperative, present tense: "change," not "changed," nor "changes".
* Use the imperative, present tense: "fix," not "fixed" nor "fixes".
* Use the imperative, present tense: "add," not "added," nor "adds".
* Use the imperative, present tense: "remove," not "removed," nor "removes".

---

## 👩‍💻 DEVELOPMENT

### Unit tests

To run the unit tests, execute the following command:

```bash
mvn clean verify
```

You can see the coverage report in **SonarQube** (the best option) or the file
`target/site/jacoco/index.html`

### Mutant tests

To run the mutant tests, execute the following command:

```bash
mvn clean test pitest:mutationCoverage 
```

It will take a while (3+ minutes), but you can see the report in the
file `target/pit-reports/index.html`

### Run code-style linters

Linting the code is vital to keep the code clean and readable. It is
essential to keep in mind that:

> The ratio of time spent reading versus writing is over 10 to 1. We are
> constantly reading old code as part of the effort to write new code. …making
> it easy to read makes it easier to write.

_Robert C. Martin (a.k.a Uncle Bob)_

To run the linter for Java, execute the following command:

````bash
mvn spotless:apply
````

If your project has Gherkin files, you also can run the checker for Gherkin:

```bash
sh ./scripts/gherkin-lint.sh
```

### Run static code analysis

It is a good practice to run static code analysis tools to detect possible bugs
or code smells before asking for merge permission (post a PR). You can run the
following command to run the analysis:

```bash
mvn clean verify sonar:sonar
```

The report will be located at http://localhost:9000

You need to have the SonarQube server running locally or in your Docker.
To run SonarQube in Docker, execute the following command:

```bash
docker compose -f scripts/sonarqube/docker-compose.yml up -d
```

SonarQube initial
setup [instructions here](https://blankfactor.atlassian.net/wiki/spaces/QA/pages/919502861/SonarQube).
