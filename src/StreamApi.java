import model.Order;
import model.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {

    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order(1, 20.0, new User("Anna", "345646465", 12), 1L),
                new Order(2, 5.0, new User("Tom", "33599997", 10), 2L),
                new Order(3, 56.0, new User("Mike", "9872132", 12), 2L),
                new Order(4, 12.0, new User("Alex", "46549879", 4), 2L)
        );

        //find all orders with price over 50
        orders.stream()
                .filter(s -> s.getSum() > 50)
                .forEach(System.out::println);

        //calculate average sum of all orders
        System.out.println(orders.stream()
                .mapToDouble(Order::getSum)
                .average()
                .getAsDouble());

        //calculate the sum of all orders
        System.out.println(orders.stream()
                .mapToDouble(Order::getSum)
                .sum());

        //find all user with discount more then 5
        orders.stream()
                .filter(o -> o.getUser().getDiscount() > 5)
                .forEach(System.out::println);

        //find user by name Anna
        orders.stream()
                .filter(o -> o.getUser().getName().equals("Anna"))
                .forEach(System.out::println);

        //get all users
        orders.stream()
                .map(Order::getUser)
                .forEach(System.out::println);

        //groupingBy discount
        System.out.println(orders.stream()
                .map(Order::getUser)
                .collect(Collectors.groupingBy(User::getDiscount)));


        //grouping by categoryId
        Map<Long, List<Order>> byCategory = orders
                .stream()
                .collect(Collectors.groupingBy(Order::getCategoryId));
        byCategory.entrySet().forEach(System.out::println);

        //count the number of orders of each category
        orders.stream()
                .collect(Collectors.groupingBy(Order::getCategoryId, Collectors.counting()))
                .entrySet().forEach(System.out::println);

        //calculate the average order sum for this category
        orders.stream()
                .collect(Collectors.groupingBy(Order::getCategoryId,
                        Collectors.averagingDouble(Order::getSum)))
                .entrySet()
                .forEach(System.out::println);

        // get average of discounts
        System.out.println(orders.stream()
                .mapToInt(d -> d.getUser().getDiscount())
                .average());


        // get integer from string
        Stream.of("1", "2", "3", "4").mapToInt(Integer::parseInt).forEach(System.out::println);

        // count of empty strings with filter()?
        System.out.println(Stream.of("", "", "1", "3")
                .filter(String::isEmpty)
                .count());

        // print 10 random numbers using forEach()?
        (new Random())
                .ints(10)
                .forEach(System.out::println);

        // print unique squares of numbers using map
        Stream.of(1, 2, 3, 4, 1)
                .map(n -> n * n)
                .distinct()
                .forEach(System.out::println);


        // print 10 random numbers sorted in ascending order
        new Random()
                .ints(10)
                .sorted()
                .forEach(System.out::println);

        // find max number in a set
        System.out.println(Stream.of(1, 2, 3, 33, 54, 2, 6, 7)
                .mapToInt(Integer::intValue)
                .max());

        System.out.println(Stream.of(1, 2, 3, 33, 54, 2, 6, 7)
                .max(Comparator.comparing(Integer::valueOf)));

        // get sum of all numbers in a set
        System.out.println(Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .mapToInt(Integer::intValue)
                .sum());

        // get average of all numbers
        System.out.println(Stream.of(1, 12, 3, 4, 5, 6, 7)
                .mapToInt(n -> n)
                .average());

    }

}
