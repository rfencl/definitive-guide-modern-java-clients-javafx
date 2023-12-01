package org.modernclients.propertiesandbindings;

import javafx.beans.property.*;

/**
 * Well this doesn't work for shit.
 */
public class BidiPropertiesExample {
        public static void main(String[] args) {
            System.out.println("Constructing two StringProperty" +
                    " objects.");
            StringProperty prop1 = new SimpleStringProperty("Hello");
            StringProperty prop2 = new SimpleStringProperty("Goodbye");
            System.out.println("Calling bindBidirectional.");
            System.out.println("Calling prop1.set(\"prop1" +
                    " says: Hi!\")");
            prop1.set("eat shit!");
            System.out.println("prop1 says " + prop1.get());
            System.out.println("prop1 says " + prop1.getValue());
            prop2.bindBidirectional(prop1);
//            prop2.bind(prop1);
            System.out.println("prop1.isBound() = " +
                    prop1.isBound());
            System.out.println("prop2.isBound() = " +
                    prop2.isBound());
            System.out.println("prop2.get() returned:");
            System.out.println(prop2.get());
            System.out.println("Calling prop2.set(prop2.get()" +
                    " + \"\\nprop2 says: Bye!\")");
            prop1.set(prop2.get() + "\nprop2 says: Bye!");
            System.out.println("prop1.get() returned:");
            System.out.println(prop1.get());
        }
    }
