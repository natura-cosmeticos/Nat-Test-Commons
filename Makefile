clean:
	./gradlew clean

lint:
	./gradlew ktlint

run-lint-rules:
	./gradlew ktlintFormat

publish-test-lib-prod: clean
	./gradlew build publish --stacktrace
