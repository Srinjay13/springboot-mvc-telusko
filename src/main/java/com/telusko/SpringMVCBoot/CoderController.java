package com.telusko.SpringMVCBoot;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.SpringMVCBoot.model.Coder;

@RestController
public class CoderController {
	@Autowired
	CoderRepo repo;
	
	
	//We can use produces tag to restrict whichever formats of data that will be sent from this server side
	@GetMapping(path = "coders", produces = {"application/xml","application/json"})
	@ResponseBody
	//When we say ResponseBody,it will send the data as a data and not a jsp name
	public List<Coder> getCoders() {
		List<Coder> coders = repo.findAll();
		//return coders.toString(); -> If we retun like this it will return as a String and not as a JSON and change the return type of the method as List<Coder>
		return coders;
	}
	@GetMapping("coder/{coderId}")
	@ResponseBody
	public Optional<Coder> getCoder(@PathVariable("coderId") int coderId) {
		Optional<Coder> c = repo.findById(coderId);
		return c;
	}
	//The above method can be done in both the ways 
	/*
	 * @GetMapping("coder/{coderId}")
	 * 
	 * @ResponseBody 
	 * public Coder getCoderById(@PathVariable("coderId") int coderId)
	 * { Coder c = repo.findById(coderId).orElse(new Coder(0,"")); return c; }
	 */
	//We can use consumes tag (reverse of produces to restrict whichever formats of data that will be accepted from this server side
	@PostMapping(path="saveCoder",consumes=MediaType.APPLICATION_JSON_VALUE)
	// When we send data in JSON/XML we need to accept it using @RequestBody tag or else it will only accept using form data
	public Coder saveCoder(Coder c) {
		repo.save(c);
		return c;
	}
}
