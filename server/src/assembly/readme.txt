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
	cd ${project.basedir}/server/src/assembly
		bash start_server.sh
		bash stop_server.sh
	or

	cd ${project.basedir}/server
		mvn -q clean compile exec:java -Dexec.mainClass="ers.students.server.ServerApplication" -Dexec.args="start"
		mvn -q clean compile exec:java -Dexec.mainClass="ers.students.server.ServerApplication" -Dexec.args="stop"

## Credits
- Snejina Yanakieva: Project architect
- Gergana Kuleva: Project architect
- Irina Ivanova: Business logic
- Ayhan Abilov: Persistence store
- Martin Stoynov: Endpoint & Server
- Viktor Radev: Data model & Server


