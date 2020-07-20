FROM openjdk:8
ADD recipes-web/target/recipes-web-0.0.1-SNAPSHOT.jar .
EXPOSE 8000
CMD java -jar recipes-web-0.0.1-SNAPSHOT.jar
