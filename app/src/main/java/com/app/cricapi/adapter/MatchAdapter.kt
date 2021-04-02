package com.app.cricapi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.cricapi.R
import com.app.cricapi.model.Match

class MatchAdapter(var context: Context, var matchList: List<Match>) : RecyclerView.Adapter<MatchAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_match, null, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvType.text = matchList[position].type
        holder.tvTeam.text = """
            ${matchList[position].team1}
            VS
            ${matchList[position].team2}
            """.trimIndent()
        holder.tvToss.text = "Toss winner : " + matchList[position].toss_winner_team
        holder.tvWinner.text = "Match winner : " + matchList[position].winner_team
    }

    override fun getItemCount(): Int {
        return matchList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvType: TextView
        var tvTeam: TextView
        var tvToss: TextView
        var tvWinner: TextView

        init {
            tvType = itemView.findViewById(R.id.tvType)
            tvTeam = itemView.findViewById(R.id.tvTeam)
            tvToss = itemView.findViewById(R.id.tvToss)
            tvWinner = itemView.findViewById(R.id.tvWinner)
        }
    }
}