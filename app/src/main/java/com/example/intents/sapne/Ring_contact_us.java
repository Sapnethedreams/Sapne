
package com.example.intents.sapne;

        import android.content.Intent;
        import android.os.Bundle;

public class Ring_contact_us extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.ring_activity);
        getLayoutInflater().inflate(R.layout.ring_activity, frameLayout);
    }
    @Override
    public void onBackPressed() {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
}

