## Intl :

- The Intl object is the namespace for the ECMAScript Internationalization API, which provides language sensitive string comparison, `number formatting`, and `date and time formatting`.

### Constructor properties :

```Plain
Intl.DateTimeFormat([locals],[options])
Intl.NumberFormat([locals],[options])

Intl.Collator([locals],[options])
Intl.DisplayNames([locals],[options])
Intl.ListFormat([locals],[options])
Intl.Locale(tag,[options])
Intl.PluralRules([locals],[options])
Intl.RelativeTimeFormat([locals],[options])
Intl.Segmenter([locals],[options])
```

### Static methods :

```Plain
Intl.getCanonicalLocales(locals)
Intl.supportedValuesOf(key)
```

### Locals :

```Plain
"en-US"
"en-GB"
"en-IN"
"hi-IN"
"gu-IN" ...
```

### Intl.DateTimeFormat() Construtor :

- The `**Intl.DateTimeFormat**` object enables language-sensitive date and time formatting.
- Return : A new `Intl.DateTimeFormat` object.

### Constructor :

```Plain
Intl.DateTimeFormat([locals],[options])
```

- Options :
    - `options` is object that supportes following properties and value.
        
        ```Plain
        "dateStyle" : "full|long|medium|short"
        "timeStyle" : "full|long|medium|short"
        
        "year" : "numeric|2-digit"
        "month" : "numeric|2-digit|long|short|narrow"
        "weekday" : "long|short|narrow"
        "day" : "numeric|2-digit"
        "hour" : "numeric|2-digit"
        "hour12" : true|falue
        "minute" : "numeric|2-digit"
        "second" : "numeric|2-digit"
        "fractionalSecondDigits" : 0|1|2|3
        "timeZone" : "Asia/Kolkata | America/New_York ..."
        "timeZoneName" : "long|short|shortOffset|longOffset|..."
        
        "calendar" : "indian|gregory|chinese..."
        "dayPeriod" : "narrow|short|long" ["in the morning", "am", "noon", "n"]
        "numberingSystem" : "arab|bali|mymr..."
        "localeMatcher" : "lookup|best fit"
        "hourCycle" : "h11|h12|h23|h24"
        "formatMatcher" : "basic|best fit"
        "era" : "long|short|narrow"
        ```
        

### Instance method :

```Plain
Intl.DateTimeFormat.prototype.formate(Date-obj)
Intl.DateTimeFormat.prototype.resolvedOptions()
Intl.DateTimeFormat.prototype.formateToParts()
```

Example :

```Plain
let intl = Intl.DateTimeFormat('en-IN', {
    dateStyle : 'full',
    timeStyle : "full",
    // year: 'numeric',
    // month: 'long',
    // weekday: 'long',
    // day: '2-digit',
    // hour: '2-digit',
    // minute: '2-digit',
    // second: '2-digit',
    // Can't set option year,month,weekday,day when dateStyle is used
    // Can't set option hour,minute,second when timestyle is used
});

let date = new Date();
let FormatedDate = intl.format(date);
console.log(FormatedDate);
// Sunday, 6 November, 2022 at 1:04:51 pm India Standard Time

/*
console.log(FormatedDate.year());   // Error
console.log(FormatedDate.month());  // Error
console.log(FormatedDate.day());    // Error
*/



```

### Intl.NumberFormat() Construtor :

- The `**Intl.NumberFormat()**` constructor creates [`Intl.NumberFormat`](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Intl/NumberFormat) objects that enable language-sensitive number formatting.
- Return : A new `Intl.NumberFormat` object.

### Constructor :

```Plain
Intl.NumberFormat([locals],[options])
```

- Options :
    - `options` is object that supportes following properties and value.
        
        ```Plain
        "style" : "decimal|currency|percent|unit"
        
        "currency" : "USD|EUR|..."
        "currencyDisplay" : "symbol|narrowSymbol|code|name"
        "currencySign" : "accounting|standard"
        
        "unit" : ""
        "unitDisplay" : "long|short|narrow"
        
        "signDisplay" : "auto|always|exceptZero|negative|never"
        "roundingMode" : "ceil|floor|trunc|..."
        "roundingPriority" : "auto|morePrecision|lessPrecision|"
        "roundingIncrement" : 1|2|5|...
        "minimumIntegerDigits" : 1|2|...|21
        "minimumFractionDigits" : 0|1|2|...|20
        "maximumFractionDigits" :  0|1|2|...|20
        "minimumSignificantDigits" : 1|2|...|21
        "maximumSignificantDigits" : 1|2|...|21
        "trailingZeroDisplay" : "auto|stripIfInteger"
        
        "useGrouping" : "always|auto|false|min2|true"
        
        "compactDisplay" : "short|long"
        "localeMatcher" : "lookup|best fit"
        "notation" : "standard|scientific|engineering|compact"
        "numberingSystem" : "arab|mymr|taml..."
        ```
        

### Instance method :

```Plain
Intl.NumberFormat.prototype.formate(Date-obj)
Intl.NumberFormat.prototype.formateToParts(Date-obj)
Intl.NumberFormat.prototype.resolvedOptions()
```

Example :

```Plain
let intl = Intl.NumberFormat('en-US', {
    style : 'currency',
    currency : "USD",
    currencyDisplay : "symbol"
});

let num = 8013.1713;
let FormatedNum = intl.format(num);
console.log(FormatedNum); // $8,013.17
```