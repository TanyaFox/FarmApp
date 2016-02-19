package ru.hse.farm; //Сущность объявления

import java.util.List;
import static java.util.Arrays.*;

public class Advertisement {

    public static final List<Advertisement> ADVERTISEMENTS = asList(
            new Advertisement(0, "Морковь свежая", 25.0, "р/кг", 4.0, R.drawable.carrots, "Морковка свежая, " +
                    "только что с огорода, никаких вам ГМО!", 1, "Клавдия", "Захарова"),
            new Advertisement(1, "Молоко коровье", 40.0, "р/л", 5.0, R.drawable.cow, "Молоко коровы Мурки, " +
                    "она у нас не государственная", 2, "Вера", "Иванова"),
            new Advertisement(2, "Свекла", 35.0, "р/кг", 4.5, R.drawable.beet, "Свекла - лучшая в деревне!",
                    1, "Клавдия", "Захарова")
    );

    int advId;
    String name;
    Double price;
    String type_of_price;
    Double rate;
    int photoId;
    String description;
    int salerId;
    String salerName;
    String salerSurname;

    Advertisement(int advId, String name, Double price, String type_of_price, Double rate, int photoId,
        String description, int salerId, String salerName, String salerSurname) {
            this.advId = advId;
            this.name = name;
            this.price = price;
            this.type_of_price = type_of_price;
            this.rate = rate;
            this.photoId = photoId;
            this.description = description;
            this.salerId = salerId;
            this.salerName = salerName;
            this.salerSurname = salerSurname;
        }

    public int getId() {
        return this.advId;
    }
}