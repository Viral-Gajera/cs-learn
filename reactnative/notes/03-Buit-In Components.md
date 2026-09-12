## Buit-In Components :

- React Native provides a number of built-in components that you can use to build your user interface.
- Here are some of the most commonly used components and their common attributes:

### 1. View

- This is a basic container component that can hold other components and layout elements.
- Attributes :
    
    ```Plain
    style
    key
    accessible
    ```
    
- Syntax :
    
    ```JavaScript
    <View style={styles.container} key="view-1" accessible>
      {/* Your components and layout elements */}
    </View>
    ```
    

### 2. Text

- This is a basic text component for displaying text in your user interface.
- Attributes :
    
    ```Plain
    style
    key
    accessibilityLabel
    ```
    
- Syntax :
    
    ```Plain
    <Text style={styles.text} key="text-1" accessibilityLabel="Welcome to React Native">
      Welcome to React Native
    </Text>
    ```
    

### 3. Image

- This is a component for displaying images in your user interface.
- Attributes :
    
    ```Plain
    style
    key
    source
    resizeModel
    ```
    
- Syntax:
    
    ```JavaScript
    <Image
      style={styles.image}
      key="image-1"
      source={require('./images/logo.png')}
      resizeMode="contain"
    />
    ```
    

### 4. Button

- This is a component for creating buttons in your user interface.
- Attributes :
    
    ```Plain
    title
    onPress
    color
    ```
    
- Syntax :
    
    ```JavaScript
    <Button
      title="Submit"
      onPress={() => {
        // Your button press logic
      }}
      color="\#841584"
    />
    ```
    

### 5. TextInput

- This is a component for creating text inputs in your user interface.
- Attributes :
    
    ```Plain
    style={}
    value=""
    placeholder=""
    placeholderTextColor=""
    selectionColor=""
    onChangeText={fn}
    minLength={5}
    maxLength={10}
    keyboardType={"numeric"|""}
    secureTextEntry={true|false}
    ```
    
- Syntax :
    
    ```JavaScript
    <TextInput
      style={styles.input}
      value={this.state.value}
      onChangeText={(value) => this.setState({ value })}
      placeholder="Enter your name"
    />
    ```
    

### 6. ScrollView

- The `ScrollView` component is a container component that can hold a scrollable list of elements.
- Attribute :
    
    ```Plain
    style={}
    horizontal={true|false}
    contentContainerStyle
    scrollEnabled
    showsVerticalScrollIndicator
    onScroll
    ```
    
- Syntax :
    
    ```JavaScript
    <ScrollView
     style={styles.scrollView}
     contentContainerStyle={styles.scrollViewContentContainer}
     scrollEnabled={this.state.scrollEnabled}
     showsVerticalScrollIndicator={this.state.showScrollIndicator}
     onScroll={(event) => {
       // Handle scroll event
     }}
    >
     {/* Your scrollable content */}
    </ScrollView>
    ```
    

### 7. Pressable

- A "Pressable" React Native component is a built-in component that allows users to interact with it by pressing or touching it.
- [ `active:` psudo class of nativewind works on this ]
- Attribute :
    
    ```Plain
    style={}
    onPress
    onLongPress
    accessibilityLabel
    disabled
    android_disableSound
    ```
    
- Syntax :
    
    ```JavaScript
    import { Pressable, Text } from 'react-native';
    
    function ExampleComponent() {
      const onPressFunction = () => {
        console.log('The Pressable component was pressed!');
      };
    
      return (
        <Pressable onPress={onPressFunction} style={{ backgroundColor: '\#fff' }}>
          <Text>Press me!</Text>
        </Pressable>
      );
    }
    ```