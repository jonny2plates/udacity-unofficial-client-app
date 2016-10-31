package xyz.abhaychauhan.www.udacityunofficialclient;

/**
 * Created by p3ac3 on 31/10/2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;


/**Luke 22: And he said unto his disciples,therefore i say unto you,
 * take no thought for your life,what you shall eat,neither for the body,
 * what you shall put on. The life is more than meat and gthe body is more that eat,
 * and the body is more than raiment.
 * Created by Jonathan on 05/02/2015.
 */
public class Splashscreen extends Activity {


    private Animation fadeIn;
    private ImageView splash_logo;
    private static int RC_SIGN_IN = 9001;


    //
    private final Handler mThreadHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscren);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        // Create the Google Api Client with access to the Play Games services
       /* mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(Games.API).addScope(Games.SCOPE_GAMES)
                .
                 addApi(Plus.API).addScope(Plus.SCOPE_PLUS_LOGIN)
          // add other APIs and scopes here as needed
                        .build();*/

        splash_logo = (ImageView) findViewById(R.id.splash_logo);
        // splash_logo.setAnimation(fadeIn);


        runThread();

    }


    public void runThread() {


        mThreadHandler.postDelayed(mPendingLauncherRunnable, 3000);




    }

    @Override
    protected void onPause() {

        super.onPause();
        //no need to pause if not instantiated
        Log.i("on pause called", "thread is:" + mThreadHandler);

        if (mThreadHandler != null) {
            if (mPendingLauncherRunnable != null)
                mThreadHandler.removeCallbacks(mPendingLauncherRunnable);
        }
    }

    @Override
    protected void onStart() {

        super.onStart();
//
    }

    @Override
    protected void onRestart() {

        super.onRestart();
    }

    @Override
    protected void onResume() {

        super.onResume();
        Log.i("on Resume called", "thread is:" + mThreadHandler);

        runThread();


    }

    @Override
    protected void onStop() {
        super.onStop();
        //     mGoogleApiClient.disconnect();

    }

    public final Runnable mPendingLauncherRunnable = new Runnable() {

        @Override
        public void run() {






         goToNextActivity();


        }

    };


    public void goToNextActivity() {
        //Lets save email address in preferences.


        Intent i = new Intent(this, MainActivity.class);
        // i.putExtra("email",email);

        startActivity(i);

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        mThreadHandler.removeCallbacks(mPendingLauncherRunnable);


    }


}
