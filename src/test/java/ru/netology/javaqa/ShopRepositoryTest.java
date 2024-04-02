package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveById() {
        Product productOne = new Product(365, "Смартфон", 63_000);
        Product productTwo = new Product(1_534, "Планшет", 33_000);
        Product productThree = new Product(435, "Защитное стекло", 350);
        Product productFour = new Product(667, "LEGO Мстители", 99_999);
        ShopRepository shop = new ShopRepository();
        shop.add(productOne);
        shop.add(productTwo);
        shop.add(productThree);
        shop.add(productFour);
        shop.removeByID(1_534);
        Product[] expected = {productOne, productThree, productFour};
        Product[] actual = shop.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldBeDeletedByNonExistentId() {
        Product productOne = new Product(365, "Смартфон", 63_000);
        Product productTwo = new Product(1_534, "Планшет", 33_000);
        Product productThree = new Product(435, "Защитное стекло", 350);
        Product productFour = new Product(667, "LEGO Мстители", 99_999);
        ShopRepository shop = new ShopRepository();
        shop.add(productOne);
        shop.add(productTwo);
        shop.add(productThree);
        shop.add(productFour);
        Assertions.assertThrows(NotFoundException.class, () -> {
            shop.removeByID(11_111);
        });
    }
}