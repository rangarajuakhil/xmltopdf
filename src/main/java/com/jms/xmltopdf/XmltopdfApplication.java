package com.jms.xmltopdf;

import com.jms.xmltopdf.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class XmltopdfApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmltopdfApplication.class, args);
	}

}

