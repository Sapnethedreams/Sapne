package com.example.intents.sapne;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by dell pc on 18/08/2017.
 */

public class Products extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.products_activity);
        getLayoutInflater().inflate(R.layout.products_activity, frameLayout);
    }
}
