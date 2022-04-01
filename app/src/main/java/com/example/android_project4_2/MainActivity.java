package com.example.android_project4_2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text1,text2;
    CheckBox ChkAgree;
    RadioGroup group1;
    RadioButton rdoDog, rdoCat, rdoRabbit;
    Button btnOK;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setDisplayUseLogoEnabled(true);
        ab.setIcon(R.drawable.my);
        setTitle(" 애완동물 사진 보기");

        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);

        ChkAgree = (CheckBox) findViewById(R.id.ChkAgree);
        group1 = (RadioGroup) findViewById(R.id.group1);
        rdoCat = (RadioButton) findViewById(R.id.rdoCat);
        rdoDog = (RadioButton) findViewById(R.id.rdoDog);
        rdoRabbit = (RadioButton) findViewById(R.id.rdoRabbit);

        btnOK = (Button) findViewById(R.id.btnok);
        imgPet = (ImageView) findViewById(R.id.ImgPet);
    }

    public void onCheckboxClicked(View view){
        boolean checked = ((CheckBox) view).isChecked();

        if(checked){
            text2.setVisibility(View.VISIBLE);
            group1.setVisibility(View.VISIBLE);
            btnOK.setVisibility(View.VISIBLE);
            imgPet.setVisibility(View.VISIBLE);
        }
        else{
            text2.setVisibility(View.INVISIBLE);
            group1.setVisibility(View.INVISIBLE);
            btnOK.setVisibility(View.INVISIBLE);
            imgPet.setVisibility(View.INVISIBLE);
        }
    }
    public void onClick(View view){
        switch (group1.getCheckedRadioButtonId()){
            case R.id.rdoDog:
                imgPet.setImageResource(R.drawable.dog);
                break;
            case R.id.rdoCat:
                imgPet.setImageResource(R.drawable.cat);
                break;
            case R.id.rdoRabbit:
                imgPet.setImageResource(R.drawable.rabbit);
                break;
            default:
                Toast.makeText(getApplicationContext(),"동물 먼저 선택하세요",Toast.LENGTH_SHORT).show();
        }
    }
}