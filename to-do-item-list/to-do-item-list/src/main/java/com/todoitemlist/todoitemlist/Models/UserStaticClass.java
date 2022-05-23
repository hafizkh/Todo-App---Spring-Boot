package com.todoitemlist.todoitemlist.Models;

public final class UserStaticClass {
    private static long UserId;

    public static long getUserId() {
        return UserId;
    }

    public static void setUserId(long userId) {
        UserId = userId;
    }
}
