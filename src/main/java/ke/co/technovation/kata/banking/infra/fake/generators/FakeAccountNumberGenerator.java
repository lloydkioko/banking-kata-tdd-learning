package ke.co.technovation.kata.banking.infra.fake.generators;

import ke.co.technovation.kata.banking.core.domain.generators.AccountNumberGenerator;
import ke.co.technovation.kata.banking.infra.fake.exceptions.FakeException;
import ke.co.technovation.kata.banking.infra.fake.exceptions.FakeMessages;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class FakeAccountNumberGenerator extends BaseFakeGenerator<String> implements AccountNumberGenerator {

}