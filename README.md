# Promela_sketcher


1. Install SPIN (Version 6.4.5) and add its directory to your search path, such that the following commands are runnable: 
>> spin -a *.pml
>> gcc -o pan pan.c
>> ./pan -a -n -N p

2. Download Promela_sketcher in the same directory

3. Run the tool by:
>> java -cp "antlr-4.5.3-complete.jar:." Root simple.pml

5. The assertions and deadlock-freedom for fwarm*-*.pml and minepumpARP.pml are checked automatically without specfying additional arguments.
>> java -cp "antlr-4.5.3-complete.jar:." Root minepumpARP.pml

