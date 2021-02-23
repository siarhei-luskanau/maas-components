# Contributing

The project is still in its early stages. We are not actively seeking external contributions
at this time, but some small contributions are welcome.

## iOS

### Build xcframework
1. `./gradlew xcframework`

## Android & Kotlin multiplatform

### Set up Android Studio
1. [Install Android Studio][install-as] version Arctic Fox (2020.3.1) Canary 7
1. [Install the Kotlin Multiplatform Mobile plugin][install-kmm-plugin]

### Launch sample apps
Add or edit the `local.properties` file to include the following properties:

```
trafi.apiBaseUrl=https\://YOUR-BASE-URL-HERE.trafi.com/
trafi.apiKey=YOUR-API-KEY-HERE
```

### Update Android screenshot tests
[Shot][shot] is used to test and record new screenshots. To update screenshots, run the
“Record Android screenshot tests” workflow, specifying the branch on which new / updated screenshots
should be generated and committed on.

You may want to record new screenshots or run the tests locally.

1. Start the emulator.
`~/Library/Android/sdk/emulator/emulator @Nexus_6_API_28 -no-window -gpu swiftshader_indirect -noaudio -no-boot-anim`
The used device currently should be set as Nexus 6 and architecture should be x86, otherwise generated screenshots will have minuscule differences compared to the ones generated by the GitHub workflow.
2. Record new / updated screenshots.
`./gradlew executeScreenshotTests -Precord`
3. Run screenshot tests to verify.
`./gradlew executeScreenshotTests`
4. Commit & push the new / updated screenshots.

## Other tools

### Run embedmd

[embedmd][embedmd] runs automatically on every pull request and helps keep code snippets in
documentation files up-to-date. You may want to run the tool locally.

1. [Install Go][install-go]
1. `go get github.com/campoy/embedmd`
1. `embedmd -w **/*.md`

[shot]: https://github.com/Karumi/Shot
[embedmd]: https://github.com/campoy/embedmd
[install-go]: https://golang.org/doc/install
[install-as]: https://developer.android.com/studio/preview
[install-kmm-plugin]: https://kotlinlang.org/docs/mobile/kmm-plugin-releases.html