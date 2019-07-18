FROM openjdk:8
COPY target/AngularTourOfHeroesAPI-0.0.1-SNAPSHOT.jar AngularTourOfHeroesAPI-0.0.1-SNAPSHOT.jar
EXPOSE 8085
CMD ["java","-jar","AngularTourOfHeroesAPI-0.0.1-SNAPSHOT.jar"]