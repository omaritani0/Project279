package My.project;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;



import java.util.ArrayList;

public class SearchSuggestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_search);

        // Back button functionality
        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Go back to the previous activity
            }
        });
        ListView listView = findViewById(R.id.suggestions_list);

        ArrayList<My.project.Suggestion> suggestions = new ArrayList<>();
        suggestions.add(new My.project.Suggestion("Olivia Rhye", "Product Manager, Integrations"));
        suggestions.add(new My.project.Suggestion("Phoenix Baker", "Frontend Developer, Payments"));
        suggestions.add(new My.project.Suggestion("Lori Bryson", "Backend Developer, Payments"));
        suggestions.add(new My.project.Suggestion("Orlando Diggs", "Sales Manager, Enterprise"));
        suggestions.add(new My.project.Suggestion("Kate Morrison", "Product Designer, Dashboard"));

        My.project.SuggestionsAdapter adapter = new My.project.SuggestionsAdapter(this, suggestions);
        listView.setAdapter(adapter);
    }
}
