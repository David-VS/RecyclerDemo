package be.ehb.recyclerdemo.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import be.ehb.recyclerdemo.R;
import be.ehb.recyclerdemo.model.Joke;
import be.ehb.recyclerdemo.view.viewutils.JokeRowAdapter;
import be.ehb.recyclerdemo.viewmodel.JokesViewModel;

public class JokesFragment extends Fragment {

    public JokesFragment() {
    }

    public static JokesFragment newInstance(){
        return new JokesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_jokes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView jokesRV = view.findViewById(R.id.rv_jokes);

        JokesViewModel mJokesViewModel = new ViewModelProvider(getActivity()).get(JokesViewModel.class);
        JokeRowAdapter mJokeRowAdapter = new JokeRowAdapter();
        //RecyclerView.LayoutManager mLayoutManager= new GridLayoutManager(getContext(), 2);
        RecyclerView.LayoutManager mLayoutManager= new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        jokesRV.setAdapter(mJokeRowAdapter);
        jokesRV.setLayoutManager(mLayoutManager);

        mJokesViewModel.getLiveJokes().observe(getViewLifecycleOwner(), new Observer<ArrayList<Joke>>() {
            @Override
            public void onChanged(ArrayList<Joke> jokes) {
                mJokeRowAdapter.newItems(jokes);
            }
        });

    }
}
