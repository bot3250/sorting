package com.bot.sort;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {
    private HashMap< String,Book> books = new HashMap<String,Book>();
    private ArrayList<String> allAuthors = new ArrayList<>();
    TextView outPut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        outPut=findViewById(R.id.output);
        addBook(0, "Анна Каренина", "Лев Толстой");
        addBook(1, "Гордость и предубеждение", "Джейн Остин");
        addBook(2, "Патрик Ленсиони", "Евгений Онегин");
        addBook(3, "Мартин Иден", "Джек Лондон");
        addBook(4, "Братья Карамазовы", "Уилбур Смит");
        addBook(5, "Собор Парижской Богоматери", "Виктор Гюго");
        addBook(6, "Малое собрание сочинений", "Михаил Зощенко");
        addBook(7, "Ромео и Джульетта", "Уильям Шекспир");

        String string = "";
        for (int i=0; i<=allAuthors.size()-1; i++){
            Book book=books.get(allAuthors.get(i));
            string+=book.getId()+" Автор: "+allAuthors.get(i)+" название: "+book.getName()+"\n";
        }
        outPut.setText(string);
    }

    private void addBook(int id, String name, String author){
        Book book = new Book(id, name);
        books.put(author,book);
        allAuthors.add(author);
    }

    public void sortAuthor(View view) {
        Collections.sort(allAuthors);
        String string = "";
        for (int i=0; i<=allAuthors.size()-1; i++){
            Book book=books.get(allAuthors.get(i));
            string+=book.getId()+" Автор: "+allAuthors.get(i)+" название: "+book.getName()+"\n";
        }
        outPut.setText(string);
    }
}