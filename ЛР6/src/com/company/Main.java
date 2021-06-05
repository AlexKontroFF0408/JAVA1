package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String str = "";
        String[] subStr;
        String wordsStr = "";
        String[] subWordsStr;

        //Пытаемся считать данные из файла input.txt
        try(FileReader reader = new FileReader("input.txt"))
        {
            int c;
            while((c = reader.read()) != -1){
                str += (char)c;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        //Пытаемся считать данные из файла words.txt
        try(FileReader reader = new FileReader("words.txt"))
        {
            int c;
            while((c = reader.read()) != -1){
                wordsStr += (char)c;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }


        subWordsStr = wordsStr.replaceAll("[^а-яА-Я ]", "").toLowerCase().split("\\s");
        subStr = str.replaceAll("[^а-яА-Я ]", "").toLowerCase().split("\\s");
        System.out.println(Arrays.toString(subStr)); //Выводим слова из файла input.txt
        System.out.println(Arrays.toString(subWordsStr)); //Выводим слова из файла words.txt

        ArrayList<WordContainer> wordContainerList = new ArrayList<>();

        for(int i = 0; i < subWordsStr.length; i++) {
            WordContainer temp = new WordContainer(subWordsStr[i]);
            wordContainerList.add(temp);
        }

        //Сравниваем каждое wordContainerList.word с каждым словом из файла input.txt
        for(int i = 0; i < wordContainerList.size(); i++)
            for(int k = 0; k < subStr.length; k++) {
                if(wordContainerList.get(i).getWord().equals(subStr[k]))
                    wordContainerList.get(i).setCount();
            }
        //Выводим результат в консоль
        for(WordContainer temp : wordContainerList)
            System.out.println(temp);

        try(FileWriter writer = new FileWriter("output.txt", false))
        {
            for(WordContainer temp : wordContainerList)
                writer.write(temp.toString());
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
