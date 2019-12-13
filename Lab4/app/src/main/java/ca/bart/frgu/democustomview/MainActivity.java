package ca.bart.frgu.democustomview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity implements Constants
{


    private Handler handler = new Handler();
    private Runnable runnable = this::RequestUpdate;


    private long previousTime;
    private long lag;

    private CustomView customView;

    private int speedRotation = 40;

    private int speedPolygone = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customView = findViewById(R.id.customView);
    }


    @Override
    protected void onResume()
    {
        super.onResume();

        previousTime = System.nanoTime();
        lag = 0;

        RequestUpdate();
    }

    private void RequestUpdate()
    {
        long currentTime = System.nanoTime();
        long elapsedTime = currentTime - previousTime;
        previousTime = currentTime;
        lag += elapsedTime;

        while (lag >= NS_PER_FRAME)
        {
            lag -= NS_PER_FRAME;
            Update();
        }

        handler.postDelayed(runnable, (long) MS_PER_FRAME);
    }

    private void Update()
    {
        speedRotation ++;
        customView.setTime(customView.getTime() + S_PER_FRAME);

        customView.polygones.setRotation(speedRotation);

    }

    @Override
    protected void onPause()
    {
        super.onPause();

        handler.removeCallbacks(runnable);
    }

}
