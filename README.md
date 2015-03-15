freerice
========

This demo is meant to show how Geb can be used for browser automation.  Freerice.com is a website that shows a user multiple choice questions and for every question the user gets correct the website donates 10 grains of rice to the World Food Program.

**To run this project:**

1. Open a console and navigate to the freerice folder
2. Type gradle wrapper
3. To run the program in chrome type ./gradlew cT -C rebuild


**Notes:**

You could have wrote out chromeTest but gralde lets you abbreviate.
Also gradle doesn't rerun tasks if no changes have been made so -C rebuild makes sure it is run every time
You also could have run the demo in firefox by typing ./gradle fT -C rebuild
