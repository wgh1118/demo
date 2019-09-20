package com.wanggh.exercise.basic.design.factory;

public class PersonFactory {
    public Person getPerson(String type) {
        if (type == null || type.length() == 0) {
            return null;
        }
        if ("tom".equalsIgnoreCase(type)) {
            return new Tom();
        } else if ("may".equalsIgnoreCase(type)) {
            return new May();
        } else {
            return null;
        }
    }
}
