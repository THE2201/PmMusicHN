package com.example.musicapphn.Grupos.MisGruposFragments;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.musicapphn.Grupos.DescubrirFragments.DescubrirAudioFragment;
import com.example.musicapphn.Grupos.DescubrirFragments.DescubrirVideoFragment;
import com.example.musicapphn.R;
import com.example.musicapphn.databinding.ActivityMisGruposBinding;

public class MisGruposActivity extends AppCompatActivity {
    ActivityMisGruposBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMisGruposBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new MisGruposAudioFragment());

        binding.bottomNavMisGrupos.setOnItemSelectedListener(item -> {
            if(item.getItemId()==R.id.audiobottom){
                replaceFragment(new MisGruposAudioFragment());
            } else if (item.getItemId()==R.id.videobottom) {
                replaceFragment(new MisGruposVideoFragment());
            } else{
                replaceFragment(new MisGruposAudioFragment());
            }
            return true;
        });

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_mis_grupos, fragment);
        fragmentTransaction.commit();
    }
}