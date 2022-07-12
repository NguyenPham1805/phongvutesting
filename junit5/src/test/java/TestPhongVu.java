import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class TestPhongVu {

//    KIỂM TRA TRẠNG THÁI CỦA GIẢM GIÁ SẢN PHẨM
    @Test
    public void statusOfSale(){
        Product product = new Product(1, "Chuột máy tính Logitech", 820000, 0, 1);

        PhongVuManage phongVuManage = new PhongVuManage();

        assertTrue("Product price should not discount", phongVuManage.checkProductIsUseSaleCode(product));
    }

//    KIỂM TRA GIÁ KHI ÁP DỤNG GIẢM GIÁ

    @Test
    public void testSale(){
        Product saleOff = new Product(1, "Chuột máy tính Logitech",  820000, 181000, 1);

        assertSame("Price must be discounted",   639000, saleOff.getSale());
    }



//    KIỂM TRA TỔNG TIỀN
    @Test
    public void testSumCart() {
        ArrayList<Product> products = new ArrayList<Product>();

        products.add(new Product(1, "Chuột máy tính Logitech", 820000,  181000, 1));
        products.add(new Product(2, "Bàn Phím Dareu LK145 Gaming đen", 360000,  51000, 1));
        products.add(new Product(3, "Tai nghe Logitech H340", 630000 ,  81000, 1));

        PhongVuManage sub = new PhongVuManage();

        float result = sub.subTotal(products);

        assertSame("Subtotal must be same", 1497000, result);
    }

//    KIỂM TRA SALE CODE
    @Test
    public void testSaleOffCode() {
        PhongVuManage phongVuManage = new PhongVuManage();
        SaleCode saleCode = new SaleCode(1, "Giảm 10%", "lkdnsclkachoiadsb", (float) 0.1);

        ArrayList<Product> products = new ArrayList();

        products.add(new Product(1, "Chuột máy tính Logitech", 820000,  181000, 1));
        products.add(new Product(2, "Bàn Phím Dareu LK145 Gaming đen", 360000,  51000, 1));
        products.add(new Product(3, "Tai nghe Logitech H340", 630000 ,  81000, 1));

        float result = phongVuManage.subTotal(products);

        assertSame("Subtotal must be discounted 10%", 1347300, phongVuManage.subTotalHasSaleCode(saleCode, result));
    }

//    KIỂM TRA MÃ CÓ TỒN TẠI HAY KHÔNG
    @Test
    public void testCheckSaleCode () {
        ArrayList<SaleCode> saleCodes = new ArrayList();

        saleCodes.add(new SaleCode(1, "Giảm giá 10%", "sdlkcdsnkkncsadli", (float) 0.1));
        saleCodes.add(new SaleCode(2, "Giảm giá 20%", "ncaiiowanociwislk", (float) 0.2));
        saleCodes.add(new SaleCode(3, "Giảm giá 30%", "caiwnioevoanncska", (float) 0.3));

        PhongVuManage phongVuManage = new PhongVuManage();

        assertTrue("Sale code must be same", phongVuManage.checkSaleCode(saleCodes, "ncaiiowanociwislk"));
    }

//    KIỂM TRA ĐỊNH DẠNG SỐ ĐIỆN THOẠI
    @Test
    public void testCheckPhoneNumber () {
        PhongVuManage phongVuManage = new PhongVuManage();
        assertTrue("Phone number format must be valid", phongVuManage.checkPhoneNumber("9849712397"));
    }

//    KIỂM TRA ĐỊA CHỈ MẶC ĐỊNH
    @Test
    public void testDefaultAddressMustChecked () {
        PhongVuManage phongVuManage = new PhongVuManage();

        ArrayList<Address> addresses = new ArrayList();

        addresses.add(new Address("HCM", "Tan Phu", "Hiep Tan", "260/10 Phan Anh", true));
        addresses.add(new Address("HCM", "Tan Phu", "Hoa Thanh", "28 Trinh Dinh Thao", false));
        addresses.add(new Address("HCM", "Tan Phu", "Hoa Thanh", "14 Trinh Dinh Thao", false));

        assertTrue("Default Address = true", phongVuManage.checkDefaultAddress(addresses));
    }

//    KIỂM TRA DỮ LIỆU TÌM KIẾM TRẢ VỀ
    @Test public void testSearchFilter(){
        PhongVuManage phongVuManage = new PhongVuManage();

        ArrayList<Product> products = new ArrayList();

        products.add(new Product(1, "Chuột máy tính Logitech", 820000,  181000, 1));
        products.add(new Product(2, "Bàn Phím Dareu LK145 Gaming đen", 360000,  51000, 1));
        products.add(new Product(3, "Tai nghe Logitech H340", 630000 ,  81000, 1));

        ArrayList<Product> productsCheck = new ArrayList();
        productsCheck.add(new Product(1, "Chuột máy tính Logitech", 820000,  181000, 1));
        productsCheck.add(new Product(3, "Tai nghe Logitech H340", 630000 ,  81000, 1));

        System.out.println(productsCheck);

        assertSame("Search result must be equal products available", productsCheck, phongVuManage.searchFilter(products, "Logitech"));
    }



//    CẬP NHẬT TÀI KHOẢN
    @Test
    public void tesValidUserUpdate () {
        PhongVuManage phongVuManage = new PhongVuManage();

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Trung Nguyen", "trungnguyen@email.com", "0987654321", new Date()));
        users.add(new User("Khanh Toan", "khanhtoan@email.com", "1234567890", new Date()));
        users.add(new User("Cong Nghia", "congnghia@email.com", "69696966969", new Date()));

        assertFalse("Profile update must valid", phongVuManage.checkValidUserUpdated(users, new User("Chi Link", "chilink@email.com", "0987654321", new Date())));
    }

    //    KIỂM TRA GIỎ HÀNG ĐANG KHÔNG CÓ SẢN PHẨM
    @Test
    public void testCheckCartIsEmpty () {
        PhongVuManage phongVuManage = new PhongVuManage();

        ArrayList<Product> products = new ArrayList();

        assertEquals( "Message must be shown when cart is empty", "Giỏ hàng chưa có sản phẩm nào",phongVuManage.showMessageWhenCartIsEmpty(products));
    }

    //    TĂNG SỐ LƯỢNG CỦA SẢN PHẨM ĐÃ TỒN TẠI TRONG GIỎ HÀNG
    @Test
    public void testIncreaseExistProduct () {
        PhongVuManage phongVuManage = new PhongVuManage();

        ArrayList<Product> cart = new ArrayList<>();

        cart.add(new Product(1, "Chuột máy tính Logitech", 820000,  181000, 1));
        cart.add(new Product(2, "Bàn Phím Dareu LK145 Gaming đen", 360000,  51000, 1));
        cart.add(new Product(3, "Tai nghe Logitech H340", 630000 ,  81000, 1));



        assertSame("Product count must increase if new proudct already exist", 2, phongVuManage.increaseExistProduct(cart, new Product(3, "Tai nghe Logitech H340", 630000 ,  81000, 1)));
    }
}
