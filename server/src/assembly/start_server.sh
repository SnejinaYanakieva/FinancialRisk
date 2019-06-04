#!/bin/bash
	cd .. 
	cd ..
	mvn -q clean compile exec:java -Dexec.mainClass="ers.students.server.ServerApplication" -Dexec.args="start"
exec bash
