package chauncy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import chauncy.service.RibbonService;

@RestController
@RequestMapping("/ribbon")
public class RibbonController {
	
	@Autowired
	RibbonService ribbonService;
	
	@RequestMapping("/index")
	public String index(@RequestParam String name){
		return ribbonService.indexLoad(name);
	}
}
