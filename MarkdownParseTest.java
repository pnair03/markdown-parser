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
    public void testFile1() throws IOException {
        Path fileName = Path.of("/Users/pranavnair/Desktop/markdown-parser/test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> fileLinks = MarkdownParse.getLinks(content);
        String[] links = {"https://something.com", "some-thing.html"};
        assertEquals(links[0], fileLinks.get(0));
        assertEquals(links[1], fileLinks.get(1));
    }

    @Test
    public void testFile2() throws IOException {
        Path fileName = Path.of("/Users/pranavnair/Desktop/markdown-parser/testfile2.md");
        String content = Files.readString(fileName);
        ArrayList<String> fileLinks = MarkdownParse.getLinks(content);
        String[] links = {"https://google.com/", "https://en.wikipedia.org/", "mailto:rmasserf@ucsd.edu"};
        assertEquals(links[0], fileLinks.get(0));
        assertEquals(links[1], fileLinks.get(1));
        assertEquals(links[2], fileLinks.get(2));
    }

    @Test
    public void testFile3() throws IOException {
        Path fileName = Path.of("/Users/pranavnair/Desktop/markdown-parser/test3.md");
        String content = Files.readString(fileName);
        ArrayList<String> fileLinks = MarkdownParse.getLinks(content);
        assertEquals("https://google.com/", fileLinks.get(0));
    }
}