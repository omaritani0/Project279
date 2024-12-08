//package My.project;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.GridLayout;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.TextView;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import java.util.ArrayList;
//import java.util.List;
//
//import My.project.ChatAdapter;
//import My.project.ChatItem;
//import My.project.NewChatActivity;
//
//public class ChatActivity extends AppCompatActivity {
//
//    private RecyclerView recentChatsRecyclerView;
//    private FloatingActionButton newChatButton;
//    private List<ChatItem> pinnedChats;
//    private List<ChatItem> recentChats;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.chat_page);
//
//        // Initialize UI components
//        GridLayout pinnedChatsLayout = findViewById(R.id.pinnedChats);
//        newChatButton = findViewById(R.id.newChatButton);
//
//        // Initialize sample data
//        pinnedChats = createSamplePinnedChats();
//        recentChats = createSampleRecentChats();
//
//        // Setup pinned chats in the GridLayout
//        setupPinnedChats(pinnedChatsLayout, pinnedChats);
//
//        ListView recentChatsListView = findViewById(R.id.recentChatsRecyclerView);
//        ChatAdapter chatAdapter = new ChatAdapter(this, recentChats, this::openChatDetail);
//        recentChatsListView.setAdapter(chatAdapter);
//
//
//
//        // Floating action button to start a new chat
//        newChatButton.setOnClickListener(v -> openNewChat());
//    }
//
//    private List<ChatItem> createSamplePinnedChats() {
//        List<ChatItem> chats = new ArrayList<>();
//        chats.add(new ChatItem("Mike Wazowski", "That's awesome!", R.drawable.profile_placeholder));
//        chats.add(new ChatItem("Darlene Steward", "Pls take a look at the...", R.drawable.profile_placeholder));
//        chats.add(new ChatItem("Gregory Robertson", "Preparing for next vac...", R.drawable.profile_placeholder));
//        chats.add(new ChatItem("Dwight Wilson", "I'd like to watch ...", R.drawable.profile_placeholder));
//        return chats;
//    }
//
//    private List<ChatItem> createSampleRecentChats() {
//        List<ChatItem> chats = new ArrayList<>();
//        chats.add(new ChatItem("Darlene Steward", "Pls take a look at the images", R.drawable.profile_placeholder));
//        chats.add(new ChatItem("Fullsnack Designers", "Hello guys, we have discussed about ...", R.drawable.profile_placeholder));
//        chats.add(new ChatItem("Lee Williamson", "Yes, that’s gonna work, hopefully.", R.drawable.profile_placeholder));
//        chats.add(new ChatItem("Ronald Mccoy", "Catch up soon?", R.drawable.profile_placeholder));
//        return chats;
//    }
//
//    private void setupPinnedChats(GridLayout layout, List<ChatItem> chats) {
//        for (ChatItem chat : chats) {
//            View view = LayoutInflater.from(this).inflate(R.layout.pinned_chat_item, layout, false);
//            ImageView profileImage = view.findViewById(R.id.profileImage);
//            TextView name = view.findViewById(R.id.chatName);
//            TextView lastMessage = view.findViewById(R.id.lastMessage);
//
//            profileImage.setImageResource(chat.getProfileImage());
//            name.setText(chat.getName());
//            lastMessage.setText(chat.getLastMessage());
//
//            view.setOnClickListener(v -> openChatDetail(chat));
//            layout.addView(view);
//        }
//    }
//
//    private void openChatDetail(ChatItem chat) {
//        Intent intent = new Intent(this, ChatDetailActivity.class);
//        intent.putExtra("chatName", chat.getName());
//        startActivity(intent);
//    }
//
//    private void openNewChat() {
//        Intent intent = new Intent(this, NewChatActivity.class);
//        startActivity(intent);
//    }
//}





