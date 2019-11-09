package org.inkreaders.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class IteratorToStream {

    public static <T> Stream<T> getStreamFromIterator(Iterator<T> iterator) {
        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(iterator, 0);
        return StreamSupport.stream(spliterator, false);
    }

    public static void main(String[] args) {

        Iterator<Integer> iterator = Arrays.asList(1, 2, 3, 4, 5).iterator();
        Stream<Integer> stream = getStreamFromIterator(iterator);
        stream.forEach(t -> System.out.println(t));
    }
}
