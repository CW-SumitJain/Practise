package com.example.aepl.camera_grid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    ImageAdapter imageAdapter;
    String targetPath;
    GridView imagegrid;
    private static int id;
    public  Bitmap bm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = 0;
        setContentView(R.layout.activity_main);
        Intent receivedIntent = getIntent();
        imageAdapter  = new ImageAdapter(this);
        String receivedAction = receivedIntent.getAction();
        if(receivedAction.equals(Intent.ACTION_SEND)){
            //content is being shared
            Uri receivedUri = (Uri)receivedIntent.getParcelableExtra(Intent.EXTRA_STREAM);
            try {
                bm = MediaStore.Images.Media.getBitmap(this.getContentResolver(),receivedUri);

            } catch (IOException e) {
                e.printStackTrace();
            }

            imageAdapter.add_image(bm);
        }

        /*String ExternalStorageDirectoryPath = Environment
                .getExternalStorageDirectory()
                .getAbsolutePath();

        targetPath = ExternalStorageDirectoryPath + "/Image1/";

        Toast.makeText(getApplicationContext(), targetPath, Toast.LENGTH_LONG).show();
        File targetDirector = new File(targetPath);
        Log.d("TAG","Chcekc "+targetPath);
        File[] files = targetDirector.listFiles();
        for (File file : files) {
            imageAdapter.add(file.getAbsolutePath());
        }*/


        Button camera = (Button )findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
        imagegrid = (GridView) findViewById(R.id.image_grid);

        imagegrid.setAdapter(imageAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                imageAdapter.add_image(photo);
//                photo.toString();
                Log.d("TAG","Photoprinted" + photo.toString());
                imageAdapter.notifyDataSetChanged();
//                saveimagetofolder(photo);
                //imagegrid.setAdapter(new ImageAdapter(MainActivity.this,photo));


            }
        }

    /*private void saveimagetofolder(Bitmap photo) {
        Log.d("TAG","Function called");
        // Find the SD Card path
        File filepath = Environment.getExternalStorageDirectory();

        // Create a new folder in SD Card
        File dir = new File(filepath.getAbsolutePath()
                + "/Image1/");
       // dir.mkdirs();
        OutputStream output;

        // Create a name for the saved image
        File file = new File(dir, "img"+id+".png");

        // Show a toast message on successful save
        Toast.makeText(MainActivity.this, "Image Saved to SD Card",
                Toast.LENGTH_SHORT).show();
        try {

            output = new FileOutputStream(file);

            // Compress into png format image from 0% - 100%
            photo.compress(Bitmap.CompressFormat.PNG, 100, output);
            output.flush();
            output.close();
        }

        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/
}
