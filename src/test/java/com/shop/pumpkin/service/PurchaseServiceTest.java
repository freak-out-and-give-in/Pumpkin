package com.shop.pumpkin.service;

import com.shop.pumpkin.model.Purchase;
import com.shop.pumpkin.repository.PurchaseRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PurchaseServiceTest {

    @InjectMocks
    private PurchaseService purchaseService;

    @Mock
    private PurchaseRepository purchaseRepository;

    @ParameterizedTest
    @CsvFileSource(resources = "/com/shop/pumpkin/service/PurchaseServiceData.csv", numLinesToSkip = 1)
    void save(String supplier, double amountPurchased, String time, String date) {
        Purchase purchase = new Purchase(supplier, amountPurchased, time, date);

        purchaseService.save(purchase);

        ArgumentCaptor<Purchase> captor = ArgumentCaptor.forClass(Purchase.class);
        verify(purchaseRepository).save(captor.capture());

        assertThat(captor.getValue().getId()).isEqualTo(purchase.getId());
        assertThat(captor.getValue().getSupplier()).isEqualTo(purchase.getSupplier());
        assertThat(captor.getValue().getAmountPurchased()).isEqualTo(purchase.getAmountPurchased());
        assertThat(captor.getValue().getTime()).isEqualTo(purchase.getTime());
        assertThat(captor.getValue().getDate()).isEqualTo(purchase.getDate());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/com/shop/pumpkin/service/PurchaseServiceData.csv", numLinesToSkip = 1)
    void getAll(String supplier, double amountPurchased, String time, String date) {
        List<Purchase> purchase = List.of(new Purchase(supplier, amountPurchased, time, date));

        when(purchaseRepository.findAll()).thenReturn(purchase);
        List<Purchase> resultPurchase = purchaseService.getAll();

        assertThat(purchase).isEqualTo(resultPurchase);
        verify(purchaseRepository, times(1)).findAll();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/com/shop/pumpkin/service/PurchaseServiceData.csv", numLinesToSkip = 1)
    void delete(String supplier, double amountPurchased, String time, String date) {
        Purchase purchase = new Purchase(supplier, amountPurchased, time, date);
        String id = purchase.getId() + "";

        purchaseService.delete(id);

        verify(purchaseRepository, times(1)).deleteById(id);
    }
}