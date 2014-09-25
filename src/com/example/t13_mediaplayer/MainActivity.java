package com.example.t13_mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

	
	@Override
	protected void onDestroy(){
		if( mp != null ){
			mp.stop();
			mp.release();
		}
		mp = null;
		
		super.onDestroy();
	}
	
	MediaPlayer mp = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btnStart = (Button)findViewById(R.id.btnStart);
        Button btnStop = (Button)findViewById(R.id.btnEnd);
        Button btnStart_new = (Button)findViewById(R.id.btnStart_new);
        Button btnStop_new = (Button)findViewById(R.id.btnEnd_new);
        
        btnStart.setOnClickListener(new OnClickListener() {
			
        	@Override
			public void onClick(View v) {
			// TODO Auto-generated method stub
				mp = MediaPlayer.create(MainActivity.this, R.raw.kalimba);
				mp.start();
			}
		});
        btnStop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(mp != null){
					mp.stop();
					mp.release();
				}
				mp = null;
			}
		});
        
        
        btnStart_new.setOnClickListener(new OnClickListener() {
			
        	@Override
			public void onClick(View v) {
			// TODO Auto-generated method stub
				String path = Environment.getExternalStorageDirectory().toString();
				path = path + "/Music/¸á·Ð/020-Å©·¯½¬-Àá ¸øµå´Â ¹ã (Feat. ÆÝÄ¡ (Punch)).mp3";
				
				mp = new MediaPlayer();
				try{
					mp.setDataSource(path);
					mp.prepare();
				}catch(Exception e){
					e.printStackTrace();
				}
				mp.start();
			}
		});
        btnStop_new.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(mp != null){
					mp.stop();
					mp.release();
				}
				mp = null;
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
