package com.example.camera_e_9590;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private Camera mCamera = null;
    private CameraView mCameraView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            mCamera = Camera.open();
        }catch (Exception e){
            Log.d("Error", "Failed to get Camera" + e.getMessage());
        }
        if (mCamera != null){
            mCameraView = new CameraView(this, mCamera);
            FrameLayout camera_viwe = (FrameLayout) findViewById(R.id.FLCamera);
            camera_viwe.addView(mCameraView);
        }

        ImageButton imageButton = (ImageButton) findViewById(R.id.imgClose);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }
}