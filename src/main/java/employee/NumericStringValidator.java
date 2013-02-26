package employee;

import validation.Message;
import validation.PrimitiveValidator;

public class NumericStringValidator extends PrimitiveValidator<String> {
    @Override
    public Message validate(String numericString, String field) {
        if (!isNumeric(numericString)) {
            return new Message(field, "some.error.string");
        }
        return null;
    }

    public static boolean isNumeric(String str)
    {
        try
        {
            Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}
