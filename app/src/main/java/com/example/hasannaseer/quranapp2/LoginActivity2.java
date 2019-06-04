package com.example.hasannaseer.quranapp2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity2 extends AppCompatActivity {
    private static final String TAG = "LoginActivity2";
    private static final int REQUEST_SIGNUP = 0;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    private ProgressDialog progressDialog;

   // TextView login;
    Context ctx;
    TextView back;

    @BindView(R.id.input_email) EditText _emailText;
    @BindView(R.id.input_password) EditText _passwordText;
    @BindView(R.id.btn_login) ImageButton _loginButton;
    @BindView(R.id.link_signup) TextView _signupLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        back = findViewById(R.id.text_back);
        //login = findViewById(R.id.link_signup);
        ctx = getApplication();

        ButterKnife.bind( this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ctx, MainActivity.class);
                startActivity(myIntent);

            }
        });

       /* login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity (new Intent(LoginActivity2.this, SignupActivity.class));
            }
        }); */


        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                //startActivity(intent);
            }
        });
    }

    public void login() {
        if (!validate()) {
            onLoginFailed();
            _loginButton.setEnabled(true);
            return;
        }else{
              progressDialog = new ProgressDialog(LoginActivity2.this,
                    R.style.AppTheme_Dark_Dialog);
            progressDialog.setIndeterminate(true);


            progressDialog.setMessage("Authenticating...");
            progressDialog.show();

            String email = _emailText.getText().toString();
            String password = _passwordText.getText().toString();
            LoginUser(email,password);
            onLoginSuccess();

        }


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = false;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty()) {
            _emailText.setError("Enter an  email address");
            valid = false;

        } else {
            valid = true;
            _emailText.setError(null);
        }

        if (password.isEmpty()) {
            _passwordText.setError("Enter a  Password");
            valid = false;
        } else {
            valid = true;
            _passwordText.setError(null);
        }

        return valid;
    }

    public void LoginUser(String Email, String Password){

        Log.d(TAG, "Login method called");
        mAuth.signInWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                                if (task.isSuccessful()) {
                                    currentUser = mAuth.getCurrentUser();
                                    _loginButton.setEnabled(true);

                                    Log.d(TAG, "Now Logged In");

                                    //finish();
                                    startActivity(new Intent(getApplicationContext(),
                                            QuranHome.class));


                                } else {
                                        validate();
                                        Toast.makeText(LoginActivity2.this, "No Account with that details found!",

                                                Toast.LENGTH_SHORT).show();
                                    progressDialog.dismiss();



                                }


                    }
                });

    }
}
