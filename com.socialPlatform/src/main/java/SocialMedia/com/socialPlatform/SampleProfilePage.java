package SocialMedia.com.socialPlatform;

import javax.swing.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.awt.*;
import java.util.List;

public class SampleProfilePage extends JFrame {
    private static final long serialVersionUID = 1L;

    private JLabel profilePicture, nameLabel, bioLabel, profileInfoLabel;
    private JPanel postsPanel;

    public SampleProfilePage(String userName) {
        UserData user;
        try (Session session = new HibernateUtil().getSessionFactory().openSession()) {
            user = session.createQuery("FROM UserData WHERE userName = :userName", UserData.class)
                          .setParameter("userName", userName)
                          .uniqueResult();

            if (user != null) {
                setTitle("User Profile");
                setSize(600, 800);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLayout(new BorderLayout());

                JPanel profilePanel = new JPanel();
                profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.Y_AXIS));
                profilePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                profilePanel.setBackground(Color.LIGHT_GRAY);

                String profilePath = user.getProfilePicturePath() != null ? user.getProfilePicturePath() : "default-profile.png";
                profilePicture = new JLabel(new ImageIcon(profilePath));

                profilePicture.setPreferredSize(new Dimension(150, 150));
                profilePicture.setAlignmentX(Component.CENTER_ALIGNMENT);

                nameLabel = new JLabel(user.getUserName());
                nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
                nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

                bioLabel = new JLabel(user.getUserBio());
                bioLabel.setFont(new Font("Arial", Font.ITALIC, 14));
                bioLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

                profileInfoLabel = new JLabel("Monochromatic Soul");
                profileInfoLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                profileInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

                JButton editProfileButton = new JButton("Edit Profile");
                editProfileButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                editProfileButton.addActionListener(e -> openEditProfileDialog(user));

                profilePanel.add(profilePicture);
                profilePanel.add(Box.createRigidArea(new Dimension(0, 10)));
                profilePanel.add(nameLabel);
                profilePanel.add(Box.createRigidArea(new Dimension(0, 5)));
                profilePanel.add(bioLabel);
                profilePanel.add(Box.createRigidArea(new Dimension(0, 5)));
                profilePanel.add(profileInfoLabel);
                profilePanel.add(Box.createRigidArea(new Dimension(0, 15)));
                profilePanel.add(editProfileButton);

                postsPanel = new JPanel(new GridLayout(3, 3, 10, 10));
                postsPanel.setBorder(BorderFactory.createTitledBorder("User Posts"));
                JScrollPane scrollPane = new JScrollPane(postsPanel);

                JButton uploadPostButton = new JButton("Upload Post");
                uploadPostButton.addActionListener(e -> uploadPost(user));

                displayUserPosts(user);

                add(profilePanel, BorderLayout.NORTH);
                add(scrollPane, BorderLayout.CENTER);
                add(uploadPostButton, BorderLayout.SOUTH);

                setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openEditProfileDialog(UserData user) {
        JDialog editDialog = new JDialog(this, "Edit Profile", true);
        editDialog.setSize(400, 300);
        editDialog.setLayout(new GridLayout(5, 1));

        JTextField nameField = new JTextField(user.getUserName());
        JTextField bioField = new JTextField(user.getUserBio());
        JButton changePictureButton = new JButton("Change Profile Picture");
        JButton saveButton = new JButton("Save Changes");

        changePictureButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getPath();
                profilePicture.setIcon(new ImageIcon(filePath));
                user.setProfilePicturePath(filePath);
            }
        });

        saveButton.addActionListener(e -> {
            try (Session session = new HibernateUtil().getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                user.setUserName(nameField.getText());
                user.setUserBio(bioField.getText());
                session.update(user);
                transaction.commit();

                nameLabel.setText(user.getUserName());
                bioLabel.setText(user.getUserBio());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            editDialog.dispose();
        });

        editDialog.add(new JLabel("Name:"));
        editDialog.add(nameField);
        editDialog.add(new JLabel("Bio:"));
        editDialog.add(bioField);
        editDialog.add(changePictureButton);
        editDialog.add(saveButton);
        editDialog.setVisible(true);
    }

    private void uploadPost(UserData user) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getPath();
            try (Session session = new HibernateUtil().getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                UserPosts post = new UserPosts();
                post.setUserData(user);
                post.setImagePath(filePath);
                session.save(post);
                transaction.commit();

                ImageIcon postImage = new ImageIcon(filePath);
                JLabel postLabel = new JLabel(postImage);
                postsPanel.add(postLabel);
                postsPanel.revalidate();
                postsPanel.repaint();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void displayUserPosts(UserData user) {
        try (Session session = new HibernateUtil().getSessionFactory().openSession()) {
            List<UserPosts> posts = session.createQuery("FROM UserPosts WHERE userData = :user", UserPosts.class)
                                          .setParameter("user", user)
                                          .list();
            for (UserPosts post : posts) {
                ImageIcon postImage = new ImageIcon(post.getImagePath());
                JLabel postLabel = new JLabel(postImage);
                postsPanel.add(postLabel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
