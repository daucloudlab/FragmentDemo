package kz.abcsoft.fragmentdemo2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WithTextViewFragment extends Fragment {

    private TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.fragment_with_textview, container, false);
        mTextView = (TextView) rootView.findViewById(R.id.textView);
        return rootView;
    }

    public void changeText(String data) {
        mTextView.setText(data);
    }
}
