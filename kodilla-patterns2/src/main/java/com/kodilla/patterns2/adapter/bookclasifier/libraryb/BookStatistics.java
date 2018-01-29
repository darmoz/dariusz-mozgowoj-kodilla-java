package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

import java.util.Map;

public interface BookStatistics {
    int averagePublicationYear(Map<Signature, Book> books);
    int medianPublicationYear(Map<Signature, Book> books);
}
