package com.natallialemiasheuskaya.presentation.sreens.homework6;

import java.util.Date;

/**
 * Created by natallialemiasheuskaya on 25.02.2018.
 */

public class Goods {


    private int id;
    private String name;
    private String description;
    private Date year;
    private int price;
    private boolean visible;

    public Goods() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "Goods{" + "id=" + (id+1) + ", name='" + name + '\'' + ", description='" + description + '\'' + ", year=" + year + ", price=" + price + ", visible=" + visible + '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (id != goods.id) return false;
        if (price != goods.price) return false;
        if (visible != goods.visible) return false;
        if (name != null ? !name.equals(goods.name) : goods.name != null) return false;
        if (description != null ? !description.equals(goods.description) : goods.description != null)
            return false;
        return year != null ? year.equals(goods.year) : goods.year == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (visible ? 1 : 0);
        return result;
    }

    public void printGoods(){
        System.out.println ("Товар "+(id+1)+" : "+name+". Дата создания: "+year
                +" Стоимостью "+price+" р. "+" Описание товара :  "+description);

    }


}
