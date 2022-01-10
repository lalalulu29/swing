package testSwing;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class SimpleGUI extends JFrame {


    private final JTextField nameTextFiled = new JTextField("");

    private final JTextField secondNameTextField = new JTextField("");

    private final JTextField ageTextField = new JTextField("");

    private final JPasswordField passwordField = new JPasswordField("");


    public SimpleGUI() throws IOException {
        super("Register user");
        this.setBounds(1000,100,350, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Image image = ImageIO.read(new File("FIk5-qXUUAAn7xm.jpg")).getScaledInstance(50,150, Image.SCALE_SMOOTH);


        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(image));

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(0, 2 , 0, 0));

        JLabel labelName = new JLabel("введите имя:");
        container.add(labelName);
        container.add(nameTextFiled);

        JLabel labelSecondName = new JLabel("введите фамилию:");
        container.add(labelSecondName);
        container.add(secondNameTextField);

        JLabel labelAge = new JLabel("введите возраст:");
        container.add(labelAge);
        container.add(ageTextField);

        JLabel labelPassword = new JLabel("введите пароль:");
        container.add(labelPassword);
        container.add(passwordField);

        JButton auth = new JButton("Авторизация");
        container.add(auth);
        JButton register = new JButton("Регистрация");
        container.add(register);

//        container.add(imageLabel);


        register.addActionListener(new ActionListenerButton());
        auth.addActionListener(new AuthListener());

    }
    class AuthListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Вы были авторизованы");
        }
    }

    class ActionListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameTextFiled.getText();
            String secondName = secondNameTextField.getText();
            String age = ageTextField.getText();
            String password = passwordField.getText();


            if (name.isEmpty()) nameTextFiled.setBorder(BorderFactory.createLineBorder(Color.RED)); else
                nameTextFiled.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            if (secondName.isEmpty()) secondNameTextField.setBorder(BorderFactory.createLineBorder(Color.RED)); else
                secondNameTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            if (age.isEmpty()) ageTextField.setBorder(BorderFactory.createLineBorder(Color.RED)); else
                ageTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            if (password.isEmpty()) passwordField.setBorder(BorderFactory.createLineBorder(Color.RED)); else
                passwordField.setBorder(BorderFactory.createLineBorder(Color.BLACK));



            if (!(name.isEmpty()) &&
                    !(secondName.isEmpty()) &&
                    !(age.isEmpty()) &&
                    !(password.isEmpty())) {
                User user = new User(name, secondName, age, password);
                System.out.println(user);



                JOptionPane.showMessageDialog(null, "Регистрация прошла успешно", "Регистрация", JOptionPane.PLAIN_MESSAGE);

                nameTextFiled.setText("");
                secondNameTextField.setText("");
                ageTextField.setText("");
                passwordField.setText("");

            } else {
                JOptionPane.showMessageDialog(null, "Заполните пустые поля");
            }

        }
    }
}
