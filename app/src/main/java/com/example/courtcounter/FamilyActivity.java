package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.miwok.R;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
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


          final ArrayList<Word> words =new ArrayList<Word>();


        words.add(new Word("Father","der Vater",R.drawable.family_father,R.raw.father));
        words.add(new Word("Mother","die Mutter ",R.drawable.family_mother,R.raw.mother));
        words.add(new Word("Older Sister","Die ältere Schwester",R.drawable.family_older_sister,R.raw.oldersister));
        words.add(new Word("Older Brother","Der ältere Bruder",R.drawable.family_older_brother,R.raw.olderbrother));
        words.add(new Word("Son","der Sohn",R.drawable.family_son,R.raw.son));
        words.add(new Word("Daughter","die Tochter",R.drawable.family_daughter,R.raw.daughter));
        words.add(new Word("grandmother","Die Oma",R.drawable.family_grandmother,R.raw.grandmother));
        words.add(new Word("grandfather","Der Opa",R.drawable.family_grandfather,R.raw.grandfather));
        words.add(new Word("friend","Der Freund",R.drawable.friends,R.raw.friend));
        words.add(new Word("wife","Die Ehefrau",R.drawable.wife,R.raw.wife));





        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);

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
                mMediaPlayer=MediaPlayer.create(FamilyActivity.this,word.getAudioResourceId());
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