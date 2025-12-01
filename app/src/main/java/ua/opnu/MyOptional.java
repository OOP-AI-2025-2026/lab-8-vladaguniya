package ua.opnu;

public class MyOptional<T> {

    private T value;
    private boolean present;

    // Конструктор без параметрів
    public MyOptional() {
        this.value = null;
        this.present = false;
    }

    // Конструктор з параметром
    public MyOptional(T value) {
        if (value == null) {
            throw new IllegalArgumentException("MyOptional не приймає null");
        }
        this.value = value;
        this.present = true;
    }

    public boolean isPresent() {
        return present;
    }

    public boolean isEmpty() {
        return !present;
    }

    public T get() {
        if (!present) {
            throw new IllegalStateException("Значення відсутнє (empty)");
        }
        return value;
    }

    public T orElse(T defaultValue) {
        if (present) {
            return value;
        }
        return defaultValue;
    }

    @Override
    public String toString() {
        if (present) {
            return "MyOptional[value=" + value + "]";
        } else {
            return "MyOptional[empty]";
        }
    }
}
