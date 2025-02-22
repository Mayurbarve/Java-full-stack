package SocialMedia.com.socialPlatform;

import javax.swing.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoginPage extends JFrame {
    
	private static final long serialVersionUID = 1L;


	public LoginPage() {
        setTitle("Login Page");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);
        
        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);
        
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);
        
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);
        
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(100, 80, 100, 25);
        panel.add(registerButton);

        loginButton.addActionListener(e -> loginUser(userText.getText(), new String(passwordText.getPassword())));
        registerButton.addActionListener(e -> registerUser(userText.getText(), new String(passwordText.getPassword())));

        setVisible(true);
    }

    public void registerUser(String username, String password) {
        try (Session session = new HibernateUtil().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            UserLoginData user = new UserLoginData(username, password);
            UserData userName = new UserData();
            userName.setUserName(username);
            
            session.save(userName);
            session.save(user);
            transaction.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "Registration Successful! Please Login.");
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
    

    public void loginUser(String username, String password) {
        try (Session session = new HibernateUtil().getSessionFactory().openSession()) {
            UserLoginData user = session.createQuery("FROM UserLoginData WHERE username = :username", UserLoginData.class)
                                        .setParameter("username", username)
                                        .uniqueResult();

            if (user != null && user.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(null, "Login Successful!");
                this.dispose();

                // Open Profile Section
                new SampleProfilePage(user.getUsername());

                session.close();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Credentials!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
