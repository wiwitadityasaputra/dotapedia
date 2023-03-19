FROM ubuntu:jammy

# install java, maven & nodejs
RUN apt-get update
RUN apt-get upgrade
RUN DEBIAN_FRONTEND=noninteractive apt install -y openjdk-17-jdk
RUN DEBIAN_FRONTEND=noninteractive apt install -y curl
RUN curl -s https://deb.nodesource.com/setup_16.x | bash
RUN DEBIAN_FRONTEND=noninteractive apt install -y maven
RUN DEBIAN_FRONTEND=noninteractive apt install -y nodejs

# prepare angular project
WORKDIR /home
RUN mkdir angular
COPY angular/src /home/angular/src
COPY angular/angular.json /home/angular/angular.json
COPY angular/cypress /home/angular/cypress
COPY angular/cypress.config.ts /home/angular/cypress.config.ts
COPY angular/karma.conf.js /home/angular/karma.conf.js
COPY angular/package-lock.json /home/angular/package-lock.json
COPY angular/package.json /home/angular/package.json
COPY angular/tsconfig.app.json /home/angular/tsconfig.app.json
COPY angular/tsconfig.json /home/angular/tsconfig.json
COPY angular/tsconfig.spec.json /home/angular/tsconfig.spec.json

# build angular project
WORKDIR /home/angular
RUN npm install --force
RUN npm run build || true

# prepare springboot project
WORKDIR /home
RUN mkdir springboot
COPY springboot/src /home/springboot/src
COPY springboot/mvnw /home/springboot/mvnw
COPY springboot/mvnw.cmd /home/springboot/mvnw.cmd
COPY springboot/pom.xml /home/springboot/pom.xml

# build  springboot project
WORKDIR /home/springboot
RUN mvn clean package

# copy .war to docker container
# WORKDIR /home
# RUN mkdir -p springboot/target
# COPY springboot/target/dotapedia-1.0.0-SNAPSHOT.war springboot/target

# prepare docker container
WORKDIR /home
COPY entrypoint.sh entrypoint.sh
RUN chmod +x entrypoint.sh
ENTRYPOINT ["./entrypoint.sh"]