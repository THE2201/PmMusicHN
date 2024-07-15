package com.example.musicapphn.Grupos.DescubrirFragments;



import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.musicapphn.R;
import com.example.musicapphn.databinding.ActivityDescubrirGruposBinding;

public class DescubrirGruposActivity extends AppCompatActivity {
    ActivityDescubrirGruposBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDescubrirGruposBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new DescubrirAudioFragment());

        binding.bottomNavDescubrir.setOnItemSelectedListener(item -> {
            if(item.getItemId()==R.id.audiobottom){
                replaceFragment(new DescubrirAudioFragment());
            } else if (item.getItemId()==R.id.videobottom) {
                replaceFragment(new DescubrirVideoFragment());
            } else{
                replaceFragment(new DescubrirAudioFragment());
            }
            return true;
        });
    }


    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_descubrir, fragment);
        fragmentTransaction.commit();
    }
}



