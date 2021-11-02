package pl.pjatk.tdd.test.arrays;

import org.junit.Assert;
import org.junit.Test;
import pl.pjatk.tdd.arrays.ArraysStatistics;

public class ArraysStatisticsTest {
    @Test
    public void maximumShouldBePositiveNumber(){
        Assert.assertEquals(1, ArraysStatistics.max(new int[]{-10,-5,1,-2,-13}));
    }

    @Test
    public void maximumShouldBeNegativeNumber(){
        Assert.assertEquals(-20, ArraysStatistics.max(new int[]{-20,-51,-111,-21,-163}));
    }

    @Test
    public void minimumShouldBePositiveNumber(){
        Assert.assertEquals(1, ArraysStatistics.min(new int[]{10,5,1,2,13}));
    }

    @Test
    public void minimumShouldBeNegativeNumber(){
        Assert.assertEquals(-163, ArraysStatistics.min(new int[]{-20,-51,-111,-21,-163}));
    }

    @Test
    public void averageOf10and20shouldBe15(){
        Assert.assertEquals(15,ArraysStatistics.avg(new int[]{10,20}),0.00001);
    }

    @Test
    public void averageShouldReturnNumberWithBreakpoint(){
        Assert.assertEquals(35.6,ArraysStatistics.avg(new int[]{123,3,0,44,8}),0.00001);
    }

    @Test
    public void sumOf10and20shouldBe30(){
        Assert.assertEquals(30,ArraysStatistics.sum(new int[]{10,20}));
    }

    @Test
    public void sumShouldReturn78(){
        Assert.assertEquals(78,ArraysStatistics.sum(new int[]{12,3,0,55,8}));
    }


}
