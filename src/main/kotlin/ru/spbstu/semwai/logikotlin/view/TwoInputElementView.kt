package ru.spbstu.semwai.logikotlin.view

import com.sun.prism.paint.Color
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.shape.Circle
import tornadofx.*

class TwoInputElementView(title: String) : View(title) {


    fun c() = Circle(5.0).apply {
        style {

        }
    }

    override val root = borderpane {
        addClass(Styles.element)
        maxWidth = 60.0
        maxHeight = 60.0
        minWidth = 60.0
        minHeight = 60.0
        style {
            backgroundColor += javafx.scene.paint.Color.rgb(230,220,200)
        }
        left {
            borderpane {
                top {
                    add(c())
                }
                bottom {
                    add(c()) }

            }
        }
        center {
            label(title)
        }
        right {
            vbox {
                alignment = Pos.CENTER
                add(c())
            }
        }
    }
}
