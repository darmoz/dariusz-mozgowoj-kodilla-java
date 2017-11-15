package prototypeChallenge;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        //given
        Library library = new Library("Library 1");
        IntStream.iterate(1, n-> n+1)
                .limit(5)
                .forEach(n->library.getBooks().add(new Book("title"+n,"author"+n,
                        LocalDate.of(2007-n, 04+n,01+n))));
        //when
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Library 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Library 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);

    }

}
