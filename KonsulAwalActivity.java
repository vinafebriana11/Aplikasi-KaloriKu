package com.tugasaplikasi.kaloriku.penghitungkalori;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.tugasaplikasi.kaloriku.penghitungkalori.Data.SharedPref;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class KonsulAwalActivity extends AppCompatActivity {

    @BindView(R.id.edit_user_name)
    EditText editUserName;
    @BindView(R.id.edit_user_umur)
    EditText editUserUmur;
    @BindView(R.id.radio_button_male)
    RadioButton radioButtonMale;
    @BindView(R.id.radio_button_female)
    RadioButton radioButtonFemale;
    @BindView(R.id.edit_user_berat)
    EditText editUserBerat;
    @BindView(R.id.edit_tinggi_user)
    EditText editTinggiUser;
    @BindView(R.id.radio_button_ringan)
    RadioButton radioButtonRingan;
    @BindView(R.id.radio_button_sedang)
    RadioButton radioButtonSedang;
    @BindView(R.id.radio_button_berat)
    RadioButton radioButtonBerat;
    @BindView(R.id.container_aktivitas)
    LinearLayout containerAktivitas;

    @BindView(R.id.button_simpan)
    Button buttonSimpan;
    @BindView(R.id.radio_grup_jenis_kelamin)
    RadioGroup radioGrupJenisKelamin;
    @BindView(R.id.radio_grup_jenis_aktifitas)
    RadioGroup radioGrupJenisAktifitas;
    @BindView(R.id.button_detil_aktifitas)
    Button buttonDetilAktifitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsul_awal);
        ButterKnife.bind(this);

        SharedPref.init(getApplicationContext());
    }

//    RadioGroup.OnCheckedChangeListener radioGroupOnCheckedChangeListener =
//            new RadioGroup.OnCheckedChangeListener(){
//
//                @Override
//                public void onCheckedChanged(RadioGroup group, int checkedId) {
//
//                    RadioButton checkedRadioButton = radioGrupJenisKelamin.findViewById(checkedId);
//                    int checkedIndex = radioGrupJenisKelamin.indexOfChild(checkedRadioButton);
//
//                    SharedPref.write(SharedPref.JENIS_KELAMIN, 0);
//                    RadioButton savedCheckedRadioButton = (RadioButton)radioGrupJenisKelamin.getChildAt(checkedIndex);
//                    savedCheckedRadioButton.setChecked(true);
//
//                    textViewJKelamin.setText(checkedIndex);
//
//                    Toast.makeText(getBaseContext(), "berhasil disimpan", Toast.LENGTH_SHORT).show();
//                }};


    @OnClick(R.id.button_simpan)
    public void onButtonSimpanClicked() {

        SharedPref.write(SharedPref.NAMA, editUserName.getText().toString());
        SharedPref.write(SharedPref.UMUR, editUserUmur.getText().toString());
        SharedPref.write(SharedPref.JENIS_KELAMIN, radioGrupJenisKelamin.isEnabled());
        SharedPref.write(SharedPref.BERAT_BADAN, editUserBerat.getText().toString());
        SharedPref.write(SharedPref.TINGGI_BADAN, editTinggiUser.getText().toString());
        SharedPref.write(SharedPref.JENIS_AKTIFITAS, radioGrupJenisAktifitas.isEnabled());

        if (editUserName.getText().toString().isEmpty() || editUserUmur.getText().toString().isEmpty() ||
                editTinggiUser.getText().toString().isEmpty() || editTinggiUser.getText().toString().isEmpty()
                ) {

            Toast.makeText(this, "harap lengkapi isian yang ada di atas", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(this, "berhasil disimpan", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.button_detil_aktifitas)
    public void onViewClicked() {
        Intent intent = new Intent(this, DetilAktifitas.class);
        startActivity(intent);
    }
}
