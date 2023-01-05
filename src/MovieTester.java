import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MovieTester {
    public static void main(String[] args)
    {
        MyLinkedList<Movie> list = new MyLinkedList<>();

        File file = new File("actors8.txt");
        Scanner console = null;
        try {
            console = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //add onto "list"
        for(int i = 0; i < 10; i++)
        {
            MyLinkedList<Actor> actors = new MyLinkedList<>();
            MyLinkedList<String> directors = new MyLinkedList<>();

            String line = console.nextLine();
            int date = Integer.parseInt(line.substring(0, 4));
            String title = line.substring(5, 38).trim();
            String[] actorNames = line.substring(38, 84).trim().split(", ");
            String[] directorsNames = line.substring(89).trim().split(", ");

            for(int b = 0; b < actorNames.length; b++)      //add actors
            {
                Actor temp = new Actor(actorNames[b]);
                actors.addLast(temp);
            }

            for(int c = 0; c < directorsNames.length; c++)  //add directors
                directors.addLast(directorsNames[c]);

            Movie temp = new Movie(date, title, actors, directors);
            list.addFirst(temp);
        }

        //Part 2 of main
        System.out.println(list.size());
        int num1 = console.nextInt();
        int num2 = console.nextInt();
        System.out.println(list.get(num1).toString());
        System.out.println(list.get(num2).toString());
        System.out.println(list.get(num1).getTitle() + " has " + list.get(num1).getActors().size() + " major actors");
        System.out.println(list.get(num2).getTitle() + " has " + list.get(num2).getDirectors().size() + " directors");
    }
}
