## [Music](https://developer.mozilla.org/en-US/docs/Web/API/HTMLAudioElement/Audio) in javascript

### Constructor :

```JavaScript
Audio()
Audio(path)
```

### Return value

A new `HTMLAudioElement` object, configured to be used for playing back the audio from the file specified by `url`.

### Instance property

```Plain
Audio.prototype.src
Audio.prototype.currentTime         // current time in second
Audio.prototype.duration            // total song time in second
Audio.prototype.paused              // boolean value
Audio.prototype.muted
Audio.prototype.volume
Audio.prototype.autoplay            // boolean value
Audio.prototype.baseURI             // string value
Audio.prototype.controls            // boolean value
Audio.prototype.draggable           // boolean value
Audio.prototype.ended               // boolean value
Audio.prototype.loop                // boolean value
Audio.prototype.muted               // boolean value
Audio.prototype.playbackRate        // integer number
```

### Instance method

```Plain
Audio.prototype.play()
Audio.prototype.pause();
```

### Event

```Plain
onended
```

### Example :