package ngo.sapne.intents.sapne;


import android.content.Context;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    String[] players;
    int[] imgs;

    public MyAdapter(Context ctx, String[] names, int[] images)
    {

        this.c=ctx;
        this.players=names;
        this.imgs=images;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,null);

        MyHolder holder=new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.img.setImageResource(imgs[position]);
        holder.nameTxt.setText(players[position]);



    }

    @Override
    public int getItemCount() {
        return players.length;
    }
}