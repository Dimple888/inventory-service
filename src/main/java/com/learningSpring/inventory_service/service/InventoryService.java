package com.learningSpring.inventory_service.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learningSpring.inventory_service.dto.InventoryResponseDto;
import com.learningSpring.inventory_service.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

	private final InventoryRepository inventoryRepository;

	
	@Transactional(readOnly = true)
	public List<InventoryResponseDto> isInStock(List<String> skuCode) throws InterruptedException {
		
		log.info("wait started");
		Thread.sleep(10000);
		log.info("wait ended");

		return inventoryRepository.findBySkuCodeIn(skuCode).stream()
				.map(inventory ->
					
					InventoryResponseDto.builder()
					.skuCode(inventory.getSkuCode())
					.isInStcok(inventory.getQuantity()>0)
					.build()
				).toList();
	}
}
