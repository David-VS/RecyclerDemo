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
        jokes.add(new Joke("Het is blauw en weegt niet veel", "lichtblauw"));
        jokes.add(new Joke("odysee is ook een toffe school", "<mic drop>"));
        jokes.add(new Joke("het is groen en glijd van een berg", "een slawine"));
        jokes.add(new Joke("het is groen en glijdt van een berg", "een skiwi"));
        jokes.add(new Joke("Hoeveel programmeurs heb je nodig om een lamp te vervangen", "geen, dat is een hardwareprobleem"));

        liveJokes.setValue(jokes);
    }

    public MutableLiveData<ArrayList<Joke>> getLiveJokes() {
        return liveJokes;
    }
}
