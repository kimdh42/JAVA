package com.ohgiraffers.section01.list.run;

import com.ohgiraffers.section01.list.comparator.AscendingPrice;
import com.ohgiraffers.section01.list.dto.BookDTO;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Application2 {
    public static void main(String[] args) {

        List<BookDTO> bookList = new ArrayList<>();

        bookList.add(new BookDTO(1, "홍길동전", "허균", 50000));
        bookList.add(new BookDTO(2, "목민심서", "정약용", 30000));
        bookList.add(new BookDTO(3, "동의보감", "허준", 40000));
        bookList.add(new BookDTO(4, "삼국사기", "김부식", 46000 ));
        bookList.add(new BookDTO(5, "삼국유사", "일연", 58000));

        for(BookDTO book : bookList) {
            System.out.println(book);
        }

        bookList.sort(new AscendingPrice());

        System.out.println("===========가격 오름차순 정렬==========");
        for(BookDTO book : bookList) {
            System.out.println(book);
        }

        /* [익명 클래스(Anonymous)]
        * 익명 클래스는 뒤에 {}를 만들어 마치 Comparator 인터페이스를 상속받은 클래스인데
        * 이름이 없다고 생각하고 사용하는 것이다.
        * */

        /* 인터페이스 이기에 바로 인스턴스 생성을 할 수 없다.*/
//        bookList.sort(new Comparator<BookDTO>());

        bookList.sort(new Comparator<BookDTO>() {

            @Override
            public int compare(BookDTO o1, BookDTO o2) {

                return o1.getPrice() >= o2.getPrice()? -1 : 1;
            }
        });

        System.out.println("==========가격 내림차순 정렬==========");
        for(BookDTO book : bookList) {
            System.out.println(book);
        }

        bookList.sort(new Comparator<BookDTO>() {
            @Override
            public int compare(BookDTO o1, BookDTO o2) {

                /*문자열은 대소비교를 할 수 없다.
                * 문자배열로 변경 후 인덱스 하나하나를 비교해서 어느것이 더 큰 값인지 확인해야 하는데
                * String클래스의 CompareTo() 메소드에서 정의해 놓았다.
                *
                * 앞에 값이 더 작은 경우 음수 반환,
                * 같으면 0 반환,
                * 앞에 값이 더 큰 경우 양수반환
                * */
//                return o1.getTitle() < o2.getTitle()? 1 : -1;
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        System.out.println("===========책 제목 오름차순 정렬==========");
        for(BookDTO book : bookList) {
            System.out.println(book);
        }

        /* 람다식을 활용할 수 있다. */
        bookList.sort((BookDTO b1, BookDTO b2) -> b2.getTitle().compareTo(b1.getTitle()));

        System.out.println("===========책 제목 내림차순 정렬==========");
        for(BookDTO book : bookList) {
            System.out.println(book);
        }
    }
}
