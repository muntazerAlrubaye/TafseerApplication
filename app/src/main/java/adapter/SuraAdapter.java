package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mohammed.tafseerapplication.R;

import java.util.List;

import models.Sura;

/**
 * Created by mohammed on 1/27/18.
 */

public class SuraAdapter extends RecyclerView.Adapter<SuraAdapter.SuraViewHolder> {

    private List<Sura> sura;
    private int rowLayout;
    private Context context;

    public static class SuraViewHolder extends RecyclerView.ViewHolder {
        TextView suraNameTV;

        public SuraViewHolder(View itemView) {
            super(itemView);

            suraNameTV = itemView.findViewById(R.id.sura_name_tv);

        }
    }

    public SuraAdapter(List<Sura> sura, int rowLayout, Context context) {
        this.sura = sura;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public SuraViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new SuraViewHolder(view);
        }

    @Override
    public void onBindViewHolder(SuraViewHolder holder, int position) {
        holder.suraNameTV.setText(sura.get(position).getName());
    }


    @Override
    public int getItemCount() {
        return sura.size();
    }

}
