package validation;

public class Message {
    private String field;
    private String key;
    private String value;
    private MessageType type;

    public Message(String field, String key, String value, MessageType type) {
        this.field = field;
        this.key = key;
        this.value = value;
        this.type = type;
    }

    public String getField() {
        return field;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public MessageType getType() {
        return type;
    }
}
