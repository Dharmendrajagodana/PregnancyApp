package com.hackathon.projects;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.messaging.FirebaseMessaging;

import utilities.AppData;
import utilities.PopupNotification;


public class Register extends AppCompatActivity {
    private static final String TAG = "RegisterActivity";
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (AppData.checkNONetWork(Register.this)) {
                    new PopupNotification(Register.this);
                } else {
                    if (user != null) {
                        // User is signed in
                        Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                        Intent intent = new Intent(Register.this, Home.class);
                        startActivity(intent);
                    } else {
                        // User is signed out
                        Log.d(TAG, "onAuthStateChanged:signed_out");
                    }
                }
                // ...
            }
        };

        setContentView(R.layout.register);

        final EditText nameET = findViewById(R.id.user_name);
        final EditText emailET = findViewById(R.id.register_email);
        final EditText passwordET = findViewById(R.id.register_password);
        Button registerButton = findViewById(R.id.register_button);
        TextView referLogin = findViewById(R.id.textView_register);

        referLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);

            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameET.getText().toString();
                String email = emailET.getText().toString();
                String password = passwordET.getText().toString();
                if (TextUtils.isEmpty(email) || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    emailET.setError("ENTER VALID EMAIL");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    passwordET.setError("REQUIRED");
                    return;
                }

                if (password.length() < 6) {
                    passwordET.setError("6 OR MORE LATTER");
                    return;
                }

                if (AppData.checkNONetWork(Register.this)) {
                    new PopupNotification(Register.this);
                }
                View loadingIndicator = findViewById(R.id.progressBar_register);
                loadingIndicator.setVisibility(View.VISIBLE);
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                View loadingIndicator = findViewById(R.id.progressBar_register);
                                loadingIndicator.setVisibility(View.GONE);
                                Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                                Toast.makeText(Register.this, R.string.toast_registered,
                                        Toast.LENGTH_SHORT).show();
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(Register.this, R.string.auth_failed,
                                            Toast.LENGTH_SHORT).show();
                                }
                                // ...
                            }
                        });
            }
        });

        FirebaseMessaging.getInstance().setAutoInitEnabled(true);


    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

}
