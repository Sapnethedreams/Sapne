package ngo.sapne.intents.sapne;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sonu on 24/07/17.
 */

public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemRecyclerViewAdapter.ItemViewHolder> {

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView itemLabel;
        private TextView itemLabel1;
        private ImageView imageView;
        private ImageView imageView1;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemLabel = itemView.findViewById(R.id.item_label);
            itemLabel1 = itemView.findViewById(R.id.item_label2);
            imageView= itemView.findViewById(R.id.img);
            imageView1= itemView.findViewById(R.id.img2);
        }
    }

    private Context context;
    private ArrayList<String> arrayList;
    private ArrayList<String> arrayList1;
    private ArrayList<Integer> arrayList2;
    private ArrayList<Integer> arrayList3;
    public ItemRecyclerViewAdapter(Context context, ArrayList<String> arrayList,ArrayList<String> arrayList1, ArrayList<Integer> arrayList2, ArrayList<Integer> arrayList3) {
        this.context = context;
        this.arrayList = arrayList;
        this.arrayList1=arrayList1;
        this.arrayList2=arrayList2;
        this.arrayList3=arrayList3;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_row_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.itemLabel.setText(arrayList.get(position));
        holder.itemLabel1.setText(arrayList1.get(position));
        holder.imageView.setImageResource(arrayList2.get(position));
        holder.imageView1.setImageResource(arrayList3.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
