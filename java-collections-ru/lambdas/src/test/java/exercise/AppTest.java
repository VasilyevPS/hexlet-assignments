package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
public class AppTest {
    @Test
    void enlargeArrayImage() {
        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };
        String[][] enlargedImage = {
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
        };
        String[][] result = App.enlargeArrayImage(image);
        assertThat(result).isEqualTo(enlargedImage);
    }

    @Test
    void enlargeArrayImageEmpty() {
        String[][] image = new String[0][0];
        String[][] enlargedImage = new String[0][0];
        String[][] result = App.enlargeArrayImage(image);
        assertThat(result).isEqualTo(enlargedImage);
    }

    @Test
    void enlargeArrayImageOneElement() {
        String[][] image = {
                {"*"},
        };
        String[][] enlargedImage = {
                {"*", "*"},
                {"*", "*"},
        };
        String[][] result = App.enlargeArrayImage(image);
        assertThat(result).isEqualTo(enlargedImage);
    }
}
// END
