package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Set {
    private List<Integer> elements;

    public Set(List<Integer> elements) {
        this.elements = elements;
    }

    public Set(Integer... elements) {
        this(Arrays.asList(elements)); //Преобразуем полученный массив в список List
    }

    public Set crossing(Set other) {
        //Сделаем через потоки
        //Мы сразу же возвращаем новый объект типа Set
        //Которому в конструктор, передаём отсортированные потоком элементы
        return new Set(elements.stream() //Создаём поток, который работает с элементами взятого сета
                .filter(other.elements::contains) //Метод filter фильтрует элементы по условию в скобках
                //Берём передаваемый сет, и с помощью ключевого слова contains
                //оставляем элементы, которые есть во взятом сете и передаваемом
                .collect(Collectors.toList()));   //Преобразуем полученные элементы в список List
        //Таким образом в конструктор возвращаемого сета были переданы общие элементы взятого сета и передаваемого
    }

    //Метод объединения
    public Set union(Set other) {
        //Сделаем через потоки
        //Мы сразу же возвращаем новый объект типа Set
        //Которому в конструктор, передаём отсортированные потоком элементы
        return new Set(Stream.concat(this.elements.stream(), other.elements.stream()) //Поток будет работать с
                //полем elements у взятого сета и передаваемого
                .distinct() //Данный метод удаляет дубликаты, между взятым сетом и передаваемым
                .collect(Collectors.toList())); //Полученный список элементов мы преобразуем в тип данных List
        //Таким образом, мы вернели новый сет со своими элементами
    }

    //Стандыртны1 метод toString
    @Override
    public String toString() {
        return "El = " + elements;
    }
}
