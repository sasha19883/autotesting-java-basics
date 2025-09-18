import org.junit.Assert;
import org.junit.Test;

public class CalculationOfInterestOnTicketRefundsTest {

    private Integer getRefundTicketPricePercent(Integer hoursBeforeConcert, Boolean wasConcertCancelled,
                                                Boolean wasConcertRescheduled) {

        if (wasConcertCancelled && wasConcertRescheduled) return 100;
        if (hoursBeforeConcert > 240) return 100;
        if (hoursBeforeConcert >= 144 && hoursBeforeConcert <= 240) return 50;
        if (hoursBeforeConcert > 3 && hoursBeforeConcert <= 144) return 30;

        return 0;
    }

    @Test
    public void moreThanTenDaysTest(){
        int result = getRefundTicketPricePercent(241, false, false);
        Assert.assertEquals(100, result);
    }

    @Test
    public void menDaysTest(){
        int result = getRefundTicketPricePercent(240, false, false);
        Assert.assertEquals(50, result);
    }

    @Test
    public void lessThanTenDays(){
        int result = getRefundTicketPricePercent(239, false, false);
        Assert.assertEquals(50, result);
    }

    @Test
    public void sixDaysTest(){
        int result = getRefundTicketPricePercent(144, false, false);
        Assert.assertEquals(50, result);
    }

    @Test
    public void fiveDaysTest(){
        int result = getRefundTicketPricePercent(120, false, false);
        Assert.assertEquals(30, result);
    }

    @Test
    public void moreThanThreeDaysTest(){
        int result = getRefundTicketPricePercent(73, false, false);
        Assert.assertEquals(30, result);
    }

    @Test
    public void threeDaysTest(){
        int result = getRefundTicketPricePercent(72, false, false);
        Assert.assertEquals(0, result);
    }

    @Test
    public void lessThanThreeDays(){
        int result = getRefundTicketPricePercent(71, false, false);
        Assert.assertEquals(0, result);
    }

    @Test
    public void twoHoursBeforeTest(){
        int result = getRefundTicketPricePercent(2, false, false);
        Assert.assertEquals(0, result);
    }

    @Test
    public void zeroHoursTest(){
        int result = getRefundTicketPricePercent(0, false, false);
        Assert.assertEquals(0, result);
    }

    @Test
    public void negativeHoursTest(){
        int result = getRefundTicketPricePercent(-1, false, false);
        Assert.assertEquals(0, result);
    }
}