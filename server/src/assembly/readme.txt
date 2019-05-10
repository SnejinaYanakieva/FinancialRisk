## System requirements
- Java Runtime Enviroment - Java version 1.8 (1.8.0_202)
- Apache Maven 3.6.0

## Installation
- Extract the archive [name of archive] into a suitable folder.

## Assembly
- Run AdminDBApp and configure the database settings.
- Go to server/src/main/resources/config.properties and configure database url, user and password

## Usage
- Open terminal and type:
	cd ${project.basedir}/server
	mvn -q clean compile exec:java -Dexec.mainClass="ers.students.server.ServerApplication" -Dexec.args="start"
	mvn -q clean compile exec:java -Dexec.mainClass="ers.students.server.ServerApplication" -Dexec.args="stop"



