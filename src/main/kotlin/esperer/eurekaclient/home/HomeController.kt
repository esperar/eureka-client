package esperer.eurekaclient.home

import esperer.eurekaclient.home.dto.ProductDto
import org.springframework.http.HttpMethod
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class HomeController(
    private val restTemplate: RestTemplate
){
    @GetMapping("/")
    fun product(){
        val product = restTemplate.exchange("http://server/",HttpMethod.GET, null, ProductDto::class.java)

        println(product.body!!.name)
        println(product.body!!.price)
    }

}