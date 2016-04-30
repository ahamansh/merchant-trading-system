# Merchant Trading System - Question JAVA  Solution

Merchant Trading system is a solution to question
<b>Problem One: Merchant's Guide to the Galaxy</b>

You decided to give up on earth after the latest financial collapse left 99.99% of the earth's population with 0.01% of the wealth. Luckily, with the scant sum of money that is left in your account, you are able to afford to rent a spaceship, leave earth, and fly all over the galaxy to sell common metals and dirt (which apparently is worth a lot).

Buying and selling over the galaxy requires you to convert numbers and units, and you decided to write a program to help you.

The numbers used for intergalactic transactions follows similar convention to the roman numerals and you have painstakingly collected the appropriate translation between them.

Roman numerals are based on seven symbols:

Symbol | Value
------ | -----
I|1
V|5
X|10
L|50
C|100
D|500
M|1,000


Numbers are formed by combining symbols together and adding the values. For example, MMVI is 1000 + 1000 + 5 + 1 = 2006. Generally, symbols are placed in order of value, starting with the largest values. When smaller values precede larger values, the smaller values are subtracted from the larger values, and the result is added to the total. For example MCMXLIV = 1000 + (1000 − 100) + (50 − 10) + (5 − 1) = 1944.

The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. (They may appear four times if the third and fourth are separated by a smaller value, such as XXXIX.) "D", "L", and "V" can never be repeated.
"I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only. "C" can be subtracted from "D" and "M" only. "V", "L", and "D" can never be subtracted.
Only one small-value symbol may be subtracted from any large-value symbol.
A number written in [16]Arabic numerals can be broken into digits. For example, 1903 is composed of 1, 9, 0, and 3. To write the Roman numeral, each of the non-zero digits should be treated separately. Inthe above example, 1,000 = M, 900 = CM, and 3 = III. Therefore, 1903 = MCMIII.
(Source: Wikipedia ( [17]http://en.wikipedia.org/wiki/Roman_numerals)

Input to your program consists of lines of text detailing your notes on the conversion between intergalactic units and roman numerals.

You are expected to handle invalid queries appropriately.

Test input:
1. glob is I
2. prok is V
3. pish is X
4. tegj is L
5. glob glob Silver is 34 Credits
6. glob prok Gold is 57800 Credits
7. pish pish Iron is 3910 Credits
8. how much is pish tegj glob glob ?
9. how many Credits is glob prok Silver ?
10. how many Credits is glob prok Gold ?
11. how many Credits is glob prok Iron ?
12. how much wood could a woodchuck chuck if a woodchuck could chuck wood ?

Test Output:
1. pish tegj glob glob is 42
2. glob prok Silver is 68 Credits
3. glob prok Gold is 57800 Credits
4. glob prok Iron is 782 Credits
5. I have no idea what you are talking about

### Version
1.0.0

### Assumption
Assumptions are as followed:

Input related Assumptions:
1. Parsing the input is through reg expression
2. Inputs are case sensitive and space sensitive
	Gold is not gold
	glob is not Glob
3. For deciding the market rates e.g. one is I, "one" should be in small letters and I sholuld be in Roman letters
4. Credits should start with Capital letter. Credits should not be in decimal or negetive value (For the current system)
5. Question should end in " ?" with a space followed by ?
6. "how much is" question is used for only Market rate to number conversion should not be used for credits info
		e.g. hundred one five Bhindi is 987 Credits amd one is I
			Que: how much is one five Bhindi ?   
*  This Will not be considered, as Bhindi is a considered as comodity not market rates -
			Que: how much is one five hundred ? ---> Valid question, if Validation passes :P
7. how many Credits is Silver ? (Needs to have a market rate before Comodity)  ---->  "NOT" SAME AS    ----> how many Credits is one Silver ?

### Instructions for starting the system

* Import the attached project into your IDE
* Run com.mts.entry.StartSystem as java application

The above steps are manual for now which can later be enhanced using maven.

For Testing Scenario you need to have log4j and junit in your build path. You can directly run AllTest Suite to complete the testing process

