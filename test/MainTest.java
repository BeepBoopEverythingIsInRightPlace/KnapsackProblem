import com.company.Item;
import com.company.Main;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MainTest {

    @Test
    public void prepareItemsTest() {
        Main.prepareItems();
        Assert.assertFalse(Main.itemsToTake.isEmpty());
    }

    @Test
    public void pickBestItemsReturnTest() {
        Main.prepareItems();
        Assert.assertTrue(Main.pickBestItems() instanceof List);
    }

    @Test
    public void pickBestItemsReturnNullTest() {
        Main.prepareItems();
        Assert.assertNotNull(Main.pickBestItems());
    }

    @Test
    public void itemsSortTest() {
        Main.prepareItems();
        Main.pickBestItems();
        for (int i = 0; i < Main.itemsToTake.size() - 1 ; i++) {
            checkSorting(i);
        }
    }

    private void checkSorting(int i) {
        Item previousItem = Main.itemsToTake.get(i);
        Item nextItem = Main.itemsToTake.get(i + 1);
        Assert.assertTrue(previousItem.valueToWeightRatio > nextItem.valueToWeightRatio);
    }

}
