package com.learningSpring.inventory_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.learningSpring.inventory_service.dto.InventoryResponseDto;
import com.learningSpring.inventory_service.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

	private final InventoryService inventoryService;

	//"http://localhost:8082/api/inventory/iphone_13,iphone_14" -if it is path variable so instead of this approach we are going for requestparam
	//"http://localhost:8082/api/inventory?skuCode=iphone_13&skuCode=iphone_14" - by using RequestParam req is build like this

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<InventoryResponseDto> isInStock(@RequestParam("skuCode") List<String> skuCode) throws InterruptedException {

		return inventoryService.isInStock(skuCode);

	}

}
