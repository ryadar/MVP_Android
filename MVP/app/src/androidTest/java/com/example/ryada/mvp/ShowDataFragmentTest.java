package com.example.ryada.mvp;

import android.support.test.runner.AndroidJUnit4;

import com.ryadar.mvp.view.ShowDataFragment;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;

@RunWith(AndroidJUnit4.class)
public class ShowDataFragmentTest {
    ShowDataFragment showDataFragment;
    void init() {
        showDataFragment=  mock(ShowDataFragment.class);
    }
    @Test
    public void isViewNull(){
        init();
        Assert.assertNotNull(showDataFragment);

    }
}
