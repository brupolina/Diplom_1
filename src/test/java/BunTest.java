import praktikum.Bun;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters(name = "Булочка {0} по цене {1}" )
    public static Object[][] setData() {
        return new Object[][]{
                {"Флюоресцентная", 80f},
                {"Краторная", 60.5f},
                {"Spaceman", 70f},
                {"Булка", 0.0f},
                {"Булка", -10.0f},
                {"", 50.0f}
        };
    }

    @Test
    public void checkGetName() {
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        Assert.assertEquals("Имя не соответствует \""+name+"\":", name, actualName);
    }
    @Test
    public void checkGetPrice() {
        Bun bun = new Bun(name, price);
        float actualPrice = bun.getPrice();
        Assert.assertEquals("Цена не соответствует \""+price+"\":", price, actualPrice, 0);
    }
}