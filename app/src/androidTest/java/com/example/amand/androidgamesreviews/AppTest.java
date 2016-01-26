package com.example.amand.androidgamesreviews;

import android.app.Application;
import android.test.ApplicationTestCase;
import junit.framework.Assert;

/**
 * André Amândio
 * Trabalho: PDM2
 * Ficheiro: AppTest
 * Data entrega: 27/01/2016
 */
public class AppTest extends ApplicationTestCase<Application> {

    public AppTest(){
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void mCurrentPositionTest(){
        GameInfoFragment gameInfoFragment = new GameInfoFragment();
        Assert.assertEquals(0, gameInfoFragment.mCurrentPosition);
    }
}
