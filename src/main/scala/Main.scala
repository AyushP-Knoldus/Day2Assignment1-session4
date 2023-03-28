package com.knoldus

//Main class which displays protocol , domain and path when url is passed in URLParser's parameter
//The program contains print statement to display messages to show the working of the code
object Main extends App {
  val url = URLParser("https://www.mywebsite.com/home")
  url match {
    case URLParser(protocol, domain, path) => println(s"Protocol: $protocol \nDomain: $domain \nPath: $path")
    case _ => println("No valid link found")
  }
}

