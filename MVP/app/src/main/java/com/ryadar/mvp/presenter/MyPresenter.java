package com.ryadar.mvp.presenter;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.ryadar.mvp.contract.MyContractor;
import com.ryadar.mvp.interactor.MyInteractor;
import com.ryadar.mvp.model.MyData;
import com.ryadar.mvp.view.ShowDataFragment;


public class MyPresenter implements MyContractor.Presenter,MyInteractor.MyInterActorInterface ,Parcelable {
    private static String TAG=MyPresenter.class.getSimpleName();

    private ShowDataFragment view;
    private MyInteractor myInteracter;

    public MyPresenter(Fragment mView){
        Log.i(TAG,"-----MyPresenter Constructor -----");

        view=(ShowDataFragment) mView;

        initilizeInteractor();
    }


    protected MyPresenter(Parcel in) {
    }

    public static final Creator<MyPresenter> CREATOR = new Creator<MyPresenter>() {
        @Override
        public MyPresenter createFromParcel(Parcel in) {
            return new MyPresenter(in);
        }

        @Override
        public MyPresenter[] newArray(int size) {
            return new MyPresenter[size];
        }
    };

    void initilizeInteractor(){
        Log.i(TAG,"-----init-----");
        myInteracter=new MyInteractor(this);
    }


    @Override
    public void sendOnResponseData(MyData myData) {
        Log.i(TAG,"-----sendOnResponseData-----");
        view.updateViewWithData(myData);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public void fetchData() {
        Log.i(TAG,"-----fetchData-----");
        myInteracter.getDataFromService();
    }
}
