# Vadym G Test

This is a page object based solution.

## Setup

### Install on Local Machine

Install Java & Maven on your local machine

Build the project (it should download all required dependencies from pom.xml):
```
> mvn clean install -DskipTests
```

Run the tests on local machine. 
```
> mvn test -DsiteUrl=https://www.dbzeitarbeit.de/ -DbrowserName="googlechrome"
```

Other options (ie / chrome / firefox / safari):

- Test with Google Chrome (Mac / Windows for machineType):
```
> mvn test -DsiteUrl=https://www.dbzeitarbeit.de -DbrowserName="googlechrome" -DmachineType="mac"
```

- Test with Firefox (Mac / Windows for machineType):
```
> mvn test -DsiteUrl=https://www.dbzeitarbeit.de -DbrowserName="firefox" -DmachineType="mac"
```

- Test with IE (Windows Only):
```
> mvn test -DsiteUrl=https://www.dbzeitarbeit.de -DbrowserName="ie"
```

- Test with Safari 
```
> mvn test -DsiteUrl=https://www.dbzeitarbeit.de -DbrowserName="safari"
```
