import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient sauce;
    @Mock
    private Ingredient filling;

    @Test
    public void checkSetBuns() {
        burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }
    @Test
    public void checkAddIngredient() {
        burger = new Burger();
        burger.addIngredient(sauce);
        //    Assert.assertEquals("В бургер было добавлено " + burger.ingredients.size() + " ингредиентов, ожидалось добавление 1 ингредиента", 1, burger.ingredients.size());
        Assert.assertTrue("Ингредиент не добавлен.", burger.ingredients.contains(sauce));
    }

    @Test
    public void checkRemoveIngredient() {
        burger = new Burger();
        burger.addIngredient(sauce);
        int index = burger.ingredients.indexOf(sauce);
        burger.removeIngredient(index);
        Assert.assertFalse("Ингредиент не удален.", burger.ingredients.contains(sauce));
    }

    @Test
    public void moveIngredient_ShouldPlaceMovedIngredientAtNewIndex() {
        burger = new Burger();
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Перемещаемый ингредиент - не на новом месте.", burger.ingredients.get(0), filling);
    }

    @Test
    public void moveIngredient_ShouldShiftIngredientFromOldIndex() {
        burger = new Burger();
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Ингредиент не смещён с нового места", burger.ingredients.get(1), sauce);
    }

    @Test
    public void checkGetPrice() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(sauce.getPrice()).thenReturn(30f);
        Mockito.when(filling.getPrice()).thenReturn(20f);
        float expectedPrice = bun.getPrice() * 2 + sauce.getPrice() + filling.getPrice();

        Assert.assertEquals("Цена не соответствует \""+expectedPrice+"\":", expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void checkGetReceipt() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(200f);

        Mockito.when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(sauce.getName()).thenReturn("chili sauce");
        Mockito.when(sauce.getPrice()).thenReturn(300f);

        Mockito.when(filling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(filling.getName()).thenReturn("cutlet");
        Mockito.when(filling.getPrice()).thenReturn(100f);

        String expectedReceipt = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", sauce.getType().toString().toLowerCase(), sauce.getName()) +
                String.format("= %s %s =%n", filling.getType().toString().toLowerCase(), filling.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());

        Assert.assertEquals("Чек не соответствовать ожидаемому.", expectedReceipt, burger.getReceipt());
    }
}