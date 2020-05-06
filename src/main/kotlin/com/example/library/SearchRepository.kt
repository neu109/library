package com.example.library

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SearchRepository : CrudRepository<Book, Int>{
    @Query
    fun findByAuthor(author:String):Iterable<Book>?

    @Query
    fun findByBookName(bookName:String):Iterable<Book>?
}