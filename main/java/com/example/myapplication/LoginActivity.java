package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private EditText kuladi,sifre;
    private String  txtkuladi,txtsifre;
    private FirebaseAuth mAuth;
    FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        kuladi=(EditText)findViewById(R.id.gkul_adi);
        sifre=(EditText)findViewById(R.id.gsifre);

        mAuth = FirebaseAuth.getInstance();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void kayit_ol(View view) {
        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
    }
    public void giris_yap(View view){
        txtkuladi=kuladi.getText().toString();
        txtsifre=sifre.getText().toString();
        if (!TextUtils.isEmpty(txtkuladi) && !TextUtils.isEmpty(txtsifre)){
            mAuth.signInWithEmailAndPassword(txtkuladi,txtsifre)
                    .addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            mUser = mAuth.getCurrentUser();
                            startActivity(new Intent(LoginActivity.this, ExerciseActivity.class));

                        }
                    }).addOnFailureListener(this, new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(LoginActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    });
        }else
        Toast.makeText(this,"Email ve şifre boş olamaz.",Toast.LENGTH_SHORT).show();
    }
}

