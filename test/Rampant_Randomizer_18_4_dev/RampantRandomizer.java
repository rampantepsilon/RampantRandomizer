package Rampant_Randomizer_18_4_dev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RampantRandomizer extends JFrame {
    //Program Info
    private static String programName = "Rampant Randomizer";
    private static String version = " v.18.4";
    private static String build = " Build 33118.1700";

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
    private JLabel result;
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
        result = new JLabel("");
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
                String file = fileNameEntry.getText();
                if (ae.getSource() == randomize){

                }
                else if (ae.getSource() == multiRandomize){

                }
                else if (ae.getSource() == randomExport){

                }
                else if (ae.getSource() == clearEntry){

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
}