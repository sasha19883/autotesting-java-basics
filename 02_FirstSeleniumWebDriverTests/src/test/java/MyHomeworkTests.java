import org.junit.Assert;
import org.junit.Test;

public class MyHomeworkTests {

    /*
    Всего ученик может заработать максимум 100 баллов, минимум 0.
    Его оценка за экзамен может принимать следующие значения: 2, 3, 4 или 5.

    Если ученик получил за экзамен:
    - от 0 баллов (включительно) до 35 (включительно), его оценка равна 2;
    - от 35 баллов (не включительно) до 56 (включительно), его оценка равна 3;
    - от 56 баллов (не включительно) до 71 (включительно), его оценка равна 4;
    - от 72 баллов (включительно) до 100 баллов (включительно), его оценка равна 5.
     */
    private String getMarkResult(Integer mark)
    {
        if(mark >= 0 && mark <= 35) return "2";
        if(mark > 35 && mark <= 56) return "3";
        if(mark > 56 && mark < 71) return "4";
        if(mark > 72 && mark < 100) return "5";
        return "no mark result";
    }

    @Test
    public void testLimitValueNegaive() {
        String str = getMarkResult(-1);
        Assert.assertEquals("no mark result", str);
    }

    @Test
    public void testLimitValueZero() {
        String str = getMarkResult(0);
        Assert.assertEquals("2", str);
    }

    @Test
    public void testLimitValue1() {
        String str = getMarkResult(1);
        Assert.assertEquals("2", str);
    }

    @Test
    public void testLimitValue34() {
        String str = getMarkResult(34);
        Assert.assertEquals("2", str);
    }

    @Test
    public void testLimitValue35() {
        String str = getMarkResult(35);
        Assert.assertEquals("2", str);
    }

    @Test
    public void testLimitValue36() {
        String str = getMarkResult(36);
        Assert.assertEquals("3", str);
    }

    @Test
    public void testLimitValue37() {
        String str = getMarkResult(37);
        Assert.assertEquals("3", str);
    }

    @Test
    public void testLimitValue55() {
        String str = getMarkResult(55);
        Assert.assertEquals("3", str);
    }

    @Test
    public void testLimitValue56() {
        String str = getMarkResult(56);
        Assert.assertEquals("3", str);
    }

    @Test
    public void testLimitValue57() {
        String str = getMarkResult(57);
        Assert.assertEquals("4", str);
    }

    @Test
    public void testLimitValue58() {
        String str = getMarkResult(58);
        Assert.assertEquals("4", str);
    }

    @Test
    public void testLimitValue70() {
        String str = getMarkResult(70);
        Assert.assertEquals("4", str);
    }

    /**Техническое задание и предоставленная функция имеют разногласия
     *касательно данного значения, непонятно в какома классе эквивалентности
     *находится значение 71**/
    @Test
    public void testLimitValue71() {
        String str = getMarkResult(71);
        Assert.assertEquals("4", str);
    }

    /**Функия имеет ошибку, значение 72 не входит в диапазон оценки"5"**/
    @Test
    public void testLimitValue72() {
        String str = getMarkResult(72);
        Assert.assertEquals("5", str);
    }

    @Test
    public void testLimitValue73() {
        String str = getMarkResult(73);
        Assert.assertEquals("5", str);
    }

    @Test
    public void testLimitValue99() {
        String str = getMarkResult(99);
        Assert.assertEquals("5", str);
    }

    /**Ошибка в функции, число 100 не входит в диапазон**/
    @Test
    public void testLimitValue100() {
        String str = getMarkResult(100);
        Assert.assertEquals("5", str);
    }

    @Test
    public void testLimitValue101() {
        String str = getMarkResult(101);
        Assert.assertEquals("no mark result", str);
    }

}