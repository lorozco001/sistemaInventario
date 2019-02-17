package dgac.inventario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/")
	@ResponseBody
	public String index(){
		String response = "Bienvenido al API del sistema de control de inventarios de CoNTI";
		return response;
	}
	
}
