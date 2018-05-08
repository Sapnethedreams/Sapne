package ngo.sapne.intents.sapne;


import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivitiesAdapter extends PagerAdapter {
//
//"One year has passed giving thousands of smiles to people. Thanks to all " +
//        "those who supported us for a good cause because of which we had a successful one year.\n" +
//        "Celebrating One year anniversary of Sapne on 22nd Jan 2017 with a very special event.,"
//        ,
    String[] names = {"On the occasion of it's first anniversary, Sapne is donating blankets and organizing a bhandara for the needy" +
            " people. Your donations, in form of blankets, clothing, food or finances, are welcome!.", "" +
            "Children are like Candle Wax. Just like Candle Wax, which can take form of anything. In the same way, Sapne ensures that these children get " +
        "educated in the right way so that they can fulfill their dreams in the coming future",
            "A child, A teacher, A book and A pen can change the whole world. In the same way, our NGO 'Sapne' wants to contribute something to these poor children and change their whole world.",
            "We are grateful to the BATRA family for extending their support to this noble cause by donating blankets." +
                    " We wish others too to come forward and be a part of this initiative.", "" +
            "At Sapne, we believe in investing in the future of the nation - \n" +
            "The Youth Wish to be a part of this noble cause? to be a part of this noble cause?",
            "While guiding children about life, we forget to teach them how to live. Help them be a better person for a better" +
                    " future of our nation. If you wish be their guide, join our NGO as a 'Change Volunteer'.",
            "How to make a difference to their lives?\n" +
                    "We want to learn and grow through education. I have all my heart and dedication to learn, just guide me to the" +
                    " right path, provide me with the resources and help.",


            "This picture perfectly describes the dedication of our team members working together to enlighten the lives of these " +
                    "children through the most powerful weapon \"Education\".",
            "Happiness is the greatest gift you can give to human being. Team SAPNE celebrated a joyful by bringing smiles to the faces" +
                    " of these kids.",
            "Diwali Fiesta Event held on 23 Oct, 2016 at Growing steps, in association with SAPNE. Besides organizing events" +
                    " like dancing, crafts, creative workshops for children; TEAM SAPNE also conducted an awareness drive to " +
                    "inform participants about the importance of spreading quality education and philanthrophy.",
            "Our volunteers involved the participants with learning based activities serving a dual purpose of enjoyment and " +
                    "social awareness. A small donation drive was also conducted by the team.",
            "Thankyou Sarso Delhi for helping poor childrens through us by donating books and clothes.",
            "THERE IS NO GREATER JOY THAN MAKING PEOPLE HAPPY!\n" +
                    "Here's a preview of the donation drive done by our NGO, SAPNE, on 8th October, 2016.\n" +
                    "Want to be a reason for someone's smile?", "A 7- year girl is thanking you for gifting her clothes. " +
            "What you don't need, might be useful for others. Let's spread happiness. Donate. A sneak peak" +
            " from donation drive organized by team Sapne on Oct 8.", "A glimpse from the diya making session conducted by team Sapne." +
            " The sessions are primarily for differently abled children who are going to showcase their talent in a" +
            " competition on 16th october, at Rohtak. Please be there to encourage them.", "Look!! How beautiful all these are. *_* \n" +
            "You can always bring a difference in someone's life. What all you need is the kindness in your heart." +
            " The diya making sessions conducted by Team Sapne for differently abled kids.", "Induction session at siraspur centre." +
            " Our young and aspiring team has made this event successful.", "“When we are happy, we dance.” But sometimes, “To be happy, we should dance.” And hence," +
            " we are inviting our choreographer to enhance the skills of these children by teaching them ‘dance’ " +
            "and hence making these children happy. Children are excited to learn from him.", "While moving on the roads , we see many children who have not worn proper clothes , who are deprived of " +
            "the basic needs , who should study and play at this age , but due to their financial conditions ," +
            " they can't even think of doing all these things because , for them , three-time meal is more than enough for " +
            "survival.", "We cannot stop celebrating friendship day with our friends any day." +
            " Finally last one from the friendship day task..", "To spread awareness and to get maximum support from " +
            "the people, we organized an activity at D-Mall, Rohini, named “Dreams unlocked in a secret diary”." +
            " As the name suggests, we had a secret diary in which the people wrote their dreams." +
            " And those dreams were kept confidential. And after a month, we reminded those people about their" +
            " dreams through mails, messages, etc., so that they may know how far their dreams have gone and to make" +
            " them realize, “how important dreams (SAPNE) are!”", "We invited people to pen-down, to write" +
            " their thoughts, their ideas, their definition of country’s development, about an NGO who is working for " +
            "improving the literacy rate of the country and who is helping poor and needy children. And we inserted that " +
            "board with the thoughts of various people in the mall so that everyone passing from there realize hisher duty " +
            "towards country.", "In this event, we had a spinning wheel on which some dare and some questions requiring " +
            "true answers were written. And people came, spinned the wheel and did the task as desired. And the tasks were" +
            " like, “Make a child smile.” and that, “Tell us about your dream and how you are trying to fulfill it.” " +
            "After doing these tasks, people realized their role towards these children who are deprive of basic needs.", "" +
            "We have educated. and skilled teachers for our NGO, who teach children and impart their knowledge to these children " +
            "in the best possible manner. We believe that, “A teacher who love teaching, teaches children to love learning.”" +
            " And hence, we have teachers who are passionate about their work i.e. teaching", "For a person to be successful," +
            " s/he not only needs to be educated but also skilled. A person must be a critical thinker; good in communication," +
            " collaboration; and s/he should be creative, apart from being educated." +
            " Then only s/he can participate productively to make India, a developed country." +
            " And hence, we are developing the skills of these children along with the academics knowledge.", "" +
            "Dreams start from childhood. Education doesn't shape them, knowledge does.We set the children on right" +
            " track and develop skills in them so they are able to create their own path of success and make their life " +
            "more colorful."
    };

    int[] images = {/*R.drawable.z1,*/ R.drawable.z2, R.drawable.z3, R.drawable.z4, R.drawable.z5, R.drawable.z6,
            R.drawable.z7, R.drawable.z8,
            R.drawable.z9, R.drawable.z10, R.drawable.z11, R.drawable.z12, R.drawable.z13, R.drawable.z14, R.drawable.z15,
            R.drawable.z16, R.drawable.z17,
            R.drawable.z18, R.drawable.z19, R.drawable.z22, R.drawable.z23, R.drawable.z24,
            R.drawable.z25, R.drawable.z26,
            R.drawable.z27, R.drawable.z28, R.drawable.z29

    };
    private Context ctx;
    private LayoutInflater layoutInflater;
    public ActivitiesAdapter (Context ctx)
    {
        this.ctx = ctx;
    }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view ==object);
    }
    public Object instantiateItem(final ViewGroup container, int position)
    {
        final int listenPosition = position;
        final int totalItems = names.length;
layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       final View item_view = layoutInflater.inflate(R.layout.activity_corner_pictures,container,false);
       final ImageView imageView = item_view.findViewById(R.id.imageViewCornerText);


        final TextView cornerText = item_view.findViewById(R.id.cornerText);
        imageView.setImageResource(images[position]);

        cornerText.setText(names[position]);


                        container.addView(item_view);


        return item_view;
    }

    public void destroyItem(ViewGroup container, int position, Object object)
    {
        container.removeView((CardView) object);
    }
}