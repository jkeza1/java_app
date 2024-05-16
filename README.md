# java_app
UniqueInt App
Introduction
The UniqueInt application processes input text files containing integers and outputs a text file with unique integers sorted in ascending order.

Requirements
Java Development Kit (JDK) 8 or higher
How to Run

Clone the Repository:

'''bash

git clone <repository_url>

'''

'''bash

cd UniqueInt

'''

#Compile the Java Code:

Compile the UniqueInt.java file using the Java compiler (javac):

'''bash

javac UniqueInt.java

'''

#Run the Application:

Run the compiled Java application using the Java interpreter (java), providing the input folder path:

'''bash

java UniqueInt

'''

Replace <input_folder_path> with the path to the folder containing the input text files.

Example:

'''bash

java UniqueInt /path/to/input_folder

'''

View Output:

Once the application finishes processing, the output text files will be generated in the specified output folder (/root/work/results by default). Each output file will contain unique integers sorted in ascending order from the corresponding input file.

Notes
Input files must have a .txt extension and contain one integer per line.
Output files will be generated in the /root/work/results directory by default. You can change the output directory by modifying the outputFolder variable in the UniqueInt.java file.
