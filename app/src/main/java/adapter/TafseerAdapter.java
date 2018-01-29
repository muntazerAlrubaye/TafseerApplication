package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mohammed.tafseerapplication.R;

import java.util.List;

import models.Tafseer;

/**
 * Created by mohammed on 1/29/18.
 */

public class TafseerAdapter extends RecyclerView.Adapter<TafseerAdapter.TafseerViewHolder> {

    private List<Tafseer> tafseers;
    private int rowLayout;
    private Context context;


    public static class TafseerViewHolder extends RecyclerView.ViewHolder {


        TextView tafseerTV;

        public TafseerViewHolder(View itemView) {
            super(itemView);
            tafseerTV = itemView.findViewById(R.id.tafseer_item_row);
        }
    }
    public TafseerAdapter(List<Tafseer> tafseers, int rowLayout, Context context) {
        this.tafseers = tafseers;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public TafseerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new TafseerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TafseerViewHolder holder, int position) {
        holder.tafseerTV.setText(tafseers.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return tafseers.size();
    }

}
