package model;

import java.util.Objects;

public class Order{

    private Integer number;

    private Double sum;

    private User user;

    private Long categoryId;

    public Order(Integer number, Double sum, User user, Long categoryId) {
        this.number = number;
        this.sum = sum;
        this.user = user;
        this.categoryId = categoryId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "number=" + number +
                ", sum=" + sum +
                ", user=" + user +
                ", categoryId=" + categoryId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(number, order.number) &&
                Objects.equals(sum, order.sum) &&
                Objects.equals(user, order.user) &&
                Objects.equals(categoryId, order.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, sum, user, categoryId);
    }
}
