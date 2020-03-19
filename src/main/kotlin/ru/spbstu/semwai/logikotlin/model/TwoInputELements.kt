package ru.spbstu.semwai.logikotlin.model

import javafx.scene.Group
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.scene.text.Text
import ru.spbstu.semwai.logikotlin.view.TwoInputElementView
import tornadofx.add


abstract class TwoInputElement : LogicElement() {
    var l: Contact
    var r: Contact

    init {
        input.add(Contact())
        input.add(Contact())
        l = input[0]
        r = input[1]

    }
}

class And2Element : TwoInputElement() {
    init {
        l.to = this
        r.to = this


        view = TwoInputElementView("AND")
    }
    override fun recalc() {
        output.value =
            if (l.signal == Contact.Value.High && r.signal == Contact.Value.High)
                Contact.Value.High
            else Contact.Value.Low
    }
}

class Or2Element : TwoInputElement() {
    init {
        l.to = this
        r.to = this

        view = TwoInputElementView("OR")
    }
    override fun recalc() {
        output.value =
            if (l.signal == Contact.Value.High || r.signal == Contact.Value.High)
                Contact.Value.High
            else Contact.Value.Low
    }
}

class Xor2Element : TwoInputElement() {
    init {
        l.to = this
        r.to = this
    }
    override fun recalc() {
        output.value
        if (l.signal == Contact.Value.High && r.signal == Contact.Value.Low ||
            l.signal == Contact.Value.Low && r.signal == Contact.Value.High
        )
            Contact.Value.High else Contact.Value.Low

    }
}

