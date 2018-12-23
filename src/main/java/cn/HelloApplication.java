package cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.solr.SolrRepositoriesAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication//(exclude={SolrRepositoriesAutoConfiguration.class})
@Configuration
@Controller
public class HelloApplication {


	@RequestMapping("/hello")
	@ResponseBody
	public String Hello(){
		return "Hello Application";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SpringApplication.run(HelloApplication.class, args);
	}

}
