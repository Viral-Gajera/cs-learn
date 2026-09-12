Q. What is docker image?

- Image is package containing all information needed to create container
- It containers all the dependencies and deployment configurations
- Images can inherit from multiple base images using layering
- Layer stacked on top of each other to form the container’s filesystem.
- Image does not have state

Q. What is docker container?

- Container is run time instance of image
- It has image + execution environment + runtime instructions
- 