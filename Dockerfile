FROM gradle:8.3.0-jdk17-alpine as builder

WORKDIR /app
COPY build.gradle settings.gradle ./
# Download Dependencies
RUN gradle dependencies

# Copy Source and Build Application
COPY src src
RUN gradle build -x test --continue && \
    mv build/libs/*-SNAPSHOT.jar build/libs/app.jar

FROM amazoncorretto:17.0.8-alpine3.18

COPY --from=builder /app/build/libs/app.jar ./

CMD ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","./app.jar"]
