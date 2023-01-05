import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class IMDb {

    public static void main(String[] args)
    {
        //Actor
        MyLinkedList<Actor> listActor = new MyLinkedList<>();

        File file = new File("actors10.txt");
        Scanner console = null;
        try {
            console = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(console.hasNextLine())
        {
            Actor addActor = new Actor(console.nextLine().trim());
            listActor.addLast(addActor);
        }

        //Movie

        MyLinkedList<Movie> listMovie = new MyLinkedList<>();

        file = new File("movies10.txt");
        console = null;
        try {
            console = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //add onto "list"
        while(console.hasNextLine())
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
            listMovie.addFirst(temp);
        }

        //Printing
        Iterator it = listActor.iterator();
        while(it.hasNext())
        {
            Actor tempActor = (Actor) it.next();
            System.out.println(tempActor.getName());

            Iterator movies = listMovie.iterator();
            while(movies.hasNext())
            {
//                System.out.println("Ran once");
                Movie tempMovie = (Movie) movies.next();
                MyLinkedList<Actor> actors = tempMovie.getActors();

//                System.out.println(actors.size());
                Iterator actorsTemp = actors.iterator();
                while(actorsTemp.hasNext()) {
                    Actor t = (Actor) actorsTemp.next();
//                    System.out.println("\t" + tempMovie.getDate() + " " + tempMovie.getTitle());
//                    System.out.println(t + " == " + tempActor);
                    if (tempActor.getName().equals(t.getName())){
                        System.out.println("  " + tempMovie.getDate() + " " + tempMovie.getTitle());
                    }
                }
            }
            System.out.println();
        }

    }
}
