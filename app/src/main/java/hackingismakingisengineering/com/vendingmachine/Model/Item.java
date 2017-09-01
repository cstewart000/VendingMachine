package hackingismakingisengineering.com.vendingmachine.Model;

/**
 * Created by Cam on 1/09/2017.
 */

public class Item {


    float value;
    String description;
    PPEClass ppeClass;

    public Item(float value, String description, PPEClass ppeClass) {
        this.value = value;
        this.description = description;
        this.ppeClass = ppeClass;
    }

    public Item(Item item) {

        this.value = item.getValue();
        this.description = item.getDescription();
        this.ppeClass = item.getPpeClass();

    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PPEClass getPpeClass() {
        return ppeClass;
    }

    public void setPpeClass(PPEClass ppeClass) {
        this.ppeClass = ppeClass;
    }

    @Override
    public String toString() {
        return "Item{" +
                "value=" + value +
                ", description='" + description + '\'' +
                ", ppeClass=" + ppeClass +
                '}';
    }
}
