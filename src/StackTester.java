import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StackTester {
    public static void main(String[] args)
    {
        MyLinkedList<Actor> list = new MyLinkedList<>();

        File file = new File("actors5.txt");
        Scanner console = null;
        try {
            console = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //adds the first two actors on list
        for(int i = 0; i < 2; i++)
        {
            Actor actor = new Actor(console.nextLine());
            list.addFirst(actor);
        }

        list.removeFirst(); //need to do 1st part
        while(console.hasNextLine())
        {
            Actor actor = new Actor(console.nextLine()); //add one Actor
            list.addFirst(actor);

            actor = new Actor(console.nextLine()); //Add second Actor
            list.addFirst(actor);

            list.removeFirst();
        }

        System.out.println(list.size());
        System.out.println(list.toString());
        list.clear();
        System.out.println(list.size());
    }
}
