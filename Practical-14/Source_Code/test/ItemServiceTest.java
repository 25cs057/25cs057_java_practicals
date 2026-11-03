package test;

import model.Item;
import service.InvalidItemException;
import service.ItemService;

/**
 * Unit test suite verifying ItemService business logic using @Test annotated methods.
 *
 * @author Krupal Parmar (25CS057)
 */
public class ItemServiceTest {

    @Test(description = "Verify that adding items increases the repository item count")
    public void testAddingIncreasesCount() throws InvalidItemException {
        ItemService service = new ItemService();
        assert service.getItemCount() == 0 : "Initial count must be 0";

        service.addItem(new Item("ITM01", "Mechanical Keyboard", 3500.0, 10));
        assert service.getItemCount() == 1 : "Count must become 1 after adding first item";

        service.addItem(new Item("ITM02", "Wireless Mouse", 1200.0, 25));
        assert service.getItemCount() == 2 : "Count must become 2 after adding second item";
    }

    @Test(description = "Verify that invalid actions throw InvalidItemException")
    public void testInvalidActionThrows() {
        ItemService service = new ItemService();

        // 1. Negative price test
        boolean priceThrew = false;
        try {
            service.addItem(new Item("ITM03", "Faulty Item", -50.0, 5));
        } catch (InvalidItemException e) {
            priceThrew = true;
        }
        assert priceThrew : "Adding item with negative price must throw InvalidItemException";

        // 2. Blank name test
        boolean blankNameThrew = false;
        try {
            service.addItem(new Item("ITM04", "   ", 200.0, 5));
        } catch (InvalidItemException e) {
            blankNameThrew = true;
        }
        assert blankNameThrew : "Adding item with blank name must throw InvalidItemException";

        // 3. Duplicate ID test
        boolean duplicateThrew = false;
        try {
            service.addItem(new Item("ITM05", "Valid Item A", 500.0, 2));
            service.addItem(new Item("ITM05", "Valid Item B", 600.0, 3));
        } catch (InvalidItemException e) {
            duplicateThrew = true;
        }
        assert duplicateThrew : "Adding item with duplicate ID must throw InvalidItemException";
    }

    @Test(description = "Verify item lookup and exception when searching non-existent ID")
    public void testFindExistingAndNonExistentItem() throws InvalidItemException {
        ItemService service = new ItemService();
        service.addItem(new Item("ITM10", "USB-C Hub", 1850.0, 15));

        // Existing item lookup
        Item found = service.findItemById("ITM10");
        assert found != null : "Item ITM10 must be found";
        assert "USB-C Hub".equals(found.getName()) : "Item name must match";
        assert Double.compare(1850.0, found.getPrice()) == 0 : "Item price must match";

        // Non-existent item lookup
        boolean nonExistentThrew = false;
        try {
            service.findItemById("DOES_NOT_EXIST");
        } catch (InvalidItemException e) {
            nonExistentThrew = true;
        }
        assert nonExistentThrew : "Searching for non-existent ID must throw InvalidItemException";
    }
}

