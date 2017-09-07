import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String from = args[0];
        String to = args[1];
        String dictionaryLocation = args[2];
        Library library = new Library(new SyntaxDifference());

        try (BufferedReader br = new BufferedReader(new FileReader(dictionaryLocation))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                library.addWordToStorage(sCurrentLine);
            }
            List<String> result = library.closetsPath(from,to);
            System.out.println(result.stream().reduce("",(a,b)-> a+" -> "+b));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
