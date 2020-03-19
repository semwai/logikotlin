package ru.spbstu.semwai.logikotlin.view

import javafx.scene.control.TreeItem
import ru.spbstu.semwai.logikotlin.model.And2Element
import ru.spbstu.semwai.logikotlin.model.Element
import ru.spbstu.semwai.logikotlin.model.Or2Element
import tornadofx.*

class MainView : View("Logikotlin") {

    val values = listOf("Alpha","Beta","Gamma","Delta").asObservable()

    val a = Or2Element()

    override val root = borderpane {
        addClass(Styles.main)
        //setMinSize(800.0, 480.0)
        top{
            menubar {
                menu("Файл") {
                    item("Открыть")
                    item("Сохранить")
                    item("Выйти")
                }
            }
        }


        left = vbox {
            addClass(Styles.leftpane)


            //label("Добавить элемент")

            val departments = schema
                .map { it.department }
                .distinct().map { Schema(it, "") }

            treeview<Schema> {

                maxHeight = 300.0
                // Create root item
                root = TreeItem(Schema("Элементы", ""))

                // Make sure the text in each TreeItem is the name of the Person
                cellFormat { text = it.name }

                // Generate items. Children of the root item will contain departments
                populate { parent ->
                    if (parent == root) departments else schema.filter { it.department == parent.value.name }
                }
            }
        }
        center = group {
            addClass(Styles.center)
            useMaxWidth = true
            for (i in 1..3)
                for (j in 1..3)
                    add(Or2Element().view.apply {
                        this.root.translateX = j * 90.0
                        this.root.translateY = i * 90.0
                    })
        }
        right = vbox {
            maxWidth = 150.0
            label("Архив действий")
            listview<String> {

            }
        }
    }
}


data class Schema(val name: String, val department: String, val element: Element = And2Element())

val schema = listOf(
    Schema("1-NOT","Логика"),
    Schema("2-AND","Логика"),
    Schema("2-OR", "Логика"),
    Schema("2-XOR","Логика"),
    Schema("Входной контакт","Ввод/ввывод"),
    Schema("Лампочка","Ввод/ввывод"),
    Schema("Дисплей","Ввод/ввывод"),
    Schema("D-триггер","Память")


)