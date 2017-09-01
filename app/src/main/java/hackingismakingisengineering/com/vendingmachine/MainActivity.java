package hackingismakingisengineering.com.vendingmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import hackingismakingisengineering.com.vendingmachine.Model.Dispenser;
import hackingismakingisengineering.com.vendingmachine.Model.Item;
import hackingismakingisengineering.com.vendingmachine.Model.PPEClass;
import hackingismakingisengineering.com.vendingmachine.Model.User;
import hackingismakingisengineering.com.vendingmachine.Model.VendingMachine;

public class MainActivity extends AppCompatActivity {


    private static final int NUM_DISPENSERS = 14;
    private static final String TAG = "MAIN";
    VendingMachine vendingMachine = new VendingMachine(NUM_DISPENSERS);

    Item gloves = new Item(3.40f,"ninja gloves", PPEClass.HAND_PROTECTION);
    Item glasses = new Item(4.70f,"safety glasses", PPEClass.EYE_PROTECTION);
    Item earBuds = new Item(0.40f,"ear plugs", PPEClass.HEARING_PROTECTION);

    User cameron = new User("Cameron Stewart", 1, 1, 10.0f);
    User laky = new User("Laky houtanga", 2, 1, 10.0f);
    User logedInUser;


    Button vendButton = (Button) findViewById(R.id.vend_button);
    Button creditButton = (Button) findViewById(R.id.credit_button);

    TextView userText = (TextView) findViewById(R.id.user_name);
    TextView vendingText = (TextView) findViewById(R.id.vending_machine_text);

    EditText editText = (EditText) findViewById(R.id.edit_text);

    int selectedItem=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {



        vendingMachine.setDispenser(1,gloves);
        vendingMachine.setDispenser(2,gloves);
        vendingMachine.setDispenser(3,gloves);
        vendingMachine.setDispenser(4,gloves);
        vendingMachine.setDispenser(5,gloves);
        vendingMachine.setDispenser(6,glasses);
        vendingMachine.setDispenser(7,glasses);
        vendingMachine.setDispenser(8,glasses);
        vendingMachine.setDispenser(9,glasses);
        vendingMachine.setDispenser(10,glasses);
        vendingMachine.setDispenser(11,earBuds);
        vendingMachine.setDispenser(12,earBuds);
        vendingMachine.setDispenser(13,earBuds);
        vendingMachine.setDispenser(14,earBuds);
        vendingMachine.setDispenser(15,earBuds);

        vendingMachine.fillAllDispensers();

        //TODO scan card;
        logedInUser = cameron;

        purhase(1);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        creditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                logedInUser.credit(1.00f);
            }

        });

        vendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String editText = editText.getText();
                selectedItem = Integer.parseInt(editText);

                purhase(selectedItem);
            }
        });



    }

    private void purhase(int posn) {

        Dispenser selectedDispenser = vendingMachine.getDispenser(posn);

        // Check that dispenser is not empty
        if(!selectedDispenser.isEmpty()){
            Log.v(TAG, "The machine is out of that item, select another ");
        }else{
            Item selectedItem = vendingMachine.getDispenser(posn).getSetItem();

            // Check user has sufficient credit
            if(selectedItem.getValue()>logedInUser.getCredit()){

                Log.v(TAG, "You do not have enough credit");

                // If passed, vend item and deduct credit
            }else {
                logedInUser.setCredit(logedInUser.getCredit() - selectedItem.getValue());
                selectedDispenser.vendItem();
            }
        }

    }
}
