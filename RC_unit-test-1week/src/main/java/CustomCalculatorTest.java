import org.junit.Test;
import static org.junit.Assert.*;
public class CustomCalculatorTest {

    @Test
    public void addTest(){
        CustomCalculator customCalculator = new CustomCalculator();
        int result = customCalculator.add(3,4);
        assertTrue(result==7);
    }

    @Test
    public void subTest(){
        CustomCalculator customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(10,2);
        assertTrue(result==8);
    }

    @Test
    public void mulTest(){
        CustomCalculator customCalculator = new CustomCalculator();
        int result = customCalculator.multiply(2,3);
        assertTrue(result==6);
    }

    @Test
    public void divTest(){
        CustomCalculator customCalculator = new CustomCalculator();
        int result = customCalculator.divide(6,2);
        assertTrue(result==3);
    }


}