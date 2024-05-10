package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    private final String expectedName;
    private final float expectedPrice;

    public BunTest(String name, float price, String expectedName, float expectedPrice){
        this.name = name;
        this.price = price;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "Тест {index}. Имя булочки: {0}, цена: {1}")
    public static Object[][] getTestData() {
        return new Object[][] {
                {"black bun", 1.25f, "black bun", 1.25f},
                {"pink bun", 0f, "pink bun", 0f},
                {"", 2.5f, "", 2.5f},
        };
    }

    @Test
    public void checkGetNameBun(){
        Bun bun = new Bun(name, price);
        Assert.assertEquals(expectedName, bun.getName());
    }

    @Test
    public void checkGetPriceBun(){
        Bun bun = new Bun(name, price);
        Assert.assertEquals(expectedPrice, bun.getPrice(), 0.0);
    }
}
