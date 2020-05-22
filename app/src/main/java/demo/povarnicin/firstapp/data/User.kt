package demo.povarnicin.firstapp.data

import java.io.Serializable

data class User(
        var id: Int = 0,
        var password: String? = null,
        var name: String? = null,
        var surname: String? = null,
        var email: String? = null,
        var imageView: Int = 0
) : Serializable