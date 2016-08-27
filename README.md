CS3219 Assignment1 - KWIC
==============================================

### Intro
KWIC is a system that outputs alphabetically sorted list of circularly shifted lines generated from a list of titles. Each title will be circularly shifted repeatedly by removing the first word and appending at the end of the line.

### Instructions to run KWIC system

#### 1. Run on Eclipse
- Make sure that Java 8 is installed in Eclipse.

#### 2. Run on command line
- Go to the directory that contains ```Main.java```.<br />
- Run the following:
```
javac Main.java
java Main
```

### Interface
1. Select an architecture to run: 1) Shared Data or 2) Pipe and Filter.<br />
2. Enter a valid input file name for words to ignore. The file must exist in the src folder.<br />
3. Enter a valid input file name for titles. The file must exist in the src folder.<br />
4. Enter a valid output file name. If no directory is specified, the output file will be stored in the src folder.<br />
5. The total execution time for the architecture will be displayed.<br />
6. Select either 'y' for yes to continue using the system or 'n' for no to terminate the system.<br />

```
Welcome to KWIC system.

Please select the architecture of your choice, either '1' or '2':
1. Shared Data Architecture
2. Pipe and Filter Architecture
Enter your choice: 1

Enter the input file name for words to ignore (Separate each word by new line): word.txt
Enter the input file name for titles (Separate each title by new line): title.txt
Enter the output file name: out.txt
>>> Output is saved in file: out.txt
Total execution time: 7076 ms

Would you like to continue using the system? (y/n): n
Thank you for using KWIC system.
```
