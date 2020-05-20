import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        myHeap H = new myHeap();

        System.out.println("How many items are there? ");
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();

        System.out.println("Input the item, follow by a key: ");

        for (int i = 0; i < n; i++) {
            System.out.println("Please enter the key");
            Integer k = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Please enter the item");
            String t = scanner.nextLine();

            H.insert(t, k);
        }


        System.out.println("The min item is: ");
        System.out.println(H.min());
    }
}
