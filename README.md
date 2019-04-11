# TaipanClone
Computer Science 233 project, Winter 2019

How to run:
If you are using intellij, extract "TaipanClone-master.zip", and open the "TaipanClone-master" folder in intellij. Also set up the SDK. 

Place jfxt.jar, hamcrest-core-1.3.jar and junit-4.12.jar into the src folder
Then, run MainGUI.java.

If you are using the command line, extract "TaipanClone-master.zip", and open the "TaipanClone-master" folder. Open your terminal and change its directory to the "src" folder within "TaipanClone-master" folder.

Then, type in "javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar:jfxrt.jar gui/*.java text/*.java logic/*.java tests/*.java", this compiles all the necessary files. Now, run MainGUI.java using "java MainGUI".

To run the test file PlayerTest.java, type in "javac -cp .;junit-4.12.jar;hamcrest-core-1.3.jar gui/*.java text/*java logic/*.java tests/*.java", this compiles all the necessary files. Now, run PlayerTest.java using "java PlayerTest".

Additional information:

You lose if your HP reaches 0. You can win if you "retire" in Hong Kong while having a net worth of over $1 million.
