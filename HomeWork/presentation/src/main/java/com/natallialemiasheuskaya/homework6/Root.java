package com.natallialemiasheuskaya.homework6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by natallialemiasheuskaya on 25.02.2018.
 */

public class Root {

    private String name;
    private String location;
    private List<String> emails;
    private ArrayList<Goods> goods;

    public Root() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public ArrayList<Goods> getGoods() {
        return goods;
    }

    public void setGoods(ArrayList<Goods> goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Root{" + "name='" + name + '\'' + ", location='" + location + '\'' + ", emails=" + emails + ", goods=" + goods + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Root root = (Root) o;

        if (name != null ? !name.equals(root.name) : root.name != null) return false;
        if (location != null ? !location.equals(root.location) : root.location != null)
            return false;
        if (emails != null ? !emails.equals(root.emails) : root.emails != null) return false;
        return goods != null ? goods.equals(root.goods) : root.goods == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (emails != null ? emails.hashCode() : 0);
        result = 31 * result + (goods != null ? goods.hashCode() : 0);
        return result;
    }

    public void print(){
        System.out.println("Название магазина: "+name+" находится в городе "+location+". По всем вопросам вы можете обращаться по emails:\n"+emails.toString());
    }
}
