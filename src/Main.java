import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setSize(400, 600);
        Font font = new Font("Lalezar", Font.BOLD, 18);

        //          Building the components
        JButton[] numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(Integer.toString(i));
            numberButtons[i].setFont(font);
        }
        JButton equalButton = new JButton("=");
        equalButton.setFont(font);
        JButton dotButton = new JButton(".");
        dotButton.setFont(font);
        JButton clearButton = new JButton("Clr");
        clearButton.setFont(font);
        JButton deleteButton = new JButton("Del");
        deleteButton.setFont(font);
        JButton negativeButton = new JButton("+/-");
        negativeButton.setFont(font);
        JButton plusButton = new JButton("+");
        plusButton.setFont(font);
        JButton multiplyButton = new JButton("*");
        multiplyButton.setFont(font);
        JButton divisionButton = new JButton("/");
        divisionButton.setFont(font);
        JButton minusButton = new JButton("-");
        minusButton.setFont(font);
        JTextField entryField = new JTextField();
        entryField.setFont(font);

        //         Adding the Components
        JPanel panel = new JPanel(null);
        Color backColor = new Color(0xD05C5C);
        panel.setBackground(backColor);
        JPanel centerPanel = new JPanel(new GridLayout(4, 4, 10, 10));
        centerPanel.setBackground(backColor);
        JPanel lowerPanel = new JPanel(new GridLayout(1, 3, 50, 50));
        lowerPanel.setBackground(backColor);
        frame.add(panel);
        entryField.setBounds(40, 70, 300, 30);
        panel.add(entryField);
        centerPanel.setBounds(40, 120, 300, 300);
        centerPanel.add(numberButtons[1]);
        centerPanel.add(numberButtons[2]);
        centerPanel.add(numberButtons[3]);
        centerPanel.add(plusButton);
        centerPanel.add(numberButtons[4]);
        centerPanel.add(numberButtons[5]);
        centerPanel.add(numberButtons[6]);
        centerPanel.add(minusButton);
        centerPanel.add(numberButtons[7]);
        centerPanel.add(numberButtons[8]);
        centerPanel.add(numberButtons[9]);
        centerPanel.add(multiplyButton);
        centerPanel.add(dotButton);
        centerPanel.add(numberButtons[0]);
        centerPanel.add(equalButton);
        centerPanel.add(divisionButton);
        panel.add(centerPanel);

        lowerPanel.setBounds(40, 450, 300, 40);
        panel.add(lowerPanel);
        lowerPanel.add(clearButton);
        lowerPanel.add(deleteButton);
        lowerPanel.add(negativeButton);


        //               Actions
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            numberButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    entryField.setText(entryField.getText() + Integer.toString(finalI));
                }
            });
        }

        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entryField.setText(entryField.getText() + "+");
            }
        });

        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entryField.setText(entryField.getText() + "-");
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entryField.setText(entryField.getText() + "*");
            }
        });

        divisionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entryField.setText(entryField.getText() + "/");
            }
        });

        dotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entryField.setText(entryField.getText() + ".");
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entryField.setText(null);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entryField.setText(entryField.getText().substring(0, entryField.getText().length() - 1));
            }
        });

        negativeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (entryField.getText() == null)
                    entryField.setText(entryField.getText() + "-");
                else{
                    double temp = Double.parseDouble(entryField.getText());
                    entryField.setText(Double.toString(temp * -1));
                }
            }
        });

        equalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(entryField.getText().contains("*")) {
                    String[] array = entryField.getText().split("\\*");
                    Double equal = Double.parseDouble(array[0]) *  Double.parseDouble(array[1]);
                    entryField.setText(Double.toString(equal));

                }

                if(entryField.getText().contains("+")){
                    String[] array = entryField.getText().split("\\+");
                    Double equal = Double.parseDouble(array[0]) + Double.parseDouble(array[1]);
                    entryField.setText(Double.toString(equal));

                }

                if(entryField.getText().contains("-")){
                    String[] array = entryField.getText().split("-");
                    Double equal = Double.parseDouble(array[0]) - Double.parseDouble(array[1]);;
                    entryField.setText(Double.toString(equal));

                }

                if(entryField.getText().contains("/")){
                    String[] array = entryField.getText().split("/");
                    Double equal = Double.parseDouble(array[0]) / Double.parseDouble(array[1]);
                    entryField.setText(Double.toString(equal));

                }



            }
        });


        frame.setDefaultCloseOperation(3);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
