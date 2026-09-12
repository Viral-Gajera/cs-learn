## Props :

- Props are used to pass data from a parent component to its child component. Props are read-only and cannot be changed within the child component.
- Here's an example of how to pass props in React Native :
    
    > MyComponent.js
    
    ```JavaScript
    import React, { Component } from 'react';
    import { View, Text } from 'react-native';
    
    class MyComponent extends Component {
      render() {
        return (
          <View>
            <Text>{this.props.message}</Text>
          </View>
        );
      }
    }
    
    export default MyComponent;
    ```
    
    > App.js
    
    ```JavaScript
    import React, { Component } from 'react';
    import MyComponent from './MyComponent';
    
    class App extends Component {
      render() {
        return (
          <MyComponent message="Hello, World!" />
        );
      }
    }
    
    export default App;
    ```
    

  

## State :

- State is used to manage the internal state of a component.
- State is mutable and can be changed within the component. Here's an example of how to use state in React Native:
    
    ```JavaScript
    import React, { Component } from 'react';
    import { View, Text, Button } from 'react-native';
    
    class MyComponent extends Component {
    
        constructor(){
            super();
            this.state = {
                message: 'Hello, World!'
              };
        }
    
          handlePress = () => {
            this.setState( { message: 'Hello, React Native!' } );
          };
    
      render() {
        return (
          <View>
            <Text>{this.state.message}</Text>
            <Button title="Change Message" onPress={this.handlePress} />
          </View>
        );
      }
    }
    
    export default MyComponent;
    ```
    
- `<button></button>` - Component

## Styling Components

- In React Native, components can be styled using **JavaScript**.
- There are several ways to style components in React Native, including inline styles, stylesheets, and CSS-in-JS libraries.

### Inline Style :

- Inline styles allow you to apply styles directly to a component.
- Inline styles are applied as an object in the `style` prop of a component.
- Here's an example of how to use inline styles in React Native:
    
    ```JavaScript
    import React, { Component } from 'react';
    import { View, Text } from 'react-native';
    
    class MyComponent extends Component {
      render() {
        return (
          <View style={ {backgroundColor: '\#F5FCFF'} }>
            <Text style={ {fontSize: 20, textAlign: 'center'} }>
              Hello, World!
            </Text>
          </View>
        );
      }
    }
    
    export default MyComponent;
    ```
    

### Style with Stylesheets :

- Stylesheets are another way to style components in React Native.
- Stylesheets allow you to define styles in a separate file and reuse them throughout your application.
- Here's an example of how to use stylesheets in React Native:
    
    ```JavaScript
    // styles.js
    import { StyleSheet } from 'react-native';
    
    export default StyleSheet.create({
      container: {
        backgroundColor: '\#F5FCFF'
      },
      text: {
        fontSize: 20,
        textAlign: 'center'
      }
    });
    ```
    
    ```JavaScript
    // MyComponent.js
    import React, { Component } from 'react';
    import { View, Text } from 'react-native';
    import styles from './styles';
    
    class MyComponent extends Component {
      render() {
        return (
          <View style={styles.container}>
            <Text style={styles.text}>Hello, World!</Text>
          </View>
        );
      }
    }
    
    export default MyComponent;
    ```
    
- Or we can write style in same file
    
    ```JavaScript
    import { StyleSheet } from 'react-native';
    
    const myStyle = StyleSheet.create({
        heading : {
            fontSize : 30,
            colot : 'red'
        },
        container : {
            width : '80%'
        }
    });
    
    function MyComponent(){
        return (
            <View style={ myStyle.heading } >
                // code
            </View>
    
            // multiple
            <View style={ [myStyle.heading, myStyle.container] }>
                // code
            </View>
        )
    }
    ```
    

### Style with nativewind

- Install `tailwindcss` and `nativewind` packages and initialize it.
    
    ```JavaScript
    function MyComponent() {
        return (
            <View className="bg-primary w-[100%] h-[100%] flex justify-center items-center">
                <View>
                    <Image
                        className="w-[250px] h-[100px]"
                        resizeMode="stretch"
                        source={require('./images/logo-4.png')}
                    />
                    <Text
                        className="relative top-[-42px] left-[85px] text-xl font-bold text-white"
                    >
                        Glucose Monitor
                    </Text>
                </View>
            </View>
        );
    }
    ```