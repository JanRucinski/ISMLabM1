package io.swagger.service;

import io.swagger.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ItemServiceImplementation implements io.swagger.service.ItemService{
    @Autowired
    private io.swagger.repository.ItemRepository itemRepository;
    @Override
    public void createItem() {
        Item item = new Item();
        itemRepository.save(item);
    }

    @Override
    public void deleteItem() {

    }

    @Override
    public void getItem() {

    }

    @Override
    public void updateItem() {

    }
}
