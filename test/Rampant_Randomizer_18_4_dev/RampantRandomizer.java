package Rampant_Randomizer_18_4_dev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;

public class RampantRandomizer extends JFrame {
    //Program Info
    private static String programName = "Rampant Randomizer";
    private static String version = " v.18.4";
    private static String build = " Build 33118.1915";

    //Repeat Values
    private static String repeat = "Yes";
    private static int repeatValue = 1;
    private static String filerepeat = "No";
    private static int fileValue = 0;

    //Value Strings
    private static String value = "";
    private static String value1 = "";
    private static String value2 = "";
    private static String value3 = "";
    private static String value4 = "";
    private static String value5 = "";

    //GUI Config
    private Container contents;
    private JPanel dialog;
    private JPanel buttons;
    private JPanel top;
    private JLabel fileNameDescription1;
    private JLabel fileNameDescription1Space;
    private JLabel fileNameDescription2;
    private JTextField fileNameEntry;
    private JButton randomize;
    private JButton multiRandomize;
    private JButton randomExport;
    private JTextArea result;
    private JButton clearEntry;

    //GUI Setup
    public RampantRandomizer(){
        super(programName + version + build);

        //Layout
        contents = getContentPane();
        contents.setLayout(new BorderLayout());

        //Components
        top = new JPanel();
        dialog = new JPanel();
        buttons = new JPanel();
        fileNameDescription1 = new JLabel("Enter the file to be randomized: ");
        fileNameDescription1Space = new JLabel("(Do NOT include .txt)");
        fileNameDescription2 = new JLabel("Note: Only .txt files can be used.");
        fileNameEntry = new JTextField(50);
        randomize = new JButton("Randomize");
        multiRandomize = new JButton("Randomize 5");
        randomExport = new JButton("Randomize & Export");
        result = new JTextArea("");
        clearEntry = new JButton("Clear");

        //Button Handler
        ButtonHandler bh = new ButtonHandler();

        randomize.addActionListener(bh);
        multiRandomize.addActionListener(bh);
        randomExport.addActionListener(bh);
        clearEntry.addActionListener(bh);

        //Dialog Components
        dialog.setLayout(new GridLayout(2,2,20,0));
        dialog.add(fileNameDescription1);
        dialog.add(fileNameDescription1Space);
        dialog.add(fileNameDescription2);
        dialog.add(fileNameEntry);

        //Button Components
        buttons.setLayout(new GridLayout(1,3,20,0));
        buttons.add(randomize);
        buttons.add(multiRandomize);
        buttons.add(randomExport);
        buttons.add(clearEntry);

        //Top Layout
        top.setLayout(new GridLayout(2,1,10,0));
        top.add(dialog);
        top.add(buttons);

        //Add Components
        contents.add(top, BorderLayout.NORTH);
        contents.add(result, BorderLayout.CENTER);
        contents.add(clearEntry, BorderLayout.SOUTH);

        //MUST KEEP AT END OF JPANEL
        setSize(600,400);
        setVisible(true);
    }

    //Button Handler
    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent ae){
            try{
                String filename = fileNameEntry.getText();
                filename = "./" + filename + ".txt";
                if (ae.getSource() == randomize){
                    File file = new File(filename);
                    if (file.exists()){
                        LinkedList<String> list = listClass(file);
                        Iterator<String> it = list.iterator();
                        value = it.next();
                        result.setText(value);
                    } else {
                        result.setText("The file does not exist. Make sure the file is in the same folder as the program and try again.\nIf you are still having issues, make sure the file is a .txt file. If you still have issues, email me at\ntomjware92@gmail.com");
                    }
                }
                else if (ae.getSource() == multiRandomize){
                    File file = new File(filename);
                    if (file.exists()) {
                        LinkedList<String> list = listClass(file);
                        Iterator<String> it = list.iterator();
                        int i = 0;
                        try {
                            while (it.hasNext() && i < 5) {
                                value1 = it.next();
                                value2 = it.next();
                                value3 = it.next();
                                value4 = it.next();
                                value5 = it.next();
                            }
                            result.setText("\n Your Values Are: \n - " + value1 + "\n - " + value2 + "\n - " + value3 + "\n - " + value4 + "\n - " + value5);
                        } catch (Exception e) {
                            result.setText("Not enough entries to complete successfully.");
                        }
                    }
                }
                else if (ae.getSource() == randomExport){
                    result.setText("Unavailable At This Build");
                }
                else if (ae.getSource() == clearEntry){
                    result.setText("");
                    fileNameEntry.setText("");
                }
            } catch (Exception e) {

            }
        }
    }

    //GUI Execution
    public static void main(String[] args){
        RampantRandomizer basicGui = new RampantRandomizer();
        basicGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //LinkedList Creation
    public LinkedList<String> listClass(File file){
        LinkedList<String> list = new LinkedList<String>();
        try {
            Scanner sc = new Scanner(new FileInputStream(file));
            while (sc.hasNextLine()){
                String content = sc.nextLine();
                list.add(content);
            }
            sc.close();
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            result.setText("\n Program terminated safely...");
        }
        Collections.shuffle(list);
        return list;
    }
}