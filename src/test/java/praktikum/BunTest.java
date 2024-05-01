package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    @Mock
    Bun bun = new Bun("test", 1.25f);

    @Test
    public void checkGetNameBun(){
        Mockito.when(bun.getName()).thenReturn("test");
    }

    @Test
    public void checkGetPriceBun(){
        Mockito.when(bun.getPrice()).thenReturn(1.25f);
    }
}
