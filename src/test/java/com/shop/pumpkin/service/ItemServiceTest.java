package com.shop.pumpkin.service;

import com.shop.pumpkin.model.Item;
import com.shop.pumpkin.repository.ItemRepository;
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
class ItemServiceTest {

    @InjectMocks
    private ItemService itemService;

    @Mock
    private ItemRepository itemRepository;

    @ParameterizedTest
    @CsvFileSource(resources = "/com/shop/pumpkin/service/ItemServiceData.csv", numLinesToSkip = 1)
    void save(String name, double wholesalePrice, double retailPrice, int amount, int quantity, double weight) {
        Item item = new Item(name, wholesalePrice, retailPrice, amount, quantity, weight);

        itemService.save(item);

        ArgumentCaptor<Item> captor = ArgumentCaptor.forClass(Item.class);
        verify(itemRepository).save(captor.capture());

        assertThat(captor.getValue().getId()).isEqualTo(item.getId());
        assertThat(captor.getValue().getName()).isEqualTo(item.getName());
        assertThat(captor.getValue().getWholesalePrice()).isEqualTo(item.getWholesalePrice());
        assertThat(captor.getValue().getRetailPrice()).isEqualTo(item.getRetailPrice());
        assertThat(captor.getValue().getAmount()).isEqualTo(item.getAmount());
        assertThat(captor.getValue().getQuantity()).isEqualTo(item.getQuantity());
        assertThat(captor.getValue().getWeight()).isEqualTo(item.getWeight());
        assertThat(captor.getValue().isHasSold()).isEqualTo(item.isHasSold());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/com/shop/pumpkin/service/ItemServiceData.csv", numLinesToSkip = 1)
    void getAll(String name, double wholesalePrice, double retailPrice, int amount, int quantity, double weight) {
        List<Item> item = List.of(new Item(name, wholesalePrice, retailPrice, amount, quantity, weight));

        when(itemRepository.findAll()).thenReturn(item);
        List<Item> resultItem = itemService.getAll();

        assertThat(item).isEqualTo(resultItem);
        verify(itemRepository, times(1)).findAll();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/com/shop/pumpkin/service/ItemServiceData.csv", numLinesToSkip = 1)
    void delete(String name, double wholesalePrice, double retailPrice, int amount, int quantity, double weight) {
        Item item = new Item(name, wholesalePrice, retailPrice, amount, quantity, weight);
        String id = item.getId() + "";

        itemService.delete(id);

        verify(itemRepository, times(1)).deleteById(id);
    }
}