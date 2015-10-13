package com.mosheparfait.semijapan;

import com.mosheparfait.semijapan.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.media.MediaPlayer;
import android.widget.ImageView;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends Activity {

	private MediaPlayer mPlayer;
	private int resMusic, resGallery, resPlay;
	private ImageView gallery;
	private TextView intro2;
	private int iPosition;
	private Button btnPlay;
	private boolean bPlay;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try{
			gallery = (ImageView)findViewById(R.id.gallery);
			intro2 = (TextView)findViewById(R.id.intro2);
			btnPlay = (Button)findViewById(R.id.btn_play);
			bPlay = true;
			resMusic = R.raw.rin_sukara_sakura;
			mPlayer = MediaPlayer.create(this,resMusic);
			mPlayer.start();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onPause() {
		super.onPause();
		pause_music();
	}
	
	@Override
	public void onResume(){
		super.onResume();
		resume_music();
	}
	
	public void pause_music(){
		try{
			mPlayer.pause();
			iPosition = mPlayer.getCurrentPosition();
			bPlay = false;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void resume_music(){
		try{
			mPlayer.seekTo(iPosition);
			mPlayer.start();
			bPlay = true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void show_picture(int iKindPic){
		try{
			gallery.setVisibility(View.VISIBLE);
			resGallery = iKindPic;
			gallery.setBackgroundResource(resGallery);
			intro2.setText(R.string.close);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void ike_click(View v){
		show_picture(R.drawable.ike_big);
	}
	
	public void ocha_click(View v){
		show_picture(R.drawable.ocha_big);
	}
	
	public void sushi_click(View v){
		show_picture(R.drawable.sushi_big);
	}
	
	public void sword_click(View v){
		show_picture(R.drawable.sword_big);
	}
	
	public void close_picture(View v){
		try{
			gallery.setVisibility(View.INVISIBLE);
			intro2.setText(R.string.intro2);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void play_click(View v){
		try{
			if(bPlay == true){
				resPlay = R.drawable.icon_play;
				btnPlay.setBackgroundResource(resPlay);
				pause_music();
			}
			else if(bPlay == false){
				resPlay = R.drawable.icon_pause;
				btnPlay.setBackgroundResource(resPlay);
				resume_music();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
