# meetup

Feb 7 ATL Clj Meetup

## Usage

We’ll be creating a little calculator that produces a person’s blood alcohol content (BAC)

1. Download Nightcode IDE
https://sekao.net/nightcode/
2. Download the sample project. 
 
3. In Nightcode, press the import button to import the project
4. Press ‘build’ to make sure the project compiles
5. Press the “Run with REPL” button in the IDE
	- Go into the test namespace (ns meetup.bac-tests)
	- Run the tests (run-tests)

The tests should fail.  Your goal is to do the following:

Step 1
In the bac namespace, flesh out the following two functions until 1 of the 2 tests pass
	- gender->constant
	- calculate-bac
The function to calculate bac is:
BAC = [(total beverages in grams) / (gender constant * weight in grams)] - DTOX, where DTOX = 0.015 * the number of hours a person has been drinking

Step 2
I completed the get-feedback function, but I messed up on the corresponding get-feedback-tests.  What is the problem there?  Please fix get-feedback-tests
Hint: Stubs


