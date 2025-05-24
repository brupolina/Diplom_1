import praktikum.IngredientType;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class IngredientTypeTest {
    IngredientType[] ingredientTypes = IngredientType.values();
    @Test
    public void checkIngredientTypeContainsSauce() {
        Assert.assertTrue("Типа SAUCE нет в перечислении.",
                Arrays.asList(ingredientTypes).contains(IngredientType.SAUCE));
    }

    @Test
    public void checkIngredientTypeContainsFilling() {
        Assert.assertTrue("Типа FILLING нет в перечислении.",
                Arrays.asList(ingredientTypes).contains(IngredientType.FILLING));
    }

}