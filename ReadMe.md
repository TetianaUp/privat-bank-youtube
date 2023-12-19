# Test automation framework for YouTube testing
## Build: TestNg, Selenium, Java(version 11), Maven



### Run tests in suits
example:
```bash
mvn -DsuiteXmlFile=youtubeSearch.xml test
```
```bash
mvn -DsuiteXmlFile=chanelCheck.xml test
```
#### See allure-reports

```bash
mvn allure:serve