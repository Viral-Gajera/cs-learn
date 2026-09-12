# Basic

Q. Latest version of technology !

- HTML 5
- CSS 3
- Tailwindcss 4
- Javascript 2025
- React 19
- Next 15
- Node 22
- Express 4

  

Q. What is SEO ?

- SEO Stands for search engine optimisation.
- Used to make our web page, rank higher in the results of search engine.
- Increase traffic & revenue.

  

Q. What is API ?

- API stands for Application Programming Interface.
- APIs allow software/website to communicate with backend server or other third party service provider.
- Type: SOAP, REST

  

Q. What is web scraping? How to optimize web scraping ?

- Web scraping is the process of extracting / collecting data from a website though the program.
- Optimize speed: Use multithreading, multiprocessing, CAPTCHA-solving service, use proxies to avoid detection, rotate your user-agent
- Step : 1) Download the content
- Step : 2) Use Regular express to extract data
- Step : 3) Utilize data

# HTML

Q. What is HTML ?

- Hyper Text Mark-up Language.
- Used for creating web pages and defining their structure.

  

Q. Difference between `html`, `xhtml`, and `xml` ?

| Feature             | HTML                                 | XHTML                                               | XML                                                     |
| ------------------- | ------------------------------------ | --------------------------------------------------- | ------------------------------------------------------- |
| Definition          | HyperText Markup Language            | Extensible HyperText Markup Language                | Extensible Markup Language                              |
| Purpose             | Used to create web pages             | Used to create web pages with stricter syntax rules | Used to transport and store data                        |
| Syntax              | Flexible, not strict                 | Strict, follows XML rules                           | Very strict, follows well-defined syntax rules          |
| Tag Case            | case-insensitive                     | Case-sensitive                                      | Case-sensitive                                          |
| Closing Tags        | Not always required                  | Required for all tags                               | Required for all tags                                   |
| Attribute Quotation | Not always required                  | Required for all attributes                         | Required for all attributes                             |
| Document Structure  | Can be less structured               | Must be well-formed                                 | Must be well-formed and properly nested                 |
| Error Handling      | Browsers try to correct errors       | Browsers do not correct errors                      | Does not handle errors; must be well-formed             |
| Doctype Declaration | Optional                             | Required                                            | Not required but recommended                            |
| Self-Closing Tags   | Not required (e.g., `<br>`, `<img>`) | Required to be closed (e.g., `<br />`, `<img />`)   | Required to be closed (e.g., `<tag />`)                 |
| Interoperability    | Less strict with other technologies  | More strict and compatible with XML tools           | Can be used with a variety of data representation tools |



Q. What is the purpose of the `doctype` declaration in HTML ?

- It is an HTML tag that is used to define the document type and version of an HTML document.
- Helps browsers render the page correctly.
- Possible values : `html`, `xhtml`.



Q. What is HTML element ?

- HTML element is combination of : starting tag + content + ending tag.




Q. What are semantic elements in HTML ?

- Semantic elements in HTML provide `meaning` to the structure of web content.
- Makes it more accessible and SEO-friendly.
- Examples include `<header>`, `<footer>`, `<nav>`, `<section>`, `<aside>` , `<article>` , `<form>`, `<table>`, `<p>` etc.




Q. What is the difference between `<div>` and `<span>`?

- `<div>` is a block-level element used for grouping and creating sections.
- While `<span>` is an inline element used for applying styles or grouping inline content.



Q. What is inline element and block element ?

- A block-level element always starts on a new line and takes up the full width available.
- An inline element does not start on a new line and it only takes up as much width as necessary.

  

Q. List 5 Block Elements and 5 Inline elements

Block : `<div>`, `<p>`, `<h1>` to `<h6>`, `<ul>`, and `<li>`

Inline : `<span>`, `b`, `i`, `u`, `s`, `strong`, `img`, `a`

  

Q. List 5 Table attributes

`border`, `colspan`, `rowspan`, `cellpadding`, `cellspacing`, `width`, `align`



Q. What is the purpose of the `alt` attribute in an `<img>` tag ?

- The `alt` attribute provides alternative text for an image,
- Which is displayed if the image fails to load or for visually impaired users who rely on screen readers.
- Google Image

  

Q. What are the different types of lists in HTML ?

- Unordered lists (`<ul>`)
- Ordered lists (`<ol>`)
- Definition lists (`<dl>`)
- Example:
  
    ```HTML
    <ul type="" >
    	<li>item 1</li>
    	<li>item 2</li>
    </ul>
    
    type =  disc, squar, circle,
    
    <ol type="" start="" >
    	<li>item 1</li>
    	<li>item 2</li>
    </ol>
    
    type = 1, i, I, A, a
    
    <dl>
        <dl>ISRO</dl>
    	<dd>Indian space research organization</dd>
    </dl>
    ```
    

  

Q. What is the purpose of the `<iframe>` tag ?

- Inline frame.
- The `<iframe>` tag is used to embed external document within the current HTML document.

  

Q. Which tag is used, while embedding youtube video in webpage.

- `iframe` tag used to embedding youtube video in webpage.
- `<iframe width="" height="" src="" title=""></iframe>`

  

Q. What is the difference between the `<script>` tag's `async` and `defer` attributes ?

- The `async` attribute downloads the script asynchronously while HTML parsing continues, and `executes it as soon as it finishes downloading`.
- The `defer` attribute downloads the script asynchronously as well but ensures that it is `executed after the HTML document is parsed`.



Q. What are the new form input types introduced in HTML5 ?

- HTML5 introduced new input types such as `email`, `url`, `search`, `number`, `date`, `week`, `month`, `color`, etc.,
- Providing built-in validation and improved user experience for specific data types.



Q. Which `meta` tag is necessary for responsivity of the webpage.

```HTML
<meta name="viewport" content="width=device-width, initial-scale=1.0">
```



Q. How can you defined favicon in title ?

```HTML
<link rel="icon" type="image/x-icon" href="/images/favicon.ico">
```



Q. Difference between disabled and readonly attribute in html ?

|Attribute|Purpose|Applicable Elements|User Interaction|Value Submitted|
|---|---|---|---|---|
|`disabled`|Makes the element's value non-editable|Form elements (input, select, etc.)|No|Not submitted|
|`readonly`|Makes the element's value non-editable|Form elements (input, textarea)|No (cursor)|Submitted|



Q. What is meant by an empty tag in HTML?

- Empty tag does not require closing tag.
- Example, hr, br, img, input, link, meta, source
- HTML elements with no content are called empty elements.



Q. What is self closing tag?

- Empty tag does not require closing tag.
- Some few self-closing tags are `<input/>`, `<hr/>`, `<br/>`, `<img/>`, etc.



Q. How to set a font for a whole page?

- `<defaultfont>` tag is used to set up a default font type for a whole page.



Q. When the attributes `src` and `href` used ?

```Java
-> href
link
a
base
area

-> src
img
script
iframe
embed
audio
video
source
```



Q. How to make responsive image without using css ?

```HTML
<picture>
  <source media="(min-width: 650px)" srcset="img_food.jpg">
  <source media="(min-width: 465px)" srcset="img_car.jpg">
  <img src="img_girl.jpg">
</picture>
```