package ru.spbstu.semwai.logikotlin.model


/***
 * Какой-то логичесекий элемент
 */
abstract class LogicElement : Element(), Attach, Combine {
    var input = mutableListOf<Contact>()

    var output = SimpleInput()

    /***
     * Когда входной контакт меняет свое значение, он посылает сигнал устройству для перерасчета значения
     */
    override fun recalc() {}

}

