all: clean build exec

run: build exec

build:
	mvn package

checkstyle:
	mvn checkstyle:check

exec:
	java -jar target/Trex-jar-with-dependencies.jar

clean:
	rm -rf target
