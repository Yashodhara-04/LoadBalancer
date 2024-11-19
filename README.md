# Load Balancer
 
Implemented a Load Balancer project to deepen my understanding on distributed system design and improve my skills in building scalable Spring Boot applications.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Usage](#usage)
- [Getting Started](#getting-started)
- [Contributing](#contributing)
- [License](#license)
- [Author](#author)

## Introduction

Designed a Load Balancer project to distribute incoming requests across multiple servers to ensure optimal resource utilization, high availability, and scalability.

## Features

- **Load Balancing Strategies:** Implemented algorithm's like Round Robin and Random Strategy for server selection.
- **Health Check:** Monitors health of server and removes unhealthy servers.
- **Efficient Server Communication:** Utilizes Rest Template to communicate with servers.

## Technologies Used

- **Spring Boot:** For building the core application.
- **Java:** The primary programming language for the project.
- **Maven:** For project management and dependency management.
- **Rest Template:** For routing requests and communicating with the servers.

  ## Usage

**1. Run Servers**
   - Open both LoadBalancerServer1 and LoadBalancerServer2 project and run.
     
  ```bash
   http://localhost:8081
   ```

  ```bash
   http://localhost:8082
   ```

**2. Run Load Balancer**
  - Once the servers are up and running run the Load Balancer application. You can see the output in the console.

    ![_](https://github.com/user-attachments/assets/c1338ab9-5deb-4514-9e3f-ce218c8238a0)

## Getting Started

**1. Clone the repository:**

  ```bash
  git clone https://github.com/Yashodhara-04/LoadBalancer.git
   ``` 
      
**3. Run the `Main` class:**

  ```bash
  java Main
   ```


## Contributing
 If you would like to contribute to this project, please fork the repository and submit a pull request. Ensure that your changes
 are well-tested and documented.

## License
This project is licensed under the MIT License - see the LICENSE file for details.

## Author

- Yashodhara C H(https://github.com/Yashodhara-04)
