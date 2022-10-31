package com.c1ph3r.firebasefirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class LoginPage extends AppCompatActivity {
    TextInputEditText user, data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        user =findViewById(R.id.user);
        data = findViewById(R.id.pass);
    }

    public void onClickButton(View view) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, String> databaseValue = new HashMap<>();
        databaseValue.put("user", user.getText().toString());
        databaseValue.put("pass", data.getText().toString());
        db.collection("databaseValues").add(databaseValue).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(LoginPage.this, "done", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginPage.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}