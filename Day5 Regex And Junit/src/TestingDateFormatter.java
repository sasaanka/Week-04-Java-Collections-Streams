import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class DateFormatter {
    public String formatDate(String inputDate) {
        try {
            DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(inputDate, inputFormat);
            return date.format(outputFormat);
        } catch (DateTimeParseException e) {
            return "Invalid date";
        }
    }
}
public class TestingDateFormatter {
    private DateFormatter formatter;
    @BeforeEach
    public void setUp() {
        formatter = new DateFormatter();
    }
    @Test
    public void testValidDateFormatting() {
        assertEquals("15-04-2025", formatter.formatDate("2025-04-15"));
        assertEquals("01-01-2000", formatter.formatDate("2000-01-01"));
    }
    @Test
    public void testInvalidDateFormat() {
        assertEquals("Invalid date", formatter.formatDate("15/04/2025")); 
        assertEquals("Invalid date", formatter.formatDate("2025-13-01")); 
        assertEquals("Invalid date", formatter.formatDate(""));           
    }
}
