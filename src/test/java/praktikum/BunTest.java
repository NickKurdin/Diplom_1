package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тест {index}. Имя булочки: {0}, цена: {1}")
    public static Object[][] getTestData() {
        return new Object[][] {
                {"black bun", 1.25f},
                {"pink bun", 0.5f}
        };
    }

    @Test
    public void checkGetNameBun(){
        Bun bun = new Bun(name, price);
        String actualBunName = bun.getName();
        assertEquals(name, actualBunName);
    }

    @Test
    public void checkGetPriceBun(){
        Bun bun = new Bun(name, price);
        float actualBunPrice = bun.getPrice();
        assertEquals(price, actualBunPrice, 0.0);
    }
}
