package ru.spbstu.semwai.logikotlin.view

import javafx.scene.layout.BorderStrokeStyle
import javafx.scene.paint.Color
import javafx.scene.shape.StrokeLineCap
import javafx.scene.shape.StrokeLineJoin
import javafx.scene.shape.StrokeType
import javafx.scene.text.FontWeight
import tornadofx.*
import tornadofx.Stylesheet.Companion.box

class Styles : Stylesheet() {
    companion object {
        // Define our styles
        val main by cssclass()
        val center by cssclass()
        val element by cssclass()
        val leftpane by cssclass()

        // Define our colors
        val dangerColor = c("#a94442")
        val hoverColor = c("#d49942")
    }

    init {
        element {
            backgroundColor += Color.rgb(230,220,200)
            borderColor += box(dangerColor)
            borderStyle += BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.MITER, StrokeLineCap.BUTT, 10.0, 0.0, listOf(25.0, 5.0))
            borderWidth += box(1.px)
        }
        main {
            spacing = 10.px
            fontSize = 15.px
            fontWeight = FontWeight.BOLD
            backgroundColor += Color.rgb(230,220,200)
        }

        leftpane {
            //padding = box(10.px)
            maxWidth = 230.0.px
            borderColor += box(Color.GRAY)
            //borderStyle += BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.MITER, StrokeLineCap.BUTT, 10.0, 0.0, listOf(25.0, 5.0))
            //borderWidth += box(2.px)

        }

        center {
            backgroundColor += Color.rgb(255,255,255)
        }
        /*label {
            fontSize = 15.px
            padding = box(5.px, 10.px)
            maxWidth = infinity

            and(bob, alice) {
                borderColor += box(dangerColor)
                borderStyle += BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.MITER, StrokeLineCap.BUTT, 10.0, 0.0, listOf(25.0, 5.0))
                borderWidth += box(5.px)

                and(hover) {
                    backgroundColor += hoverColor
                }
            }
        }*/
    }
}