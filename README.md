# dotapedia

### springboot
##### run
$ cd springboot
$ export NEWSAPI_APIKEY=3e68bc0d922f4cd4a176119148cb78c5
$ mvn clean spring-boot:run
##### test
$ cd springboot
$ mvn clean test
$ mvn clean test -Dtest=NewsApiServiceTest
$ mvn clean test -Dtest=HeroControllerTest#getAllHeroes_heroType_null

### angular
##### install
$ cd angular
$ nvm use
$ npm install --force
##### run
$ cd angular
$ nvm use
$ npm start
##### test
$ cd angular
$ npm run cypress:open