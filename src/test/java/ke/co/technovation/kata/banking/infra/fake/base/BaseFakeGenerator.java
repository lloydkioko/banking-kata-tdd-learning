package ke.co.technovation.kata.banking.infra.fake.base;

import ke.co.technovation.kata.banking.core.domain.generators.Generator;
import ke.co.technovation.kata.banking.infra.fake.exceptions.FakeException;
import ke.co.technovation.kata.banking.infra.fake.exceptions.FakeMessages;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public abstract class BaseFakeGenerator<T> implements Generator<T> {
    private Queue<String> queue;

    public BaseFakeGenerator() {
        this.queue = new ArrayDeque<>();
    }

    @Override
    public T next() {
        if(queue.isEmpty()) {
            throw new FakeException(FakeMessages.GENERATOR_DOES_NOT_HAVE_NEXT);
        }
        return (T)queue.remove();
    }

    public void add(String... values) {
        Arrays.stream(values).forEach(e -> queue.add(e));
    }
}
