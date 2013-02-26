package validation;

public class Message {
    private String field;
    private String key;

    public Message(String field, String key) {
        this.field = field;
        this.key = key;
    }

    public String getField() {
        return field;
    }

    public String getKey() {
        return key;
    }

    public static Message from(Message message, String field) {
        return new Message(field, message.getKey());
    }
}
