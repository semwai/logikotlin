import junit.framework.Assert.assertEquals
import org.junit.Test
import ru.spbstu.semwai.logikotlin.AndElement
import ru.spbstu.semwai.logikotlin.Contact

class test {
    @Test
    fun first(){
        val a = AndElement()
        a.l().setValue(Contact.Value.High)
        a.r().setValue(Contact.Value.High)
        a.recalc()
        assertEquals(Contact.Value.High, a.output.getValue())
    }
}