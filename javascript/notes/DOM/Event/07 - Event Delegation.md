# Event-Delegation:

- Event delegation adds a single event handler to the parent element instead of having to register multiple event handlers to the child elements.
- If you have a large number of event handlers on a page, these event handlers will directly impact the performance.
- To solve this issue, you can leverage the event bubbling.

Working:

- In the 'click' event listener, you can access the 'target' property of event object which returns clicked child element inside parent element
- To get the id of the element that the event actually fires, you use the '[eventObj.target.id](http://eventobj.target.id/)' property.

Example:

```html
<ul id="menu">
<li><a id="home">home</a></li>
<li><a id="dashboard">Dashboard</a></li>
<li><a id="report">report</a></li>
</ul>

<script>
let menu = document.querySelector('#menu');

menu.addEventListener('click', (event) => {
	switch(event.target.id) {
    	case 'home':
        	console.log('Home menu item was clicked');
    		window.location.href = "/" + event.target.id;	// page redirect
        	break;
    	case 'dashboard':
        	console.log('Dashboard menu item was clicked');
    		window.location.href = "/" + event.target.id;
        	break;
    	case 'report':
        	console.log('Report menu item was clicked');
    		window.location.href = "/" + event.target.id;
        	break;
	}
});

</script>
```