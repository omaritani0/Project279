package My.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;





public class ProfileDisplayActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_guidlines);

        // Back button functionality
        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the previous activity
                finish(); // This will finish the current activity and go back to the previous one
            }
        });

        ImageButton searchButton = findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileDisplayActivity.this, SearchSuggestionsActivity.class);
                startActivity(intent);
            }
        });
        // Chat button functionality
        Button chatButton = findViewById(R.id.chat_button);
        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileDisplayActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });


    }
}
