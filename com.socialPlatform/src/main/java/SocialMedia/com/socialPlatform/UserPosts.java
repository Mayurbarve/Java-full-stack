package SocialMedia.com.socialPlatform;

import javax.persistence.*;

@Entity
@Table(name = "user_posts")
public class UserPosts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private UserData userData;

    @Column(name = "image_path")
    private String imagePath;

    public UserPosts() {}

    public UserPosts(UserData userData, String imagePath) {
        this.userData = userData;
        this.imagePath = imagePath;
    }

    public int getPostId() { return postId; }
    public UserData getUserData() { return userData; }
    public void setUserData(UserData userData) { this.userData = userData; }
    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }
}
