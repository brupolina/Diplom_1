import praktikum.Ingredient;
import praktikum.IngredientType;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тип ингридиента {0}, название {1}, цена {2}")
    public static Object[][] setData() {
        return new Object[][] {
                {IngredientType.FILLING, "hot sauce", 100f},
                {IngredientType.FILLING, "sour cream", 200f},
                {IngredientType.FILLING, "chili sauce", 300f},
                {IngredientType.SAUCE, "cutlet", 100f},
                {IngredientType.SAUCE, "dinosaur", 200f},
                {IngredientType.SAUCE, "sausage", 300f},
                {null, "sausage", 300f},
                {IngredientType.SAUCE, null, 300f},
                {IngredientType.SAUCE, "sausage", -30f},

        };
    }

    @Test
    public void checkIngredientType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals("Тип не соответствует \""+type+"\":", type, actualType);
    }

    @Test
    public void checkIngredientName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualName = ingredient.getName();
        Assert.assertEquals("Имя не соответствует \""+name+"\":", name, actualName);
    }

    @Test
    public void checkIngredientPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals("Цена не соответствует \""+price+"\":", price, actualPrice, 0);
    }

}