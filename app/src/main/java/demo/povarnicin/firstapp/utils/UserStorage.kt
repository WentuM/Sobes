package demo.povarnicin.firstapp.utils

import demo.povarnicin.firstapp.R
import demo.povarnicin.firstapp.data.User
import java.util.*

class UserStorage {
    val arraylist = ArrayList<User>()
    private fun createUser() {
        val id1 = 1
        val id2 = 2
        val id3 = 3
        val user1 = User(
                id1, "12Danil", "Danil", "Povarnicin", "user1@mail.ru", R.drawable.test1)
        val user2 = User(
                id2, "123Anvar", "Anvar", "Hasanov", "user2@mail.ru", R.drawable.test2)
        val user3 = User(
                id3, "1Shamil", "Shamil", "Nurkaev", "user3@mail.ru", R.drawable.test3)
        arraylist.add(user1)
        arraylist.add(user2)
        arraylist.add(user3)
    }

    fun find(id: Int): User? {
        for (i in arraylist.indices) {
            if (arraylist[i].id == id) {
                return arraylist[i]
            }
        }
        return null
    }

    init {
        createUser()
    }
}