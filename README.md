# dotapedia

## springboot

#### setup
1. prepare database using database/dotapedia.sql
2. make sure has java 17
$ java -version
3. setup news api key
$ export NEWSAPI_APIKEY=3e68bc0d922f4cd4a176119148cb78c5

#### build with all test
$ cd src/springboot
$ mvn clean package

#### run spring-boot
$ mvn clean spring-boot:run

#### run jar (spring-boot only)
$ java -jar target/dotapedia-1.0.0-SNAPSHOT.war

#### check api
open http://localhost:8430/api/heroes

#### test
$ mvn clean test
$ mvn clean test -Dtest=NewsApiServiceTest
$ mvn clean test -Dtest=HeroControllerTest#getAllHeroes_heroType_null

#### dependencies tree
$ mvn dependency:tree

## angular

#### install
$ cd src/angular
$ nvm use
$ npm install --force

#### run
$ cd angular
$ nvm use
$ npm start
open http://localhost:8433

#### test
$ cd angular
$ npm run cypress:open
$ npm run cypress:headless
$ npx cypress run --spec cypress/e2e/home.cy.ts

## run fat-jar (spring-boot & angular)
#### prepare angular files then build & run spring-boot
$ cd src/angular
$ npm run build
$ cp -R dist/angular/* ../springboot/src/main/resources/static
$ cd ../springboot
$ mvn clean package
$ java -jar target/dotapedia-1.0.0-SNAPSHOT.war

## docker
#### run all through docker-compose
$ docker-compose -f docker-compose.yml up -d
#### stop-remove all
$ docker-compose down --rmi all
#### show logs
$ docker logs -f dotapedia_springboot_1
#### run ubuntu then access bash
$ docker run --rm -it --entrypoint bash ubuntu:jammy
#### check spring-boot api
open http://localhost:8435/api/heroes
#### run dotapedia
open http://localhost:8435

