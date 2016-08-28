CS3219 Assignment1 - KWIC
==============================================

### Intro
KWIC is a system that outputs alphabetically sorted list of circularly shifted lines generated from a list of titles. Each title will be circularly shifted repeatedly by removing the first word and appending at the end of the line.

### Instructions to run KWIC system on command-line interface
- Go to the directory that contains ```Main.java```.<br />
- Run the following:
```
javac Main.java
java Main
```

### Interface
1. Select an architecture to run: 1) Shared Data or 2) Pipe and Filter.<br />
2. Enter a valid input file name that contains a list of words to ignore (Each word is separated by new line). A valid input file name is file name that exist in src folder.<br />
3. Enter a valid input file name that contains a list of titles (Each title is separated by new line). A valid input file name is file name that exist in src folder.<br />
4. Enter a valid output file name. If no directory is specified, the output file will be stored in the src folder.<br />
5. The total execution time for the architecture will be displayed.<br />
6. Select either 'y' for yes to continue using the system or 'n' for no to terminate the system.<br />

```
Welcome to KWIC system.

Please select the architecture of your choice, either '1' or '2':
1. Shared Data Architecture
2. Pipe and Filter Architecture
Enter your choice: 1

Enter the input file name for words to ignore 
>> Ensure file is in src folder and separate each word by new line: word.txt
Enter the input file name for titles 
>> Ensure file is in src folder and separate each title by new line: title.txt
Enter the output file name: shareddata.txt
>>> Output is saved in file: shareddata.txt
Total execution time: 14855 ms

Would you like to continue using the system? (y/n): y


Please select the architecture of your choice, either '1' or '2':
1. Shared Data Architecture
2. Pipe and Filter Architecture
Enter your choice: 2

Enter the input file name for words to ignore 
>> Ensure file is in src folder and separate each word by new line: word.txt
Enter the input file name for titles 
>> Ensure file is in src folder and separate each title by new line: title.txt
Enter the output file name: pipeandfilter.txt       
>>> Output is saved in "pipeandfilter.txt"
Total execution time: 14855 ms

Would you like to continue using the system? (y/n): n
Thank you for using KWIC system.
```
