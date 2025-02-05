package org.modernclients.propertiesandbindings;

import javafx.beans.property.*;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;

public class PropertiesExample {
    private static IntegerProperty i1;

    public static void main(String[] args) {
        createProperty();
        addAndRemoveInvalidationListener();
        addAndRemoveChangeListener();
        bindAndUnbindOnePropertyToAnother();
    }

    private static void createProperty() {
        System.out.println();
        i1 = new SimpleIntegerProperty(1024);
        System.out.println("i1 = " + i1);
        System.out.println("i1.get() = " + i1.get());
        System.out.println("i1.getValue() = "
                + i1.getValue());
    }

    /**
     * The Invalidation listener is fired each time the value
     * changes.
     */
    private static void addAndRemoveInvalidationListener() {
        System.out.println();
        final InvalidationListener invalidationListener =
                observable -> {
                    System.out.println(
                            "The observable has been " +
                                    "invalidated: " +
                                    observable + ".");
                };
        i1.addListener(invalidationListener);
        System.out.println("Added invalidation listener.");
        System.out.println("Calling i1.set(2048).");
        i1.set(2048);
        System.out.println("Calling i1.setValue(3072).");
        i1.setValue(3072);
        i1.removeListener(invalidationListener);
        System.out.println("Removed invalidation listener.");
        System.out.println("Calling i1.set(4096).");
        i1.set(4096);
    }

    /**
     * The change listener is fired each time the value changes and
     * the old and new value are available in the listener.
     */
    private static void addAndRemoveChangeListener() {
        System.out.println();
        final ChangeListener<Number> changeListener =
                (observableValue,
                 oldValue,
                 newValue) -> {
                    System.out.println(
                            "The observableValue has " +
                                    "changed: oldValue = " +
                                    oldValue +
                                    ", newValue = " +
                                    newValue);
                };
        i1.addListener(changeListener);
        System.out.println("*******\nAdded change listener.\n*******");
        System.out.println("Calling i1.set(5120).");
        i1.set(5120);
        i1.removeListener(changeListener);
        System.out.println("Removed change listener.");
        System.out.println("Calling i1.set(6144).");
        i1.set(6144);
    }

    private static void bindAndUnbindOnePropertyToAnother() {
        System.out.println();
        IntegerProperty i2 = new SimpleIntegerProperty(0);
        System.out.println("i2.get() = " + i2.get());
        System.out.println("**********\nBinding i2 to i1.\n**********");
        i2.bind(i1);
        System.out.println("i2.get() = " + i2.get());
        System.out.println("Calling i1.set(7168).");
        i1.set(7168);
        System.out.println("i2.get() = " + i2.get());
        System.out.println("Unbinding i2 from i1.");
        i2.unbind();
        System.out.println("i2.get() = " + i2.get());
        System.out.println("Calling i1.set(8192).");
        i1.set(8192);
        System.out.println("i2.get() = " + i2.get());
    }
}