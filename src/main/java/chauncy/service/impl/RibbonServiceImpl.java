package chauncy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import chauncy.service.RibbonService;

@Service
public class RibbonServiceImpl implements RibbonService{
	
	@Autowired
	RestTemplate restTemplate;
	
	public String indexLoad(String name) {
		return restTemplate.getForObject("http://SPRINGCLOUD-EUREKACLIENT/client?name="+name, String.class);
	}

}
