package com.angnein;

/**
 * @package_name: com.angnein
 * @name: User
 * @author: angenin
 * @dateTime: 2020/8/7 10:04 上午
 **/
public class User {

    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
