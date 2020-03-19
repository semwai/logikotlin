package ru.spbstu.semwai.logikotlin.view

import javafx.stage.Stage
import tornadofx.*


class MyApp : App(MainView::class, Styles::class) {
    init {

    }

    override fun start(stage: Stage) {
        if (parameters.named["hotreload"] == "true") {
            stage.isAlwaysOnTop = true
            reloadViewsOnFocus()
            reloadStylesheetsOnFocus()
        }
        stage.width = 1000.0
        stage.height = 600.0
        super.start(stage)
    }
}

fun main(args: Array<String>) {
    launch<MyApp>(args)


}