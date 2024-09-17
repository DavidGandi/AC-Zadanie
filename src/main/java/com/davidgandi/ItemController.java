package com.davidgandi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }

    @GetMapping(path = "{id}")
    public Item getItem(@PathVariable("id") Long id) {
        return itemService.getItemById(id);
    }

    @GetMapping
    public List<Item> getItems() {
        return itemService.getAllItems();
    }

    @PutMapping(path = "{id}")
    public void updateItem(@PathVariable("id") Long id, @RequestBody Item item) {
        itemService.updateItem(id, item);
    }

    @DeleteMapping(path = "{id}")
    public void deleteItem(@PathVariable("id") Long id) {
        itemService.deleteItem(id);
    }
}
