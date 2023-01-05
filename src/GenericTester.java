import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GenericTester {

    public static void main(String[] args)
    {
        MyLinkedList<Actor> list = new MyLinkedList<>();

        File file = new File("actors4.txt");
        Scanner console = null;
        try {
            console = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int numCases = Integer.parseInt(console.nextLine());

        for(int i = 0; i < numCases; i++)
        {
            Actor actor = new Actor(console.nextLine());
            list.addFirst(actor);
        }

        System.out.println(list.size());

        System.out.println(list.toString());

        System.out.println();

        for(int i = 0; i < 3; i++)
        {
            int num = console.nextInt();
            System.out.println(list.get(num));
        }

        System.out.println();

        //Integers

        MyLinkedList<Integer> numbers = new MyLinkedList<>();
        console.nextLine();
        console.nextLine();

        numCases = Integer.parseInt(console.nextLine());

        for(int i = 0; i < numCases; i++)
        {
            Integer num = console.nextInt();
            numbers.addFirst(num);
        }

        System.out.println(numbers.size());

        for(int i = 0; i < numbers.size(); i++)
        {
            System.out.println(numbers.get(i));
        }



        int sum = 0;
        String s = "";
        for(int i = 0; i < 3; i++)
        {
            int input = console.nextInt();
            int num = numbers.get(input);

            if(i != 2)
            {
                s += num + " + ";
                sum += num;
            } else {
                sum += num;
                s += num + " = " + sum;
            }
        }

        System.out.println(s);
    }
}
