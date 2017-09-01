package hackingismakingisengineering.com.vendingmachine.Model;

import java.util.ArrayList;

/**
 * Created by Cam on 1/09/2017.
 */

public class VendingMachine {

    ArrayList<Dispenser> dispenserArrayList;


    public VendingMachine(ArrayList<Dispenser> dispenserArrayList) {
        this.dispenserArrayList = dispenserArrayList;
    }

    public VendingMachine(int numDispensers) {
        dispenserArrayList = new ArrayList<Dispenser>(numDispensers);
    }

    public ArrayList<Dispenser> getDispenserArrayList() {
        return dispenserArrayList;
    }

    public void setDispenserArrayList(ArrayList<Dispenser> dispenserArrayList) {
        this.dispenserArrayList = dispenserArrayList;
    }

    @Override
    public String toString() {

        String output ="VendingMachine{\n";

        for(Dispenser dispenser: dispenserArrayList){
            output += "["+dispenser.toString()+"]";

        }


        return output;
    }

    public void fillAllDispensers(){

        for(Dispenser dispenser: dispenserArrayList){
            dispenser.refillAll();
        }

    }

    public void setDispenser(int position, Item item){

        dispenserArrayList.get(position).setSetItem(item);

    }

    public Dispenser getDispenser(int posn) {
        return dispenserArrayList.get(posn);
    }
}
