package br.com.tairoroberto.testelinkfy;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.support.v7.app.ActionBarActivity;
import android.text.util.Linkify;
import android.text.util.Linkify.MatchFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	
	private TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		txt1 = (TextView)findViewById(R.id.textView1);
		txt2 = (TextView)findViewById(R.id.textView2);
		txt3 = (TextView)findViewById(R.id.textView3);
		txt4 = (TextView)findViewById(R.id.textView4);
		txt5 = (TextView)findViewById(R.id.textView5);
		txt6 = (TextView)findViewById(R.id.textView6);
		txt7 = (TextView)findViewById(R.id.textView7);
		txt8 = (TextView)findViewById(R.id.textView8);
		
		Linkify.addLinks(txt1, Linkify.ALL);
		Linkify.addLinks(txt2, Linkify.EMAIL_ADDRESSES);
		Linkify.addLinks(txt3, Linkify.PHONE_NUMBERS);
		Linkify.addLinks(txt4, Linkify.WEB_URLS);
		Linkify.addLinks(txt5, Linkify.MAP_ADDRESSES);
		
		//Cria uma expressao regular para pegar uma palavra dentro do textView
		//no caso será a palavre 'OU'
		Pattern pattern = Pattern.compile("(OU)");		
		Linkify.addLinks(txt6, pattern, "http://www.tairoroberto.kinghost.net/"); //funciona com esse construtor
		
		//Add um tranform filter para adicionar o texto encontrado a url
		Linkify.TransformFilter transformFilter = new Linkify.TransformFilter() {			
			@Override
			public String transformUrl(Matcher match, String url) {
				// TODO Auto-generated method stub
				return("contact");
			}
		};		
		
		//Add um filtro ao texto
		Linkify.MatchFilter filter = new Linkify.MatchFilter() {			
			@Override
			public boolean acceptMatch(CharSequence s, int start, int end) {
				if (start > 5) {
					return(true);//retorna um link
				}else{
					return(false); //retorna um texto
				}				
			}
		};		
		Linkify.addLinks(txt7, pattern, "http://www.tairoroberto.kinghost.net/",filter,transformFilter);
		
		Linkify.addLinks(txt8, Linkify.ALL);
		
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
}
