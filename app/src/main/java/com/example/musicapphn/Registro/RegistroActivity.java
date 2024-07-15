package com.example.musicapphn.Registro;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.musicapphn.R;
import com.example.musicapphn.databinding.ActivityRegistroBinding;

public class RegistroActivity extends AppCompatActivity {
    ActivityRegistroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new FragmentRegistro1());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId()==R.id.audiobottom){
                replaceFragment(new FragmentRegistro1());
            } else if (item.getItemId()==R.id.videobottom) {
                replaceFragment(new FragmentRegistro2());
            } else{
                replaceFragment(new FragmentRegistro1());
            }
            return true;
        });

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}