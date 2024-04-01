package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldAllProductsAdded() {
        Product productOne = new Product(365, "Смартфон", 63_000);
        Product productTwo = new Product(1_534, "Планшет", 33_000);
        Product productThree = new Product(435, "Защитное стекло", 350);
        Product productFour = new Product(667, "LEGO Мстители", 99_999);
        ShopRepository shop = new ShopRepository();
        shop.add(productOne);
        shop.add(productTwo);
        shop.add(productThree);
        shop.add(productFour);
        Product[] expected = {productOne, productTwo, productThree, productFour};
        Product[] actual = shop.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        Product productOne = new Product(365, "Смартфон", 63_000);
        Product productTwo = new Product(1_534, "Планшет", 33_000);
        Product productThree = new Product(435, "Защитное стекло", 350);
        Product productFour = new Product(667, "LEGO Мстители", 99_999);
        ShopRepository shop = new ShopRepository();
        shop.add(productOne);
        shop.add(productTwo);
        shop.add(productThree);
        shop.add(productFour);
        Product[] expected = {productTwo};
        Product[] actual = new Product[]{shop.findById(1_534)};
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
            shop.remove(666);
            shop.remove(6_496);
        });
    }

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
        Product[] expected = {productOne, productThree, productFour};
        Product[] actual = shop.remove(1_534);
        Assertions.assertArrayEquals(expected, actual);
    }
}