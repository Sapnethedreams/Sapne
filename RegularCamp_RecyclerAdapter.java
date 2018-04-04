package ngo.sapne.intents.sapne;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pankaj on 17-01-2018.
 */

public class RegularCamp_RecyclerAdapter extends RecyclerView.Adapter<RegularCamp_RecyclerAdapter.RegularCampViewHolder>{

    private List<RegularCampItem> listData = new ArrayList<>();

    public RegularCamp_RecyclerAdapter(List<RegularCampItem> listData) {
        this.listData = listData;
    }

    @Override
    public RegularCampViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.regular_camp_item, parent, false);
        return new RegularCampViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RegularCampViewHolder holder, int position) {
        holder.mImageView.setImageResource(listData.get(position).getImageCamp());
        holder.mTextView.setText(listData.get(position).getTxtCamp());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class RegularCampViewHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;
        TextView mTextView;

        public RegularCampViewHolder(View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.imgRegularCamp);
            mTextView = itemView.findViewById(R.id.txtRegularCamp);
        }
    }

}
