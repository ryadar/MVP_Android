package com.ryadar.mvp.interactor;

import android.os.AsyncTask;
import android.util.Log;

import com.ryadar.mvp.model.MyData;
import com.ryadar.mvp.presenter.MyPresenter;

public class MyInteractor {
    public static String TAG=MyInteractor.class.getSimpleName();
    private MyPresenter myPresenter;

    public MyInteractor(MyPresenter mMyPresenter){
        Log.i(TAG,"-----MyInteractor Constructor-----");
        myPresenter = mMyPresenter;
    }
    public void getDataFromService(){
        Log.i(TAG,"-----getDataFromService-----");
        new MyAsynk().execute();
    }
    public interface MyInterActorInterface{
        void sendOnResponseData(MyData myData);
    }
    class MyAsynk extends AsyncTask<Void,Void,Integer>{
        MyData myData;
        @Override
        protected Integer doInBackground(Void... params) {
            int counter=0;
            myData = new MyData();
            while(counter<5) {
                try {
                    Log.i(TAG,"-----doInBackground----- count value\t"+ counter);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter++;
            }
            return 200;
        }
        @Override
        protected void onPostExecute(Integer responseCode) {
            super.onPostExecute(responseCode);

            if(responseCode==200){
                myData.setContent("Success");
                myData.setSize(5);
            }else{
                myData.setSize(-1);
            }
            Log.i(TAG,"-----onPostExecute-----");
            myPresenter.sendOnResponseData(myData);
        }
    }
}
