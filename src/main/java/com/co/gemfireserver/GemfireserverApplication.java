package com.co.gemfireserver;

import com.co.gemfireserver.hello.Person;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.config.annotation.*;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@SpringBootApplication
@CacheServerApplication(logLevel = "info", autoStartup = true, maxConnections = 100)
@EnableCacheServer(name = "Venus", autoStartup = true, hostnameForClients = "localhost", port = 8080)
@EnableEntityDefinedRegions(basePackageClasses = com.co.gemfireserver.hello.Person.class,
        clientRegionShortcut = ClientRegionShortcut.CACHING_PROXY)
@EnableHttpService
@EnableGemfireRepositories
@EnablePdx
public class GemfireserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GemfireserverApplication.class, args);
	}
}

