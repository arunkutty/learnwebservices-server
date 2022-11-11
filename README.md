# SOA Testing sample app

This repository contains the source code for an enhanced "learnwebservices" sample application containing an additional service endpoint "ConversionHistory" to get a list of all temperature conversion requests that the server received. To do so, the application persists the requests it receive to a database.

You can find the original repository's README file [here](./README-original-repo.md).

## Run with the embedded H2 database (dev mode)

To run this application with an embedded in-memory H2 database (typically for development purposes), either run with the dev profile activated or run the following command in the root folder of the project: 
(Note: You must have a JDK version 11 or above installed.)

```shell
mvnw spring-boot:run
```

The application will be available at: `http://localhost:8080`.

## Running in production

Install MySQL version 8. You can find the installer [here](https://dev.mysql.com/downloads/installer/).
(You can opt to install the Database Server alone.)
Typically, MySQL starts up automatically post installation; if not, start it manually.

Afterwards, as a one time post-installation step, create the lwsapp database for the application to use. The steps are:
1) Locate the command line client in the  MySQL installation folder (In Windows this would be mysql.exe at C:\Program Files\MySQL\MySQL Server 8.0\bin)
2) In a command terminal, cd to the above folder and the run the following to access the mysql client prompt: 

```shell
mysql.exe --user=root --password=password
```
At the mysql> prompt, run the following: 

```shell
create database lwsapp;
```

To launch the application, first build it with the following command: 

```shell
mvnw clean install
```

(Note: you'd have to do the above only for: a) the first time after the repo is cloned, and b) if the code is changed.

To start the application in the production mode, run the following command: 

```shell
java -jar -Dspring.profiles.active=prod target\lwsapp.jar
```

The application will be available at: `http://localhost:8080`.

## Author

The application is maintained by Arun Kutty (kutty.a@gmail.com); contact him to report issues.

## Licence

The source code of the SOAP server is licensed under MIT License.

See [LICENCE](LICENCE) files for details.
