package kz.abcsoft.fragmentdemo2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class WithButtonFragment extends Fragment implements View.OnClickListener{

    private Communicator mCommunicator;
    private int mCounter = 0 ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_with_button, container, false) ;
        Button button = (Button)rootView.findViewById(R.id.button) ;
        button.setOnClickListener(this);
        return rootView ;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mCommunicator = (Communicator)getActivity() ;

    }

    @Override
    public void onClick(View v) {
        mCounter++;
        mCommunicator.count("Я насчитал " + mCounter + " котов");
    }
}
