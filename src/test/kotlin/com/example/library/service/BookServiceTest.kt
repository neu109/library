package com.example.library.service


import com.example.library.BookRepository
import com.example.library.Book
import com.example.library.BookService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class BookServiceTest(@Autowired private val bookService: BookService){
    @MockkBean
    private  lateinit var mockBookRepository: BookRepository

    val test1 = Book(id = 1, bookName = "aa", author = "bb", attribute = "cc")
    val test2 = Book(id = 2, bookName = "aa", author = "bb", attribute = "cc")
    val testItems= listOf(test1,test2)

    @Test
    fun testFindAll(){
        every{mockBookRepository.findAll()} returns testItems
        val expectedTest1 = Book(id = 1, bookName = "aa", author = "bb", attribute = "cc")
        val expectedTest2 = Book(id = 2, bookName = "aa", author = "bb", attribute = "cc")
        val expectedItems = listOf(expectedTest1,expectedTest2)

        Assertions.assertEquals(expectedItems,bookService.findAll())
        verify { mockBookRepository.findAll() }
    }

    @Test
    fun testFindById(){
        every {mockBookRepository.findById(1)} returns Optional.of(test1)
        val expectedTest1 = Book(id = 1, bookName = "aa", author = "bb", attribute = "cc")

        Assertions.assertEquals(expectedTest1,bookService.findById(1))
        verify { mockBookRepository.findById(1) }
    }

    @Test
    fun testFindById_Null(){
        every {mockBookRepository.findById(3)} returns Optional.empty()
        val expectedTest1 = null

        Assertions.assertEquals(expectedTest1,bookService.findById(3))
        verify { mockBookRepository.findById(3) }
    }

    @Test
    fun testSave(){
        every { mockBookRepository.save(Book(id = 3, bookName = "aa", author = "bb", attribute = "cc")) } returns Book(id = 3, bookName = "aa", author = "bb", attribute = "cc")
        val exptectedTest1 = Book(id = 3, bookName = "aa", author = "bb", attribute = "cc")

        Assertions.assertEquals(exptectedTest1,bookService.save(Book(id = 3, bookName = "aa", author = "bb", attribute = "cc")))
        verify { mockBookRepository.save(Book(id = 3, bookName = "aa", author = "bb", attribute = "cc")) }
    }

    @Test
    fun testExistsById(){
        every { mockBookRepository.existsById(1) } returns true
        val exptectedTest1 = true

        Assertions.assertEquals(exptectedTest1,bookService.existsById(1))
        verify { mockBookRepository.existsById(1) }
    }

    @Test
    fun testExistsById_Null(){
        every { mockBookRepository.existsById(3) } returns false
        val exptectedTest1 = false

        Assertions.assertEquals(exptectedTest1,bookService.existsById(3))
        verify { mockBookRepository.existsById(3) }
    }

    @Test
    fun testDeleteById(){
        every { mockBookRepository.deleteById(1) } returns Unit
        val expectedTest1 = Unit

        Assertions.assertEquals(expectedTest1,bookService.deleteById(1))
        verify { mockBookRepository.deleteById(1) }
    }
}