**Description**

https://docs.google.com/document/d/1CoPMJ-vTboUOMPmETUhw1S61tIXuBmNLYwiHBK5109g

**Settings**

Used next capabilities:

`{
   "deviceName": "Nexus 5 API 26",
   "udid": "emulator-5554",
   "platformName": "Android",
   "platformVersion": "8.0",
   "appPackage": "com.todoist",
   "appActivity": "com.todoist.activity.HomeActivity"
 }`

Make sure you have installed Maven, Java(8+), Android SDK(26).
And you have up Android virtual device (with installed Todoist apk) and run Appium server on host:
`127.0.0.1:4723`

**Execution**

Please use next command to execute the test suite:

`mvn clean test`

Results would be printed to console.