package ngo.sapne.intents.sapne;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by user on 10/11/2017.
 */

public class VerticalPagerAdapter extends PagerAdapter {

    String mResources[] = {"Her name is Sapna, a young girl who recently migrated to Delhi from Nepal, along with her parents. The first few months in Delhi were tough. Having little knowledge of Hindi, the common language, Sapna struggled to communicate with other kids of her dilapidated locality in Delhi. But not only does she share her name with our organisation, she shares SAPNE\'s grit and determination as well! Sapna has been working diligently on her Hindi under the guidance of tutors provided by SAPNE. Her hardwork seems to be paying off. During one of the career counselling sessions organised by SAPNE at her locality, Sapna shared her dream of becoming a doctor when she grows up. \"I want to help the needy\" she says with her trademark adorable smile.","AJAY, a 26 year old boy suffering from EPILEPSY,a neurological disorder. He is a man of great inspiration for all of us. Ajay is so keen to get himself educated like all the other children. His innocence,dedication and hard work will not let him down. Despite facing the major problems he has in his life,his struggle fades all the other things that hinders the path of learning. He has that zeal to attain good and achieve best. We are very much involved into him by supporting his efforts. Are you? Help us so that we could provide him the best he wants.","Manpreet, despite belonging to a underprivileged section of the society is an integral part of SAPNE family and is no less than any of the so-called “rich children”. But due to some social and economic barriers, her dreams are somehow being neglected. She wants to adore her life and aspires to be a successful and respected teacher. Though, she has some learning disabilities and speech defects but, due to this, her dreams should not be shattered. So, we, with the help of our special educators are teaching her through the play-way method and hence she is edging towards her dreams."};
    ImageView imgview;
    Context mContext;
    LayoutInflater mLayoutInflater;

    public VerticalPagerAdapter(Context context) {

        mContext=context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mResources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if(position==0) {
            View itemView = mLayoutInflater.inflate(R.layout.successstories, container, false);
            imgview= itemView.findViewById(R.id.imageView);
            imgview.setImageResource(R.drawable.n1);
            TextView label = itemView.findViewById(R.id.textView);
            label.setText("Her name is Sapna, a young girl who recently migrated to Delhi from Nepal, along with her parents. The first few months in Delhi were tough. Having little knowledge of Hindi, the common language, Sapna struggled to communicate with other kids of her dilapidated locality in Delhi. But not only does she share her name with our organisation, she shares SAPNE\\'s grit and determination as well! Since the past three months, Sapnas been working diligently on her Hindi under the guidance of tutors provided by SAPNE. Her hardwork seems to be paying off and she can now converse and play with her friends with relative ease. During one of the career counselling sessions organised by SAPNE at her locality, Sapna shared her dream of becoming a doctor when she grows up. \"I want to help the needy\" she says with her trademark adorable smile. Help her fulfil her dreams.");
            container.addView(itemView);

            return itemView;
        }
        else if(position==1) {


            View itemView = mLayoutInflater.inflate(R.layout.successstories, container, false);
            imgview= itemView.findViewById(R.id.imageView);
            imgview.setImageResource(R.drawable.n2);

            TextView label = itemView.findViewById(R.id.textView);
            label.setText("\"AJAY, a 26 year old boy suffering from EPILEPSY,a neurological disorder. He is a man of great inspiration for all of us. Ajay is so keen to get himself educated like all the other children. His innocence,dedication and hard work will not let him down. Despite facing the major problems he has in his life,his struggle fades all the other things that hinders the path of learning. He has that zeal to attain good and achieve best. We are very much involved into him by supporting his efforts. Are you? Help us so that we could provide him the best he wants.\"");
            label.setText(mResources[position]);
            container.addView(itemView);

            return itemView;
        }
        else {
            View itemView = mLayoutInflater.inflate(R.layout.successstories, container, false);
            imgview= itemView.findViewById(R.id.imageView);
            imgview.setImageResource(R.drawable.n3);

            TextView label = itemView.findViewById(R.id.textView);
            label.setText("Manpreet, despite belonging to a underprivileged section of the society is an integral part of SAPNE family and is no less than any of the so-called “rich children”. But due to some social and economic barriers, her dreams are somehow being neglected. She wants to adore her life and aspires to be a successful and respected teacher. Though, she has some learning disabilities and speech defects but, due to this, her dreams should not be shattered. So, we, with the help of our special educators are teaching her through the play-way method and hence she is edging towards her dreams.");
            container.addView(itemView);

            return itemView;



        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}