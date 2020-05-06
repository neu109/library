package com.example.library

import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository,private val searchRepository: SearchRepository){
    fun findAll()=bookRepository.findAll()

    fun findById(id:Int)=bookRepository.findById(id).orElse(null)

    fun save(book: Book)=bookRepository.save(book)

    fun existsById(id: Int)=bookRepository.existsById(id)

    fun deleteById(id: Int)=bookRepository.deleteById(id)

    fun findByAuthor(author:String)=searchRepository.findByAuthor(author)

    fun findByBookName(bookName:String)=searchRepository.findByBookName(bookName)
}