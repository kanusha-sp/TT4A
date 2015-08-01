package qcom.tryandriod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	public final static String EXTRA_MESSAGE = "qcom.tryandroid.MESSAGE";
	List<Client> clientList = new ArrayList<Client>();
	
	Client client=null;
	TextView optionName1 = null;
	TextView optionName2 = null;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ReportMaker reportMaker = new ReportMaker();
        clientList = ReportMaker.getClients();
        client= clientList.get(0);
    	
        Stock stockMain = new Stock();
        //public static double stockPrice = stockMain.getCurrentPrice();
		
		//ComputeClientProfit();
        TextView stockPriceText = (TextView) findViewById(R.id.textView3);
        stockPriceText.setText(String.valueOf(stockMain.getCurrentPrice()));
        
        TextView clientName = (TextView) findViewById(R.id.clientName);
        clientName.setText(client.clientName);
        
        TextView premiumText = (TextView) findViewById(R.id.textView4);
        premiumText.setText(String.valueOf(client.premiumAmount));
        
        optionName1 = (TextView) findViewById(R.id.optionName1);
        optionName1.setText(String.valueOf(client.optionList.get(0).getName()));
        
        optionName2 = (TextView) findViewById(R.id.optionName2);
        optionName2.setText(String.valueOf(client.optionList.get(1).getName()));
        
        Button submitBtn = (Button) findViewById(R.id.submit);
        submitBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				CheckBox call1 = (CheckBox)findViewById(R.id.call1);
				CheckBox call2 = (CheckBox)findViewById(R.id.call2);
				CheckBox put1 = (CheckBox)findViewById(R.id.put1);
				CheckBox put2 = (CheckBox)findViewById(R.id.put2);
		        if(call1.isChecked()){
		        	List<Option> optionList = new ArrayList<Option>();
		        	optionList = client.optionList;
					Iterator<Option> optionItr = optionList.iterator();
										
					while(optionItr.hasNext()){
						Option option = optionItr.next();
						if(option.getName().equals(optionName1.getText())){
							option.setOperation("call");
						}
					}
		        }
		        
		        if(put1.isChecked()){
		        	List<Option> optionList = new ArrayList<Option>();
		        	optionList = client.optionList;
					Iterator<Option> optionItr = optionList.iterator();
										
					while(optionItr.hasNext()){
						Option option = optionItr.next();
						if(option.getName().equals(optionName1.getText())){
							option.setOperation("put");
							
						}
					}
		        }
		        
		        if(call2.isChecked()){
		        	List<Option> optionList = new ArrayList<Option>();
		        	optionList = client.optionList;
					Iterator<Option> optionItr = optionList.iterator();
										
					while(optionItr.hasNext()){
						Option option = optionItr.next();
						if(option.getName().equals(optionName2.getText())){
							option.setOperation("call");
						}
					}
		        }
		        
		        if(put2.isChecked()){
		        	List<Option> optionList = new ArrayList<Option>();
		        	optionList = client.optionList;
					Iterator<Option> optionItr = optionList.iterator();
										
					while(optionItr.hasNext()){
						Option option = optionItr.next();
						if(option.getName().equals(optionName2.getText())){
							option.setOperation("put");
						}
					}
		        }
		        
			}
		});
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void send_message(View view) {
    	/*Intent intent = new Intent(this, DisplayMessageActivity.class);
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	String message = editText.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);*/
    }
    
}
