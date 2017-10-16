package net.twisteddna.vocabulary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.function.Consumer;

/**
 * Crafted by TwistedDNA on 10/10/2017.
 */
public class TextFileVocabulary implements Vocabulary{
    private static final String DEFAULT_VOCABULARY = "wordlist.txt";
    private String vocabularyFilename;

    public TextFileVocabulary(String vocabularyFilename) {
        this.vocabularyFilename = vocabularyFilename;
    }

    public TextFileVocabulary() {
        vocabularyFilename="non-existing-resource";
    }

    @Override
    public void forEveryWord(Consumer<String> func) {
        BufferedReader reader = getReaderForVocabulary();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                func.accept(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Exception happened during vocabulary file read. Message: "+e.getMessage());
        }
    }
    private BufferedReader getReaderForVocabulary(){
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream in = classloader.getResourceAsStream(vocabularyFilename);
        if(in == null){
            in = classloader.getResourceAsStream(DEFAULT_VOCABULARY);
        }
        return new BufferedReader(new InputStreamReader(in,Charset.forName("UTF-8")));
    }

}
