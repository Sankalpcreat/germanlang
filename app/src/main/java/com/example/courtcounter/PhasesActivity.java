package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.miwok.R;

import java.util.ArrayList;

public class PhasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListner = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("what is your name?", "Wie lautet dein Name?", R.raw.a));
        words.add(new Word("how old are you?", "wie alt bist du?", R.raw.b));
        words.add(new Word("thank  you", "Danke", R.raw.c));
        words.add(new Word("sorry", "Es tut uns leid", R.raw.d));
        words.add(new Word("hello", "hallo", R.raw.f));
        words.add(new Word("can i talk to you", "\n" +
                "kann ich mit dir sprechen", R.raw.g));
        words.add(new Word("what is cost of", "\n" +
                "was kostet", R.raw.g));
        words.add(new Word("can you leave","\n" +
                "kannst du gehen",R.raw.m));
                words.add(new Word("Good morning","Guten Morgen",R.raw.i));
        words.add(new Word("Nice to meet you","Freut mich, dich kennenzulernen",R.raw.j));
        words.add(new Word("Goodbye","Auf Wiedersehen",R.raw.k));
        words.add(new Word( "I love you","Ich liebe dich ",R.raw.l));


        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = words.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(PhasesActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListner);
            }
        });

    }


    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }


    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}