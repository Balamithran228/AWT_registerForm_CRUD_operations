package org.registerformsskcet;




class StudentRegister
//implements Serializable
{
//    private static final long serialVersionUID = 1L;

    private static int nextID = 1;
    private int studentID;
    private String name;
    private int age;
    private String email;
    private String phoneNumber;
    private String dob;
    private String password;

    public StudentRegister(String name, int age, String email, String phoneNumber, String dob, String password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.password = password;
        this.studentID = nextID++;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // Method to delete student based on studentID
    public boolean deleteStudent(int studentID) {
        return this.studentID == studentID;
    }
    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDob() {
        return dob;
    }

    public String getPassword() {
        return password;
    }
}
