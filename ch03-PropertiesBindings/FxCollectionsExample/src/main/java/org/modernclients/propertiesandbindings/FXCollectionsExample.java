package org.modernclients.propertiesandbindings;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableFloatArray;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Here, we created an observable list, an observable map, an observable set, and an
 * observable array using FXCollections factory methods, attached listeners to them, and
 * manipulated them in some way, including using FXCollections utility methods for the
 * list and ObservableFloatArray methods for the array.
 */
// @formatter:off
public class FXCollectionsExample {
    public static void main(String[] args) {
        // create an observable list, an observable map, an observable set, and an
        // observable array using FXCollections factory methods
        ObservableList<String> list =           FXCollections.observableArrayList();
        ObservableMap<String, String> map =     FXCollections.observableHashMap();
        ObservableSet<Integer> set =            FXCollections.observableSet();
        ObservableFloatArray array =            FXCollections.observableFloatArray();

        // attach listeners to them
        list.addListener((ListChangeListener<String>) c -> {
            System.out.println("\tlist = " + c.getList());
        });
        map.addListener((MapChangeListener<String, String>) c -> {
            System.out.println("\tmap = " + c.getMap());
        });
        set.addListener((SetChangeListener<Integer>) c -> {
            System.out.println("\tset = " + c.getSet());
        });
        array.addListener((observableArray, sizeChanged, from, to) -> {
            System.out.println("\tarray = " + observableArray);
        });

        // manipulate them
        manipulateList(list);
        manipulateMap(map);
        manipulateSet(set);
        manipulateArray(array);
    }
    private static void manipulateList(ObservableList<String> list) {
        System.out.println("Calling list.addAll(\"Zero\"," + " \"One\", \"Two\", \"Three\"):");
        list.addAll("Zero", "One", "Two", "Three");

        System.out.println("Calling copy(list," + " Arrays.asList(\"Four\", \"Five\")):");
        FXCollections.copy(list, Arrays.asList("Four", "Five"));

        System.out.println("Calling replaceAll(list," + " \"Two\", \"Two_1\"):");
        FXCollections.replaceAll(list, "Two", "Two_1");

        System.out.println("Calling reverse(list):");
        FXCollections.reverse(list);

        System.out.println("Calling rotate(list, 2):");
        FXCollections.rotate(list, 2);

        System.out.println("Calling shuffle(list):");
        FXCollections.shuffle(list);

        System.out.println("Calling shuffle(list," + " new Random(0L)):");
        FXCollections.shuffle(list, new Random(0L));

        System.out.println("Calling sort(list):");
        FXCollections.sort(list);

        System.out.println("Calling sort(list, c)" + " with custom comparator: ");
        FXCollections.sort(list, Comparator.reverseOrder()); // static method
        // lambda
//        FXCollections.sort(list, (lhs, rhs) ->  {
//            return rhs.compareTo(lhs);
//        });
        // anonymous function
//        FXCollections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String lhs, String rhs) {
//// Reverse the order
//                return rhs.compareTo(lhs);
//            }
//        });

        System.out.println("Calling fill(list," + " \"Ten\"): ");
        FXCollections.fill(list, "Ten");
    }
    private static void manipulateMap(ObservableMap<String, String> map) {
        System.out.println("Calling map.put(\"Key\"," + " \"Value\"):");
        map.put("Key", "Value");
    }

    private static void manipulateSet(ObservableSet<Integer> set) {
        System.out.println("Calling set.add(1024):");
        set.add(1024);
    }
    private static void manipulateArray(ObservableFloatArray array) {
        System.out.println("Calling array.addAll(3.14159f," + " 2.71828f):");
        array.addAll(3.14159f, 2.71828f);
    }
}
