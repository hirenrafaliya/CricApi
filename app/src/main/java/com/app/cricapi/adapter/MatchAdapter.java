package com.app.cricapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.cricapi.R;
import com.app.cricapi.model.Match;

import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder> {

    Context context;
    List<Match> matchList;

    public MatchAdapter(Context context, List<Match> matchList) {
        this.context = context;
        this.matchList = matchList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tvType.setText(matchList.get(position).getType());
        holder.tvTeam.setText(matchList.get(position).getTeam1()+"\nVS\n"+matchList.get(position).getTeam2());
        holder.tvToss.setText("Toss winner : "+matchList.get(position).getToss_winner_team());
        holder.tvWinner.setText("Match winner : "+matchList.get(position).getWinner_team());
    }

    @Override
    public int getItemCount() {
        return matchList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvType,tvTeam,tvToss,tvWinner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvType=itemView.findViewById(R.id.tvType);
            tvTeam=itemView.findViewById(R.id.tvTeam);
            tvToss=itemView.findViewById(R.id.tvToss);
            tvWinner=itemView.findViewById(R.id.tvWinner);
        }
    }
}
