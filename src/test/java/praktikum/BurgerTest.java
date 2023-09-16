package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient_second;

    @Test
    public void setBunsTest() {

        Burger testBurger = new Burger();

        testBurger.setBuns(bun);
        assertThat(testBurger.bun, is(bun));

    }

    @Test
    public void addIngredientTest() {

        Burger testBurger = new Burger();

        testBurger.ingredients.add(ingredient);
        assertThat(testBurger.ingredients.get(0), is(ingredient));

    }

    @Test
    public void removeIngredientTest() {

        Burger testBurger = new Burger();

        testBurger.addIngredient(ingredient);
        testBurger.removeIngredient(0);
        assertThat(testBurger.ingredients.size(), is(0));
    }

    @Test
    public void moveIngredientTest() {

        Burger testBurger = new Burger();

        testBurger.addIngredient(ingredient);
        testBurger.addIngredient(ingredient_second);

        assertThat(testBurger.ingredients.get(0), is(ingredient));

        testBurger.moveIngredient(1, 0);

        assertThat(testBurger.ingredients.get(0), is(ingredient_second));

    }

    @Test
    public void getPriceTest() {


        Burger testBurger = new Burger();
        testBurger.setBuns(bun);
        testBurger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(111F);
        Mockito.when(ingredient.getPrice()).thenReturn(333F);

        assertThat(testBurger.getPrice(), is(555F));

    }

    @Test
    public void getReceiptTest() {

        Burger testBurger = new Burger();
        testBurger.setBuns(bun);
        testBurger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("Ржаная булочка");
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Нереальный соус");
        Mockito.when(bun.getPrice()).thenReturn(222F);
        Mockito.when(ingredient.getPrice()).thenReturn(555F);

        assertThat( testBurger.getReceipt(), is("(==== Ржаная булочка ====)\r\n= sauce Нереальный соус =\r\n(==== Ржаная булочка ====)\r\n\r\nPrice: 999,000000\r\n"));
    }
}