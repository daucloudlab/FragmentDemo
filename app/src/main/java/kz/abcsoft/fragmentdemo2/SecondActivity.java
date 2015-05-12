package kz.abcsoft.fragmentdemo2;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            finish();


        Intent intent = getIntent() ;
        int buttonIndex = intent.getIntExtra("buttonIndex", -1) ;
        if(buttonIndex != -1){
            FragmentManager fragmentManager = getFragmentManager() ;
            Fragment2 fragment2 = (Fragment2)fragmentManager.findFragmentById(R.id.fragment2) ;
            fragment2.setDescription(buttonIndex);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
