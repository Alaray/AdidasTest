Selenium library was used for browser ui automation.
For creating test scenarios in BDD approach I used Cucumber library.
Test runner for running those scenarios is testng.
WebdriverManager library was used to simplify the process of setting up drivers for different browsers.

I started implementing test scenarios with creating feature file where I define the steps
and provide data for extending the reliability of scenario.
Then the file with steps definition was created. It contains the initialization of driver
and the required page objects as a precondition for scenarios execution and the calls to 
appropriate page objects in steps methods.
After that page objects with low-level browser interactions were created.
The last thing was the browser setup file.

