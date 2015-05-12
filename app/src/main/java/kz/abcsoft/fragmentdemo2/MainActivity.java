package kz.abcsoft.fragmentdemo2;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends Activity implements OnSelectedButtonListener, Communicator {

    private boolean mIsDynamic;

    @Override
    public void count(String data){
        FragmentManager manager = getFragmentManager();
        WithTextViewFragment withTextViewFragment =
                (WithTextViewFragment) manager.findFragmentById(R.id.fragment_withTextView);
        withTextViewFragment.changeText(data);
    }

    @Override
    public void onSelectedButton(int buttonIndex) {
//        FragmentManager fragmentManager = getFragmentManager() ;
//        Fragment2 fragment2 = (Fragment2)fragmentManager.findFragmentById(R.id.fragment2) ;
//        if(fragment2 == null || !fragment2.isVisible()) {
////            fragment2.setDescription(buttonIndex);
//            Intent intent = new Intent(this, SecondActivity.class) ;
//            intent.putExtra("buttonIndex", buttonIndex) ;
//            startActivity(intent) ;
//        }else{
//            fragment2.setDescription(buttonIndex);
//        }
        // подключаем FragmentManager
        FragmentManager fragmentManager = getFragmentManager();
        Fragment2 fragment2;

        // Если фрагмент недоступен
        if (mIsDynamic) {
            // Динамическое переключение на другой фрагмент
            FragmentTransaction ft = fragmentManager.beginTransaction();
            fragment2 = new Fragment2();

            // Подготавливаем аргументы
            Bundle args = new Bundle();
            args.putInt(Fragment2.BUTTON_INDEX, buttonIndex);
            fragment2.setArguments(args);

            ft.replace(R.id.container, fragment2, "fragment2");
            ft.addToBackStack(null);
            ft.setCustomAnimations(
                    android.R.animator.fade_in, android.R.animator.fade_out);
            ft.commit();
        } else {
            // Если фрагмент доступен
            fragment2 = (Fragment2) fragmentManager
                    .findFragmentById(R.id.fragment2);
            fragment2.setDescription(buttonIndex);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        Fragment2 fragment2 = (Fragment2) fragmentManager.findFragmentById(R.id.fragment2);
        mIsDynamic = fragment2 == null || !fragment2.isInLayout();
//        Toast.makeText(getApplicationContext(), mIsDynamic + "", Toast.LENGTH_SHORT).show();
        // Зная, что второго фрагмента нет, загружаем первый
        if (mIsDynamic) {
            // начинаем транзакцию
            FragmentTransaction ft = fragmentManager.beginTransaction();
            // Создаем и добавляем первый фрагмент
            Fragment1 fragment1 = new Fragment1();
            ft.add(R.id.container, fragment1, "fragment1");
            // Подтверждаем операцию
            ft.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
