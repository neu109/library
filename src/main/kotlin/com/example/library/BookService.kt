package com.example.library

import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository){
    fun findAll()=bookRepository.findAll()

    fun findById(id:Int)=bookRepository.findById(id).orElse(null)

    fun save(book: Book)=bookRepository.save(book)

    fun existsById(id: Int)=bookRepository.existsById(id)

    fun deleteById(id: Int)=bookRepository.deleteById(id)
}