clean:
	./gradlew clean

lint:
	./gradlew ktlint

run-lint-rules:
	./gradlew ktlintFormat

unit-test:
	./gradlew sample:test --parallel

instrumentation-test: clean disable-animations
	./gradlew connectedAndroidTest

disable-animations:
	adb shell settings put global window_animation_scale 0
	adb shell settings put global transition_animation_scale 0
	adb shell settings put global animator_duration_scale 0

enable-animations:
	adb shell settings put global window_animation_scale 1
	adb shell settings put global transition_animation_scale 1
	adb shell settings put global animator_duration_scale 1

publish-test-lib-prod: clean
	./gradlew build publish --stacktrace

run-all-sanitycheck-steps: lint unit-test instrumentation-test
