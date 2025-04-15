import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class PasswordValidator {
    public boolean isValid(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUppercase = false;
        boolean hasDigit = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            }
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }
        return hasUppercase && hasDigit;
    }
}

public class TestingPassword{
    private PasswordValidator validator;
    @BeforeEach
    public void setUp() {
        validator = new PasswordValidator();
    }
    @Test
    public void testValidPassword() {
        assertTrue(validator.isValid("StrongPass1"), "Password with uppercase, digit, and length >= 8 should be valid");
    }
    @Test
    public void testTooShortPassword() {
        assertFalse(validator.isValid("S1a"), "Too short password should be invalid");
    }
    @Test
    public void testMissingUppercase() {
        assertFalse(validator.isValid("password1"), "Password without uppercase should be invalid");
    }
    @Test
    public void testMissingDigit() {
        assertFalse(validator.isValid("Password"), "Password without digit should be invalid");
    }
    @Test
    public void testNullPassword() {
        assertFalse(validator.isValid(null), "Null password should be invalid");
    }
}
