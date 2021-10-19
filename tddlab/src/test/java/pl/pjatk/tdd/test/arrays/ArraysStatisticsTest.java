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
}
