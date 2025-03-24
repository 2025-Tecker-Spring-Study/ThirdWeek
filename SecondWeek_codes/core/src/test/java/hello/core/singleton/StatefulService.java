package hello.core.singleton;

public class StatefulService {

    String itemName;

    public String order(String itemName, int price) {
        System.out.println("item : " + itemName + "price : " + price);
        this.itemName = itemName;
        return itemName;
    }

    public String getItemName() {
        return itemName;
    }
}
