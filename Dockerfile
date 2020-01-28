FROM openjdk:12-alpine
LABEL maintainer=doutorking@gmail.com
WORKDIR /app
COPY libs libs/
COPY resources resources/
COPY classes classes/
ENTRYPOINT ["java", "-cp", "/app/resources:/app/classes:/app/libs/*", "com.swabber.Application"]
EXPOSE 8080
