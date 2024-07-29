package com.learningSpring.inventory_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.learningSpring.inventory_service.model.Inventory;
import com.learningSpring.inventory_service.repository.InventoryRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) { //at the time of starting appn we are creating this bean to load data into db 
		
		return args -> {
			Inventory inventory =  new Inventory();
			inventory.setSkuCode("iphone_13");
			inventory.setQuantity(1);
			
			Inventory inventory1 =  new Inventory();
			inventory1.setSkuCode("iphone_13_red");
			inventory1.setQuantity(0);
			
			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
			
		};
	}

}
