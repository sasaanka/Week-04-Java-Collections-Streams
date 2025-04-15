import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class UserRegistration {
    public String registerUser(String username, String email, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (email == null || !email.matches("^\\S+@\\S+\\.\\S+$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters");
        }
        return "User registered successfully";
    }
}

public class TestingUserRegistration {

    private UserRegistration registration;

    @BeforeEach
    public void setUp() {
        registration = new UserRegistration();
    }

    @Test
    public void testValidRegistration() {
        String result = registration.registerUser("john_doe", "john@example.com", "secure123");
        assertEquals("User registered successfully", result);
    }

    @Test
    public void testEmptyUsername() {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
            registration.registerUser("", "john@example.com", "secure123"));
        assertEquals("Username cannot be empty", e.getMessage());
    }

    @Test
    public void testInvalidEmail() {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
            registration.registerUser("john", "johnexample.com", "secure123"));
        assertEquals("Invalid email format", e.getMessage());
    }

    @Test
    public void testShortPassword() {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
            registration.registerUser("john", "john@example.com", "123"));
        assertEquals("Password must be at least 6 characters", e.getMessage());
    }
}
