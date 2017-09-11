package com.example.yao.broadcastbestpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BasicActivity {
    private EditText accountText;
    private EditText passwordText;
    private Button login;

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox rememberPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        rememberPass = (CheckBox) findViewById(R.id.remember_pass);
        accountText = (EditText) findViewById(R.id.account);
        passwordText = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        boolean isRemember = pref.getBoolean("remember_password", false);
        if (isRemember){
            String account = pref.getString("account", "");
            String password = pref.getString("password", "");
            accountText.setText(account);
            passwordText.setText(password);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountText.getText().toString();
                String password = passwordText.getText().toString();
                if (account.equals("admin") && password.equals("123456")){
                    editor = pref.edit();
                    if (rememberPass.isChecked()){
                        editor.putBoolean("remember_password", true);
                        editor.putString("account", account);
                        editor.putString("password", password);
                    } else {
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(LoginActivity.this, "invalid account or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
