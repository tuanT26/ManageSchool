
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
public class School {

    public static void main(String[] args) throws empty {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        char s;
        listPerson list = new listPerson();
        do {
            boolean cont = true;
            do {
                try {
                    menu();
                    choice = Integer.parseInt(sc.nextLine());
                    cont = false;
                } catch (Exception e) {
                    System.out.println("Invalid.Try again!!!");
                    System.out.println("--------------------");

                }
            } while (cont);
            switch (choice) {
                case 1:
                    Person tmp = new Student();
                    tmp.Input();
                    if (list.add(tmp) == false) {
                        System.out.println("ID already exists. Can't add");
                        System.out.println("---------------------");

                    }
                    break;
                case 2:
                    Person tmp2 = new Teacher();
                    tmp2.Input();
                    if (list.add(tmp2) == false) {
                        System.out.println("ID already exists. Can't add");
                        System.out.println("---------------------");
                    }
                    break;
                case 3:
                    list.printf();
                    break;
                case 4:
                    list.listStudent();
                    break;
                case 5:
                    list.listTeacher();
                    break;
                case 6:
                    if (list.sortPoint()) {
                        System.out.println("Sorting success!!!");
                    }
                    break;
                case 7:
                    System.out.println("Please enter ID:");
                    String id = sc.nextLine();
                    if (!list.searchID(id)) {
                        System.out.println("Not found!!!");
                    }
                    break;
                case 8:
                    System.out.println("Please enter ID:");
                    String id1 = sc.nextLine();
                    Double point = null;
                    boolean cont1 = true;
                    do {
                        System.out.print("Please enter  point:");
                        try {
                            point = Double.parseDouble(sc.nextLine());
                            if (point < 0 || point > 10) {
                                throw new Exception();
                            }
                            cont1 = false;
                        } catch (Exception e) {
                            System.out.println("Invalid.Try again!!!");
                        }
                    } while (cont1);
                    if (!list.changePoint(id1, point)) {
                        System.out.println("Can not change point!!!");
                        System.out.println("________________________");
                    } else {
                        System.out.println("Successful!!!");
                    }
                    break;
                case 9:
                    System.out.println("Please enter ID:");
                    String id2 = sc.nextLine();
                    if (!list.remove(id2)) {
                        System.out.println("Not found!!!");
                    }else{
                        System.out.println("Successful!!!");
                    }
                    break;
            }
            System.out.print("Continue?(Y):");
            s = sc.nextLine().charAt(0);
        } while (s == 'y' || s == 'Y');

    }

    public static void menu() {
        System.out.println("!!!Wecome to my program!!!");
        System.out.println("1.Add Student to list");
        System.out.println("2.Add Teacher to list");
        System.out.println("3.Print a list of all");
        System.out.println("4.Display table format student list");
        System.out.println("5.Display table format teacher list");
        System.out.println("6.Sort students by grade ascending");
        System.out.println("7.Search by ID");
        System.out.println("8.Change student score");
        System.out.println("9.Remove Student or Teacher to list");
        System.out.print("Please enter your choice:");
    }

}
