package validation;

public abstract class PrimitiveValidator<T> {
    public abstract Message validate(T t, String field);
}
