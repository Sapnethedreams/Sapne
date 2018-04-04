package ngo.sapne.intents.sapne;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class GridActivity extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        //Set Event
        setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);
    }

    private void setToggleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(GridActivity.this, "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(GridActivity.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

//                    Intent intent = new Intent(GridActivity.this,BaseActivity.class);
//                    intent.putExtra("info","This is activity from card item index  "+finalI);
//                    startActivity(intent);

                    switch(view.getId())
                    {
                        case R.id.cv1:
                            Intent intent1 = new Intent(GridActivity.this, Grid1Activity.class);
                            startActivity(intent1);
                            break;

                        case R.id.cv2:
                            Intent intent2 = new Intent(GridActivity.this, Grid2Activity.class);
                            startActivity(intent2);
                            break;

                        case R.id.cv3:
                            Intent intent3 = new Intent(GridActivity.this, Grid3Activity.class);
                            startActivity(intent3);
                            break;

                        case R.id.cv4:
                            Intent intent4 = new Intent(GridActivity.this, Grid4Activity.class);
                            startActivity(intent4);
                            break;


                       case R.id.cv5:
                          Intent intent5 = new Intent(GridActivity.this, Grid5Activity.class);
                           startActivity(intent5);
                            break;

                        case R.id.cv6:
                            Intent intent6 = new Intent(GridActivity.this, Grid6Activity.class);
                            startActivity(intent6);
                            break;

                        case R.id.cv7:
                            Intent intent7 = new Intent(GridActivity.this, Grid7Activity.class);
                            startActivity(intent7);
                            break;

                        case R.id.cv8:
                            Intent intent8 = new Intent(GridActivity.this, Grid8Activity.class);
                           startActivity(intent8);
                    }

                }
            });
        }
    }
}
