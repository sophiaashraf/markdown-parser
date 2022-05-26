import static org.junit.Assert.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.io.*;

import org.junit.*;


public class MarkdownParseTest {
    @Test
    public void addition(){
        assertEquals(2, 1 + 1);
    }

    @Test
    public void link1() throws IOException{
        List linklist = List.of("some-thing.html");
        MarkdownParse obj = new MarkdownParse();
        Path testFile = Path.of("test-file.md");
        String content = Files.readString(testFile);
        ArrayList<String> output = obj.getLinks(content);
        assertEquals(linklist, output);

    }

    @Test
    public void link2() throws IOException{
        List linklist = List.of("https://something.com", "some-page.html");
        MarkdownParse obj = new MarkdownParse();
        Path testFile = Path.of("test-file2.md");
        String content = Files.readString(testFile);
        ArrayList<String> output = obj.getLinks(content);
        assertEquals(linklist, output);

    }

    @Test
    public void link3() throws IOException{
        List linklist = List.of();
        MarkdownParse obj = new MarkdownParse();
        Path testFile = Path.of("test-file3.md");
        String content = Files.readString(testFile);
        ArrayList<String> output = obj.getLinks(content);
        assertEquals(linklist, output);

    }

    @Test 
    public void link4() throws IOException{
        List expected = List.of();

        Path fileName = Path.of("test-file4.md");
        String content = Files.readString(fileName);
        ArrayList<String> actual = MarkdownParse.getLinks(content);
        assertEquals(expected, actual);
    }


}
