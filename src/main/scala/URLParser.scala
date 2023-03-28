package com.knoldus

//URLParser class with string type parameter
class URLParser(val url: String)

//companion object of URLParser with apply and unapply method
object URLParser {
  //Return object of URLParser class
  def apply(url: String) = new URLParser(url)

  //Takes object as an input and return protocol , domain and path encapsulated in option
  def unapply(urlParserObject: URLParser): Option[(String, String, String)] = {
    val urlValue = urlParserObject.url
    urlValue match {
      //Using pattern matching to check if proper url is passed.
      case urlValue if urlValue.contains("http") =>
        val protocol = urlValue.take(urlValue.indexOf(":"))
        val removingProtocol = urlValue.substring(urlValue.indexOf(":") + 3)
        val domain = removingProtocol.take(removingProtocol.indexOf("/"))
        val path = removingProtocol.drop(removingProtocol.indexOf("/") + 1)
        Some(protocol, domain, path)
      case _ => None
    }
  }
}