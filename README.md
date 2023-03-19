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

#### run jar (spring-boot only)
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

#### run fat-jar (spring-boot & angular)
##### prepare angular files then build & run spring-boot
$ cd angular
$ npm run build
$ cp -R dist/angular/* ../springboot/src/main/resources/static
$ cd ../springboot
$ mvn clean package
$ java -jar target/dotapedia-1.0.0-SNAPSHOT.war



docker-compose -f docker-compose.yml up -d
docker-compose down --rmi all
docker logs -f dotapedia_springboot_1

docker run --rm -it --entrypoint bash ubuntu:jammy

apt-get update
DEBIAN_FRONTEND=noninteractive apt install -y curl
curl -s https://deb.nodesource.com/setup_16.x | bash
DEBIAN_FRONTEND=noninteractive apt install -y nodejs
curl -s https://deb.nodesource.com/setup_8.x | bash