import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class) // Adds SpringExtension i.e. Spring stuff to Junit5
@ContextConfiguration(locations = {"classpath:/Beans.xml"}) // To specify the context to be loaded
public class LanguageTest {
    @Autowired
    ApplicationContext context;

    @Test
    public void testFrench() {
        String actual = context.getMessage("greeting", null,"Default", Locale.FRENCH);
        assertEquals("Bonjour", actual);
    }

    @Test
    public void testItalian() {
        String actual = context.getMessage("greeting", null,"Default", Locale.ITALIAN);
        assertEquals("Ciao", actual);
    }

    @Test
    public void testDefault() {
        String actual = context.getMessage("greeting", null,"Default", Locale.getDefault());
        assertEquals("Hello", actual);
    }

}
