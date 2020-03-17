package ru.spbstu.semwai.logikotlin


open class Element {



}


abstract class LogicElement : Element() {
    var input = mutableListOf<InputContact>()

    var output = OutputContact()

    /***
     * Когда входной контакт меняет свое значение, он посылает сигнал устройству для перерасчета значения
     */
    abstract fun recalc(): Contact.Value

    init {

        input.add(InputContact())
        input.add(InputContact())
    }

    fun l() = input[0]
    fun r() = input[1]
}

class Wire {
    fun setFrom(c: Contact) {}

    fun setTo(c: Contact) {}
}


/***
 * Класс контакта. Это либо вход, либо выход. Имеет 2 состояния - 1 и 0.
 * При изменении значения он должен каскадно вызывать перерасчет значения в элементы дальше. т.е. используется
 * функция обратного вызова.
 *
 * @device - устройство, к которому идет *выход*
 */
open class Contact {
    enum class Value(val value: Int){
        High(1),
        Low(0);

        fun inverse():Value{
            return if (this.value == 1) Low else High
        }
    }
    //значение контакта
    private var value = Value.Low

    lateinit var from: Element
    lateinit var to: Element

    fun getValue() = value

    open fun setValue(value: Value){
        this.value = value
    }

    override fun toString(): String {
        return value.toString()
    }



}

class OutputContact : Contact() {
    //устройство, к которому нужно подвести данный контакт
    lateinit var device: LogicElement

    override fun setValue(value: Value) {
        super.setValue(value)
        device.recalc()
    }
}

class InputContact : Contact() {

}