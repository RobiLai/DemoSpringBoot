package com.demo.info;

import java.util.HashMap;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class ClienteInfoContributor implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		
		HashMap<String, Integer> clientiMap = new HashMap<>();
		clientiMap.put("Numero Clienti", 2);
		
		builder.withDetail("DemoCloudInfoClients", clientiMap);
		
	}

}
