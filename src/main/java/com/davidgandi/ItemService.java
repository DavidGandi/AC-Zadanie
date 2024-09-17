package com.davidgandi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item addItem(Item item) {

        item.setCreatedAt(LocalDateTime.now());
        item.setUpdatedAt(LocalDateTime.now());
        return itemRepository.save(item);

    }

    public Item getItemById(Long id) {

        Item item = itemRepository.findById(id);
        if (item == null) {
            throw new IllegalStateException("Item with id " + id + " not found");
        }else {
            return item;
        }
    }
    public List<Item> getAllItems() {

        return itemRepository.findAll();
    }

    public Item updateItem(Long id, Item updatedItem) {

        Item itemToBeUpdated = itemRepository.findById(id);

        if (updatedItem.getName() != null) {
            itemToBeUpdated.setName(updatedItem.getName());
        }
        if (updatedItem.getDescription() != null) {
            itemToBeUpdated.setDescription(updatedItem.getDescription());
        }
        if (updatedItem.getPrice() != null) {
            itemToBeUpdated.setPrice(updatedItem.getPrice());
        }
        if (updatedItem.getQuantity() != null) {
            itemToBeUpdated.setQuantity(updatedItem.getQuantity());
        }
        if (updatedItem.getCreatedAt() != null) {
            itemToBeUpdated.setCreatedAt(updatedItem.getCreatedAt());
        }
        itemToBeUpdated.setUpdatedAt(LocalDateTime.now());

        return itemRepository.save(itemToBeUpdated);
    }

    public void deleteItem(Long id) {

        Item item = itemRepository.findById(id);
        if (item == null) {
            throw new IllegalStateException("Item with id " + id + " not found");
        } else {
            itemRepository.delete(item);
        }
    }
}
