package hackingismakingisengineering.com.vendingmachine.Model;

import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by Cam on 1/09/2017.
 */

public class Dispenser {

    Queue<Item> items;
    Item setItem;
    int numSpaces =0 ;


    public Dispenser(Queue<Item> items, Item setItem, int numSpaces) {
        this.items = items;
        this.setItem = setItem;
        this.numSpaces = numSpaces;
    }

    public void refillAll() {

        if(numSpaces!=0 & setItem!=null ){
            for(Item item: items){
                if(item==null){
                    item = new Item(setItem);
                }

            }
        }
    }

    public void restockItem(){
        items.add(new Item(setItem));
    }

    public Queue<Item> getItems() {
        return items;
    }

    public void setItems(Queue<Item> items) {
        this.items = items;
    }

    public Item getSetItem() {
        return setItem;
    }

    public void setSetItem(Item setItem) {
        this.setItem = setItem;
    }

    public int getNumSpaces() {
        return numSpaces;
    }

    public void setNumSpaces(int numSpaces) {
        this.numSpaces = numSpaces;
    }

    public Item vendItem(){
        return items.poll();
    }

    @Override
    public String toString() {
        return "Dispenser{" +
                "items=" + items +
                ", setItem=" + setItem +
                ", numSpaces=" + numSpaces +
                '}';
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
