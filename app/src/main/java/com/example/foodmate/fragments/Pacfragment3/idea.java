package com.example.foodmate.fragments.Pacfragment3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.foodmate.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class idea extends AppCompatActivity {
    public static final int TAKE_PHOTO=1;
    private ImageView picture;
    private Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idea);
        final EditText editText=findViewById(R.id.themttext);
        Button write=findViewById(R.id.buttonwrite);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("yew",editText.getText().toString());
                setResult(RESULT_OK,intent);
                finish();


            }
        });
        Button takePhoto=findViewById(R.id.willtakephoto);
        picture=findViewById(R.id.willphoto);
        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File outputImage=new File(getExternalCacheDir(),"output_image.jpg");
                try{
                    if(outputImage.exists()){
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                imageUri= FileProvider.getUriForFile(idea.this,"com.example.cameraalbumtest.fileprovider",outputImage);
                Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                startActivityForResult(intent,TAKE_PHOTO);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode){
            case  TAKE_PHOTO:
                if(resultCode==RESULT_OK){
                    try{
                        Bitmap bitmap= BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        picture.setImageBitmap(bitmap);
                    }catch (FileNotFoundException e){
                        e.printStackTrace();
                    }
                }
                break;
                default:
                    break;
        }
    }
}
