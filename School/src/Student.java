/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author win
 */
public class Student extends Person {

    public final static String job = "Student";
    private double point;
    private String status;

    public Student(int point, String name, int age, String add, String ID) {
        super(name, age, add, ID);
        this.point = point;
    }

    public Student() {
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
        if (point >= 5) {
            status = "PASS";
        } else {
            status = "FAIL";
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void Input() throws empty {
        Scanner sc = new Scanner(System.in);
        super.Input();
        boolean cont = true;
        do {
            System.out.print("Please enter  point:");
            try {
                point = Double.parseDouble(sc.nextLine());
                if (point < 0 || point > 10) {
                    throw new Exception();
                }
                cont = false;
            } catch (Exception e) {
                System.out.println("Invalid.Try again!!!");
            }
        } while (cont);
        if (point >= 5) {
            setStatus("PASS");
        } else {
            setStatus("FAIL");
        }
    }

    @Override
    public void tostring() {
        super.tostring();
        System.out.println("Job:" + Student.job);
        System.out.println("Point:" + getPoint());
    }

}
