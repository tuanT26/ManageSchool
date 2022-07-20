
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class listPerson {

    final int MAX = 100;
    int numberofhuman;
    Person[] arr;

    public listPerson() {
        arr = new Person[MAX];
        numberofhuman = 0;
    }

    public boolean add(Person human) {
        if (human == null || numberofhuman > MAX || checkId(human) == false) {
            return false;
        } else {
            arr[numberofhuman] = human;
        }
        numberofhuman++;
        return true;
    }

    public void printf() {
        System.out.println(Person.School);
        System.out.println("----------------------------------------");
        if (numberofhuman == 0) {
            System.out.println("List is empty!!!");
        }
        for (int i = 0; i < numberofhuman; i++) {
            System.out.printf("[%d]\n", i + 1);
            arr[i].tostring();
        }
    }

    public boolean checkId(Person human) {
        for (int i = 0; i < numberofhuman; i++) {
            if (arr[i].getID().equals(human.getID()) == true) {
                return false;
            }
        }
        return true;
    }

    public void listStudent() {
        int cout = 0;
        System.out.println("|stt|\t\t Name|\t\tID|\tAge|\t Addrest| Point |Status|");
        for (int i = 0; i < numberofhuman; i++) {
            if (arr[i] instanceof Student) {
                Student tmp = (Student) arr[i];
                System.out.printf("|  %d|%16s|%12s|%8d|%12s|%6.2f | %s |\n", cout + 1, tmp.getName(),
                        tmp.getID(), tmp.getAge(), tmp.getAdd(), tmp.getPoint(), tmp.getStatus());
                cout++;
            }
        }
        if (cout == 0) {
            System.out.println("List is empty!!!");
        }
    }

    public void listTeacher() {
        int cout = 0;
        System.out.println("|stt|\t\t Name|\t\tID|\tAge|\t Addrest| Salary|");
        for (int i = 0; i < numberofhuman; i++) {
            if (arr[i] instanceof Teacher) {
                Teacher tmp = (Teacher) arr[i];
                System.out.printf("|  %d|%16s|%12s|%8d|%12s|%6.2f |\n", cout + 1, tmp.getName(),
                        tmp.getID(), tmp.getAge(), tmp.getAdd(), tmp.getSalary());
                cout++;
            }
        }
        if (cout == 0) {
            System.out.println("List is empty!!!");
        }
    }

    public boolean sortPoint() {
        for (int i = 0; i < numberofhuman - 1; i++) {
            for (int j = i + 1; j < numberofhuman; j++) {
                if (arr[i] instanceof Student && arr[j] instanceof Student) {
                    if (((Student) arr[i]).getPoint() > ((Student) arr[j]).getPoint()) {
                        Student tmp = (Student) arr[i];
                        arr[i] = (Student) arr[j];
                        arr[j] = tmp;
                    }
                }
            }
        }
        return true;
    }

    public boolean searchID(String id) {
        for (int i = 0; i < numberofhuman; i++) {
            if (id.equals(arr[i].getID())) {
                if (arr[i] instanceof Teacher) {
                    System.out.println("|\t\t Name|\t\tID|\tAge|\t Addrest| Salary|");
                    Teacher tmp = (Teacher) arr[i];
                    System.out.printf("|%20s|%12s|%8d|%12s|%6.2f |\n", tmp.getName(),
                            tmp.getID(), tmp.getAge(), tmp.getAdd(), tmp.getSalary());
                    return true;
                }
                if (arr[i] instanceof Student) {
                    System.out.println("|\t\t Name|\t\tID|\tAge|\t Addrest| Point |Status|");
                    Student tmp = (Student) arr[i];
                    System.out.printf("|%20s|%12s|%8d|%12s|%6.2f | %s |\n", tmp.getName(),
                            tmp.getID(), tmp.getAge(), tmp.getAdd(), tmp.getPoint(), tmp.getStatus());
                    return true;
                }
            }
        }return false;
    }
    public boolean changePoint(String id,double point){
         for (int i = 0; i < numberofhuman; i++){
             if(id.equals(arr[i].getID())&&arr[i] instanceof Student){
                ((Student)arr[i]).setPoint(point);
             return true;
             }
         }
         return false;
    }
    public boolean remove(String id){
        List<Person> list=new ArrayList<Person>(Arrays.asList(arr));
        for (int i = 0; i < numberofhuman; i++) {
            if(id.equals(arr[i].getID())){
              list.remove(i);
               arr = list.toArray(new Person[0]);
              numberofhuman--;
              return true;
            }
        }return false;
    }

}
