package com.emrecavdar.kentsimgeleriapp;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import android.view.View;
import com.emrecavdar.kentsimgeleriapp.databinding.ActivityMainBinding;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    ArrayList<Landmark> landmarkArrayList;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.
                inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        landmarkArrayList=new ArrayList<>();
        //Data
        Landmark anitkabir=new Landmark
                ("Anıtkabir",
                        "Ankara",
                        R.drawable.ankara);
        Landmark kizKulesi=new Landmark
                ("Kız Kulesi",
                        "İstanbul",
                        R.drawable.istanbul);
        Landmark pamukkale=new Landmark
                ("Pamukkale",
                        "Denizli",
                        R.drawable.pamukkale);
        Landmark mevlana=new Landmark
                ("Mevlana",
                        "Konya",
                        R.drawable.konya);
        landmarkArrayList.add(anitkabir);
        landmarkArrayList.add(kizKulesi);
        landmarkArrayList.add(pamukkale);
        landmarkArrayList.add(mevlana);
        binding.recyclerView.setLayoutManager
                (new LinearLayoutManager(this));
        LandMarkAdapter landMarkAdapter =new
                LandMarkAdapter(landmarkArrayList);
        binding.recyclerView.setAdapter(landMarkAdapter);
    }
}