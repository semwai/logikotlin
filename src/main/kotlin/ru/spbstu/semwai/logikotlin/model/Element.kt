package ru.spbstu.semwai.logikotlin.model

import javafx.scene.Group
import tornadofx.View
import java.lang.Exception


abstract class Element {
    //внешнее представление элемента
    lateinit var view: View
}


class Wire {
    fun setFrom(c: Contact) {}

    fun setTo(c: Contact) {}
}




/***
 * Вход в схему. Предполагается, что контролируется пользователем
 */
class SimpleInput() : Element(), Attach {
    var value = Contact.Value.Low
        set(value) {
            field = value
            to.forEach {
                it.signal = value
                //it.to?.recalc()
            }
        }
    var to: MutableSet<Contact> = mutableSetOf()

    constructor(value: Contact.Value = Contact.Value.Low) : this() {
        this.value = value
    }

    fun bind(to: Contact) {

        this.to.add(to)
        to.signal = value
        to.to?.recalc()
    }

}

/***
 * Присоединение элементов друг к другу. Это может быть присоединение входа SimpleInput к элементу,
 * элемента к элементу и элемента к выходу
 */
interface Attach {
    fun bind(to: Element){
        if (this === to)
            throw Exception("Одинаковые контакты не могут быть соединены")
    }
}

/***
 * Соглашение о том, что элемент изменяет свое состояние в зависимости от входных сигналов
 */
interface Combine {
    fun recalc(){}
}