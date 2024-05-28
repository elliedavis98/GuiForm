import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Registration {

    public static void main(String[] args) {
        MyFrame f = new MyFrame();
    }
}

class MyFrame extends JFrame implements ActionListener {

    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel email;
    private JTextField temail;
    private JLabel cc;
    private JTextField tcc;
    private JLabel expDate;
    private JTextField texpDate;
    private JLabel cvv;
    private JTextField tcvv;
    private JLabel swPoints;
    private JTextField tswPoints;
    private JLabel swMember;
    private JCheckBox tswMember;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JButton readF;
    private JButton saveCSV;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;

    private List<BankAccount> accounts; // List to store multiple registrations

    public MyFrame() {
        setTitle("SeaWorld Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        accounts = new ArrayList<>(); // Initialize the list

        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
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

        email = new JLabel("Email");
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setSize(100, 20);
        email.setLocation(100, 150);
        c.add(email);

        temail = new JTextField();
        temail.setFont(new Font("Arial", Font.PLAIN, 15));
        temail.setSize(190, 20);
        temail.setLocation(200, 150);
        c.add(temail);

        cc = new JLabel("Credit Card");
        cc.setFont(new Font("Arial", Font.PLAIN, 20));
        cc.setSize(100, 20);
        cc.setLocation(100, 200);
        c.add(cc);

        tcc = new JTextField();
        tcc.setFont(new Font("Arial", Font.PLAIN, 15));
        tcc.setSize(190, 20);
        tcc.setLocation(200, 200);
        c.add(tcc);

        expDate = new JLabel("Expiration Date");
        expDate.setFont(new Font("Arial", Font.PLAIN, 20));
        expDate.setSize(150, 20);
        expDate.setLocation(100, 250);
        c.add(expDate);

        texpDate = new JTextField();
        texpDate.setFont(new Font("Arial", Font.PLAIN, 15));
        texpDate.setSize(190, 20);
        texpDate.setLocation(250, 250);
        c.add(texpDate);

        cvv = new JLabel("CVV");
        cvv.setFont(new Font("Arial", Font.PLAIN, 20));
        cvv.setSize(100, 20);
        cvv.setLocation(100, 300);
        c.add(cvv);

        tcvv = new JTextField();
        tcvv.setFont(new Font("Arial", Font.PLAIN, 15));
        tcvv.setSize(190, 20);
        tcvv.setLocation(200, 300);
        c.add(tcvv);

        swPoints = new JLabel("SeaWorld Points");
        swPoints.setFont(new Font("Arial", Font.PLAIN, 20));
        swPoints.setSize(150, 20);
        swPoints.setLocation(100, 350);
        c.add(swPoints);

        tswPoints = new JTextField();
        tswPoints.setFont(new Font("Arial", Font.PLAIN, 15));
        tswPoints.setSize(190, 20);
        tswPoints.setLocation(250, 350);
        c.add(tswPoints);

        swMember = new JLabel("SeaWorld Member");
        swMember.setFont(new Font("Arial", Font.PLAIN, 20));
        swMember.setSize(150, 20);
        swMember.setLocation(100, 400);
        c.add(swMember);

        tswMember = new JCheckBox();
        tswMember.setFont(new Font("Arial", Font.PLAIN, 15));
        tswMember.setSize(20, 20);
        tswMember.setLocation(250, 400);
        c.add(tswMember);

        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 450);
        c.add(term);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 475);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 475);
        reset.addActionListener(this);
        c.add(reset);

        readF = new JButton("Read CSV");
        readF.setFont(new Font("Arial", Font.PLAIN, 15));
        readF.setSize(120, 20);
        readF.setLocation(200, 500);
        readF.addActionListener(this);
        c.add(readF);

        saveCSV = new JButton("Save to CSV");
        saveCSV.setFont(new Font("Arial", Font.PLAIN, 15));
        saveCSV.setSize(120, 20);
        saveCSV.setLocation(340, 500);
        saveCSV.addActionListener(this);
        c.add(saveCSV);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(420, 400);
        tout.setLocation(440, 100);
        tout.setLineWrap(false);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 530);
        c.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(220, 75);
        resadd.setLocation(570, 175);
        resadd.setLineWrap(false);
        c.add(resadd);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sub) {
            if (term.isSelected()) {
                BankAccount account = new BankAccount(
                        tname.getText(),
                        temail.getText(),
                        tcc.getText(),
                        texpDate.getText(),
                        tcvv.getText(),
                        tswPoints.getText(),
                        tswMember.isSelected() ? "Yes" : "No"
                );

                accounts.add(account);

                StringBuilder allData = new StringBuilder();
                for (BankAccount acc : accounts) {
                    allData.append(acc.toString()).append("\n\n");
                }

                tout.setText(allData.toString());
                res.setText("Registration Successful..");

                saveFile(allData.toString());
                appendStrToFile("csv.csv", "\n" + account.toCSV());
            } else {
                tout.setText("");
                resadd.setText("");
                res.setText("Please accept the terms & conditions..");
            }
        } else if (e.getSource() == reset) {
            String def = "";
            tname.setText(def);
            temail.setText(def);
            tcc.setText(def);
            texpDate.setText(def);
            tcvv.setText(def);
            tswPoints.setText(def);
            tswMember.setSelected(false);
            res.setText(def);
            tout.setText(def);
            resadd.setText(def);
            term.setSelected(false);
        } else if (e.getSource() == readF) {
            String data1 = readCSVFile("csv.csv");
            tout.setText(data1);
        } else if (e.getSource() == saveCSV) {
            saveToCSV();
        }
    }

    public void saveFile(String content) {
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write(content);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void appendStrToFile(String fileName, String str) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true))) {
            out.write(str);
        } catch (IOException e) {
            System.out.println("exception occurred" + e);
        }
    }

    public String readFile() {
        String data = "";
        try {
            data = new String(Files.readAllBytes(Paths.get("filename.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public String readCSVFile(String s) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String filePath = selectedFile.getAbsolutePath();

                BufferedReader br = new BufferedReader(new FileReader("csv.csv"));
                String line;
                StringBuilder csvContent = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length == 7) { // Assuming there are 7 fields in each line
                        String name = data[0];
                        String email = data[1];
                        String cc = data[2];
                        String expDate = data[3];
                        String cvv = data[4];
                        String swPoints = data[5];
                        String swMember = data[6];

                        String formattedData = "Name: " + name + "\n"
                                + "Email: " + email + "\n"
                                + "Credit Card: " + cc + "\n"
                                + "Expiration Date: " + expDate + "\n"
                                + "CVV: " + cvv + "\n"
                                + "SeaWorld Points: " + swPoints + "\n"
                                + "SeaWorld Member: " + swMember + "\n";

                        csvContent.append(formattedData);
                    } else {
                        csvContent.append("Invalid data format: ").append(line).append("\n");
                    }
                }
                br.close();
                tout.setText(csvContent.toString());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading CSV file.");
        }
        return s;
    }

    private void saveToCSV() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                String filePath = "csv.csv"; // Specify the file path
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
                writer.write("Name,Email,Credit Card,Expiration Date,CVV,SeaWorld Points,SeaWorld Member\n");  // Adding header
                for (BankAccount acc : accounts) {
                    writer.write(acc.toCSV() + "\n");
                }
                writer.close();
                JOptionPane.showMessageDialog(this, "Data successfully saved to CSV file.");
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saving data to CSV file.");
            }
        }
    }
}

