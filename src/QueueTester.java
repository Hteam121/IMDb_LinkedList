import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QueueTester
{
    public static void main(String[] args)
    {
        MyLinkedList<Actor> list = new MyLinkedList<>();

        File file = new File("actors6.txt");
        Scanner console = null;
        try {
            console = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < 4; i++)
        {
            Actor addActor = new Actor(console.nextLine());
            list.addFirst(addActor);
            addActor = new Actor(console.nextLine());
            list.addLast(addActor);
        }

        System.out.println(list.size());
        System.out.println(list.toString());

        for(int i = 0; i < 5; i++)
        {
            list.removeFirst();
        }

        System.out.println(list.size());
        System.out.println(list.toString());

        list.clear();
        System.out.println(list.size());

        while(console.hasNextLine())
        {
            Actor addActor = new Actor(console.nextLine());
            list.addLast(addActor);
        }

        System.out.println(list.size());
        System.out.println(list.toString());
    }
}
