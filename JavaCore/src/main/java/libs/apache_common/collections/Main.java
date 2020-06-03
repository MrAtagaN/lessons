package libs.apache_common.collections;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Customer customer1 = new Customer(1, "Daniel", new Address("locality1", "city1"));
        Customer customer2 = new Customer(2, "Fredrik", new Address("locality2", "city2"));
        Customer customer3 = new Customer(3, "Kyle", new Address("locality3", "city3"));
        Customer customer4 = new Customer(4, "Bob", new Address("locality4", "city4"));
        Customer customer5 = new Customer(5, "Cat", new Address("locality5", "city5"));
        Customer customer6 = new Customer(6, "John", new Address("locality6", "city6"));

        List<Customer> list1 = Arrays.asList(customer1, customer2, customer3);
        List<Customer> list2 = Arrays.asList(customer4, customer5, customer6);
        List<Customer> list3 = Arrays.asList(customer1, customer2);

        List<Customer> linkedList1 = new LinkedList<>(list1);


        CollectionUtils.addIgnoreNull(list1, null);
        Collection<Customer> result = CollectionUtils.subtract(list1, list3);


    }
}
