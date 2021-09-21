package com.springsecurity.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllerclass 
{
	@GetMapping("/")
	public String Accesofkonnectgen()
	{
		return "It can access all of all emp in konnectgen";
	}
	@GetMapping("/user")
	public String Accesofkonnectgenhruser()
	{
		return "It can access only the hr of konnectgen";
	}
	@GetMapping("/admin")
	public String AccesofkonnectgenItteamAndhrTeam()
	{
		return "It can access only the It and hr team";
	}

}
