package demo.povarnicin.firstapp;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String password;
    private String name;
    private String surname;
    private String email;
    private int imageView;

    public User() {
    }

    public User(int id, String password, String name, String surname, String email, int imageView) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.imageView = imageView;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }

}
