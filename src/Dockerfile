FROM ubuntu:jammy

RUN apt-get update
RUN apt-get upgrade
RUN DEBIAN_FRONTEND=noninteractive apt install -y openjdk-17-jdk
RUN DEBIAN_FRONTEND=noninteractive apt install -y curl
RUN curl -s https://deb.nodesource.com/setup_16.x | bash
# RUN DEBIAN_FRONTEND=noninteractive apt install -y maven
RUN DEBIAN_FRONTEND=noninteractive apt install -y nodejs

WORKDIR /home
RUN mkdir angular
COPY angular/src /home/angular/src
COPY angular/angular.json /home/angular/angular.json
COPY angular/karma.conf.js /home/angular/karma.conf.js
COPY angular/package-lock.json /home/angular/package-lock.json
COPY angular/package.json /home/angular/package.json
COPY angular/tsconfig.app.json /home/angular/tsconfig.app.json
COPY angular/tsconfig.json /home/angular/tsconfig.json
COPY angular/tsconfig.spec.json /home/angular/tsconfig.spec.json

WORKDIR /home/angular
# RUN ls -lR .
RUN ls
RUN node -v
RUN npm -v
RUN npm install --force
RUN npm run build || true
RUN ls
RUN ls dist
RUN ls dist/angular

# WORKDIR /home
# RUN mkdir springboot
# COPY springboot /home/springboot

# WORKDIR /home/springboot
# RUN mvn clean package

# RUN pwd
# RUN java -version
# RUN mvn -version
# RUN ls 
# RUN ls target

WORKDIR /home
RUN mkdir -p springboot/target
COPY springboot/target/dotapedia-1.0.0-SNAPSHOT.war springboot/target
RUN ls
RUN ls springboot
RUN ls springboot/target

WORKDIR /home
COPY entrypoint.sh entrypoint.sh
RUN chmod +x entrypoint.sh
ENTRYPOINT ["./entrypoint.sh"]