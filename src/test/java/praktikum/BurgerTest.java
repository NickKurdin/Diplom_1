package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1, ingredient2, ingredient3;

    @Before
    public void createBurger() {
        burger = new Burger();
    }

    @Test
    public void checkSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void checkAddIngredientBurger(){
        burger.addIngredient(ingredient1);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void checkRemoveIngredientBurger(){
        burger.addIngredient(ingredient1);
        Assert.assertEquals(1, burger.ingredients.size());
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void checkMoveIngredientBurger(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.moveIngredient(1,2);
        Assert.assertEquals(ingredient2, burger.ingredients.get(2));
        Assert.assertEquals(ingredient3, burger.ingredients.get(1));
    }

    @Test
    public void checkPriceBurger(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        when(bun.getPrice()).thenReturn(2f);
        when(ingredient1.getPrice()).thenReturn(3f);
        when(ingredient2.getPrice()).thenReturn(6f);
        float expectedPrice = (2f * 2) + 3f + 6f;
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void checkGetReceiptBurger(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(2f);
        Mockito.when(ingredient1.getName()).thenReturn("майонез");
        Mockito.when(ingredient1.getPrice()).thenReturn(3f);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient2.getName()).thenReturn("котлета");
        Mockito.when(ingredient2.getPrice()).thenReturn(6f);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        String expectedReceipt = "(==== white bun ====)\n= sauce майонез =\n= filling котлета =\n(==== white bun ====)\n\nPrice: 13.000000\n";
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }

}
