package com.lynas.crud

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@SpringBootApplication
class CrudApplication

fun main(args: Array<String>) {
    SpringApplication.run(CrudApplication::class.java, *args)
}

@Entity
data class Book(
        @Id @GeneratedValue
        var id: Long? = null,
        @Column(nullable = false)
        var name: String
)

interface BookRepository : JpaRepository<Book,Long>

@Controller
class HomeController(val bookRepository: BookRepository) {

    @RequestMapping("/")
    fun home(model: Model): String {
        model.addAttribute("book", Book(name = ""))
        val bookList = bookRepository.findAll()
        model.addAttribute("bookList", bookList)

        return "home"
    }

    @PostMapping("/book")
    fun createBook(@ModelAttribute book: Book): String {
        bookRepository.save(book)
        return "redirect:/"
    }
}