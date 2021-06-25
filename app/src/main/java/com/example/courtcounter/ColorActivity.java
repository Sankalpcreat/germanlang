package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.miwok.R;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;


    private MediaPlayer.OnCompletionListener mCompletionListner=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


      final   ArrayList<Word> words =new ArrayList<Word>();


        words.add(new Word("black","schwarz",R.drawable.color_black,R.raw.black));
        words.add(new Word("white","Weiß",R.drawable.color_white,R.raw.white));
        words.add(new Word("gray","grau",R.drawable.color_gray,R.raw.grey));
        words.add(new Word("red","rot",R.drawable.color_red,R.raw.red));

        words.add(new Word("yellow","geib",R.drawable.color_dusty_yellow,R.raw.yellow));
        words.add(new Word("green","grun",R.drawable.color_green,R.raw.green));

        words.add(new Word("brown","braun",R.drawable.color_brown,R.raw.brown));
        words.add(new Word("blue","blau",R.drawable.blue_color,R.raw.blue));
        words.add(new Word("orange","orange",R.drawable.orange_color,R.raw.orange));
        words.add(new Word("pink","rosa",R.drawable.rosa,R.raw.pink));





        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

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

                Word word=words.get(position);
                releaseMediaPlayer();
                mMediaPlayer=MediaPlayer.create(ColorActivity.this,word.getAudioResourceId());
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
