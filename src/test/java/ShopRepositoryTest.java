import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.Product;
import ru.netology.javaqa.ShopRepository;
import ru.netology.javaqa.exception.AlreadyExistsException;
import ru.netology.javaqa.exception.NotFoundException;


public class ShopRepositoryTest {

    @Test
    public void shouldRemove() {

        Product product1 = new Product(1, "Печенье", 355);
        Product product2 = new Product(3, "Конфеты", 1_755);
        Product product3 = new Product(13, "Рулет шоколадный", 718);
        Product product4 = new Product(27, "Мармелад", 2_153);
        Product product5 = new Product(5, "Шоколад Бабаевский", 547);

        ShopRepository shop = new ShopRepository();
        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        shop.add(product4);
        shop.add(product5);
        shop.remove(5);

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = shop.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdFromArrayThrowException() throws RuntimeException {
        Product product1 = new Product(1, "Печенье", 355);
        Product product2 = new Product(3, "Конфеты", 1_755);
        Product product3 = new Product(13, "Рулет шоколадный", 718);
        Product product4 = new Product(27, "Мармелад", 2_153);
        Product product5 = new Product(5, "Шоколад Бабаевский", 547);

        ShopRepository shop = new ShopRepository();
        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        shop.add(product4);
        shop.add(product5);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shop.remove(555);
        });
    }

    @Test
    public void shouldSaveToArray() {

        Product product1 = new Product(1, "Печенье", 355);
        Product product2 = new Product(3, "Конфеты", 1_755);
        Product product3 = new Product(13, "Рулет шоколадный", 718);
        Product product4 = new Product(27, "Мармелад", 2_153);
        Product product5 = new Product(5, "Шоколад Бабаевский", 547);

        ShopRepository shop = new ShopRepository();
        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        shop.add(product4);
        shop.add(product5);

        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = shop.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void saveByIdShouldThrowException() {
        Product product1 = new Product(13, "Печенье", 355);
        Product product2 = new Product(3, "Конфеты", 1_755);
        Product product3 = new Product(3, "Рулет шоколадный", 718);

        ShopRepository shop = new ShopRepository();
        shop.add(product1);
        shop.add(product2);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            shop.add(product3);
        });
    }
}