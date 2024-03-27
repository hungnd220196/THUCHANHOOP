package ra.run;

import ra.entity.Categories;
import ra.entity.Product;

import java.util.Arrays;
import java.util.Scanner;

public class ShopManagement {
    static Scanner scanner = new Scanner(System.in);
    public static Categories[] arrCategories = new Categories[100];
    static Product[] arrProduct = new Product[100];
    static int countCategory = 0;
    static int countProduct = 0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("******************SHOP MENU*******************\n" +
                    "1. Quản lý danh mục sản phẩm\n" +
                    "2. Quản lý sản phẩm\n" +
                    "3. Thoát\n");
            System.out.println("mời bạn nhập lựa chọn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayCategoryManagement();
                    break;
                case 2:
                    displayProductManagement();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("không hợp lệ, mời nhập lại");
                    break;
            }
        }
    }

    public static void displayCategoryManagement() {
        while (true) {
            System.out.println("********************CATEGORIES MENU***********\n" +
                    "1. Nhập thông tin các danh mục\n" +
                    "2. Hiển thị thông tin các danh mục\n" +
                    "3. Cập nhật thông tin danh mục\n" +
                    "4. Xóa danh mục\n" +
                    "5. Cập nhật trạng thái danh mục\n" +
                    "6. Thoát\n");
            System.out.println("mời bạn nhập lựa chọn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addCategory();
                    break;
                case 2:
                    displayCategory();
                    break;
                case 3:
                    updateCategory();
                    break;
                case 4:
                    deleteCategory();
                    break;
                case 5:
                    updateStatus();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("số không hợp lệ mời nhập lại");
                    break;
            }
        }
    }

    // thêm danh mục
    public static void addCategory() {
        System.out.println("bạn muốn thêm mấy danh mục");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            arrCategories[countCategory] = new Categories();
            arrCategories[countCategory].inputData(scanner, arrCategories);
            countCategory++;
        }
    }

    // in danh mục
    public static void displayCategory() {
        for (int i = 0; i < countCategory; i++) {
            arrCategories[i].displayData();
        }
    }

    // update danh mục
    public static void updateCategory() {
        System.out.println("mời bạn nhập id danh mục muốn update");
        int idEdit = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countCategory; i++) {
            if (arrCategories[i].getCategoryId() == idEdit) {
                System.out.println("thông tin chưa sửa là ");
                arrCategories[i].displayData();

                System.out.println("mời bạn nhập thông tin cần sửa");
                arrCategories[i].inputData(scanner, arrCategories);

                System.out.println("thông tin sau khi sửa là ");
                arrCategories[i].displayData();
            } else {
                System.out.println("không tìm thấy id danh mục cần update");
                break;
            }
        }
    }

    //xóa danh mục
    public static void deleteCategory() {
    }

    //cập nhật trạng thái
    public static void updateStatus() {
    }

    public static void displayProductManagement() {
        while (true) {
            System.out.println("*******************PRODUCT MANAGEMENT*****************\n" +
                    "1. Nhập thông tin các sản phẩm\n" +
                    "2. Hiển thị thông tin các sản phẩm\n" +
                    "3. Sắp xếp các sản phẩm theo giá\n" +
                    "4. Cập nhật thông tin sản phẩm theo mã sản phẩm\n" +
                    "5. Xóa sản phẩm theo mã sản phẩm\n" +
                    "6. Tìm kiếm các sản phẩm theo tên sản phẩm\n" +
                    "7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn\n" +
                    "phím)\n" +
                    "8. Thoát\n");
            System.out.println("mời bạn nhập lựa chọn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    displayProduct();
                    break;
                case 3:
                    sortProductByPrice();
                    break;
                case 4:
                    updateProductById();
                    break;
                case 5:
                    deleteProductById();
                    break;
                case 6:
                    searchProductByName();
                    break;
                case 7:
                    searchProductInRange();
                    break;
                case 8:
                    return;
                default:
                    break;
            }
        }
    }

    private static void searchProductInRange() {
        System.out.println("Nhập khoảng giá bạn muốn tìm kiếm (a – b)");
        System.out.print("Nhập giá thấp nhất (a): ");
        float priceLow = Float.parseFloat(scanner.nextLine());
        System.out.print("Nhập giá cao nhất (b): ");
        float priceHigh = Float.parseFloat(scanner.nextLine());
        boolean foundProduct1 = false;
        for (Product p : arrProduct) {
            if (p != null && p.getPrice() >= priceLow && p.getPrice() <= priceHigh) {
                p.displayData();
                foundProduct1 = true;
            }
        }
        if (!foundProduct1) {
            System.out.println("Không tìm thấy sản phẩm nào trong khoảng giá từ " + priceLow + " đến " + priceHigh);
        }
    }

    private static void searchProductByName() {
        System.out.println("mời bạn nhập tên cần tìm kiếm ");
        String nameSearch = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < countProduct; i++) {
            if (arrProduct[i].getProductName().toLowerCase().contains(nameSearch.toLowerCase())) {
                check = true;
                arrProduct[i].displayData();
                break;
            }
        }
        if (!check) {
            System.out.println("không tìm thấy tên sản phẩm");
        }
    }

    private static void deleteProductById() {
        System.out.println("mời bạn nhập id sp cần delete");
        String idDelete = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < countProduct; i++) {
            if (arrProduct[i].getProductId().equals(idDelete)) {
                check = true;
            }
            for (int j = i; j < countProduct - 1; j++) {
                arrProduct[j] = arrProduct[j + 1];
            }
            countProduct--;
            System.out.println("sp đã xóa thành công");
            break;

        }
        if (!check) {
            System.out.println("không tìm thấy id sp cần xóa " + idDelete);

        }

    }

    private static void updateProductById() {
        System.out.println("mời bạn nhập id sp cần update");
        String idEdit = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < countProduct; i++) {
            if (arrProduct[i].getProductId().equals(idEdit)) {
                check = true;
                System.out.println("thông tin ban đầu sản phẩm");
                arrProduct[i].displayData();
                System.out.println("mời bạn nhập thông tin cần sửa");
                arrProduct[i].inputData(scanner, arrProduct);
                System.out.println("thông tin sau khi sửa");
                arrProduct[i].displayData();
            }
            check = false;
            break;

        }
        System.out.println("không tìm thấy sp có id " + idEdit);
    }

    public static void addProduct() {
        System.out.println("bạn muốn thêm mấy sản phẩm");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            arrProduct[countProduct] = new Product();
            arrProduct[countProduct].inputData(scanner, arrProduct);
            countProduct++;
        }
    }

    private static void displayProduct() {
        for (int i = 0; i < countProduct; i++) {
            arrProduct[i].displayData();
        }
    }

    private static void sortProductByPrice() {
        System.out.println("mảng trước khi sắp xếp ");
        for (int i = 0; i < countProduct; i++) {
            arrProduct[i].displayData();
        }

        for (int i = 0; i < countProduct - 1; i++) {
            for (int j = i + 1; j < countProduct; j++) {
                if (arrProduct[i].getPrice() > (arrProduct[j].getPrice())) {
                    Product temp = arrProduct[i];
                    arrProduct[i] = arrProduct[j];
                    arrProduct[j] = temp;
                }
            }
        }
        System.out.println("Mảng sản phẩm sắp xếp theo giá là: ");
        for (int i = 0; i < countProduct; i++) {
            arrProduct[i].displayData();
        }

    }
}
