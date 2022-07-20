
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author win
 */
public class Teacher extends Person{
        public final static String job="Teacher";
    private double salary;

    public Teacher(double salary, String name, int age, String add, String ID) {
        super(name, age, add, ID);
        this.salary = salary;
    }
  
    public Teacher() {
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void Input() throws empty {
        Scanner sc = new Scanner(System.in);
        super.Input();
        boolean cont = true;
        do {
            System.out.print("Please enter salary(million):");
            try {
                salary = Double.parseDouble(sc.nextLine());
                if (salary < 0) {
                    throw new Exception();
                }
                cont = false;
            } catch (Exception e) {
                System.out.println("Invalid.Try again!!!");
            }
        } while (cont);
    }

    @Override
    public void tostring() {
        super.tostring();
        System.out.println("Job:"+Student.job);
        System.out.println("Salary:"+getSalary());
    }

}
