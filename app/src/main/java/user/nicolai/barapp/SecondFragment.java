package user.nicolai.barapp;

import static user.nicolai.barapp.FirstFragment.myThreadConnected;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import user.nicolai.barapp.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

      binding = FragmentSecondBinding.inflate(inflater, container, false);
      return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_blankFragment);
            }
        });

        binding.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myThreadConnected.write("1:2:3:1:5:3".getBytes());
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_loadingFragment);
            }
        });

        binding.imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myThreadConnected.write("1:2:3:1:5:3".getBytes());
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_loadingFragment);
            }
        });

        binding.imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myThreadConnected.write("1:2:3:1:5:3".getBytes());
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_loadingFragment);
            }
        });

        binding.imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myThreadConnected.write("1:2:3:1:5:3".getBytes());
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_loadingFragment);
            }
        });

        binding.imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myThreadConnected.write("1:2:3:1:5:3".getBytes());
            }
        });

        binding.imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myThreadConnected.write("1:2:3:1:5:3".getBytes());
            }
        });

        binding.imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myThreadConnected.write("1:2:3:1:5:3".getBytes());
            }
        });

        binding.imageButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myThreadConnected.write("1:2:3:1:5:3".getBytes());
            }
        });

        binding.imageButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myThreadConnected.write("1:2:3:1:5:3".getBytes());
            }
        });

        binding.imageButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myThreadConnected.write("1:2:3:1:5:3".getBytes());
            }
        });

    }


@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
