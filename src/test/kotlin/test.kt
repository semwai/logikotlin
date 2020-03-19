@file:Suppress("NonAsciiCharacters")

import junit.framework.Assert.assertEquals
import org.junit.Test
import ru.spbstu.semwai.logikotlin.model.*

class Tests {
    @Test
    fun `Элемент И`(){
        val x = SimpleInput(Contact.Value.High)
        val y = SimpleInput(Contact.Value.High)
        val a = And2Element()
        x.bind(a.l)
        y.bind(a.r)
        assertEquals(Contact.Value.High, a.output.value) // 1 1
        x.value = Contact.Value.Low
        assertEquals(Contact.Value.Low, a.output.value) // 0 1
        y.value = Contact.Value.Low
        assertEquals(Contact.Value.Low, a.output.value) // 0 0
        x.value = Contact.Value.High
        assertEquals(Contact.Value.Low, a.output.value) // 1 0
    }
    @Test
    fun `Элемент ИЛИ`(){
        val x = SimpleInput(Contact.Value.High)
        val y = SimpleInput(Contact.Value.High)
        val a = Or2Element()
        x.bind(a.l)
        y.bind(a.r)
        assertEquals(Contact.Value.High, a.output.value) // 1 1
        x.value = Contact.Value.Low
        assertEquals(Contact.Value.High, a.output.value) // 0 1
        y.value = Contact.Value.Low
        assertEquals(Contact.Value.Low, a.output.value) // 0 0
        x.value = Contact.Value.High
        assertEquals(Contact.Value.High, a.output.value) // 1 0
    }
    @Test
    fun `Элемент НЕ`(){
        val x = SimpleInput(Contact.Value.High)
        val a = NotElement()
        x.bind(a.l)
        assertEquals(Contact.Value.Low, a.output.value)
        x.value = Contact.Value.Low
        assertEquals(Contact.Value.High, a.output.value)
    }
    @Test
    fun `Последовательное соединение`(){
        val x = SimpleInput(Contact.Value.High)
        val y = SimpleInput(Contact.Value.Low)
        val z = SimpleInput(Contact.Value.Low)
        val k = SimpleInput(Contact.Value.Low)
        val a = And2Element()
        x.bind(a.l)
        y.bind(a.r)
        val b = And2Element()
        z.bind(b.l)
        k.bind(b.r)
        val c = Or2Element()

        a.output.bind(c.l)
        b.output.bind(c.r)

        val d = NotElement()
        c.output.bind(d.l)
        println("\n\n${c.output.value} ${d.output.value}\n\n")
    }
}