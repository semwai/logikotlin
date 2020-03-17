package ru.spbstu.semwai.logikotlin

class OrElement : LogicElement() {

    override fun recalc(): Contact.Value {

        val v = Contact.Value.Low
        for (it in input) {
            if (it.getValue() == Contact.Value.High)
                return Contact.Value.High
        }
        return Contact.Value.Low
    }
}