package ngo.sapne.intents.sapne;


import android.support.v7.widget.RecyclerView;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.TextView;

public class MyHolder extends RecyclerView.ViewHolder {
    //VIEWS
    ImageView img;
    TextView nameTxt;

    public MyHolder(View itemView) {
        super(itemView);
        //ASSIGNING VIEWS
        img= itemView.findViewById(R.id.playerImage);
        nameTxt= itemView.findViewById(R.id.nameTxt);

    }



}
