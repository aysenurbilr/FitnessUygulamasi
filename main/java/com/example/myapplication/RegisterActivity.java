package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

   private EditText kuladi,sifre;
   private String  txtkuladi,txtsifre;
   private FirebaseAuth mAuth;
   private TextView textViewg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        kuladi=(EditText)findViewById(R.id.kul_adi);
        sifre=(EditText)findViewById(R.id.sifre);


        mAuth = FirebaseAuth.getInstance();

        EdgeToEdge.enable(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void kayit_ol1(View view) {
        txtkuladi=kuladi.getText().toString();
        txtsifre=sifre.getText().toString();

        if(!TextUtils.isEmpty(txtkuladi) && !TextUtils.isEmpty(txtsifre)){
            mAuth.createUserWithEmailAndPassword(txtkuladi,txtsifre)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, "Kayıt işlemleri başarılı.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, ExerciseActivity.class);
                                startActivity(intent);
                                finish();
                            }else {
                                Toast.makeText(RegisterActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

        }else
            Toast.makeText(this,"Email ve şifre boş olamaz.",Toast.LENGTH_SHORT).show();
    }

    public void giris_yap2(View view) {
        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));

    }
}