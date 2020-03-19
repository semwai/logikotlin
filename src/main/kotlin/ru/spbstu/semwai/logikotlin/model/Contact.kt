package ru.spbstu.semwai.logikotlin.model

import ru.spbstu.semwai.logikotlin.model.Contact.Value.*

/***
 * Класс контакта. Это либо вход, либо выход. Имеет 2 состояния - 1 и 0.
 * При изменении значения он должен каскадно вызывать перерасчет значения в элементы дальше. т.е. используется
 * функция обратного вызова.
 *
 * @device - устройство, к которому идет *выход*
 */
open class Contact {
    enum class Value(val value: Int) {
        High(1),
        Low(0);

    }

    //значение контакта
    var signal = Low
        set(value) {
            field = value
            to?.recalc()
        }

    //устройство, к которому подлкючен данный контакт
    var to: LogicElement? = null




    override fun toString(): String {
        return signal.toString()
    }
}



