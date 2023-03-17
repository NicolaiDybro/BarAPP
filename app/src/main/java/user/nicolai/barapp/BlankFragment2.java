package user.nicolai.barapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import user.nicolai.barapp.databinding.BoozeFragmentBinding;


public class BlankFragment2 extends Fragment {

    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = BoozeFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    private BoozeFragmentBinding binding;

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(BlankFragment2.this)
                        .navigate(R.id.action_Boozefragment_to_blankFragment);
            }
        });
    }

}