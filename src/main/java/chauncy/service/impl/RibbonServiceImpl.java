package chauncy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import chauncy.service.RibbonService;

@Service
public class RibbonServiceImpl implements RibbonService{
	
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="error")
	public String indexLoad(String name) {
		return restTemplate.getForObject("http://SPRINGCLOUD-EUREKACLIENT/client?name="+name, String.class);
	}
	
	public String error(String name){
		return "参数为："+name+"，调用SPRINGCLOUD-EUREKACLIENT失败！";
	}
}
