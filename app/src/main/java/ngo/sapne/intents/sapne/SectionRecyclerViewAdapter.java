package ngo.sapne.intents.sapne;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;



public class SectionRecyclerViewAdapter extends RecyclerView.Adapter<SectionRecyclerViewAdapter.SectionViewHolder> {


    class SectionViewHolder extends RecyclerView.ViewHolder {
        private TextView sectionLabel;
        private RecyclerView itemRecyclerView;
        private ImageView imageView;

        public SectionViewHolder(View itemView) {
            super(itemView);
            sectionLabel = itemView.findViewById(R.id.section_label);
            itemRecyclerView = itemView.findViewById(R.id.item_recycler_view);
        }
    }

    private Context context;
    private RecyclerViewType recyclerViewType;
    private ArrayList<SectionModel> sectionModelArrayList;

    public SectionRecyclerViewAdapter(Context context, RecyclerViewType recyclerViewType, ArrayList<SectionModel> sectionModelArrayList) {
        this.context = context;
        this.recyclerViewType = recyclerViewType;
        this.sectionModelArrayList = sectionModelArrayList;
    }

    @Override
    public SectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.section_custom_row_layout, parent, false);
        return new SectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SectionViewHolder holder, int position) {
        final SectionModel sectionModel = sectionModelArrayList.get(position);
        holder.sectionLabel.setText(sectionModel.getSectionLabel());

        //recycler view for items
        holder.itemRecyclerView.setHasFixedSize(true);
        holder.itemRecyclerView.setNestedScrollingEnabled(false);

        /* set layout manager on basis of recyclerview enum type */
        switch (recyclerViewType) {
            case LINEAR_VERTICAL:
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
                holder.itemRecyclerView.setLayoutManager(linearLayoutManager);
                break;

        }
        ItemRecyclerViewAdapter adapter = new ItemRecyclerViewAdapter(context, sectionModel.getItemArrayList(), sectionModel.getItemArrayList1(),sectionModel.getItemArrayList2(),sectionModel.getItemArrayList3());
        holder.itemRecyclerView.setAdapter(adapter);


    }

    @Override
    public int getItemCount() {
        return sectionModelArrayList.size();
    }


}
