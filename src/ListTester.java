import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListTester {
    public static void main(String[] args)
    {
        MyLinkedList<Actor> list = new MyLinkedList<>();

        File file = new File("actors7.txt");
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

        int num = Integer.parseInt(console.nextLine());
        Actor addActor = new Actor(console.nextLine());
        list.add(num, addActor);

        list.remove(Integer.parseInt(console.nextLine()));

        for(int i = 0; i < 1; i++)
        {
            num = Integer.parseInt(console.nextLine());
            addActor = new Actor(console.nextLine());
            list.add(num, addActor);

            list.remove(Integer.parseInt(console.nextLine()));
        }

        System.out.println(list.size());
        System.out.println(list.toString());

        int[][] mat = new int[0][0];

//        Scanner input = new Scanner(System.in);
//
//        System.out.println("Input plaintext >>> ");
//        String inputUser = input.nextLine();
//
//        String ans = "";
//
//        for(int i = 0; i < inputUser.length() ; i++)
//        {
//            String letter = inputUser.substring(i, i+1);
//
//            if(letter.equals("i"))
//            {
//                ans += "!";
//            } else if(letter.equals("@")){
//                ans += "@";
//            } else if(letter.equals("l")) {
//                ans += "1";
//            } else if(letter.equals("B")) {
//                ans += "8";
//            } else if(letter.equals("E")){
//                ans += "3";
//            } else if(letter.equals("m")){
//                ans += "M";
//            } else if(letter.equals("s")) {
//                ans += "$";
//            } else {
//                ans += letter;
//            }
//        }
//        ans += "z^w";
//        System.out.println(ans);
    }
}
