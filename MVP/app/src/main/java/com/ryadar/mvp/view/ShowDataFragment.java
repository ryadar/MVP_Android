package com.ryadar.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ryada.mvp.R;
import com.ryadar.mvp.contract.MyContractor;
import com.ryadar.mvp.model.MyData;
import com.ryadar.mvp.presenter.MyPresenter;

public class ShowDataFragment extends Fragment implements MyContractor.View {
    private static String TAG=ShowDataFragment.class.getSimpleName();
    private MyPresenter myPresenter;
    private TextView textView;
    private ProgressBar progressBar;
    private static final String KEY="PresenterKey";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG,"------Fragment onCreateView ------");

        myPresenter = (savedInstanceState == null) ?
                new MyPresenter(this) :
                (MyPresenter)savedInstanceState.getParcelable(KEY);

        View view =inflater.inflate(R.layout.show_data_layout,container,false);

        progressBar=(ProgressBar) view.findViewById(R.id.progressBar);
        textView=(TextView)view.findViewById(R.id.textView2);

        progressBar.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);

        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                Log.i(TAG,"------Button onClick------");
                textView.setVisibility(View.VISIBLE);
                textView.setText("Requesting Data");
                myPresenter.fetchData();
            }
        });
        return view;
    }

    @Override
    public void updateViewWithData(MyData myData) {
        Log.i(TAG,"------updateViewWithData------");

        if(myData.getSize()>0){
            textView.setText(""+myData.getSize());
        }else{
            textView.setText("request is not success");
        }
        progressBar.setVisibility(View.INVISIBLE);
        textView.setText("Done");
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG,"------onDestroyView------");
        super.onDestroyView();
        if(myPresenter !=null) {
            myPresenter = null;
        }
    }

}
