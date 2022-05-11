/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brothrock
 */
public class Student {
    //attributes
    private int id;
    private String name;
    private double test1;
    private double test2;
    private double test3;
    
    
    // constructors
    public Student() {
        id = 0;
        name = "unknown";
        test1 = 0.0;
        test2 =0.0;
        test3 = 0.0;
    }
    
    public Student(int id, String name, double test1, double test2, double test3) {
        this.id = id;
        this.name = name;
        this.test1 = test1;
        this.test2 = test2;
        this.test3 = test3;
    }
    
    // behaviors
    @Override
    public String toString() {
        return name;
    }
    
    public double calculateAverage(){
        return (test1 + test2 + test3 / 3.0);
    }
    
    public String calculateLetterGrade(){
        double avg = calculateAverage();
        
        if(avg >= 9.0)
            return "A";
        else if (avg >= 80)
            return "B";
        else if (avg >= 70)
            return "C";
        else if (avg >= 60)
            return "D";
        else
            return "F";
    }
    
    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTest1() {
        return test1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTest1(double test1) {
        this.test1 = test1;
    }

    public double getTest2() {
        return test2;
    }

    public void setTest2(double test2) {
        this.test2 = test2;
    }

    public double getTest3() {
        return test3;
    }

    public void setTest3(double test3) {
        this.test3 = test3;
    }
        
    
}
