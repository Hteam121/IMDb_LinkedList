import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class IteratorTester {

    public static void main(String[] args)
    {
        MyLinkedList<Actor> list = new MyLinkedList<>();

        File file = new File("actors9.txt");
        Scanner console = null;
        try {
            console = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < 10; i++)
        {
            Actor addActor = new Actor(console.nextLine());
            list.addLast(addActor);
        }

        System.out.println(list.size());

        Iterator it = list.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }

        Actor addActor = new Actor(console.nextLine());
        it = list.iterator();

        while(it.hasNext())
        {
            Actor compare = (Actor) it.next();
            if(compare.getName().equals(addActor.getName()))
            {
                it.remove();
            }
        }

        System.out.println();
        System.out.println(list.size());
        it = list.iterator();
        for(Object a : list)
            System.out.println(a);
    }
}
