import com.company.Item;
import com.company.Main;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainTest {

    @Test
    public void prepareItemsTest() {
        Main.prepareItems();
        Assert.assertFalse(Main.itemsToTake.isEmpty());
    }

    @Test
    public void pickBestItemsReturnTest() {
        ArrayList<Item> bestItems = new ArrayList<Item>();
        Main.prepareItems();
        Assert.assertTrue(Main.pickBestItems(new ArrayList<Item>()) instanceof List);
    }

    @Test
    public void pickBestItemsReturnNullTest() {
        ArrayList<Item> bestItems = new ArrayList<Item>();
        Main.prepareItems();
        Assert.assertNotNull(Main.pickBestItems(new ArrayList<Item>()));
    }

    @Test
    public void itemsSortTest() {
        List<Item> bestItems = new ArrayList<Item>();
        Main.prepareItems();
        bestItems = Main.pickBestItems(Main.itemsToTake);
        Main.sortItemsToTake();
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
