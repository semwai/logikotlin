package ru.spbstu.semwai.logikotlin

class AndElement : LogicElement() {

    override fun recalc(): Contact.Value {
        println(input.toString())
        for (it in input) {
            if (it.getValue() == Contact.Value.Low)
                return Contact.Value.Low
        }
        return Contact.Value.High
    }
}