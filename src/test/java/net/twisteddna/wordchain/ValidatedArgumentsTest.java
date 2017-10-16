package net.twisteddna.wordchain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Crafted by TwistedDNA on 10/16/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ValidatedArgumentsTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowExceptionOnNullArgument() {
        thrown.expect(IllegalArgumentException.class);
        new ValidatedArguments(null);
    }

    @Test
    public void shouldThrowExceptionOnEmptyArgument() {
        thrown.expect(IllegalArgumentException.class);
        new ValidatedArguments(new String[]{});
    }

    @Test
    public void shouldThrowExceptionOnOneArgumentOnly() {
        thrown.expect(IllegalArgumentException.class);
        new ValidatedArguments(new String[]{"withoutSecondOne"});
    }

    @Test
    public void shouldProperlyCreateOnAtLeastTwoArguments() {
        new ValidatedArguments(new String[]{"firstOne", "secondOne"});
    }
}