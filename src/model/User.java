package model;

import java.util.Objects;

public class User {

    private String name;

    private String phone;

    private Integer discount;


    public User(String name, String phone, Integer discount) {
        this.name = name;
        this.phone = phone;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", discount=" + discount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(discount, user.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, phone, discount);
    }
}
