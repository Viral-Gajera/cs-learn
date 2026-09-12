## React Native :

- React Native is a popular framework for building mobile applications using JavaScript and **React**.
- It allows developers to build native mobile apps for iOS and Android platforms using a single codebase.
- React Native is an open-source framework developed by Facebook.

## Installation :

- Install Node.js and npm (Node Package Manager) on your computer and use following commands
    
    ```Plain
    npx react-native init app-name
    cd app-name
    
    npx react-native run-android
    npx react-native start
    npx react-native start --reset-cache
    ```
    
- [NativeWind](https://www.nativewind.dev/quick-starts/react-native-cli)
    
    ```Plain
    npm i tailwindcss
    npm i nativewind
    npx tailwindcss init
    ```
    

## Build APK (Generate .apk):

- [Guide](https://reactnative.dev/docs/signed-apk-android)
    
    ```Plain
    cd android
    ./gradlew assembleRelease
    
    or
    
    ./gradlew app:assembleRelease
    ```
    
- Location of .apk file will be, `android/app/build/output/apk`.

## Example :

- The syntax of React Native is very similar to React.
- Components are the building blocks of React Native applications.
- Components are reusable and can be customized to suit the needs of your application.
- Here's an example of a simple component in React Native:
    
    ```JavaScript
    import React from 'react';
    import { View, Text } from 'react-native';
    
    function MyComponent {
        return (
          <View>
            <Text>Hello, World!</Text>
          </View>
        );
    }
    
    export default MyComponent;
    ```
    
- `<Text></Text>` - Component to display text
- `<View></View>` - Component which act as `<div>`

## Function and Class Components :

- With React, you can make components using either classes or functions.
- Originally, class components were the only components that could have state. But since the introduction of React's Hooks API, you can add state and more to function components.
    
    ```Plain
    // Function components
    function MyComponent(){
        // body
    }
    ```
    
    ```Plain
    // class components
    class MyComponent extends React.Components
     {
     // body
     }
    ```
    

## Life Cycle methods :

```Plain
constructor()

getDerivedStateFromProps()
ShouldComponentUpdate()

rendor()

getSnapShotBeforeUpdate()

componentDidMound()
componentDidUpdate()
componentWillUnmount()
```