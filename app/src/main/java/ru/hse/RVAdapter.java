package ru.hse.farm; //Адаптер для RecyclerView: загрузка данных и заполнение списка

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.AdvrtViewHolder> {

    public static class AdvrtViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView advName;
        TextView advPrice;
        TextView advType_of_price;
        TextView advRate;
        ImageView advPhoto;

        public AdvrtViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            advName = (TextView)itemView.findViewById(R.id.adv_name);
            advPrice = (TextView)itemView.findViewById(R.id.adv_price);
            advType_of_price = (TextView)itemView.findViewById(R.id.adv_type_of_price);
            advRate = (TextView)itemView.findViewById(R.id.adv_rate);
            advPhoto = (ImageView)itemView.findViewById(R.id.adv_photo);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public AdvrtViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adv_recycleview_item,
                viewGroup, false);
        AdvrtViewHolder avh = new AdvrtViewHolder(v);
        return avh;
    }

    final List<Advertisement> advertisements = Advertisement.ADVERTISEMENTS;

    @Override
    public void onBindViewHolder(AdvrtViewHolder advrtViewHolder, int i) {

        advrtViewHolder.advName.setText(advertisements.get(i).name);
        advrtViewHolder.advPrice.setText(advertisements.get(i).price.toString());
        advrtViewHolder.advType_of_price.setText(advertisements.get(i).type_of_price);
        advrtViewHolder.advRate.setText(advertisements.get(i).rate.toString());
        advrtViewHolder.advPhoto.setImageResource(advertisements.get(i).photoId);

        advrtViewHolder.cv.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return advertisements.size();
    }
}
