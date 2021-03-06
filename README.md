# TaipanClone
Computer Science 233 project, Winter 2019

How to run:
If you are using intellij, extract "TaipanClone-master.zip", and open the "TaipanClone-master" folder in intellij. Also set up the SDK. 

Place jfxt.jar, hamcrest-core-1.3.jar and junit-4.12.jar into the src folder
Then, run MainGUI.java.

# To play the game
If you are using the command line, extract "TaipanClone-master.zip", and open the "TaipanClone-master" folder. Open your terminal and change its directory to the "src" folder within "TaipanClone-master" folder.

Then, if you are using Linux, type in 
```
"javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar:jfxrt.jar gui/*.java text/*.java logic/*.java tests/*.java"
```
Otherwise, if you are using Windows, type in
```
"javac -cp .;junit-4.12.jar;hamcrest-core-1.3.jar;jfxrt.jar gui/*.java text/*.java logic/*.java tests/*.java"
```
This compiles all the necessary files. Now, to play the GUI version run MainGUI.java using 
```
java gui.MainGUI
```
To play the text-based version run MainText.java using
```
java text.MainText
```

# To run the test file PlayerTest.java for Linux type in:
```
javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar:jfxrt.jar gui/*.java text/*.java logic/*.java tests/*.java
```
This compiles all the necessary files. Now, run PlayerTest.java by typing in
```
java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore tests.PlayerTest
```
# To run the test file PlayerTest.java for Windows, type in:
```
javac -cp .;junit-4.12.jar;hamcrest-core-1.3.jar;jfxrt.jar gui/*.java text/*.java logic/*.java tests/*.java
```
This compiles all the necessary files. Now, run PlayerTest.java by typing in
```
java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore tests.PlayerTest
```
Additional information:

You lose if your HP reaches 0. You can win if you "retire" in Hong Kong while having a net worth of over $1 million.
