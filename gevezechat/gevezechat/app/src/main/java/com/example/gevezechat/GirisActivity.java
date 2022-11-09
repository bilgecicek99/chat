package com.example.gevezechat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GirisActivity extends AppCompatActivity {
    EditText kullaniciAdiEditText;
    Button kayitOlButon;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        tanimla();
        System.out.println("On create girildi");
    }
    public void tanimla()
    {
        kullaniciAdiEditText =findViewById(R.id.kullaniciAdiEditText);
        kayitOlButon=findViewById(R.id.kayitOlButon);
        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference();
        kayitOlButon.setOnClickListener(view -> {
            String userName= kullaniciAdiEditText.getText().toString();
            kullaniciAdiEditText.setText("");
            System.out.println("tanımla girildi");
            ekle(userName);
                });

    }

    public void ekle(String kadi)

    {
        System.out.println("ekle komutuna girildi");
        reference.child("Kullanıcılar").child(kadi).child("kullaniciadi").setValue(kadi).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(getApplicationContext(), "Başarıyla Kayıt İşlemini Tamamladınız.", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(GirisActivity.this, MainActivity.class);
                intent.putExtra("kadi",kadi);
                startActivity(intent);
            }
        });
    }
}