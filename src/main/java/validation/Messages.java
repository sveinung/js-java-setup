package validation;

import java.util.ArrayList;

public class Messages {

    private final ArrayList<Message> messages;

    public Messages() {
        messages = new ArrayList<Message>();
    }

    public void add(Message message, String field) {
        messages.add(Message.from(message, field));
    }

    public void addAll(Messages messages, String field) {
        for (Message message : messages.getMessages()) {
            add(message, field + "." + message.getField());
        }
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
}
