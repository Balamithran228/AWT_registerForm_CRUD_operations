# AWT_registerForm_CRUD_operations
AWT java application CRUD oprations with search functionality


# AWT Java Registration Form

This is a simple Java application that demonstrates a user registration form using AWT (Abstract Window Toolkit) for the GUI. The registration form allows users to input their name, age, email, phone number, date of birth, and password. The application performs validation on the input fields and displays appropriate error messages for invalid input.

## Features

- User-friendly registration form GUI built using AWT components.
- Input field validations for name, age, email, phone number, date of birth, and password.
- Proper error messages displayed for invalid inputs.
- Successful registration message displayed on successful registration.
- Ability to view the registered student details in a separate window.
- Options to update and delete student records.
- Search functionality to find a student by ID.

## Prerequisites

To run the application, you need the following software installed on your machine:

- Java Development Kit (JDK) 8 or higher.
- An Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse.

## How to Run

## How to Run the AWT Java Registration Form Application

To run the AWT Java registration form application, follow the steps below:

1. **Clone the Repository:**
   - Open your terminal (for Mac/Linux) or Git Bash (for Windows).
   - Navigate to the directory where you want to clone the repository.
   - Run the following command to clone the repository:
     ```
     git clone <repository_url>
     ```
   - Change into the cloned repository directory:
     ```
     cd <repository_name>
     ```

2. **Compile Java Files:**
   - Make sure you have Java Development Kit (JDK) installed on your system.
   - Inside the repository folder, navigate to the `org/package/example` directory:
     ```
     cd org/package/example
     ```
   - Compile the Java files using the `javac` command:
     ```
     javac Main.java StudentRegister.java RegisterForm.java
     ```

3. **Run the Application:**
   - After successful compilation, run the application using the `java` command:
     ```
     java Main
     ```

4. **Registration Form GUI:**
   - The application window will open, displaying the registration form GUI.
   - Fill in the required details (Name, Age, Email, Phone Number, Date of Birth, Password, Confirm Password).
   - Click the "Register" button to submit the form.

5. **Validation Messages:**
   - The application performs validation for each field based on the specified regex patterns.
   - If any field is not valid, an error message will be displayed with the corresponding issue(s).
   - If all fields pass validation, a success message will be shown, and the data will be stored in memory.

6. **View Student Details:**
   - After successful registration, click the "View" button to see the registered student details in a new window.
   - The student details will be displayed in a table format.

7. **Update and Delete Students:**
   - In the student details window, select a row to update or delete a student's information.
   - Click the "Update" button to modify the selected student's data.
   - Click the "Delete" button to remove the selected student from the list.

8. **Search for a Student:**
   - In the student details window, click the "Search" button to search for a student by ID.
   - Enter the student ID in the dialog box to find the corresponding student's details.

9. **Close the Application:**
   - Close the application window or the student details window when you are done using the application.

**Note:** Make sure to have the required Java Development Kit (JDK) installed on your system to successfully compile and run the application.

Enjoy using the AWT Java registration form application for managing student data! If you encounter any issues or have questions, feel free to raise them in the repository's issues section. Happy coding!

## Screenshots

![Student Details](/screenshots/student_details.png)
![Registration Form](https://github.com/Balamithran228/AWT_registerForm_CRUD_operations/assets/73731940/68677a71-2b37-40c4-99ab-1283cde3b9de)
![Registration Form](https://github.com/Balamithran228/AWT_registerForm_CRUD_operations/assets/73731940/7841ce88-0474-42f3-b537-843da9143a18)
![Table_record_CRUD](https://github.com/Balamithran228/AWT_registerForm_CRUD_operations/assets/73731940/245cd6da-ab1b-4be3-8c01-37da519facc8)
![Table_record_CRUD search](https://github.com/Balamithran228/AWT_registerForm_CRUD_operations/assets/73731940/e11fc968-25ca-4c51-8601-903cc0b7a686)

## Contribution

Contributions are welcome! Feel free to open issues and pull requests for any enhancements or bug fixes.

## Author

This project was created by [BalamithranS](https://github.com/Balamithran228).

