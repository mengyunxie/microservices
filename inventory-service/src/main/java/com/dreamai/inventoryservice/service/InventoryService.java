package com.dreamai.inventoryservice.service;

import com.dreamai.inventoryservice.dto.InventoryResponse;
import com.dreamai.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
//    @SneakyThrows // This is test code for resilience4j, do not use in product envirement.
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        // This is test code for resilience4j
        //  log.info("Wait start");
        //  Thread.sleep(10000);
        //  log.info("Wait end");

        return inventoryRepository.findBySkuCodeIn(skuCode)
                .stream().map(inventory ->
                    InventoryResponse.builder()
                            .skuCode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity() > 0)
                            .build()
                ).toList();
    }
}
