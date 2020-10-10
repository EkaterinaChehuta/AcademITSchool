package ekaterina.chehuta.csv;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Csv {
    public Csv(String url) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileReader(url));
             PrintWriter writer = new PrintWriter("C:\\Users\\Ekaterina\\IdeaProjects\\AcademITSchool\\CSV\\import.html")) {

            String string;
            writer.println("<table border=\"1\" cols=\"3\">");

            Stack<Character> stack = new Stack<>();

            while (scanner.hasNextLine()) {
                string = scanner.nextLine();

                if (stack.empty()) {
                    writer.println("<tr>");
                    writer.print("<td>");
                } else {
                    writer.print("<br/>");
                }

                for (int i = 0; i < string.length(); i++) {
                    char ch = string.charAt(i);

                    switch (ch) {
                        case ';': {
                            if (stack.empty()) {
                                stack.push(ch);
                                writer.println("</td>");
                                break;
                            }

                            if (stack.pop() == ';') {
                                writer.print("<td>");
                                break;
                            }

                            writer.print(ch);
                            break;
                        }

                        case '"': {
                            if (stack.empty()) {
                                writer.print(ch);
                                break;
                            }

                            if (stack.peek() == ';') {
                                stack.push(ch);
                                writer.print("<td>");
                                break;
                            }

                            if (string.charAt(i + 1) == '"') {
                                writer.print(ch);
                                i++;
                                break;
                            }

                            if (stack.pop() == '"') {
                                writer.println("</td>");
                                break;
                            }

                            writer.print(ch);
                            break;
                        }

                        default:
                            writer.print(ch);
                    }
                }

                if (stack.empty()) {
                    writer.println("</td>");
                    writer.println("</tr>");
                }
            }

            writer.println("</table>");
        }
    }
}