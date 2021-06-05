package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Catalog {

    //Создаём список из книг
    //Название книги Book n, где n - номер итерации цикла
    //Всего зададим 15 книг, по 5 книг в каждом разделе каталога
    public static ArrayList<Book> books = new ArrayList<Book>() {{
        for (int i = 0; i < 15 ; i++) {
            if(i < 5)
                add(new Book("Book" + i, "A" + i));
            if(i >= 5 && i < 10)
                add(new Book("Book" + i, "B" + i));
            if(i >= 10)
                add(new Book("Book" + i, "C" + i));
        }
    }
    };

    //Метод на проверку взята ли книга
    public void checkBook(String name) {
        //Ищем книгу по названию в каталоге
        for(Book t : books) {
            //Если нашли, ставим ста
            if(t.name.equals(name)) {
                //Создаём анонимный класс, объекту которого присваиваем найденную книгу
                Book temp = new Book(name, t.catalogName) {
                    @Override
                    public String toString() {
                        return "isTaken: " + isTaken;
                    }
                };
                //Присваиваем объекту анонимного класса статус найденной книги
                temp.isTaken = t.isTaken;
                //Вызываем переопределённый метод toString() у анонимного класса
                System.out.println(temp);
                return;
            }
        }
        System.out.println(name + " is not taken!");

    }

    //Наш вложенный в класс "Каталог" класс "Книга"
    public static class Book{
        String name;            //Название книги
        String catalogName;     //Название каталога
        boolean isTaken;        //Статус, взял ли кто-то эту книгу
        StringBuilder history;  //История взятий этой книги людьми

        //Конструктор книги
        public Book(String name, String catalogID) {
            this.name = name;
            this.catalogName = catalogID;
            isTaken = false;
            history = new StringBuilder();
        }

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", catalogName='" + catalogName + '\'' +
                    ", isTaken=" + isTaken +
                    ", history=" + history +
                    '}';
        }
    }

    //Метод "Взять книгу из каталога"
    public String takeBook (String reader, String bookName){
        //ищем есть ли свободная книга с указанным названием в каталоге
        //если нашли: делаем записи в каталоге по данной книге о выдаче
        for (Book cur : books){
            if (cur.name.equals(bookName)){
                if (cur.isTaken) continue;              //Если книга взята, идём дальше
                else {
                    cur.isTaken = true;
                    cur.history.append(reader);         //Имя читателя, который взял книгу
                    cur.history.append(" take ");
                    cur.history.append(new Date());     //Дата, когда была взята книга
                    return cur.catalogName;             //Возвращаем каталог, в котором взяли книгу
                }
            }
        }
        return "taken";


    }

    //Метод "Вернуть книгу в каталог"
    public void returnBook (String reader, String bookName){
        //ищем книгу в каталоге,
        //делаем пометки про возврат книги,
        //изменяем статус на то, что книга не взята
        for (Book currentBook: books){
            if (currentBook.name.equals(bookName)){
                if (currentBook.isTaken) {
                    currentBook.isTaken = false;               //Ставим статус "не взята"
                    currentBook.history.append(reader);        //Имя читателя, который взял книгу
                    currentBook.history.append(" return ");
                    currentBook.history.append(new Date());    //Пишем когда вернули книгу
                    return;
                }
                break;
            }
        }

    }


    //Переопределение метода toString
    @Override
    public String toString() {
        StringBuilder catalogLog = new StringBuilder();
        for (Book book : books){
            catalogLog.append(book.name);
            catalogLog.append("\r\n");
            catalogLog.append(book.history);
        }

        return catalogLog.toString();
    }
}
