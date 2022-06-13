This file gives some verbal explanations to the project.
This project was developed as a final task for Fullstack Test Automation Course, containing multiple tools and frameworks,
such as Selenium WebDriver, Appium, Rest Assured, ElectronDriver, WinAppDriver, Jenkins, Database connection, all written in Java.

**Please note that this is a demo project to demonstrate my knowledge and abilities, this is not for production (in which case the infra and tests should be separate projects).

Using TestNG, Maven, Allure Reports system, Monte Screen Recorder

Under ./Configuration/DataConfig an XML configuration files, Platform name is configured at TestNG.xml file

Project Structure:
    Infrastructure (under src > main > java):
        extensions - contains actions and verifications
        page objects - initializes page objects
        utilities - contains Base, Common Ops and Managing Pages
        workflows - contains work flows (Specific Steps for tests)

    Tests (under src > test > java > sanity):
        CalculateDesktop - Tests for Calculator app in Windows using WindowsDriver
        ChuckNorrisAPI - Tests for Chuck Norris Jokes' API using Rest-Assured
        MetricConversionsMobile - Tests for Metric Conversions app on mobile using Appium
        MetricConversionsWeb - Tests for Metric Conversions Website using Selenium
        TodolistElectron - Tests for Todolist Electron-based app on Windows using ElectronDriver

#Allure -> "allure serve allure-results -h localhost"

#Remote MySQL Database:
    Free MySQL Server, get credentials and use this data:
    Server: remotemysql.com
    Port: 3306

#Data Driven Testing:
    Under ./DDTFiles there are 2 files:
        bmi.csv is used for MetricConversionsWeb
        calculator.csv is used for CalculatorDesktop
    those are configured according to corresponding suite

#Desktop:
    MAKE SURE WinAppDriver.exe is on

#Jenkins
    to start server -> "java -jar .\jenkins.war --httpPort=9090"
    and go to localhost:9090