package ngo.sapne.intents.sapne;



import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class websites extends AppCompatActivity {
    WebView webView;
   ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websites);
        webView=findViewById(R.id.webvi);




        Intent intent=getIntent();
        String str=intent.getStringExtra("posi");

        switch (str)
        {
            case "0":
               webView.loadUrl("https://www.msme-udyogaadhaar.com");
                break;
            case "1":
                webView.loadUrl("https://www.pdsportal.nic.in");
                break;

            case "2":
                webView.loadUrl("https://portal2.passportindia.gov.in/AppOnlineProject/user/RegisterationBaseAction");
                break;

            case "3":
                webView.loadUrl("https://unifiedportal-mem.epfindia.gov.in/memberinterface/");
                break;



        }
        progressBar=(ProgressBar) findViewById(R.id.pross);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        },2000);



   }


}
