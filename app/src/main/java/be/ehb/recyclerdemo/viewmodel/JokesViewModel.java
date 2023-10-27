package be.ehb.recyclerdemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

import be.ehb.recyclerdemo.model.Joke;

public class JokesViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Joke>> liveJokes;

    public JokesViewModel(@NonNull Application application) {
        super(application);
        liveJokes = new MutableLiveData<>();
        initJokes();
    }

    private void initJokes() {
        ArrayList<Joke> jokes = new ArrayList<>();
        jokes.add(new Joke("Het is grijs en als het in uw oog vliegt ben je dood", "Een boeing"));
        jokes.add(new Joke("het is oranje en als het regent verdwijnt het", "de mannen van de gemeente"));
        jokes.add(new Joke("Het is wit en het staat in de hoek", "een stoute frigo"));

        liveJokes.setValue(jokes);
    }

    public MutableLiveData<ArrayList<Joke>> getLiveJokes() {
        return liveJokes;
    }
}
