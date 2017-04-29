package com.android.example.riyadhtourguide;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MasjedFragment extends Fragment {

    private MediaPlayer mMediaPlayer;

    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    public MasjedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(R.string.masjed1_name, R.string.masjed1_Info, R.mipmap.masjed, R.raw.luhyadan, R.mipmap.ic_play_arrow_white_24dp));
        items.add(new Item(R.string.masjed2_name, R.string.masjed2_Info, R.mipmap.masjed, R.raw.julaiel, R.mipmap.ic_play_arrow_white_24dp));
        items.add(new Item(R.string.masjed3_name, R.string.masjed3_Info, R.mipmap.masjed, R.raw.nasser, R.mipmap.ic_play_arrow_white_24dp));
        items.add(new Item(R.string.masjed4_name, R.string.masjed4_Info, R.mipmap.masjed, R.raw.yasser, R.mipmap.ic_play_arrow_white_24dp));
        items.add(new Item(R.string.masjed5_name, R.string.masjed5_Info, R.mipmap.masjed, R.raw.adel, R.mipmap.ic_play_arrow_white_24dp));

        ItemAddapter Adapter = new ItemAddapter(getActivity(), items, R.color.masjed_background);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item item = items.get(i);

                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now

                    mMediaPlayer = MediaPlayer.create(getActivity(), item.getSoundResourseId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
