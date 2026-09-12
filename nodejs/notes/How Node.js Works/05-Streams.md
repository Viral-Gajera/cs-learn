## Streams

- Used to process (read and write) data piece by piece (chunks), without completing the whole read or write operation, and therefore without keeping all the data in memory.
    
    ![[6 5.png|6 5.png]]
    

  

  

  

Example:

```JavaScript
const fs = require('fs');
const server = require('http').createServer();

server.on('request', (req, res) => {
    // Solution 1
    fs.readFile('./test-file.txt', (err, data) => {
        if (err) console.log(err);
        res.end(data);
    });

    // Solution 2: Streams
    const readable = fs.createReadStream('test-file.txt');
    readable.on('data', chunk => {
        res.write(chunk);
    });
    readable.on('end', () => {
        res.end();
    });
    readable.on('error', err => {
        console.log(err);
        res.statusCode = 500;
        res.end('File not found!');
    });

    // Solution 3
    const readable = fs.createReadStream('test-file.txt');
    readable.pipe(res);
    // readableSource.pipe(writeableDestination)
});

server.listen(8000, '127.0.0.1', () => {
    console.log('Listening...');
});
```