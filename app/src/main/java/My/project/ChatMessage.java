package My.project;

public class ChatMessage {
    private String senderName;
    private String messageText;
    private boolean isSentByUser;
    private int imageResourceId; // Optional, if there's an image

    // Constructor for text messages
    public ChatMessage(String senderName, String messageText, boolean isSentByUser) {
        this.senderName = senderName;
        this.messageText = messageText;
        this.isSentByUser = isSentByUser;
        this.imageResourceId = -1; // No image by default
    }

    // Constructor for messages with an image
    public ChatMessage(String senderName, String messageText, boolean isSentByUser, int imageResourceId) {
        this.senderName = senderName;
        this.messageText = messageText;
        this.isSentByUser = isSentByUser;
        this.imageResourceId = imageResourceId;
    }

    // Getters
    public String getSenderName() {
        return senderName;
    }

    public String getMessageText() {
        return messageText;
    }

    public boolean isSentByUser() {
        return isSentByUser;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public boolean hasImage() {
        return imageResourceId != -1;
    }
}
