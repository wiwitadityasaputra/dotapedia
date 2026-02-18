# dotapedia
this project is demo application to implement angular, springboot & mysql together

its a website application to show information about dota2 tournament around Dec-21

in this project we have frontend (angular) & backend (springboot) projects

we can run both inside docker using docker command - production mode

or for dev mode we also can running frontend/backend separately

## screen recording
https://www.youtube.com/watch?v=azxRT_P04Ug

## production
running inside docker, make sure you have docker running

#### run all through docker-compose
run following command and wait a couple minutes
```terminal
docker-compose -f docker-compose.yml up -d
```
after finish we can check folloing url
#### check spring-boot api
open http://localhost:8435/api/heroes
#### run dotapedia
open http://localhost:8435


#### stop-remove all
```terminal
docker-compose down --rmi all
```

#### show logs
```terminal
docker logs -f dotapedia_springboot_1
```

#### run ubuntu then access bash
```terminal
docker run --rm -it --entrypoint bash ubuntu:jammy
```

## development

for development purpose we can run springboot first then angular

### springboot

we are using mysql for database & java for backend languange

you need to setup mysql first & import the database

we also have news section, it will fetch data from `newsapi.org`

#### setup
1. prepare database using database/dotapedia.sql
2. make sure has java 17
```terminal
java -version
```
3. setup news api key
$ export NEWSAPI_APIKEY=3e68bc0d922f4cd4a176119148cb78c5

#### build

go to springboot directory
```terminal
cd src/springboot
```

using maven to build
```terminal
mvn clean package
```

#### run spring-boot
```terminal
mvn clean spring-boot:run
```

#### run jar (spring-boot only, without angular)
```terminal
java -jar target/dotapedia-1.0.0-SNAPSHOT.war
```

#### check api
open http://localhost:8430/api/heroes

#### test
```terminal
mvn clean test
mvn clean test -Dtest=NewsApiServiceTest
mvn clean test -Dtest=HeroControllerTest#getAllHeroes_heroType_null
```

#### check dependencies tree
```terminal
mvn dependency:tree
```

### angular


#### install
```terminal
cd src/angular
nvm use
npm install --force
```

#### run
```terminal
cd angular
nvm use
npm start
```
open http://localhost:8433

#### test
```terminal
cd angular
npm run cypress:open
npm run cypress:headless
npx cypress run --spec cypress/e2e/home.cy.ts
```

## run fat-jar (spring-boot & angular)
#### prepare angular files then build & run spring-boot
```terminal
cd src/angular
npm run build
cp -R dist/angular/* ../springboot/src/main/resources/static
cd ../springboot
mvn clean package
java -jar target/dotapedia-1.0.0-SNAPSHOT.war
```


