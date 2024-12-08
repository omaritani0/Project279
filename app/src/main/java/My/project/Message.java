//package My.project;
//
//public class Message {
//    private String message;
//
//    // Constructor
//    public Message(String message) {
//        this.message = message;
//    }
//
//    // Getter and setter methods
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//}
package My.project;


public class Message {
    private String message;
    private String chatName;

    // Constructor
    public Message(String message, String chatName) {
        this.message = message;
        this.chatName = chatName;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }
}
