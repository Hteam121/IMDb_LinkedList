//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class NodeTester {
//    public static void main(String[] args)
//    {
//        File file = new File("Part 1 actors.txt");
//        Scanner console = null;
//        try {
//            console = new Scanner(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        Actor head = null;
//
//        while(console.hasNextLine())
//        {
//            String name = console.nextLine();
//            Actor s = new Actor(name);
//            s.setNextPtr(head);
//            head = s;
//        }
//
//        Actor currentPointer = head;
//
//        while(currentPointer != null)
//        {
//            if(!currentPointer.getName().equals(""))
//            {
//                System.out.println(currentPointer.getName());
//                currentPointer = currentPointer.getNextPtr();
//            } else {
//                currentPointer = currentPointer.getNextPtr();
//            }
//        }
//    }
//}
