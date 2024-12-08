//package My.project;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.BaseAdapter;
//
//import java.util.List;
//
//public class ChatAdapter extends BaseAdapter {
//
//    private List<ChatItem> chatList;
//    private final Context context;
//    private final OnItemClickListener listener;
//
//    public ChatAdapter(Context context, List<ChatItem> chatList, OnItemClickListener listener) {
//        this.context = context;
//        this.chatList = chatList;
//        this.listener = listener;
//    }
//
//    @Override
//    public int getCount() {
//        return chatList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return chatList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View view;
//        ViewHolder viewHolder;
//
//        if (convertView == null) {
//            // Inflate the layout for each item
//            LayoutInflater inflater = LayoutInflater.from(context);
//            view = inflater.inflate(R.layout.chat_item, parent, false);
//
//            // Create a ViewHolder to store references to the views
//            viewHolder = new ViewHolder();
//            viewHolder.name = view.findViewById(R.id.chatName);
//            viewHolder.lastMessage = view.findViewById(R.id.lastMessage);
//            viewHolder.profileImage = view.findViewById(R.id.profileImage);
//
//            view.setTag(viewHolder);
//        } else {
//            // Reuse the convertView if available
//            view = convertView;
//            viewHolder = (ViewHolder) view.getTag();
//        }
//
//        // Bind data to the views
//        ChatItem chatItem = chatList.get(position);
//        viewHolder.name.setText(chatItem.getName());
//        viewHolder.lastMessage.setText(chatItem.getLastMessage());
//        viewHolder.profileImage.setImageResource(chatItem.getProfileImage());
//
//        // Set click listener for the item
//        view.setOnClickListener(v -> listener.onItemClick(chatItem));
//
//        return view;
//    }
//
//    // ViewHolder pattern to optimize view lookups
//    static class ViewHolder {
//        TextView name;
//        TextView lastMessage;
//        ImageView profileImage;
//    }
//
//    // Listener interface for item clicks
//    public interface OnItemClickListener {
//        void onItemClick(ChatItem chatItem);
//    }
//}
//package My.project;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import androidx.recyclerview.widget.RecyclerView;
//import java.util.List;
//
//public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
//
//    private List<ChatItem> chatList;
//    private final Context context;
//    private final OnItemClickListener listener;
//
//    public ChatAdapter(Context context, List<ChatItem> chatList, OnItemClickListener listener) {
//        this.context = context;
//        this.chatList = chatList;
//        this.listener = listener;
//    }
//
//    @Override
//    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        // Inflate the layout for each item
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View view = inflater.inflate(R.layout.chat_item, parent, false);
//        return new ChatViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(ChatViewHolder holder, int position) {
//        // Bind data to the views
//        ChatItem chatItem = chatList.get(position);
//        holder.name.setText(chatItem.getName());
//        holder.lastMessage.setText(chatItem.getLastMessage());
//        holder.profileImage.setImageResource(chatItem.getProfileImage());
//
//        // Set click listener for the item
//        holder.itemView.setOnClickListener(v -> listener.onItemClick(chatItem));
//    }
//
//    @Override
//    public int getItemCount() {
//        return chatList.size();
//    }
//
//    // ViewHolder class to hold references to the views
//    public static class ChatViewHolder extends RecyclerView.ViewHolder {
//        TextView name;
//        TextView lastMessage;
//        ImageView profileImage;
//
//        public ChatViewHolder(View view) {
//            super(view);
//            name = view.findViewById(R.id.chatName);
//            lastMessage = view.findViewById(R.id.lastMessage);
//            profileImage = view.findViewById(R.id.profileImage);
//        }
//    }
//
//    // Listener interface for item clicks
//    public interface OnItemClickListener {
//        void onItemClick(ChatItem chatItem);
//    }
//}
package My.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    private List<ChatItem> chatList;
    private final Context context;
    private final OnItemClickListener listener;

    public ChatAdapter(Context context, List<ChatItem> chatList, OnItemClickListener listener) {
        this.context = context;
        this.chatList = chatList;
        this.listener = listener;
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.chat_item, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {
        ChatItem chatItem = chatList.get(position);
        holder.name.setText(chatItem.getName());
        holder.lastMessage.setText(chatItem.getLastMessage());
        holder.profileImage.setImageResource(chatItem.getProfileImage());

        holder.itemView.setOnClickListener(v -> listener.onItemClick(chatItem));
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public static class ChatViewHolder extends RecyclerView.ViewHolder {
        TextView name, lastMessage;
        ImageView profileImage;

        public ChatViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.chatName);
            lastMessage = view.findViewById(R.id.lastMessage);
            profileImage = view.findViewById(R.id.profileImage);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(ChatItem chatItem);
    }
}
