clean:
	./gradlew clean

lint:
	./gradlew ktlint

run-lint-rules:
	./gradlew ktlintFormat

documentation:
	./gradlew dokka

publish-test-lib-prod: clean
	./gradlew build publish --stacktrace
