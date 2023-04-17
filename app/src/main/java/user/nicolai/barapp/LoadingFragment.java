package user.nicolai.barapp;

import static user.nicolai.barapp.FirstFragment.myThreadConnected;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


import java.util.Objects;

import user.nicolai.barapp.databinding.FragmentFirstBinding;
import user.nicolai.barapp.databinding.FragmentSecondBinding;
import user.nicolai.barapp.databinding.LoadingScreenBinding;

public class LoadingFragment extends Fragment {
    private LoadingScreenBinding binding;

    public void SwitchScene() {
        NavHostFragment.findNavController(this)
                .navigate(R.id.action_blankFragment_to_FirstFragment);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = LoadingScreenBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        VideoView simpleVideoView = binding.videoView;
        simpleVideoView.setVideoURI(Uri.parse("android.resource://" + BuildConfig.APPLICATION_ID + "/" + R.raw.loading));

        simpleVideoView.start();
        this.binding.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                simpleVideoView.start();
            }
        });
        super.onViewCreated(view, savedInstanceState);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
