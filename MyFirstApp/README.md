MyFirstApp is the first Springboot application which will return you a greet message as on when you hit the below service URL.

As part of this application I didn't do any customization like server port or internal db anything. So, application is running on default configurations like port is 8080.

Created only one controller with hello request path. Controller class look like,

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	@GetMapping(path="/hello")
	public String sayHello(){
		return "Hello XYZ.... Welcome to Springboot world.";
	}
}
```
Hit this URL after application started successfully http://localhost:8080/hello

**Output:** Hello XYZ.... Welcome to Springboot world.
