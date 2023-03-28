# Day2Assignment1-session4
## URL Parser
Create a URL parser using the concept of Extractors (unapply method) with pattern matching that  
takes the input (URL) as string and displays the protocol, domain name, and path from the given URL.  
A seperate file named as URLParser is created for the test cases.
### Input
“https://www.mywebsite.com/home”

### Output
Protocol: https  
Domain: www.mywebsite.com  
Path: home  

### Code
class URLParser(val url: String)

object URLParser {
 
  def apply(url: String) = new URLParser(url)

  def unapply(urlParserObject: URLParser): Option[(String, String, String)] = {  
    val urlValue = urlParserObject.url  
    urlValue match {  
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

