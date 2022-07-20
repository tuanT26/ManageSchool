
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
public class Person {
    public static final String School = "FPT University";
    private String name;
    private int age;
    private String add;
    private String id;
    public Person(String name, int age, String add, String ID) {
        this.name = name;
        this.age = age;
        this.add = add;
        this.id = ID;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getID() {
        return id;
    }

    public void setID(String ID) {
        this.id = ID;
    }

    public void Input() throws empty {
        Scanner sc = new Scanner(System.in);
                do {
            try {
                System.out.print("Please enter ID:");
                id = sc.nextLine();
                if (id.isEmpty() == true) {
                    throw new empty();
                } else {
                    id = formString(id);
                }
            } catch (empty e) {
            }
        } while (id.isEmpty());
        do {
            try {
                System.out.print("Please enter name:");
                name = sc.nextLine();
                if (name.isEmpty() == true) {
                    throw new empty();
                } else {
                    name = formString(name);
                }
            } catch (empty e) {
            }
        } while (name.isEmpty());
        boolean cont = true;
        do {
            System.out.print("Please enter age:");
            try {
                age = Integer.parseInt(sc.nextLine());
                if (age < 0) {
                    throw new Exception();
                }
                cont = false;
            } catch (Exception e1) {
                System.out.println("Invalid,Try again!!!");
            }
        } while (cont);
        do {
            System.out.print("Please enter addrest:");
            try {
                add = sc.nextLine();
                if (add.isEmpty() == true) {
                    throw new empty();
                } else {
                    add = formString(add);
                }
            } catch (empty e) {
            }
        } while (add.isEmpty());
        
    }

    private String formString(String a) {
        a = a.toLowerCase().trim();// trim xoa khoang trang dau va cuoi chuoi
        a = a.replaceAll("\\s+", " ");// sua tat ca xau co 2 khoang trang lien tuc thanh 1 khang trang...
        char[] s = a.toCharArray();
        s[0] = Character.toUpperCase(s[0]);
        for (int i = 0; i < a.length(); i++) {
            if (s[i] == ' ') {
                if (Character.isLetter(s[i + 1]) == true) {
                    s[i + 1] = Character.toUpperCase(s[i + 1]);
                }
            }
        }
        a = String.valueOf(s);
        return a;
    }

    public void tostring() {
        System.out.println("ID:"+getID());
        System.out.println("Name:"+getName());
        System.out.println("Age:"+getAge());
        System.out.println("Addrest:"+getAdd());
    }

}
