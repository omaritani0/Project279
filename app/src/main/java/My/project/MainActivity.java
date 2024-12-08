package My.project;

import static My.project.R.*;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // Declare your views as instance variables
    private EditText emailEditText;
    private EditText passwordEditText;
    private CheckBox rememberMeCheckBox;
    private Button continueButton;
    private TextView signupText;
    private Button userProfilesButton;
    private Button meetingSchedulerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);  // Ensure this matches your XML layout name

        // Initialize your views after setContentView
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText); // Correct this line
        rememberMeCheckBox = findViewById(R.id.rememberMeCheckBox);
        continueButton = findViewById(R.id.continueButton);
        signupText = findViewById(R.id.signUpTextView);
        // Ensure these buttons exist in your XML if you're using them
        // userProfilesButton = findViewById(R.id.userProfilesButton);
        // meetingSchedulerButton = findViewById(R.id.meetingSchedulerButton);

        // Debug logging
        Log.d("MainActivity", "emailEditText: " + emailEditText);
        Log.d("MainActivity", "passwordEditText: " + passwordEditText);
        Log.d("MainActivity", "rememberMeCheckBox: " + rememberMeCheckBox);
        Log.d("MainActivity", "continueButton: " + continueButton);
        Log.d("MainActivity", "signupText: " + signupText);

        // Set up listeners for your buttons
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (validateCredentials(email, password)) {
                    Intent intent = new Intent(MainActivity.this, UploadPhotoActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Email or password is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        // Only set up listeners if buttons are initialized
        if (userProfilesButton != null) {
            userProfilesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, ProfileDisplayActivity.class);
                    startActivity(intent);
                }
            });
        }

        if (meetingSchedulerButton != null) {
            meetingSchedulerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, MeetingSchedulerActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    public void onForgotPasswordClick(View view) {
        Intent intent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
        startActivity(intent);
    }

    private boolean validateCredentials(String email, String password) {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String registeredEmail = sharedPreferences.getString("email", "");
        String registeredPassword = sharedPreferences.getString("password", "");

        return email.equals(registeredEmail) && password.equals(registeredPassword);
    }
}
