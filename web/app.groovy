@RestController
class Web {
    String color = "blue";
	@RequestMapping('/')
	String h() {		
"<h2 style='background-color:$color; color: white'><p>Keep Calm<br/>And<br/>Push Apps</p>"
    }
}