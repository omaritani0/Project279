//package My.project;
//
//public class ChatItem {
//    private String name;
//    private String lastMessage;
//    private int profileImage;
//
//    public ChatItem(String name, String lastMessage, int profileImage) {
//        this.name = name;
//        this.lastMessage = lastMessage;
//        this.profileImage = profileImage;
//    }
//
//    public String getName() { return name; }
//    public String getLastMessage() { return lastMessage; }
//    public int getProfileImage() { return profileImage; }
//}
package My.project;
public class ChatItem {
    private String name; // Name of the sender or chat
    private String lastMessage; // Last message
    private int profileImage; // Profile image resource

    // Constructor to initialize the fields
    public ChatItem(String name, int profileImage) {
        this.name = name;
        this.lastMessage = lastMessage;
        this.profileImage = profileImage;
    }

    // Getter for name (chat or sender name)
    public String getName() {
        return name;
    }

    // Getter for last message
    public String getLastMessage() {
        return lastMessage;
    }

    // Getter for profile image
    public int getProfileImage() {
        return profileImage;
    }
}

