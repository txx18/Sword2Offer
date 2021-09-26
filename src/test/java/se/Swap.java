package se;

import org.junit.Test;

/**
 * @author ShaneTang
 * @create 2021-05-05 22:48
 */
public class Swap {

    static class Book {
        String title;
        String auth;

        @Override
        public String toString() {
            return "Book{" +
                    "title='" + title + '\'' +
                    ", auth='" + auth + '\'' +
                    '}';
        }
    }

    @Test
    public void testSwap() {
        int a = 10;
        int b = 20;
        System.out.println("a = " + a + ", b = " + b);
        swap(a, b);
        System.out.println("a = " + a + ", b = " + b);
    }

    @Test
    public void testClass() {
        Book book = new Book();
        book.title = "Golang";
        book.auth = "tx";
        System.out.println("book = " + book);
        changeField(book);
        System.out.println("book = " + book);
    }

    private void changeField(Book book) {
        book.auth = "zy";
    }

    /**
     * 值传递
     * @param a
     * @param b
     */
    private static void swap(int a, int b) {
        int tmp = a;
        b = a;
        a = tmp;
    }


}
