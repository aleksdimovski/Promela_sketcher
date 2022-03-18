# Promela_sketcher


1. Install SPIN (Version 6.4.5) and add its directory to your search path, such that the following commands are runnable: 
>> spin -a *.pml
>> gcc -o pan pan.c
>> ./pan -a -n -N p

2. Download Promela_sketcher in the same directory

3. Compile the tool:
>> java -jar antlr-4.8-complete.jar Promela.g4 -visitor
>> javac -cp "antlr-4.8-complete.jar:." Promela*.java
>> javac -cp "antlr-4.8-complete.jar:." Root.java

4. Run the tool by resolving simple.pml:
>> java -cp "antlr-4.8-complete.jar:." Root simple.pml


