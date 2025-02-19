package SocialMedia.com.socialPlatform;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserLoginData {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Id
    private String username;
    private String password;

    public UserLoginData() {}
    
    public UserLoginData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
}