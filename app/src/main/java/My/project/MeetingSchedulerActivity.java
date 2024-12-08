package My.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MeetingSchedulerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_scheduler);// Ensure this layout file exists in res/layout

        // Back button functionality
        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the previous activity
                finish(); // This will finish the current activity and go back to the previous one
            }
        });
        // Setup the "Add Members" button
        Button addMembersButton = findViewById(R.id.add_members_button);

        // Set an OnClickListener for the "Add Members" button
        addMembersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When the button is clicked, start SuggestionActivity
                Intent intent = new Intent(MeetingSchedulerActivity.this, SearchSuggestionsActivity.class);
                startActivity(intent);
            }
        });
    }

}
