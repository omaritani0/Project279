package My.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class UploadPhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_photo);

        // Set padding for the photo icon to handle system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.photoUploadIcon), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set up the button to navigate to AddMorePhotosActivity
        Button addPhotoButton = findViewById(R.id.addPhotoButton);
        addPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start AddMorePhotosActivity when the button is clicked
                Intent intent = new Intent(UploadPhotoActivity.this, AddMorePhotosActivity.class);
                startActivity(intent);
            }
        });

        // Set up the skip button to navigate to NextActivity
        Button skipButton = findViewById(R.id.skipButton);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NextActivity when the skip button is clicked
                Intent intent = new Intent(UploadPhotoActivity.this, PhotoGuidlinesActivity.class);
                startActivity(intent);
            }
        });
    }
}
