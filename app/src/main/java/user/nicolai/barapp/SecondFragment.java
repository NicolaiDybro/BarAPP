package user.nicolai.barapp;

import static user.nicolai.barapp.FirstFragment.myThreadConnected;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import user.nicolai.barapp.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
private static FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

      binding = FragmentSecondBinding.inflate(inflater, container, false);
      return binding.getRoot();

    }

    public void startLoading() {
        binding.videoView2.setVisibility(View.VISIBLE);
        binding.Scrollview.setVisibility(View.GONE);
        binding.align.setBackgroundColor(Color.BLACK);
        binding.videoView2.start();
    }

    public static void stopLoading1() {
        binding.videoView2.setVisibility(View.GONE);
        binding.Scrollview.setVisibility(View.VISIBLE);
        binding.align.setBackgroundColor(Color.alpha(181111));
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        VideoView simpleVideoView = binding.videoView2;
        simpleVideoView.setVideoURI(Uri.parse("android.resource://" + BuildConfig.APPLICATION_ID + "/" + R.raw.loading));

        simpleVideoView.start();
        binding.videoView2.setVisibility(View.GONE);
        this.binding.videoView2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                simpleVideoView.start();
            }
        });
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
                startLoading();
            }
        });

        binding.imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myThreadConnected.write("1:2:3:1:5:3".getBytes());
                startLoading();
            }
        });

        binding.imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myThreadConnected.write("1:2:3:1:5:3".getBytes());
                startLoading();
            }
        });

        binding.imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myThreadConnected.write("1:2:3:1:5:3".getBytes());
                startLoading();
            }
        });

        binding.imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myThreadConnected.write("1:2:3:1:5:3".getBytes());
                startLoading();
            }
        });

        binding.imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myThreadConnected.write("1:2:3:1:5:3".getBytes());
                startLoading();
            }
        });

        binding.imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myThreadConnected.write("1:2:3:1:5:3".getBytes());
                startLoading();
            }
        });

        binding.imageButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myThreadConnected.write("1:2:3:1:5:3".getBytes());
                startLoading();
            }
        });

        binding.imageButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myThreadConnected.write("1:2:3:1:5:3".getBytes());
                startLoading();
            }
        });

        binding.imageButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myThreadConnected.write("1:2:3:1:5:3".getBytes());
                startLoading();
            }
        });

    }


@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
