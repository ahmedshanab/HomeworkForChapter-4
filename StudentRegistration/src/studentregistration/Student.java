/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentregistration;

/**
 *
 * @author LENOVO
 */
class Student {

    private int id;
    private String name;
   private String major;
    private int grade;

    public Student() {
    }
    
   

    public Student(int id, String name, String major, int grade) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

}
