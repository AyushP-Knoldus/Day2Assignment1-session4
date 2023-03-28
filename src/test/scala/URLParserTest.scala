package com.knoldus

class URLParserTest extends org.scalatest.funsuite.AnyFunSuite {
  //Test case to show result when valid url is passed.
  test("unapply method should match with first case if valid url is passed") {
    val url = URLParser("https://www.mywebsite.com/home")
    url match {
      case URLParser(protocol, domain, path) =>
        assert(protocol == "https")
        assert(domain == "www.mywebsite.com")
        assert(path == "home")
      case _ =>
        val result = false
        assert(result)
    }
  }
  //Test case to show result when invalid url is passed.
  test("unapply method should match with second case if invalid url is passed") {
    val url = URLParser("ayush")
    url match {
      case URLParser(protocol, domain, path) =>
        assert(protocol.nonEmpty)
        assert(domain.nonEmpty)
        assert(path.nonEmpty)
      case _ =>
        val result = true
        assert(result)
    }
  }
}
