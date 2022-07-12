import java.util.Date;

public class User {
    private String displayName;
    private String email;
    private String phoneNumber;
    private Date dateOfBirth;
    public enum gender {
        MALE,
        FEMALE,
        OTHER
    };

    public User(String displayName, String email, String phoneNumber, Date dateOfBirth) {
        this.displayName = displayName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
}
