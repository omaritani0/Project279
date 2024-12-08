package My.project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;


public class AddMorePhotosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_more_photos);


        Button continueButton = findViewById(R.id.confirmButton);
        continueButton.setOnClickListener(v -> {
            // Default behavior if no image is selected
            Intent intent = new Intent(AddMorePhotosActivity.this, PhotoGuidlinesActivity.class);
            startActivity(intent);
        });
    }

    // Helper method to set click listener
    private void setPhotoClickListener(ImageView photo, int photoId) {
        photo.setOnClickListener(v -> {
            Intent intent = new Intent(AddMorePhotosActivity.this, PhotoGuidlinesActivity.class);
            startActivity(intent);
        });
    }
}
