package com.example.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    TextView text1, text2;
    CheckBox chkAgree;
    RadioGroup rGroup1;
    RadioButton rdoDog, rdoCat, rdoHam;
    Button btnOK, btnreset, btnexit;
    ImageView imgPet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        text1=(TextView) findViewById(R.id.Text1);
        chkAgree=(CheckBox) findViewById(R.id.ChkAgree);

        text2=(TextView) findViewById(R.id.Text2);
        rGroup1=(RadioGroup) findViewById(R.id.Rgroup1);
        rdoDog=(RadioButton) findViewById(R.id.RdoDog);
        rdoCat=(RadioButton) findViewById(R.id.RdoCat);
        rdoHam=(RadioButton) findViewById(R.id.RdoHam);

        btnOK=(Button) findViewById(R.id.BtnOK);
        imgPet=(ImageView) findViewById(R.id.ImgPet);

        btnreset=(Button) findViewById(R.id.Btnreset);
        btnexit=(Button) findViewById(R.id.Btnexit);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chkAgree.isChecked()==true){
                    text2.setVisibility(android.view.View.VISIBLE);
                    rGroup1.setVisibility(android.view.View.VISIBLE);
                    btnOK.setVisibility(android.view.View.VISIBLE);
                    imgPet.setVisibility(android.view.View.VISIBLE);
                } else
                {
                    text2.setVisibility(android.view.View.INVISIBLE);
                    rGroup1.setVisibility(android.view.View.INVISIBLE);
                    btnOK.setVisibility(android.view.View.INVISIBLE);
                    imgPet.setVisibility(android.view.View.INVISIBLE);
                }
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                switch(rGroup1.getCheckedRadioButtonId()) {
                    case R.id.RdoDog:
                        imgPet.setImageResource(R.drawable.dog);
                        break;
                    case R.id.RdoCat:
                        imgPet.setImageResource(R.drawable.cat);
                        break;
                    case R.id.RdoHam:
                        imgPet.setImageResource(R.drawable.ham);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물 먼저 선택하세요", Toast.LENGTH_SHORT).show();
                }
            }
         });

        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chkAgree.setChecked(false);
                text2.setVisibility(android.view.View.INVISIBLE);
                rGroup1.setVisibility(android.view.View.INVISIBLE);
                btnOK.setVisibility(android.view.View.INVISIBLE);
                imgPet.setVisibility(android.view.View.INVISIBLE);
            }
        });


    }
}