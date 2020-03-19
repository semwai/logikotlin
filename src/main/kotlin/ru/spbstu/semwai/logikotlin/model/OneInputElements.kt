package ru.spbstu.semwai.logikotlin.model

abstract class OneInputElement : LogicElement() {
    var l: Contact

    init {
        input.add(Contact())
        l = input[0]
    }
}

class NotElement : OneInputElement() {
    init {
        l.to = this
    }

    override fun recalc() {
        output.value =
            if (output.value == Contact.Value.High) Contact.Value.Low
            else Contact.Value.High
    }
}