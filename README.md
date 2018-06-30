Website for findeasily.net
============================

[![CircleCI](https://circleci.com/gh/zhouhao/findeasily.net/tree/master.svg?style=svg&circle-token=afb24021c44ad75ddad34fd29ac8ed311887763c)](https://circleci.com/gh/zhouhao/findeasily.net/tree/master)

### The Wish
1. landlord can post their resources into this website easily(?How easily?)
2. tenant can search house of rent by map, which is more informative

### Quick start
1. Please make sure you have `Java8` and `git` installed
2. `git clone https://github.com/zhouhao/findeasily.net.git`
3. Create you configuration file(*optional step*, e.g. your file is `application-sample.properties`) in [`resources`](https://github.com/zhouhao/findeasily.net/tree/master/src/main/resources) folder(use [`application-dev.properties`](https://github.com/zhouhao/findeasily.net/blob/master/src/main/resources/application-dev.properties) as example)
4. `SPRING_PROFILES_ACTIVE=sample mvn spring-boot:run`
5. Visit [http://localhost:8080/](http://localhost:8080/), if everything is OK, you can see the home page


### Note:
1. I recommend [**Intellij**](https://www.jetbrains.com/idea/download/#section=mac) as IDE(either Ultimate or Community).(Eclipse is OK, but as I know, Lombok plugin does not work well in Eclipse)
2. You do not need to patch DB schemas manually, as flyway can do it automatically. (Attention: All DB change should have its SQL file in [db/migration](https://github.com/zhouhao/findeasily.net/tree/master/src/main/resources/db/migration) folder)
3. For people who just want to read the source code, you can install [Octotree plugin for Chrome](https://chrome.google.com/webstore/detail/octotree/bkhaagjahfmjljalopjnoealnfndnagc?hl=en-US)

### Tech Details
// todo

### How to Contribute
1. Create your own branch (*Note: name your branch based on the feature*)
2. Commit your changes in your branch
3. Open pull request
4. Merge after CI job (code review, if required)
5. Delete your branch if you want

### Resources 
(*Note*: 对于那些有版权的模板，请不要用于自己的公开项目里面 - 当然自己买了版权除外)
1. The UI template I bought: [Official Demo Link with Images](http://citybook.kwst.net/) & [Provided Html Pages with Image Placeholder `sample/sample`](http://sample.findeasily.net/)
2. The Email template I bought: [Lil Commerce](http://notification-emails.com/transactional-email-templates) - [Already added in this folder](https://github.com/zhouhao/findeasily.net/tree/master/src/main/resources/templates/email)
3. For the test&dev database servers, you can feel free to use them. - *Please do not delete other people's table*.