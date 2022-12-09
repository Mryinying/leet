package com.zephyr.leet.special;

public abstract sealed class Subject permits English {

    String name(Object o) {
        return o.toString();
    }

}
