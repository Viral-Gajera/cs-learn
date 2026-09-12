# Software Engineering  

Q. What is software engineering ?

- Software engineering provides systematic process for building software applications.
- Used to develop high-quality, reliable, and efficient software products.
- Deliver software on time.



Q. What is a software development framework?

- A software development framework is a collection of tools, libraries, and guidelines that provides systematic process for building software applications.
- It offers a foundation for developers to create and manage applications efficiently.




Q. What are different software process model ?

- Software development life cycle (SDLC)
- Linear sequential model (Water fall model)
- Prototyping model
- Rapid application development (RAD)
- Evolutionary process model
    - Incremental Process Model
    - Spiral Model
    - Concurrent Development Model
- Component based development
- Agile Software Development
    - Scrum
    - Extreme programming
    - Adaptive software development
    - Dynamic systems development methods
    - Feature driven development
    - Crystal
    - Agile Modelling
- DevOps




Q. What is software development life cycle (SDLC), and what are its phases ?

- SDLC provides systematic process for building software applications, that involves several phases, or stages.
    1. Requirement Gathering: Understanding the client's needs.
    2. Analysis: Analysing requirements and feasibility.
    3. Design: Creating the software architecture and design.
    4. Implementation: Writing code and developing the software.
    5. Testing: Checking for bugs and ensuring functionality.
    6. Deployment: Releasing the software to users.
    7. Maintenance: Updating and improving the software based on user feedback.



Q. What is agile methodologies in software development.

- Agile is iterative software developement process unlike the waterfall model.
- People based rather than plan based
- Individuals and interactions over processes and tools.



Q. Explain the scrum.

- Scrum is iterative software developement process.
- Roles
    - Product owner
    - Scrum master
    - Team
- Meeting
    - Sprint planing meeting
    - Daily meeting
- Task List
    - Product backlog
    - Sprint backlog
- Sprint is 1-4 week time period.



Q. Explain the difference between waterfall and agile methodologies in software development.

- Waterfall is a linear, sequential approach to software development, where each phase is completed before moving to the next.
- Agile is an iterative and flexible approach, allowing for continuous feedback and adaptation throughout the development process.



Q. What is Requirements Engineering ?

- It is systematic process of gathering user requirements and Analysing it.
- Type of requirements:
    - Functional requirements
    - Non Functional requirement



Q. What is the difference between functional and non-functional requirements in software development ?

- Functional requirements define as specific features/functionalities of application, like Add/Delete/Update Books in library management system.
- Non-functional requirements specify how the system should perform, including aspects like performance, security, reliability, and usability.
- Take an example of library management system.



Q. What is the purpose of a software requirement specification (SRS) document ?

- SRS document contains all the detailed of user requirements, funcation, non-functional, business requirement etc.
- It serves as a reference for developers, testers, and stakeholders to understand the project scope, features, and constraints.



Q. What is Cohesion & Coupling ?

- Cohesion refers to degree of interdependency between various `elements of module`.
- Coupling refers to degree of dependency between `multiple modules`.
- For good software product, their shoud be `high cohesion` and `low coupling`.



Q. What is Code Review ?

- Code Review is strategy for reducing error and producing high quality code.
- Two types of reviews are carried out on the code of a module
    - Code Walk Through
      
        Code Walkthrough is a peer review process in software development where a group of developers examine the code line by line to identify errors, bugs, and other issues.
        
    - Code Inspection
      
        Code Inspection is a software development technique for detecting errors/defects in the code before it is released.



Q. What is the significance of software testing in the development process?

- Software testing ensures that our software is bug/defect free, to enhance user experience.



Q. What are Software Testing Strategies?

- Unit Testing
- Integration testing
    - Top-down Integration Testing
    - Bottom-up Integration Testing
- Regression Testing
- Smoke Testing
- Validation Testing
    - Alpha Testing
    - Beta Testing
- System Testing
    - Recovery testing
    - Security testing
    - Stress testing
    - Performance testing
    - Deployment testing
- Acceptance Testing
- Black Box and White Box Testing



- During the development process, software products undergo four levels of testing: Unit Testing, Integration Testing, System Testing, and Acceptance Testing.

<img src="Testin.png" style="zoom: 50%;" >



Q. What is unit testing ?

- Unit is the smallest part of a software system which is  testable.
- It may include code files, classes and methods which can be tested individually for correctness.
- Unit Testing validates small building block of a complex system before testing an integrated large module or whole system.



Q. What is integration testing ?

- Integration testing is a type of software testing that involves gradually integrating component and testing components of a software application as a unified group.
- It's the second level of the software testing process, after unit testing, and before system testing.
- Top-down integration testing: Focuses on the main module and then its sub-modules
- Bottom-up integration testing: Tests the sub-modules or sub-routines first, then the main module



Q. What is system testing ?

