//package My.project;
//
//import android.os.Bundle;
//import androidx.appcompat.app.AppCompatActivity;
//import android.widget.TextView;
//
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//
//
//public class ChatDetailActivity extends AppCompatActivity {
//
//    private ApiService apiService;
//    private EditText messageInput;
//    private Button sendButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_chat_detail);
//
//        // Initialize API service
//        apiService = ApiClient.getClient().create(ApiService.class);
//
//        // Get references to UI components
//        messageInput = findViewById(R.id.messageInput);
//        sendButton = findViewById(R.id.sendButton);
//
//        sendButton.setOnClickListener(v -> sendMessage());
//
//        // Get chat name passed from ChatActivity
//        String chatName = getIntent().getStringExtra("chatName");
//
//        // Display the chat name (or any other details)
//        TextView chatNameTextView = findViewById(R.id.chatNameTextView);
//        chatNameTextView.setText(chatName);
//    }
//    private void sendMessage() {
//        String messageText = messageInput.getText().toString().trim();
//
//        if (messageText.isEmpty()) {
//            Toast.makeText(this, "Please type a message", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        // Create message object
//        Message message = new Message(messageText);
//
//        // Make API call
//        apiService.sendMessage(message).enqueue(new Callback<Void>() {
//            @Override
//            public void onResponse(Call<Void> call, Response<Void> response) {
//                if (response.isSuccessful()) {
//                    Toast.makeText(ChatDetailActivity.this, "Message sent!", Toast.LENGTH_SHORT).show();
//                    messageInput.setText(""); // Clear the input field
//                } else {
//                    Toast.makeText(ChatDetailActivity.this, "Failed to send message", Toast.LENGTH_SHORT).show();
//                }
//            }
//        };
//    }
//}


//
//
//package My.project;
//
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//
//public class ChatDetailActivity extends AppCompatActivity {
//
//    private ApiService apiService;
//    private EditText messageInput;
//    private Button myImageView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_chat_detail);
//
//        // Initialize API service
//        apiService = ApiClient.getClient().create(ApiService.class);
//
//        // Get references to UI components
//        messageInput = findViewById(R.id.messageInput);
//        ImageView myImageView = findViewById(R.id.sendButton);  // Correct cast if it's an ImageView
////        sendButton = findViewById(R.id.sendButton);
//
//        // Send message on button click
//        myImageView.setOnClickListener(v -> sendMessage());
//    }
//
//    private void sendMessage() {
//        String messageText = messageInput.getText().toString().trim();
//
//        if (messageText.isEmpty()) {
//            Toast.makeText(this, "Please type a message", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        // Create message object
//        Message message = new Message(messageText);
//
//        // Make API call
//        apiService.sendMessage(message).enqueue(new Callback<Void>() {
//            @Override
//            public void onResponse(Call<Void> call, Response<Void> response) {
//                if (response.isSuccessful()) {
//                    Toast.makeText(ChatDetailActivity.this, "Message sent!", Toast.LENGTH_SHORT).show();
//                    messageInput.setText(""); // Clear the input field
//                } else {
//                    Toast.makeText(ChatDetailActivity.this, "Failed to send message", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Void> call, Throwable t) {
//                Toast.makeText(ChatDetailActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}

package My.project;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class ChatDetailActivity extends AppCompatActivity {

    private RecyclerView chatRecyclerView;
    private ChatHistoryAdapter chatHistoryAdapter;
    private List<Message> messageList;
    private String chatName;
    private EditText messageInput;
    private ImageView sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_detail);

        // Get the chat name passed from the previous activity
        chatName = getIntent().getStringExtra("chatName");


        // Initialize the RecyclerView
        chatRecyclerView = findViewById(R.id.chatRecyclerView);
        chatRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        chatHistoryAdapter = new ChatHistoryAdapter(messageList);
        chatRecyclerView.setAdapter(chatHistoryAdapter);

        // Initialize message input and send button
        messageInput = findViewById(R.id.messageInput);
        sendButton = findViewById(R.id.sendButton);

        // Fetch chat history
        fetchChatHistory();

        // Send message on button click
        sendButton.setOnClickListener(v -> sendMessage());
    }

    // Modify the fetchChatHistory() method
    private void fetchChatHistory() {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<List<Message>> call = apiService.getMessages(chatName);  // Pass chatName in the request
        call.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    messageList = response.body();
                    chatHistoryAdapter.updateMessages(messageList); // Update the RecyclerView
                }
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                // Handle failure
            }
        });
    }

    public void sendMessage() {
        String messageText = messageInput.getText().toString().trim();
        if (!messageText.isEmpty()) {
            Message message = new Message(messageText, chatName);  // Pass chatName

            // Set up Retrofit for the POST request
            ApiService apiService = ApiClient.getClient().create(ApiService.class);

            // Ensure the correct headers are set, e.g., Content-Type: application/json
            Call<Void> call = apiService.sendMessage(message);

            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {
                        messageInput.setText("");
                        fetchChatHistory();  // Refresh the chat history after sending a message
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    // Handle failure
                }
            });
        }
    }
}