package com.example.library

import org.springframework.web.bind.annotation.*
import javax.persistence.Id

@RestController
class BookController (private val bookService: BookService){

    @PostMapping("/add")
    fun addNewBook(@RequestParam book: Book):String{
        bookService.save(book)
        return "Saved"
    }

    @GetMapping("/find_all")
    fun findAllList()=bookService.findAll()

    @GetMapping("/find_id")
    fun findListById(@PathVariable id: Int)=bookService.findById(id)

    @PostMapping("/update")
    fun updateBook(@RequestParam id: Int,bookName:String,author: String,attribute: String):String{
        bookService.save(Book(id, bookName, author, attribute))
        return "Updated"
    }

    @PostMapping("/delete")
    fun deleteBook(@RequestParam id: Int):String{
        if (bookService.existsById(id)==true) {
            bookService.deleteById(id)
            return "Deleted"
        }else
            return "No Book"
    }

    @GetMapping("/find_author")
    fun findListByAuthor(@PathVariable author: String)=bookService.findByAuthor(author)

    @GetMapping("/find_bookname")
    fun findListByBookName(@PathVariable bookName: String)=bookService.findByBookName(bookName)
}