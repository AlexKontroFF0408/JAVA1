package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameCreator extends JFrame {
    //Главная панель:
    private final JPanel mainPanel;
    //Таблица с результатом
    private JTable jTable;
    //Панель содержащая таблицу
    private JPanel tablePanel;

    //конструктор
    public FrameCreator() {
        mainPanel = new JPanel();
        tablePanel = new JPanel();
        jTable = new JTable();
        //Устанавливаем параметры
        setProperties();
    }

    public void setProperties() {
        //Размер окна на старте
        setPreferredSize(new Dimension(500, 500));
        //Установить, что при закрытии окна, прога закрывается
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setTopPanel();
        //Метод, устанавливающий параметры для главной панели
        setMainPanel();

        //На Frame добавляем главную панель
        add(mainPanel);
        //Ставим видимость на true
        setVisible(true);
        //"Пересобираем" наш frame
        revalidate();
        //Собираем весь frame
        pack();
    }

    private void setMainPanel() {
        //Фон главной панели
        mainPanel.setBackground(Color.getHSBColor(225f, 0.16f, 0.20f));
        //Способ размещения элементов
        mainPanel.setLayout(new GridBagLayout());
        //Преднастройка для размещения элементов в окне
        GridBagConstraints c = new GridBagConstraints();

        //Надпись с функцией
        JLabel fun = new JLabel("Function: a*x*cos(ax)");
        //Текст белый
        fun.setForeground(Color.WHITE);
        //Текст посередине
        c.fill = GridBagConstraints.CENTER;
        //Ширина п Х
        c.weightx = 0.5;
        //номер квадратика, с помощью GridBagLayout мы можем размещать элементы как в таблице, указывая
        //координаты размещения
        c.gridx = 0;
        c.gridy = 0;
        //Добавляем элемент на глав панель, с примененными настройками размещения, налогично для следующих
        mainPanel.add(fun, c);

        //JTextField - текстовое поле
        JTextField paramA = new JTextField();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        mainPanel.add(paramA, c);

        JLabel a = new JLabel(" a");
        a.setForeground(Color.WHITE);
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        mainPanel.add(a, c);

        JTextField stepX = new JTextField();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.gridx = 3;
        c.gridy = 0;
        mainPanel.add(stepX, c);

        JLabel step = new JLabel(" step");
        step.setForeground(Color.WHITE);
        c.gridx = 4;
        c.gridy = 0;
        mainPanel.add(step, c);

        JTextField dotNumber = new JTextField();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 5;
        c.gridy = 0;
        mainPanel.add(dotNumber, c);

        JLabel count = new JLabel(" count");
        count.setForeground(Color.WHITE);
        c.gridx = 6;
        c.gridy = 0;
        mainPanel.add(count, c);

        //Создаём кнопку
        JButton set = new JButton("Create table");
        c.gridx = 7;
        c.gridy = 0;
        mainPanel.add(set, c);

        int flag = 0;
        //Создаём обработчик событий для кнопки
        //(действие при нажатии на кнопку)
        set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double a = Double.parseDouble(paramA.getText());
                double s = Double.parseDouble(stepX.getText());
                int n = Integer.parseInt(dotNumber.getText());
                double buf = 0;

                //Массив иксов
                String x[] = new String[n + 1];
                x[0] = " X ";
                //Макссив игреков
                String y[] = new String[n + 1];
                y[0] = " Y ";


                //Заполняем вектора данными, этими веторами будет заполнятся таблица
                for(int i = 1; i < n + 1; i++)
                    x[i] = Double.toString(buf+=s);
                for(int i = 1; i < n + 1; i++)
                    y[i] = Double.toString(a * Double.parseDouble(x[i]) *
                            Math.cos(a * Double.parseDouble(x[i])));


                //Создаём модель для нашей таблицы новой
                DefaultTableModel model = new DefaultTableModel();

                //Создаём необходимое кол-во столбцов
                for(String t : x)
                    model.addColumn("");


                //Создаём новую таблицу и записываем туда соответствующие параметры
                jTable = new JTable(model);
                model.addRow(x);
                model.addRow(y);
                jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);


                //Создаём скролинг-панель, в которой будет таблица
                JScrollPane pane = new JScrollPane(jTable);
                pane.setPreferredSize(new Dimension(300,60));
                tablePanel.add(pane);

                //Обновляем на JFrame, чтобы прорисовались новые таблицы
                revalidate();
            }
        });

        //Настройки для размещения
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 8;
        c.gridheight = 8;
        c.gridx = 0;
        c.gridy = 1;

        //Создаём скролинг-панель, в которой будут скролинг-панели с таблицами
        JScrollPane mainPane = new JScrollPane(tablePanel, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        mainPane.setPreferredSize(new Dimension(100,100));

        //Добавляем ее на главную панель
        mainPanel.add(mainPane, c);

    }
}