package pl.pjatk.tdd.test.strings;

import org.junit.Assert;
import org.junit.Test;
import pl.pjatk.tdd.strings.StringUtils;

public class StringUtilsTest {

    @Test
    public void sumOfAllNumbersInAStringShouldBeEqualTo7(){
        Assert.assertEquals(7, StringUtils.sumOfNumbersInAString("52"));
    }

    @Test
    public void sumOfAllNumbersInAStringShouldBeEqualTo15(){
        Assert.assertEquals(15, StringUtils.sumOfNumbersInAString("12345"));
    }

    @Test
    public void palindromeShouldReturnTrue(){
        Assert.assertTrue(StringUtils.palindrome("kamilŚlimak"));
    }

    @Test
    public void palindromeShouldReturnFalse(){
        Assert.assertFalse(StringUtils.palindrome("To nie jest palindrom"));
    }
}
