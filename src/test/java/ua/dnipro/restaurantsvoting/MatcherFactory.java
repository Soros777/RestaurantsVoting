package ua.dnipro.restaurantsvoting;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MatcherFactory {
    public static <T> Matcher<T> usingIgnoringFieldsComparator(String ... fieldsToIgnoring) {
        return new Matcher<>(fieldsToIgnoring);
    }

    public static class Matcher<T> {
        private final String[] fieldsToIgnoring;

        public Matcher(String[] fieldsToIgnoring) {
            this.fieldsToIgnoring = fieldsToIgnoring;
        }

        public void assertMatch(T actual, T expected) {
            assertThat(actual).usingRecursiveComparison().ignoringFields(fieldsToIgnoring).isEqualTo(expected);
        }

        public void assertMatch(Iterable<T> actual, T ... expected) {
            assertMatch(actual, List.of(expected));
        }

        public void assertMatch(Iterable<T> actual, Iterable<T> expected) {
            assertThat(actual).usingRecursiveFieldByFieldElementComparatorIgnoringFields(fieldsToIgnoring).isEqualTo(expected);
        }
    }
}
