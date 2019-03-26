package hu.me.demo.controller.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FirstParams {

    //@NotNull
    @Min(18)
    int age;

    //@NotNull
    //@NotEmpty
    String name;

    int money;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "FirstParams{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
