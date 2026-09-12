
# Introduction

> Dockerfile

```
FROM node:alpine
COPY . /app
WORKDIR /app
CMD node index.js
```


## Commands

```
docker build -t image-name .
docker images
docker image ls
docker run image-name

docker pull image-name
docker pull viralgajera/image-name
```