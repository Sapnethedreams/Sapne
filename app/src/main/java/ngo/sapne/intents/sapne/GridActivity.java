package ngo.sapne.intents.sapne;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import ngo.sapne.intents.sapne.events.Gridintent;

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
                            Intent intent1 = new Intent(GridActivity.this, Gridintent.class);
                            intent1.putExtra("info","Class activities\n" +
                                    "Educational activities\n" +
                                    "\n" +
                                    "Sapne has been committed to undertaking fun and educational activities for our young and dynamic children. Sapne strongly believes that education goes beyond the classroom and a lot of things can be learnt via games and interactive sessions which leads to a more holistic style of teaching.\n" +
                                    "\n" +
                                    "In the past, Sapne has organized Draw your dreams, a painting competition several times to highlight the importance of art and craft in our daily lives. Art can teach kids to be patient and to appreciate the beauty in simple things. It can also teach kids to be more creative and think out-of-the-box.\n" +
                                    "\n" +
                                    "In 2016, SAPNE launched weekly Dance classes conducted by Piyush Sir! Dance is also a form of art where we can express ourselves and have fun at the same time. The kids thoroughly enjoyed sir’s classes.\n");

                            Bundle bundle=new Bundle();
                            bundle.putInt("image",R.drawable.sapnea);
                            intent1.putExtras(bundle);


                            startActivity(intent1);
                            break;

                        case R.id.cv2:
                            Intent intent2 = new Intent(GridActivity.this, Gridintent.class);
                            intent2.putExtra("info","BULLYING\n" +
                                    "Negative impacts are such that they last a lifetime. Besides horrible memories they leave behind a trail of pain, fear and negativity to be dealt upon. This is what every bullied person faces.\n" +
                                    "Bullying doesn’t have a definition because words are less to define what the person goes through. Repeated aggressive behavior traumatizes the victim, effects of which can stay for a lifetime.\n" +
                                    "There are many ways in which these manipulative people find joy from. It can be physical bullying, verbal bullying or social bullying and in such forms that other people might not even realize it.\n" +
                                    "Verbal bullying can be either in the form of name calling, teasing or passing unusual comments about the person.\n" +
                                    "Social bullying is established when the bully leaves out the person on purpose, manipulates others to not talk to them or even spreading rumors about them whereas physical bullying is seen as the word says “physical” involving pushing and hitting the person.\n" +
                                    "Starting at a younger age, this behavior can leave a deep impact on the person who is facing it.");
                            Bundle bundleb=new Bundle();
                            bundleb.putInt("image",R.drawable.sapneb);
                            intent2.putExtras(bundleb);
                            startActivity(intent2);
                            break;

                        case R.id.cv3:
                            Intent intent3 = new Intent(GridActivity.this, Gridintent.class);
                            intent3.putExtra("info","Developing an art is the search of the inquisitive mind for creativity.\n" +
                                    "Music and drum have such a beautiful connection and at Sapne - Sagar creates the melodies to\n" +
                                    "sync the amazing relation that these two make.\n" +
                                    "The sticks hit on the drum creating a wave of happiness on our mind and this boy doesn't fail to\n" +
                                    "do it.\n" +
                                    "Sagar Shah - as humble his background is - his efforts are that collosal and commendable!!\n" +
                                    "The world lacks passion and this boy serves the example of being an odd one out because he\n" +
                                    "follows his heart and that is playing drum.\n" +
                                    "Sagar - is a boy developing his skills at this NGO. And Team Sapne is indeed doing a\n" +
                                    "phenomenal task by carving a masterpiece!\n" +
                                    "Team Sapne has such a backing when it comes to his talents and giving confidence to\n" +
                                    "someone to follow their passion is one of the most supreme things that anyone can ever do and\n" +
                                    "Team Sapne serves his purpose.\n" +
                                    "Music never has an end. Passion never does too. Sagar hopes to bring out his talent in front of\n" +
                                    "people. He is an inspiration for all of them - To pursue their passion!\n" +
                                    "A big applause to Sagar for his work and his dedication. This for sure shall shape a melodious\n" +
                                    "future!!");

                            Bundle bundlec=new Bundle();
                            bundlec.putInt("image",R.drawable.sapnec);
                            intent3.putExtras(bundlec);
                            startActivity(intent3);
                            break;

                        case R.id.cv4:
                            Intent intent4 = new Intent(GridActivity.this, Gridintent.class);
                            intent4.putExtra("info","\n" +
                                    "                                    Holi Celebration At Sapne Ngo\n" +
                                    "Holi was celebrated at Sapne Ngo camp area on 1st march.  Mr. Devesh Mittal and some other volunteers celebrated Holi with NGO kids on 1st march.\n" +
                                    "As we are aware about Water Conservation so to emphasize on that area Dry Holi was celebrated with underprivileged kids  With colors and flowers. All the Arrangements Were done by Volunteers with donation and every possible manner. Kids were given sweets in Form of gujiya and other eateries.\n" +
                                    "Mr Devesh Gave a Speech Regarding Holi Festival and thanked all the people gathered there for making this event a success.  At the end all kids danced with volunteers on Holi themed songs and enjoyed a lot.");
                            Bundle bundled=new Bundle();
                            bundled.putInt("image",R.drawable.sapned);
                            intent4.putExtras(bundled);
                            startActivity(intent4);
                            break;


                       case R.id.cv5:
                          Intent intent5 = new Intent(GridActivity.this, Gridintent.class);
                           intent5.putExtra("info","A teacher presents the past, reveals the present and creates the future, rightly said by John Holt. So, here at Sapne - our NGO, we are providing quality teachers, for the children who are willing to study and who want to make their future bright but due to some obstacles , they are unable to do so. Due to this reason, we are teaching them, making them capable for themselves and for the society too. We have organized regular camps in which we teach students, we provide the children with the academic education and apart from this, we play with them, we teach them how to live life to its fullest. And in the two hours of the camp, those children are so happy that their happiness, their joy, their cheer, cannot be expressed in words.");
                           Bundle bundlee=new Bundle();
                           bundlee.putInt("image",R.drawable.sapnee);
                           intent5.putExtras(bundlee);
                           startActivity(intent5);
                            break;

                        case R.id.cv6:
                            Intent intent6 = new Intent(GridActivity.this, Gridintent.class);
                            intent6.putExtra("info","We believe that Learning is not the product of teaching , Learning is the product of activities of learners . So we indulge the children in various kinds of activities of their own interest and also in other activities which can benefit them in future. We dance together , we sing together , we play together , we study together , we giggle together , we gossip together , we share our memories , our experiences in those two hours of regular camps organized by Sapne For us , every sapna , every dream is important and hence we try our best to accomplish that , if not accomplish , we try our best to give that dream , a direction. For this , we provide teachers , who are skilled in their field of work and accordingly they teach , they train the students . In this way teachers get the platform to teach and express or share their knowledge , moreover , increase their knowledge , and students get quality education");

                            Bundle bundlef=new Bundle();
                            bundlef.putInt("image",R.drawable.sapnef);
                            intent6.putExtras(bundlef);
                            startActivity(intent6);
                            break;

                        case R.id.cv7:
                            Intent intent7 = new Intent(GridActivity.this, Gridintent.class);
                            intent7.putExtra("info","While moving on the roads , we see many children who have not worn proper clothes , who are deprived of the basic needs , who should study and play at this age , but due to their financial conditions , they can't even think of doing all these things because , for them , three-time meal is more than enough for survival. Now the question arrises , What do we , as responsible citizen of the country , do for them ? Except for showing concern , except for being sympathetic , we do nothing . But Sapne , our NGO , is proud to tell that , we are doing something , we have taken first step and it is the . First step that leads to the Final step . And we are sure that we will definitely reach till the final step with the support of our team and the children who want to make their future bright and satisfying .\n" +
                                    "");

                            Bundle bundleg=new Bundle();
                            bundleg.putInt("image",R.drawable.sapneg);
                            intent7.putExtras(bundleg);
                            startActivity(intent7);
                            break;

                        case R.id.cv8:
                            Intent intent8 = new Intent(GridActivity.this, Gridintent.class);
                            intent8.putExtra("info","While moving on the roads , we see many children who have not worn proper clothes , who are deprived of the basic needs , who should study and play at this age , but due to their financial conditions , they can't even think of doing all these things because , for them , three-time meal is more than enough for survival. Now the question arrises , What do we , as responsible citizen of the country , do for them ? Except for showing concern , except for being sympathetic , we do nothing . But Sapne , our NGO , is proud to tell that , we are doing something , we have taken first step and it is the . First step that leads to the Final step . And we are sure that we will definitely reach till the final step with the support of our team and the children who want to make their future bright and satisfying .\n" +
                                    "   ");

                            Bundle bundleh=new Bundle();
                            bundleh.putInt("image",R.drawable.sapneh);
                            intent8.putExtras(bundleh);
                            startActivity(intent8);
                    }

                }
            });
        }
    }
}
