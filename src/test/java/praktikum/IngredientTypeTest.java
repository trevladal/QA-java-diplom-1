package praktikum;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {

    @Test
    public void values() {
        assertThat(IngredientType.values(), is(notNullValue()));
    }

    @Test
    public void valueOf() {
        assertThat(IngredientType.valueOf("SAUCE"), is(SAUCE));
        assertThat(IngredientType.valueOf("FILLING"), is(FILLING));

    }
}