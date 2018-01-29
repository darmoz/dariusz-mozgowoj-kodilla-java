package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookStatistics;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Signature;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Statistics;

import java.util.Map;

public class MedianAdaptee implements BookStatistics {
    @Override
    public int averagePublicationYear(Map<Signature, Book> books) {
        Statistics statistics = new Statistics();
        return statistics.averagePublicationYear(books);
    }

    @Override
    public int medianPublicationYear(Map<Signature, Book> books) {
        Statistics statistics = new Statistics();
        return statistics.medianPublicationYear(books);
    }
}
