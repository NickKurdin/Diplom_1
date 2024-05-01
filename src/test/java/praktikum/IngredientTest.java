package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    @Mock
    Ingredient ingredient = new Ingredient(FILLING, "Котлета", 5.2f);

    @Test
    public void checkGetTypeIngredient() {
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
    }

    @Test
    public void checkGetNameIngredient(){
        Mockito.when(ingredient.getName()).thenReturn("Котлета");
    }

    @Test
    public void checkGetPriceIngredient(){
        Mockito.when(ingredient.getPrice()).thenReturn(5.2f);
    }
}
