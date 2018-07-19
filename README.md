### Task description

https://docs.google.com/document/d/1CoPMJ-vTboUOMPmETUhw1S61tIXuBmNLYwiHBK5109g

###Settings

Used next capabilities:

```
{
   "deviceName": "Nexus 5 API 26",
   "udid": "emulator-5554",
   "platformName": "Android",
   "platformVersion": "8.0",
   "appPackage": "com.todoist",
   "appActivity": "com.todoist.activity.HomeActivity"
 }
 ```

Make sure you have installed **Maven, Java(8+), Android SDK(26)**. 
To check if everything is installed you can use command `appium-doctor`, example of correct output is:

```
 info AppiumDoctor Appium Doctor v.1.4.3
 info AppiumDoctor ### Diagnostic starting ###
 info AppiumDoctor  ✔ The Node.js binary was found at: /usr/local/bin/node
 info AppiumDoctor  ✔ Node version is 9.11.1
 info AppiumDoctor  ✔ Xcode is installed at: /Library/Developer/CommandLineTools
 info AppiumDoctor  ✔ Xcode Command Line Tools are installed.
 info AppiumDoctor  ✔ DevToolsSecurity is enabled.
 info AppiumDoctor  ✔ The Authorization DB is set up properly.
 info AppiumDoctor  ✔ HOME is set to: /Users/mikhailzlochevskyi
 info AppiumDoctor  ✔ ANDROID_HOME is set to: /Users/mikhailzlochevskyi/Library/Android/sdk
 info AppiumDoctor  ✔ JAVA_HOME is set to: /Library/Java/JavaVirtualMachines/jdk1.8.0_161.jdk/Contents/Home
 info AppiumDoctor  ✔ adb exists at: /Users/mikhailzlochevskyi/Library/Android/sdk/platform-tools/adb
 info AppiumDoctor  ✔ android exists at: /Users/mikhailzlochevskyi/Library/Android/sdk/tools/android
 info AppiumDoctor  ✔ emulator exists at: /Users/mikhailzlochevskyi/Library/Android/sdk/tools/emulator
 ```
 
And also make sure you have up Android virtual device (with installed Todoist apk) and run Appium server on host:
`127.0.0.1:4723`

### Execution

Please use next command to execute the test suite:

`mvn clean test`

Results would be printed to console.