# dotapedia

## springboot

#### setup
$ java17
$ cd springboot
$ export NEWSAPI_APIKEY=3e68bc0d922f4cd4a176119148cb78c5

#### build with all test
$ mvn clean package

#### run spring-boot
$ mvn clean spring-boot:run

#### run jar
$ java -jar target/dotapedia-1.0.0-SNAPSHOT.war

#### test
$ mvn clean test
$ mvn clean test -Dtest=NewsApiServiceTest
$ mvn clean test -Dtest=HeroControllerTest#getAllHeroes_heroType_null

#### dependencies tree
$ mvn dependency:tree

## angular

#### install
$ cd angular
$ nvm use
$ npm install --force

#### run
$ cd angular
$ nvm use
$ npm start

#### test
$ cd angular
$ npm run cypress:open
$ npm run cypress:headless
$ npx cypress run --spec cypress/e2e/home.cy.ts
