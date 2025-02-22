package SocialMedia.com.socialPlatform;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_data")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "user_name")
    private String userName;

    
    @OneToOne(mappedBy = "userData", cascade = CascadeType.ALL)
    private UserLoginData userLoginData;
    

    @Column(name = "user_bio")
    private String userBio;
    
    @Column(name = "profile_picture_path")
    private String profilePicturePath;

    @Lob
    @Column(name = "user_profile")
    private byte[] userProfile;

    @OneToMany(mappedBy = "userData", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserPosts> posts;

    public UserData() {}

    public UserData(String userName, UserLoginData userLoginData, String userBio, byte[] userProfile) {
        this.userName = userName;
        this.userLoginData = userLoginData;
        this.userBio = userBio;
        this.userProfile = userProfile;
    }

    public int getUserId() { return userId; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public UserLoginData getUserLoginData() { return userLoginData; }
    public void setUserLoginData(UserLoginData userLoginData) { this.userLoginData = userLoginData; }
    public String getUserBio() { return userBio; }
    public void setUserBio(String userBio) { this.userBio = userBio; }
    public byte[] getUserProfile() { return userProfile; }
    public void setUserProfile(byte[] userProfile) { this.userProfile = userProfile; }
    public List<UserPosts> getPosts() { return posts; }
    public void setPosts(List<UserPosts> posts) { this.posts = posts; }

	public String getProfilePicturePath() {
		return profilePicturePath;
	}

	public void setProfilePicturePath(String profilePicturePath) {
		this.profilePicturePath = profilePicturePath;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}


    
    
}
