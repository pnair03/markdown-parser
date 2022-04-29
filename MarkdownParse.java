//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while (currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);

            //if there's no more open brackets, quit
            if (openBracket == -1) { 
                break; 
            }
            int closeBracket = markdown.indexOf("]", openBracket);
            if (closeBracket == -1) { 
                break; 
            }
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);

            //only add the link if it's not an image link and both ( and ) were found
            //and if there are no more than 3 characters between ] and (
            if (openParen != -1 && closeParen != -1 && (openParen - closeBracket) < 3) {
                if (openBracket == 0) {
                    toReturn.add(markdown.substring(openParen + 1, closeParen));
                } 
                else {
                    if (markdown.charAt(openBracket - 1) != '!') {
                        toReturn.add(markdown.substring(openParen + 1, closeParen));
                    }
                }
            }

            //if either ( or ) were not found, restart the search from ]
            //otherwise restart the search from )
            if (openParen == -1 || closeParen == -1) {
                currentIndex = closeBracket + 1;
            } 
            else {
                currentIndex = closeParen + 1;
            }
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
