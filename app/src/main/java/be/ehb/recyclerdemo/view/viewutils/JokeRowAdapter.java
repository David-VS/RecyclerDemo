package be.ehb.recyclerdemo.view.viewutils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import be.ehb.recyclerdemo.R;
import be.ehb.recyclerdemo.model.Joke;

public class JokeRowAdapter extends RecyclerView.Adapter<JokeRowAdapter.JokeViewHolder> {

    class JokeViewHolder extends RecyclerView.ViewHolder{
        final TextView tvSetup;
        final TextView tvPunchline;

        public JokeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSetup = itemView.findViewById(R.id.tv_row_setup);
            tvPunchline = itemView.findViewById(R.id.tv_row_punchline);
        }
    }

    private ArrayList<Joke> jokeItems;

    public JokeRowAdapter(ArrayList<Joke> jokeItems) {
        this.jokeItems = jokeItems;
    }

    public void newItems(ArrayList<Joke> newItems){
        jokeItems = newItems;
    }

    @NonNull
    @Override
    public JokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_joke_recycler, parent, false);
        return new JokeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull JokeViewHolder holder, int position) {
        Joke jokeForRow = jokeItems.get(position);
        holder.tvSetup.setText(jokeForRow.getSetup());
        holder.tvPunchline.setText(jokeForRow.getPunchline());
    }

    @Override
    public int getItemCount() {
        return jokeItems.size();
    }
}
