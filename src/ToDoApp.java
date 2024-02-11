import java.util.Arrays;
import java.util.Scanner;

public class ToDoApp {
    static String[] enterTasks = {};

    public static void removeTask(Scanner input) {
        System.out.println("\n------------------------");
        System.out.println("Tasks: ");
        //display-a taske za izbris
        for(String task: enterTasks){
            System.out.println(task);
        }
        System.out.println("---------------------\nEnter task to remove: ");
        String elemInput = input.nextLine();

        int count = 0;
        for (int i = 0; i < enterTasks.length; i++) {
            if (enterTasks[i].equals(elemInput)) {
                count++;
                // izbriše elemnt
                for (int j = i; j < enterTasks.length - 1; j++) {
                    enterTasks[j] = enterTasks[j + 1];
                }
                enterTasks = Arrays.copyOf(enterTasks, enterTasks.length - 1);
                i--;
            }
        }
    }

    public static void chooseOption(Scanner input) {
        while (true) {
            System.out.println("\n1. Enter Task\n2. Remove Task\n3. Task List\n4. Quit\n---------------------------------- ");
            System.out.println("Choose option: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nEnter Task: ");
                    createTask(input);
                    System.out.println("----------------------");
                    break;
                case 2:
                    removeTask(input);
                    break;
                case 3:
                    System.out.println("\nTasks: ");
                    for (String task : enterTasks) {
                        System.out.println(task);
                    }
                    System.out.println("----------------------");
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option!!!");
            }
        }
    }

    public static void createTask(Scanner input) {
        String task = input.nextLine();
        int newTasksLength = enterTasks.length + 1;
        String[] newTasks = Arrays.copyOf(enterTasks, newTasksLength);
        newTasks[newTasksLength - 1] = task;
        enterTasks = newTasks;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        chooseOption(input);
    }
}
