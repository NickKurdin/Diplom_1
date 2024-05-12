package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тест {index}. Тип ингредиента: {0}, название ингредиента: {1}, цена ингредиента: {2}")
    public static Object[][] getTestData() {
        return new Object[][] {
                {FILLING, "Котлета", 5.25f},
                {SAUCE, "Майонез", 2.25f},
        };
    }

    @Test
    public void checkGetTypeIngredient() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualIngredientType = ingredient.getType();
        assertEquals(type, actualIngredientType);
    }

    @Test
    public void checkGetNameIngredient(){
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualIngredientName = ingredient.getName();
        assertEquals(name, actualIngredientName);
    }

    @Test
    public void checkGetPriceIngredient(){
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualIngredientPrice = ingredient.getPrice();
        assertEquals(price, actualIngredientPrice, 0.0);
    }
}
