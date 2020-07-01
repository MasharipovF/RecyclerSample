package com.example.recyclersample

import kotlin.random.Random

object SampleData {
    private val images = arrayOf(
        R.drawable.a,
        R.drawable.b,
        R.drawable.c,
        R.drawable.d,
        R.drawable.e,
        R.drawable.f,
        R.drawable.g,
        R.drawable.h
    )

    private var dummy_description =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce accumsan quis justo quis hendrerit. Curabitur a ante neque. Fusce nec mauris sodales, auctor sem at, luctus eros. Praesent aliquam nibh neque. Duis ut suscipit justo, id consectetur orci. Curabitur ultricies nunc eu enim dignissim, sed laoreet odio blandit."

    val DATA = ArrayList<Items>()

    init {
        for (i in 0..15) {
            var num = Random.nextInt(8)
            val newItem = Items()
            newItem.id = i
            newItem.image = images[num]
            newItem.description = dummy_description
            newItem.title = "Smile $num"
            DATA.add(newItem)
        }
    }


    fun addItem(): Int {
        var num = Random.nextInt(8)
        var id = DATA.size
        val newItem = Items()
        newItem.id = id
        newItem.image = images[num]
        newItem.description = dummy_description
        newItem.title = "Smile $num"
        DATA.add(newItem)
        return id
    }

    /*fun getItemById(id: Int): Items? {
        for (i in DATA.indices) {
            if (DATA[i].id == id) {
                return DATA[i]
            }
        }
        return null
    }*/

    fun deleteItem(id: Int) {
        DATA.removeAt(id)
    }
}

