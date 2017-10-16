package net.twisteddna.vocabulary;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Crafted by TwistedDNA on 10/16/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class TextFileVocabularyTest {

    @Test
    public void shouldLoadNamedFileAsVocabulary(){
        List<String> localVocabulary = new ArrayList<>();
        Vocabulary vocabulary = new TextFileVocabulary("test-vocabulary.txt");
        vocabulary.forEveryWord(localVocabulary::add);
        assertTrue(localVocabulary.contains("word1"));
        assertTrue(localVocabulary.contains("secondWord"));
        assertTrue(localVocabulary.contains("third"));
    }

    @Test
    public void shouldLoadDefaultVocabularyOnNotFindingPassedName(){
        List<String> localVocabulary = new ArrayList<>();
        Vocabulary vocabulary = new TextFileVocabulary("nonexistingfile");
        vocabulary.forEveryWord(localVocabulary::add);
        assertTrue(localVocabulary.contains("gold"));
        assertTrue(localVocabulary.contains("lead"));
    }
}