package SocialMedia.com.socialPlatform;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfilePage extends JFrame {
    private JLabel profilePicture, nameLabel, bioLabel;
    private JPanel postsPanel;
    
    public ProfilePage() {
        setTitle("User Profile");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Profile Section
        JPanel profilePanel = new JPanel();
        profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.Y_AXIS));
        profilePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        profilePicture = new JLabel(new ImageIcon("default-profile.png"));
        profilePicture.setPreferredSize(new Dimension(100, 100));
        nameLabel = new JLabel("Username");
        bioLabel = new JLabel("User Bio goes here");

        profilePanel.add(profilePicture);
        profilePanel.add(nameLabel);
        profilePanel.add(bioLabel);
        
        // Edit Profile Button
        JButton editProfileButton = new JButton("Edit Profile");
        editProfileButton.addActionListener(e -> openEditProfileDialog());
        profilePanel.add(editProfileButton);
        
        // Posts Section
        postsPanel = new JPanel();
        postsPanel.setLayout(new GridLayout(3, 3, 5, 5));
        JScrollPane scrollPane = new JScrollPane(postsPanel);

        // Upload Post Button
        JButton uploadPostButton = new JButton("Upload Post");
        uploadPostButton.addActionListener(e -> uploadPost());
        
        add(profilePanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(uploadPostButton, BorderLayout.SOUTH);
        
        setVisible(true);
    }

    private void openEditProfileDialog() {
        JDialog editDialog = new JDialog(this, "Edit Profile", true);
        editDialog.setSize(300, 250);
        editDialog.setLayout(new GridLayout(4, 1));

        JTextField nameField = new JTextField(nameLabel.getText());
        JTextField bioField = new JTextField(bioLabel.getText());
        JButton changeProfilePicture = new JButton("Change Profile Picture");
        JButton saveButton = new JButton("Save Changes");

        saveButton.addActionListener(e -> {
            nameLabel.setText(nameField.getText());
            bioLabel.setText(bioField.getText());
            editDialog.dispose();
        });

        editDialog.add(new JLabel("Name"));
        editDialog.add(nameField);
        editDialog.add(new JLabel("Bio"));
        editDialog.add(bioField);
        editDialog.add(changeProfilePicture);
        editDialog.add(saveButton);
        editDialog.setVisible(true);
    }

    private void uploadPost() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            ImageIcon postImage = new ImageIcon(fileChooser.getSelectedFile().getPath());
            JLabel postLabel = new JLabel(postImage);
            postsPanel.add(postLabel);
            postsPanel.revalidate();
            postsPanel.repaint();
        }
    }
}