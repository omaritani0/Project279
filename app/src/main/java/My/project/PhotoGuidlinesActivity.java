package My.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;



public class PhotoGuidlinesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_guidlines);

        // Find the Setup a Meeting button by its ID
        Button setupMeetingButton = findViewById(R.id.setup_meeting_button);
        setupMeetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When the button is clicked, start MeetingSchedulerActivity
                Intent intent = new Intent(PhotoGuidlinesActivity.this, MeetingSchedulerActivity.class);
                startActivity(intent);
            }
        });

        ImageButton searchButton = findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhotoGuidlinesActivity.this, SearchSuggestionsActivity.class);
                startActivity(intent);
            }
        });
        // Chat button functionality
        Button chatButton = findViewById(R.id.chat_button);
        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhotoGuidlinesActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

    }

}
