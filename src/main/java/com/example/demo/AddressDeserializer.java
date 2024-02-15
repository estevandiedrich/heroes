package com.example.demo;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;

public class AddressDeserializer extends JsonDeserializer<Address> {
	
	@Override
	public Address deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		JsonNode node = p.getCodec().readTree(p);
		JsonNode idNode = node.findValue("id");
		Integer id = 0;
		if(idNode != null) {
			id = (Integer) ((IntNode) idNode).numberValue();
		}
		String addressStr = node.get("address").asText();
		JsonNode heroNode = node.get("hero");
		Integer heroId = (Integer) ((IntNode)heroNode.get("id")).numberValue();
		Hero hero = new Hero();
		hero.setId(Long.valueOf(heroId));
		Address address = new Address(Long.valueOf(id), addressStr, hero);
		return address;
	}

}