//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.GridLayout;
//import android.widget.ImageView;
//import android.widget.TextView;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ChatActivity extends AppCompatActivity {
//
//    private RecyclerView recentChatsRecyclerView;
//    private FloatingActionButton newChatButton;
//    private List<ChatItem> pinnedChats;
//    private List<ChatItem> recentChats;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.chat_page);
//
//        // Initialize UI components
//        GridLayout pinnedChatsLayout = findViewById(R.id.pinnedChats);
//        newChatButton = findViewById(R.id.newChatButton);
//
//        // Initialize sample data
//        pinnedChats = createSamplePinnedChats();
//        recentChats = createSampleRecentChats();
//
//        // Setup pinned chats in the GridLayout
//        setupPinnedChats(pinnedChatsLayout, pinnedChats);
//
//        // Setup RecyclerView for recent chats
//        recentChatsRecyclerView = findViewById(R.id.recentChatsRecyclerView);
//        recentChatsRecyclerView.setLayoutManager(new LinearLayoutManager(this)); // Set a LinearLayoutManager
//        ChatAdapter chatAdapter = new ChatAdapter(this, recentChats, this::openChatDetail);
//        recentChatsRecyclerView.setAdapter(chatAdapter);
//
//        // Floating action button to start a new chat
//        newChatButton.setOnClickListener(v -> openNewChat());
//    }
//
//    private List<ChatItem> createSamplePinnedChats() {
//        List<ChatItem> chats = new ArrayList<>();
//        chats.add(new ChatItem("Darlene Steward", R.drawable.profile_placeholder));
//        chats.add(new ChatItem("Lee Williamson", R.drawable.profile_placeholder));
//        chats.add(new ChatItem("Gregory Robertson", R.drawable.profile_placeholder));
//        chats.add(new ChatItem("Dwight Wilson",  R.drawable.profile_placeholder));
//        return chats;
//    }
//
//    private List<ChatItem> createSampleRecentChats() {
//        List<ChatItem> chats = new ArrayList<>();
//        chats.add(new ChatItem("Darlene Steward",  R.drawable.profile_placeholder));
//        chats.add(new ChatItem("Lee Williamson", R.drawable.profile_placeholder));
//        chats.add(new ChatItem("Gregory Robertson",  R.drawable.profile_placeholder));
//        chats.add(new ChatItem("Dwight Wilson", R.drawable.profile_placeholder));
//        return chats;
//    }
//
//    private void setupPinnedChats(GridLayout layout, List<ChatItem> chats) {
//        for (ChatItem chat : chats) {
//            View view = LayoutInflater.from(this).inflate(R.layout.pinned_chat_item, layout, false);
//            ImageView profileImage = view.findViewById(R.id.profileImage);
//            TextView name = view.findViewById(R.id.chatName);
//            TextView lastMessage = view.findViewById(R.id.lastMessage);
//
//            profileImage.setImageResource(chat.getProfileImage());
//            name.setText(chat.getName()); // Use 'getName()' to set the name
//            lastMessage.setText(chat.getLastMessage()); // Use 'getLastMessage()' to set the message
//
//            view.setOnClickListener(v -> openChatDetail(chat));
//            layout.addView(view);
//        }
//    }
//
//
//    private void openChatDetail(ChatItem chat) {
//        Intent intent = new Intent(this, ChatDetailActivity.class);
//        intent.putExtra("chatName", chat.getName());
//        startActivity(intent);
//    }
//
//    private void openNewChat() {
//        Intent intent = new Intent(this, NewChatActivity.class);
//        startActivity(intent);
//    }
//}
//

package My.project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity implements ChatAdapter.OnItemClickListener {

    private RecyclerView recentChatsRecyclerView;
    private ChatAdapter recentChatsAdapter;
    private List<ChatItem> recentChatsList;
    private RecyclerView pinnedChatsRecyclerView;  // Changed from GridLayout to RecyclerView
    private ChatAdapter pinnedChatsAdapter;  // Adapter for pinned chats
    private List<ChatItem> pinnedChatsList;  // List for pinned chat
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_page);

        // Setup Pinned Chats
        pinnedChatsRecyclerView = findViewById(R.id.pinnedChatsRecyclerView);
        pinnedChatsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)); // Horizontal layout for example
        setupPinnedChats();

        // Setup Recent Chats
        recentChatsRecyclerView = findViewById(R.id.recentChatsRecyclerView);
        recentChatsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        setupRecentChats();
    }

    private void setupPinnedChats() {
        pinnedChatsList = new ArrayList<>();
        pinnedChatsList.add(new ChatItem("Olivia Rhye", R.drawable.profile_placeholder));
        pinnedChatsList.add(new ChatItem("Phoenix Baker", R.drawable.profile_placeholder));

        pinnedChatsAdapter = new ChatAdapter(this, pinnedChatsList, this);  // Use the same ChatAdapter for pinned chats
        pinnedChatsRecyclerView.setAdapter(pinnedChatsAdapter);
    }

    private void setupRecentChats() {
        recentChatsList = new ArrayList<>();
        recentChatsList.add(new ChatItem("Lori Bryson", R.drawable.profile_placeholder));
        recentChatsList.add(new ChatItem("Orlando Diggs", R.drawable.profile_placeholder));

        recentChatsAdapter = new ChatAdapter(this, recentChatsList, this);
        recentChatsRecyclerView.setAdapter(recentChatsAdapter);
    }

    @Override
    public void onItemClick(ChatItem chatItem) {
        openChatDetail(chatItem.getName());
    }

    private void openChatDetail(String chatName) {
        Intent intent = new Intent(ChatActivity.this, ChatDetailActivity.class);
        intent.putExtra("chatName", chatName); // Pass chat name to ChatDetailActivity
        startActivity(intent);
    }
}
