package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;

    public IngredientTest(IngredientType type, String name, float price, IngredientType expectedType,
                          String expectedName, float expectedPrice){
        this.type = type;
        this.name = name;
        this.price = price;
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "Тест {index}. Тип ингредиента: {0}, название ингредиента: {1}, цена ингредиента: {2}")
    public static Object[][] getTestData() {
        return new Object[][] {
                {FILLING, "Котлета", 5.25f, FILLING, "Котлета", 5.25f},
                {SAUCE, "Майонез", 2.25f, SAUCE, "Майонез", 2.25f},
        };
    }

    @Test
    public void checkGetTypeIngredient() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(expectedType, ingredient.getType());
    }

    @Test
    public void checkGetNameIngredient(){
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void checkGetPriceIngredient(){
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(expectedPrice, ingredient.getPrice(), 0.0);
    }
}