class BankAccount {

    private String name;
    private String email;
    private String cc;
    private String expDate;
    private String cvv;
    private String swPoints;
    private String swMember;

    public BankAccount() {
        this.name = "";
        this.email = "";
        this.cc = "";
        this.expDate = "";
        this.cvv = "";
        this.swPoints = "";
        this.swMember = "";
    }

    public BankAccount(String n, String e, String c, String d, String cv, String p, String m) {
        this.name = n;
        this.email = e;
        this.cc = c;
        this.expDate = d;
        this.cvv = cv;
        this.swPoints = p;
        this.swMember = m;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String e) {
        this.email = e;
    }

    public String getCC() {
        return this.cc;
    }

    public void setCC(String c) {
        this.cc = c;
    }

    public String getExpDate() {
        return this.expDate;
    }

    public void setExpDate(String d) {
        this.expDate = d;
    }

    public String getCVV() {
        return this.cvv;
    }

    public void setCVV(String cv) {
        this.cvv = cv;
    }

    public String getSWPoints() {
        return this.swPoints;
    }

    public void setSWPoints(String p) {
        this.swPoints = p;
    }

    public String getSWMember() {
        return this.swMember;
    }

    public void setSWMember(String m) {
        this.swMember = m;
    }

    public String toCSV() {
        return this.name + "," + this.email + "," + this.cc + "," + this.expDate + "," + this.cvv + "," + this.swPoints + "," + this.swMember;
    }

    public String toString() {
        return "Name: " + this.name + "\nEmail: " + this.email + "\nCredit Card: " + this.cc + "\nExpiration Date: " + this.expDate + "\nCVV: " + this.cvv + "\nSeaWorld Points: " + this.swPoints + "\nSeaWorld Member: " + this.swMember;
    }
}
