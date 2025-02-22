package SocialMedia.com.socialPlatform;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserLoginData {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Id
    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_data_id", referencedColumnName = "userId")
    private UserData userData;

    public UserLoginData() {}

    public UserLoginData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public UserData getUserData() { return userData; }
    public void setUserData(UserData userData) { this.userData = userData; }
}
