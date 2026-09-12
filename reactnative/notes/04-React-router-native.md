## React-router-native

- To install `react-router-native`, you can use npm or yarn:
    
    ```Plain
    npm install react-router-native
    ```
  

### Example :

- Here is an example of how to use `react-router-native` in a React Native app that includes the components Like `NativeRouter`, `Routes`, `Route`, and `Link`.
    
    ```JavaScript
    import React from 'react';
    import { View, Text, TouchableOpacity } from 'react-native';
    import { NativeRouter, Routes, Route, Link } from 'react-router-native';
    
    const Home = () => (
      <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
        <Text>Home</Text>
      </View>
    );
    
    const About = () => (
      <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
        <Text>About</Text>
      </View>
    );
    
    const App = () => (
    	<NativeRouter>
    		<View style={{ flex: 1 }}>
    			<View style={{ flexDirection: 'row', justifyContent: 'space-around' }}>
    				<Link to="/">
    					<Text>Home</Text>
    				</Link>
            		<Link to="/about">
              			<Text>About</Text>
            		</Link>
          		</View>
          		<Routes>
            		<Route path="/" element={<Home />} />
            		<Route path="/about" element={<About />} />
          		</Routes>
        	</View>
    	</NativeRouter>
    );
    
    export default App;
    ```
    
- In this example, we have two components `Home` and `About` that are being rendered based on the current URL. The `NativeRouter` component acts as the parent component that holds the routing logic.
- The `Routes` component contains the `Route` components, which define the different paths in your application and the components that should be rendered for each path.
- The `Link` component is used to navigate between different routes in your app. Link component also have`style` attribute to apply stying to it.

  

## Styling Link Component

- To apply a click style to a `Link` component in `react-router-native`, you can wrap the `Link` component in a `TouchableOpacity` component and add styles to it. \
- Here's an example:
    
    ```JavaScript
    import React from 'react';
    import { Link } from 'react-router-native';
    import { View, Text, TouchableOpacity, StyleSheet } from 'react-native';
    
    function MyLink() {
      return (
        <TouchableOpacity onPress={() => {}}>
          <Link to="/some/route" style={styles.link}>
            <Text style={styles.text}>Go to Some Route</Text>
          </Link>
        </TouchableOpacity>
      );
    }
    
    const styles = StyleSheet.create({
      link: {
        backgroundColor: 'lightgray',
        padding: 10,
      },
      text: {
        fontWeight: 'bold',
        color: 'black',
      },
    });
    
    export default MyLink;
    ```
    
- To apply a click style to a `Link` component in `react-router-native`, you can wrap the `Link` component in a `TouchableOpacity` component and add styles to it. Here's an example:
    
    ```Plain
    javascriptCopy codeimport React from 'react';
    import { Link } from 'react-router-native';
    import { View, Text, TouchableOpacity, StyleSheet } from 'react-native';
    
    function MyLink() {
      return (
        <TouchableOpacity onPress={() => {}}>
          <Link to="/some/route" style={styles.link}>
            <Text style={styles.text}>Go to Some Route</Text>
          </Link>
        </TouchableOpacity>
      );
    }
    
    const styles = StyleSheet.create({
      link: {
        backgroundColor: 'lightgray',
        padding: 10,
      },
      text: {
        fontWeight: 'bold',
        color: 'black',
      },
    });
    
    export default MyLink;
    ```
    
    In this example, the `Link` component is wrapped in a `TouchableOpacity` component to allow it to be pressable.
    
    The `onPress` prop is used to handle the press event, but it can be left blank for now. Styles are then applied to the `TouchableOpacity` and `Text` components to create the desired click style. You can modify the styles as needed for your specific use case.