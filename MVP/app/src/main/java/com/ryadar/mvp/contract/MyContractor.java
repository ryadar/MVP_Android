package com.ryadar.mvp.contract;

import com.ryadar.mvp.model.MyData;

public class MyContractor {

   public interface View{
        void updateViewWithData(MyData myData);
    }

    public interface Presenter{
        void fetchData();
    }
}
