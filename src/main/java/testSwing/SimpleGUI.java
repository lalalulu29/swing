package testSwing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SimpleGUI extends JFrame {
    private final JButton register = new JButton("Регистрация");


    private final JLabel labelName = new JLabel("введите имя:");
    private final JTextField nameTextFiled = new JTextField("");

    private final JLabel labelSecondName = new JLabel("введите фамилию:");
    private final JTextField secondNameTextField = new JTextField("");

    private final JLabel labelAge = new JLabel("введите возраст:");
    private final JTextField ageTextField = new JTextField("");

    private final JLabel labelPassword = new JLabel("введите пароль:");
    private final JPasswordField passwordField = new JPasswordField("");




    public SimpleGUI() {
        super("Register user");
        this.setBounds(1000,100,350, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(0,2,1,1));

        container.add(labelName);
        container.add(nameTextFiled);

        container.add(labelSecondName);
        container.add(secondNameTextField);

        container.add(labelAge);
        container.add(ageTextField);

        container.add(labelPassword);
        container.add(passwordField);


        container.add(register);



        register.addActionListener(new ActionListenerButton());

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
