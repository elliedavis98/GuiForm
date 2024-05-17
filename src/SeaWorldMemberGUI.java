import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.text.*;
import java.util.*;

public class SeaWorldMemberGUI {
    public static void main(String[] args) throws Exception {
        SeaWorldFrame f = new SeaWorldFrame();
    }
}

class SeaWorldFrame extends JFrame implements ActionListener {

    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    // Additions
    private JLabel emailLabel;
    private JTextField emailField;

    private JLabel creditCardLabel;
    private JTextField creditCardNumberField;
    private JTextField expirationDateField;
    private JTextField cvvField;

    private JLabel pointsLabel;
    private JTextField pointsField;

    private JLabel vipAccessLabel;
    private JTextField vipAccessField;
    // End of Additions

    private JButton sub;
    private JButton reset;

    private JTextArea outputArea;

    // Constructor
    public SeaWorldFrame() {
        setTitle("SeaWorld Member Registration");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("SeaWorld Member Registration");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(500, 30);
        title.setLocation(200, 30);
        c.add(title);

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(200, 100);
        c.add(tname);

        // Email components
        emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        emailLabel.setSize(100, 20);
        emailLabel.setLocation(100, 150);
        c.add(emailLabel);

        emailField = new JTextField();
        emailField.setFont(new Font("Arial", Font.PLAIN, 15));
        emailField.setSize(190, 20);
        emailField.setLocation(200, 150);
        c.add(emailField);

        // Credit card components
        creditCardLabel = new JLabel("Credit Card");
        creditCardLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        creditCardLabel.setSize(150, 20);
        creditCardLabel.setLocation(100, 200);
        c.add(creditCardLabel);

        creditCardNumberField = new JTextField();
        creditCardNumberField.setFont(new Font("Arial", Font.PLAIN, 15));
        creditCardNumberField.setSize(150, 20);
        creditCardNumberField.setLocation(250, 200);
        c.add(creditCardNumberField);

        expirationDateField = new JTextField();
        expirationDateField.setFont(new Font("Arial", Font.PLAIN, 15));
        expirationDateField.setSize(60, 20);
        expirationDateField.setLocation(410, 200);
        c.add(expirationDateField);

        cvvField = new JTextField();
        cvvField.setFont(new Font("Arial", Font.PLAIN, 15));
        cvvField.setSize(40, 20);
        cvvField.setLocation(480, 200);
        c.add(cvvField);

        // SeaWorld points components
        pointsLabel = new JLabel("SeaWorld Points");
        pointsLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        pointsLabel.setSize(200, 20);
        pointsLabel.setLocation(100, 250);
        c.add(pointsLabel);

        pointsField = new JTextField();
        pointsField.setFont(new Font("Arial", Font.PLAIN, 15));
        pointsField.setSize(100, 20);
        pointsField.setLocation(300, 250);
        c.add(pointsField);

        // VIP Access components
        vipAccessLabel = new JLabel("VIP Access Code");
        vipAccessLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        vipAccessLabel.setSize(200, 20);
        vipAccessLabel.setLocation(100, 300);
        c.add(vipAccessLabel);

        vipAccessField = new JTextField();
        vipAccessField.setFont(new Font("Arial", Font.PLAIN, 15));
        vipAccessField.setSize(150, 20);
        vipAccessField.setLocation(300, 300);
        c.add(vipAccessField);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 425);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 425);
        reset.addActionListener(this);
        c.add(reset);

        // Output area
        outputArea = new JTextArea();
        outputArea.setFont(new Font("Arial", Font.PLAIN, 15));
        outputArea.setSize(400, 200);
        outputArea.setLocation(500, 100);
        outputArea.setLineWrap(true);
        outputArea.setEditable(false);
        c.add(outputArea);

        setVisible(true);
    }

    // Method actionPerformed()
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sub) {
            // Handle submission
            String name = tname.getText();
            String email = emailField.getText();
            String creditCardNumber = creditCardNumberField.getText();
            String expirationDate = expirationDateField.getText();
            String cvv = cvvField.getText();
            String points = pointsField.getText();
            String vipAccessCode = vipAccessField.getText();

            // Display the data in the output area
            outputArea.setText(outputArea.getText()+ "Name: " + name + "\n" +
                    "Email: " + email + "\n" +
                    "Credit Card Number: " + creditCardNumber + "\n" +
                    "Expiration Date: " + expirationDate + "\n" +
                    "CVV: " + cvv + "\n" +
                    "SeaWorld Points: " + points + "\n" +
                    "VIP Access Code: " + vipAccessCode + "\n" + "\n");
        } else if (e.getSource() == reset) {
            // Reset fields
            tname.setText("");
            emailField.setText("");
            creditCardNumberField.setText("");
            expirationDateField.setText("");
            cvvField.setText("");
            pointsField.setText("");
            vipAccessField.setText("");
            outputArea.setText("");
        }
    }
}
