package praktikum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Burger burger = new Burger();

    @Test
    public void checkSetBuns() {
        Bun bun = new Bun("Булка", 1.1f);
        burger.setBuns(bun);
        Mockito.verify(burger).setBuns(bun);
    }

    @Test
    public void checkAddIngredientBurger(){
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "майонез", 5.5f));
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void checkRemoveIngredientBurger(){
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "майонез", 5.5f));
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void checkMoveIngredientBurger(){
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "майонез", 5.5f);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0,1);
        Assert.assertEquals(ingredient, burger.ingredients.get(1));
    }

    @Test
    public void checkPriceBurger(){
        Bun bun = new Bun("Булка", 1.1f);
        burger.setBuns(bun);
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "майонез", 5.5f));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "котлета", 5.5f));
        Mockito.when(burger.getPrice()).thenReturn(13.2f);
    }

    @Test
    public void checkGetReceiptBurger(){
        Bun bun = new Bun("Булка", 1.1f);
        burger.setBuns(bun);
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "майонез", 5.5f));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "котлета", 5.5f));
        Mockito.when(burger.getReceipt()).thenReturn("(==== Булка ====)\n= sause майонез =\n= filling котлета =\n(==== Булка ====)\n\nPrice: 13.2\n");
    }


}
