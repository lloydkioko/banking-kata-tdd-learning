package ke.co.technovation.kata.banking.core.domain.base;

public interface Generator<T> {
    T next();
}
