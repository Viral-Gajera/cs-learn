# Introduction

- Angular is one of the most powerful and performance-efficient JavaScript frameworks to build single-page applications for both web and mobile.
- Popular web platforms like Google Adwords, Google Fiber, Adsense have built their user interfaces using Angular.
- We can also create mobile application using angular & ionic.

# Installing Angular CLI

- You will be using Angular CLI to speed up the development process of Angular applications.
- Angular CLI is a command-line interface tool to scaffold and build Angular applications.

```Shell
npm install -g @angular/cli         # Install Globally
npm install -g @angular/cli@10.0.0  # Install Globally

ng new my-app

ng version
ng serve
ng serve --open
ng serve --open --port 3000

ng help

ng generate <schematic> [option]
ng g <schematic> [option]

ng g component component-name
ng g class class-name
bg g module module-name
bg g interface interface-name

ng g c component-name
ng g c folder/component-name
ng g c component-name --inline-style
ng g c component-name --inline-templete
ng g c component-name --inline-style --inline-templete

ng build

ng update @angular/cli @angular/core    // For CLI update
ng update @angular/cdk                  // For material/cdk upgrade
ng update @angular/material             // For material/cdk upgrade
```