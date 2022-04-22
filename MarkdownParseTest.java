import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile() throws IOException {
        Path fileName = Path.of("/Users/pranavnair/Desktop/markdown-parser/test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> fileLinks = MarkdownParse.getLinks(content);
        String[] links = {"https://something.com", "some-thing.html"};
        assertEquals(links[0], fileLinks.get(0));
        assertEquals(links[1], fileLinks.get(1));
    }
}