- System testing is the process of testing an system to evaluate its performance/functionality.

- Recovery testing

  Determines if a software program can continue operating after a failure, such as a crash, power outage, or network outage. During recovery testing, the system is forced to crash to record how long it takes to recover.

- Security testing

  Evaluates a system's security to identify vulnerabilities and potential threats, and to ensure it's protected against unauthorized access and data breaches. Testers simulate attacks to check existing security mechanisms and look for new vulnerabilities.

- Stress testing

  Determines how well a software can function under heavy or extreme loads. Stress testing evaluates a software's error-handling techniques, robustness, and availability.

- Performance testing

  Evaluates a system's performance and scalability under different loads and conditions. Performance testing helps identify bottlenecks, measure system performance, and ensure that the system can handle the expected number of users or transactions.

- Deployment testing

  Ensures that a software system works as expected in its target environment and meets quality standards before being released to end users. Deployment testing verifies the system's installation, configuration, performance, security, and compatibility. 



Q. What is acceptance testing ?

- It is a final test before the system available for actual use 
- It ensures that software system meets the requirements and expectations of the end-users/customers/business. 



Q. What is validation testing ?

- alpha testing - Performed internally by the development team
- beta testing - Performed by selected external users
- They are both types of <u>User Acceptance Testing (UAT)</u> that aim to identify and resolve issues, but they differ in who performs the testing.



Q. Explain the difference between black-box testing and white-box testing.

- Black-box testing involves testing the functionality of a system <u>without any knowledge of its internal structure or code</u>.
- Tester does not have any knowledge of the internal workings of the software and tests it solely based on its inputs and outputs.
- White-box testing involves testing the internal structure, logic, architecture and code of the system.
- Tester has some knowledge to the internal workings / structure of the system being tested.



Q. What is Re-engineering, Reverse Engineering and Forward Engineering?

- Re-engineering is process of modifying and updating an existing software system to improve its functionality, maintainability, and efficiency.
- Reverse Engineering is process of understading/analysing an existing product or system to understand its design, function, and operation.
- Forward Engineering is process of obtaining desired software from the specifications, which were brought by reverse engineering.
- Forward engineering is same as software engineering process with only one difference, it is carried out always after reverse engineering.



Q. What is Software as a Service ?

- Unlike conventional method, where we build software for particular client and deliver to them,
- Software as a service (SaaS) is a web-based software, or web-hosted software that allows users to access software on a subscription basis.



Q. What is version control, and why is it important in software development?

- Version control is a system that track changes to files over time.
- It allows tracking modifications, reverting to previous versions, and collaborating on code with multiple developers. It ensures better collaboration, maintains code integrity, and facilitates software evolution.



Q. Explain the concept of a design pattern in software engineering.

- Design patterns are reusable solutions to common software design problems.
- They provide best practices for designing and solving recurring issues in software development, enhancing code readability, scalability, and maintainability.



Q. Explain the concept of a software bug and the bug life cycle.

- A bug is a flaw or error in software that causes it to behave unexpectedly or incorrectly.
- The bug life cycle involves stages such as identification, logging, assignment, fixing, retesting, and closure of the bug after verification.



Q. Explain the concept of refactoring in software development.

- Refactoring is the process of restructuring existing code without changing its external behavior.
- It aims to improve code readability, maintainability, and performance by eliminating redundancy, improving design, and enhancing code quality.



Q. What are the main principles of software architecture design?

- Principles of software architecture design include:
    - **Modularity**: Breaking the system into smaller, manageable components.
    - **Scalability**: Designing systems that can handle increasing loads.
    - **Security**: Ensuring the system is resistant to unauthorized access and attacks.
    - **Performance**: Designing for optimal speed and efficiency.



Q. What is Continuous Integration (CI) and Continuous Deployment (CD) in software?

- CI involves regularly integrating, changes into a repository. (adding new module)
- CD involves automatically deploying changes to production environments.



Q. What are the advantages of pair programming in software development?

- Pair programming involves two programmers working together in single codebase.
- Its benefits include improved code quality, knowledge sharing, reduced errors, faster problem-solving, and enhanced collaboration.



Q. What is DevOps ?

- DevOps, which is a combination of the words "development" and "operations", is a software development methodology.
- CI/CD: DevOps practices emphasize continuously integrating code changes and delivering updates quickly and efficiently.
  Phases: Plan, code, build, test, release, deploy, operate, monitor
- Benefits:
  - Faster Delivery: Rapid and frequent delivery of updates and new features.
  - Improved Quality: Automated testing and integration lead to fewer bugs and higher quality software.
  - Enhanced Collaboration: Better communication and collaboration between development and operations teams.
  - Increased Efficiency: Automation of repetitive tasks reduces manual effort and the potential for errors.
  - Scalability: Easier to scale applications and infrastructure to meet changing demands.