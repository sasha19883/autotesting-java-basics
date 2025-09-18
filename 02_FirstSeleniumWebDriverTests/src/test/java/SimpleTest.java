import org.junit.Assert;
import org.junit.Test;

public class SimpleTest {

    @Test
    public void testNormalWeight(){
        var actualResult = getIMTResult(180F, 75F);
        Assert.assertEquals("нормальной массе тела", actualResult);
    }

    @Test
    public void testZeroHeight(){
        var actualResult = getIMTResult(0f, 65f);
        Assert.assertEquals("указан некорректный рост", actualResult);
    }

    @Test
    public void testNegativeHeight(){
        var actualResult = getIMTResult(-1f, 65f);
        Assert.assertEquals("указан некорректный рост", actualResult);
    }

    @Test
    public void testBigHeight351(){
        var actualResult = getIMTResult(351f, 65f);
        Assert.assertEquals("указан некорректный рост", actualResult);
    }

    @Test
    public void testBigHeight352(){
        var actualResult = getIMTResult(352f, 65f);
        Assert.assertEquals("указан некорректный рост", actualResult);
    }

    @Test
    public void testNegativeWeight(){
        var actualResult = getIMTResult(170f, -1f);
        Assert.assertEquals("указан некорректный вес", actualResult);
    }

    @Test
    public void testZeroWeight(){
        var actualResult = getIMTResult(170f, 0f);
        Assert.assertEquals("указан некорректный вес", actualResult);
    }

    @Test
    public void testVeryBigWeight1001(){
        var actualResult = getIMTResult(170f, 1001f);
        Assert.assertEquals("указан некорректный вес", actualResult);
    }

    @Test
    public void testVeryBigWeight1002(){
        var actualResult = getIMTResult(170f, 1002f);
        Assert.assertEquals("указан некорректный вес", actualResult);
    }

    @Test
    public void testLimitsHeightMax(){
        var actualResult = getIMTResult(350f, 100f);
        Assert.assertEquals("выраженному дефициту массы тела", actualResult);
    }

    @Test
    public void testLimitsHeightMin(){
        var actualResult = getIMTResult(10f, 20f);
        Assert.assertEquals("избыточной массе тела", actualResult);
    }

    @Test
    public void testLimitsWeightMin(){
        var actualResult = getIMTResult(1f, 1f);
        Assert.assertEquals("избыточной массе тела", actualResult);
    }

    @Test
    public void testLimitsWeightMax(){
        var actualResult = getIMTResult(200f, 1000f);
        Assert.assertEquals("избыточной массе тела", actualResult);
    }

    @Test
    public void testImtFrom0To16(){
        var actualResult = getIMTResult(180f, 50f);
        Assert.assertEquals("выраженному дефициту массы тела", actualResult);
    }

    @Test
    public void testImtFrom16To19(){
        var actualResult = getIMTResult(170f, 50f);
        Assert.assertEquals("недостаточной массе тела", actualResult);
    }

    @Test
    public void testImtFrom19To25(){
        var actualResult = getIMTResult(180f, 70f);
        Assert.assertEquals("нормальной массе тела", actualResult);
    }

    @Test
    public void testImtFrom25(){
        var actualResult = getIMTResult(180f, 90f);
        Assert.assertEquals("избыточной массе тела", actualResult);
    }

    private String getIMTResult(Float heightCm, Float weightKg)
    {
        var userIndex = Math.round(weightKg / Math.pow((heightCm / 100), 2));
        String userResult = null;
        if (heightCm <= 0 || heightCm > 350) {
            userResult = "указан некорректный рост";
        } else if (weightKg <= 0 || weightKg > 1000) {
            userResult = "указан некорректный вес";
        } else if (userIndex <= 16) {

            userResult = "выраженному дефициту массы тела";

        } else if (userIndex > 16 && userIndex < 19)  {

            userResult = "недостаточной массе тела";

        } else if (userIndex > 19 && userIndex < 25) {

            userResult = "нормальной массе тела";

        } else if (userIndex > 25) {

            userResult = "избыточной массе тела";

        }

        return userResult;
    }
}