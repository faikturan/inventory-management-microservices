package com.faikturan.inventoryservice;

import com.faikturan.inventoryservice.model.Inventory;
import com.faikturan.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryserviceApplication.class, args);
    }

    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            inventoryRepository.save(Inventory.builder()
                    .skuCode("iPhone 13")
                    .quantity(100)
                    .build());

            inventoryRepository.save(Inventory.builder()
                    .skuCode("iPhone 12")
                    .quantity(0)
                    .build());
        };
    }


}
