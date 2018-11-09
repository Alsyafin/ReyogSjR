package com.example.windows.reyogsjr;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    private LinearLayout LienearAlsyafin;
    private ImageView logo;
    private TextView nama,email;
    private Button SignOut;
    private SignInButton SignIn;
    private GoogleApiClient googleApiClient;
    private static final int REQ_CODE=9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LienearAlsyafin = (LinearLayout)findViewById(R.id.LienearAlsyafin);
        SignOut = (Button)findViewById(R.id.SignOut);
        SignIn = (SignInButton) findViewById(R.id.SignIn);
        nama = (TextView)findViewById(R.id.nama);
        email = (TextView) findViewById(R.id.email);
        logo = (ImageView) findViewById(R.id.logo);

        SignIn.setOnClickListener(this);
//        SignIn = (Button)SignIn.findViewById(R.id.SignIn);
        SignOut.setOnClickListener(this);
        logo.setVisibility(View.GONE);

        GoogleSignInOptions signInOptions =new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,signInOptions)
                .build();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.SignIn:
                signIn();
                break;
            case R.id.SignOut:
                SignOut();

        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void signIn() {
        Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent,REQ_CODE);
    }

    private void SignOut(){
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                updateUI(false);
            }
        });
    }

    private void handleSignInResult(GoogleSignInResult result) {

        if (result.isSuccess()){
            GoogleSignInAccount account = result.getSignInAccount();
            String nama = account.getDisplayName();
            String email = account.getEmail();
            String img_url = account.getPhotoUrl().toString();

//            nama.setText(nama);
//            email.setText(email);
            Glide.with(this).load(img_url).into(logo);
            updateUI(true);
        }
        else {
            updateUI(false);
        }
    }

    private void updateUI(boolean isLogin){
        if(isLogin){
            logo.setVisibility(View.VISIBLE);
            SignIn.setVisibility(View.GONE);
        }
        else {
            logo.setVisibility(View.GONE);
            SignIn.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == REQ_CODE) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }
}
