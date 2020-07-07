clean:
	./gradlew clean

build:
	./gradlew build

lint:
	./gradlew ktlint

run-lint-rules:
	./gradlew ktlintFormat

documentation:
	./gradlew dokka

publish-test-lib-prod: clean build
	./gradlew publish --stacktrace
