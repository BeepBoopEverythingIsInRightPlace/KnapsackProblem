import com.company.Item;
import org.junit.Assert;
import org.junit.Test;

public class ItemTest {
    @Test
    public void itemCasualCreationTest() {
        Item item = new Item(5, 10);
        Assert.assertNotNull(item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void itemCreationNegativeWeightTest() {
        Item item = new Item(-5, 10);
        Assert.assertNotNull(item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void itemCreationNegativeValueTest() {
        Item item = new Item(5, -10);
        Assert.assertNotNull(item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void itemCreationNegativeValueAndWeightTest() {
        Item item = new Item(-5, -10);
        Assert.assertNotNull(item);
    }

    @Test
    public void toStringTest() {
        Item item = new Item(5,10);
        Assert.assertEquals("value: 10, weight: 5", item.toString());
    }

    //ten test nic nie mówi, nie wiem jak to zrobić
    @Test
    public void itemCompareToTest() {
        Item biggerItem = new Item(5,10);
        Item smallerItem = new Item(6,10);
        Assert.assertTrue(0 > biggerItem.compareTo(smallerItem));
    }

    @Test
    public void valueToWeightConstructorTest() {
        Item item = new Item(8, 1);
        Assert.assertEquals(0.125, item.valueToWeightRatio, 0.0001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void valueToWeightConstructorZeroDivideTest() {
        Item item = new Item(8, 0);
    }
}
