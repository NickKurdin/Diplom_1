package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType type;
    private final IngredientType expectedType;

    public IngredientTypeTest(IngredientType type, IngredientType expectedType){
        this.type = type;
        this.expectedType = expectedType;
    }

    @Parameterized.Parameters(name = "Тест {index}. Тип ингредиента: {0}}")
    public static Object[][] getTestData() {
        return new Object[][] {
                {SAUCE, SAUCE},
                {FILLING, FILLING},
        };
    }

    @Test
    public void checkGettingIngredientType(){
        assertEquals(expectedType, type);
    }

}
