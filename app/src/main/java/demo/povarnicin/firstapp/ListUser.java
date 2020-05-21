package demo.povarnicin.firstapp;

import java.util.ArrayList;

public class ListUser {
    private ArrayList<User> arrayList = new ArrayList<>();

    public ListUser() {
        createUser();
    }

    private void createUser() {
        int id1 = 1;
        int id2 = 2;
        int id3 = 3;
        User user1 = new User(
                id1, "1234Da", "Danil", "Povarnicin", "user1@mail.ru", R.drawable.test1);
        User user2 = new User(
                id2, "123Anvar", "Anvar", "Hasanov", "user2@mail.ru", R.drawable.test2);
        User user3 = new User(
                id3, "1Shamil", "Shamil", "Nurkaev", "user3@mail.ru", R.drawable.test3);
        arrayList.add(user1);
        arrayList.add(user2);
        arrayList.add(user3);
    }

    public User find(int id) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getId() == id) {
                return arrayList.get(i);
            }
        }
        return null;
    }

    public ArrayList<User> getArraylist() {
        return arrayList;
    }
}
