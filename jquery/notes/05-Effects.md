# jQuery Effects

- `hide( [speed], [callback] )`
    
    The optional speed parameter specifies the speed of the hiding/showing, and can take the following values: "slow", "fast", or milliseconds. The optional callback parameter is a function to be executed after method completes.
    
- `show( [speed], [callback] )`
    
    The optional speed parameter can take the following values: "slow", "fast", or milliseconds.
    
- `toggle( [speed], [callback] )`
    
    The optional speed parameter can take the following values: "slow", "fast", or milliseconds.
    
- `fadeIn( [speed], [callback] )`
- `fadeOut( [speed], [callback] )`
- `fadeToggle( [speed], [callback] )`
- `fadeTo( speed, opacity, [callback] )`
- `slideDown( [speed], [callback] )`
- `slideUp( [speed], [callback] )`
- `slideToggle( [speed], [callback] )`

# Animation

- `animate( {params}, [speed], [callback])`
    
    The required params parameter defines the CSS properties to be animated.
    

### Using Relative Values

- It is also possible to define relative values (the value is then relative to the element's current value). This is done by putting += or -= in front of the value:
- Example :
    
    ```Plain
    $("button").click(function(){
      $("div").animate({
        left: '250px',
        height: '+=150px',
        width: '+=150px'
      });
    });
    ```
    

### Pre-defined Values

- You can even specify a property's animation value as "`show`", "`hide`", or "`toggle`".
- Example :
    
    ```JavaScript
    $("button").click(function(){
      $("div").animate({
        height: 'toggle'
      });
    });
    ```
    

### Queue Functionality

- By default, jQuery comes with queue functionality for animations.
- This means that if you write multiple `animate()` calls after each other, jQuery creates an "internal" queue with these method calls. Then it runs the animate calls ONE by ONE.
- So, if you want to perform different animations after each other, we take advantage of the queue functionality:
    
    Example:
    
    ```Plain
    $("button").click(function(){
      var div = $("div");
      div.animate({height: '300px', opacity: '0.4'}, "slow");
      div.animate({width: '300px', opacity: '0.8'}, "slow");
      div.animate({height: '100px', opacity: '0.4'}, "slow");
      div.animate({width: '100px', opacity: '0.8'}, "slow");
    });
    ```
    

### Stop Animations

- The jQuery `stop(stopAll,goToEnd)` method is used to stop an animation or effect before it is finished.