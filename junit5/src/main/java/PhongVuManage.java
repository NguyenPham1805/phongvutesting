import java.util.ArrayList;
import java.util.Date;

public class PhongVuManage {
    public float subTotal (ArrayList<Product> products) {
        float sum = 0;

        for (Product product : products) {
            sum += product.getSale();
        }

        return sum;
    }


    public int increaseExistProduct (ArrayList<Product> cart, Product newProduct) {
        for (Product product: cart) {
            if (product.getId() == newProduct.getId()) {
                product.setQuantity(product.getQuantity() + newProduct.getQuantity());
                return product.getQuantity();
            }
        }
        return 0;
    }

    public boolean checkProductIsUseSaleCode (Product product) {
        return product.getPrice() == product.getSale();
    }

    public String  showMessageWhenCartIsEmpty(ArrayList<Product> products) {
        if (products.size() < 1) return "Giỏ hàng chưa có sản phẩm nào";
        return null;
    }

    public float subTotalHasSaleCode (SaleCode saleCode, float subTotal) {
        return subTotal - subTotal * saleCode.getPercent();
    }

    public boolean checkSaleCode (ArrayList<SaleCode> saleCodes, String userCode) {
        for (SaleCode saleCode : saleCodes) {
            if (userCode == saleCode.getCode()) return true;
        }

        return false;
    }

    public boolean checkPhoneNumber (String phoneNumber) {
        if (phoneNumber.length() < 9) return false;
        if (phoneNumber.length() > 11) return  false;
        if (!phoneNumber.matches("^[0-9]*$")) return false;
        return true;
    }

    public boolean checkDefaultAddress (ArrayList<Address> addresses) {
        int sumAddressChecked = 0;
        for (Address address : addresses) {
            if (address.isApply()) sumAddressChecked++;
        }
        if (sumAddressChecked == 1) return true;
        return false;
    }
    public ArrayList<Product> searchFilter(ArrayList<Product> products, String keyword){
        ArrayList<Product> productsSearch = new ArrayList<>();
        for (Product product: products) {
            if(product.getName().toLowerCase().contains(keyword.toLowerCase())) {
                productsSearch.add(product);
            }
        }
        return productsSearch;
    }

    public boolean checkValidUserUpdated (ArrayList<User> users, User userToUpdate) {
        if (!(userToUpdate.getDateOfBirth() instanceof Date)) return false;
        if (!(userToUpdate.getEmail().contains("@"))) return false;
        if (!(checkPhoneNumber(userToUpdate.getPhoneNumber()))) return false;

        for (User user: users) {
            if(user.getEmail().equals(userToUpdate.getEmail())) return false;
            if(user.getPhoneNumber().equals((userToUpdate.getPhoneNumber()))) return false;
        }

        return true;
    }
}
