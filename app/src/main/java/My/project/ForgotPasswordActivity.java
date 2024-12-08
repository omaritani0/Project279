package My.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import java.util.regex.Pattern;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText emailEditText, newPasswordEditText, confirmPasswordEditText;

    // Regex pattern to validate email ending with @...com
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+\\.com)$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        // Set up the Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Show the back button
        getSupportActionBar().setTitle("Forgot Password"); // Set title if needed

        emailEditText = findViewById(R.id.emailEditText);
        newPasswordEditText = findViewById(R.id.newPasswordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        Button returnToLoginButton = findViewById(R.id.returnToLoginButton);

        returnToLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String newPassword = newPasswordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();

                // Validate email format
                if (!EMAIL_PATTERN.matcher(email).matches()) {
                    Toast.makeText(ForgotPasswordActivity.this, "Invalid email format. It should end with @...com", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check if the email is registered
                SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                String registeredEmail = sharedPreferences.getString("email", "");

                if (!email.equals(registeredEmail)) {
                    Toast.makeText(ForgotPasswordActivity.this, "Email is not registered.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validate password criteria
                if (!isValidPassword(newPassword)) {
                    Toast.makeText(ForgotPasswordActivity.this, "Password must be at least 8 characters long, " +
                            "and contain at least one uppercase letter and one lowercase letter", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check if passwords match
                if (!newPassword.equals(confirmPassword)) {
                    Toast.makeText(ForgotPasswordActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    // Save new password in SharedPreferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("password", newPassword);
                    editor.apply();

                    Toast.makeText(ForgotPasswordActivity.this, "Password updated successfully", Toast.LENGTH_SHORT).show();

                    // Go back to the MainActivity
                    Intent intent = new Intent(ForgotPasswordActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    // Method to check if the password meets the criteria
    private boolean isValidPassword(String password) {
        return password.length() >= 8 &&
                password.chars().anyMatch(Character::isUpperCase) &&
                password.chars().anyMatch(Character::isLowerCase);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks
        switch (item.getItemId()) {
            case android.R.id.home:
                // Respond to the back button click
                finish(); // Finish the activity and go back to the previous one
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
