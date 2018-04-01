package RampantRandomizer_18_4;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;

public class RampantRandomizer extends repeater {

    //Program Info
    private static String version = "v18.4";
    private static String build = "";

    //Repeat Values
    private static String repeat = "Yes";
    private static int repeatValue = 1;
    private static String filerepeat = "No";
    private static int fileValue = 0;

    //Value Strings
    private static String value1 = "";
    private static String value2 = "";
    private static String value3 = "";
    private static String value4 = "";
    private static String value5 = "";

    public static void main (String[] args) {
        System.out.println("Rampant Randomizer " + version);
        while (repeatValue == 1 && fileValue == 0) {
            Scanner reader = new Scanner(System.in);
            System.out.println("Enter a filename: ");
            String name = reader.next();
            String filename = "./" + name + ".txt";
            File file = new File(filename);
            if (file.exists()) {
                LinkedList<String> list = new LinkedList<String>();
                try {
                    Scanner sc = new Scanner(new FileInputStream(file));
                    while (sc.hasNextLine()) {
                        String content = sc.nextLine();
                        list.add(content);
                    }
                    sc.close();
                } catch (FileNotFoundException fnf) {
                    fnf.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("\nProgram terminated Safely...");
                }
                fileValue = 1;
                //while (repeatValue == 1 && fileValue == 1) {
                Collections.shuffle(list);
                Iterator<String> it = list.iterator();
                while (repeatValue == 1 && fileValue == 1) {
                    String value = "";
                    int i = 0;
                    if (it.hasNext() && i < 5) {
                        value1 = it.next();
                        value2 = it.next();
                        value3 = it.next();
                        value4 = it.next();
                        value5 = it.next();
                        i = i+5;
                        System.out.println("\nYour Value Is:");
                        System.out.println(value1 + " | " + value2 + " | " + value3 + " | " + value4 + " | " + value5 + "\n");
                    } else {
                        value = "End of file found. Try another file.";
                        System.out.println("\nYour Value Is:");
                        System.out.println(value + "\n");
                    }
                    //String value = it.next();
                    System.out.println("Retry using the same file? (Enter Yes or No)");
                    filerepeat = reader.next();
                    fileValue = repeater(filerepeat);
                    if (fileValue == 0) {
                        System.out.println("Try using a different file? (Enter Yes or No)");
                        repeat = reader.next();
                        repeatValue = repeater(repeat);
                    } else {
                        repeatValue = 1;
                    }
                }
            } else {
                System.out.println("The file does not exist. Make sure the file is in the same folder as the program and try again.");
                System.out.println("Do you want to try again? (Enter Yes or No)");
                repeat = reader.next();
                repeatValue = repeater(repeat);
            }
        }
    }
}