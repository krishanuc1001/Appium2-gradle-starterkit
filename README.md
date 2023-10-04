# Appium (v2.x.x) Starter-kit for Android and iOS

## About

- This framework provides a basic implementation for Appium based Android/ iOS tests using the latest Appium Client v8.x.x and Server 2.x.x
- This could be used as the initial starter-kit to evolve into a full-fledged framework
- Multiple stand-alone test examples have been added to understand different functionalities

## Framework components/ layers

<img width="355" alt="image" src="https://github.com/krishanuc1001/Appium2-gradle-starterkit/assets/40739038/951d5a33-c014-478e-a7f8-e868ecdc1d70">

### Component functions:

**Tests**
* Tests defining the user actions based on business workflow
* Assertions based on the expected outcomes

**Tasks**
* Combining multiple actions to workflow
* Tests should use tasks
* Return type for assertion

An intermediate layer to combine multiple page interactions in a user-flow. 
These can be modularized to have re-usability across the tasks. 
If a single page has multiple workflows then we should create page-wise tasks else we should try and combine them to define it as user actions.

**Pages**
* Locators to identify the elements
* Methods to interact with Elements on page

## Set-up steps on Mac

- Install Homebrew

```zsh
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)”
```

Check brew version:
```zsh
brew --version
```

- Install Android Studio

[https://developer.android.com/codelabs/basic-android-kotlin-compose-install-android-studio#4](https://developer.android.com/codelabs/basic-android-kotlin-compose-install-android-studio#4)

- Install node and npm

```zsh
brew install node
```


Check node version:

```zsh   
node -v
```

Check npm version:

```zsh
npm -v
```

Install ```appium-installer```:

```zsh
npm install -g appium-installer
```

Run ```appium-installer``` to
- set-up Android and iOS environments
- install Appium server
- install Appium driver
- install Appium plugins
- run Appium doctor
- launch Emulators/ Simulators

```zsh
appium-installer
```

## Run tests

- Use ```testng.xml``` to run a suite of tests or a single test

or

- Using gradle:
```zsh
./gradlew clean test -Pgroups=dragDrop --info
```


