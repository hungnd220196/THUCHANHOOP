package ra.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static ra.run.ShopManagement.arrCategories;


public class Product {
    private String productId;
    private String productName;
    private Float price;
    private String description;
    private Date createdDate;
    private int categoryId;

    public Product() {
    }

    public Product(String productId, String productName, Float price, String description, Date createdDate, int categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.createdDate = createdDate;
        this.categoryId = categoryId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void inputData(Scanner scanner, Product[] arrProduct) {
        this.productId = getInputProductId();
        System.out.println("mời bạn nhập tên sp");
        this.productName = scanner.nextLine();
        // nhập giá
        System.out.println("Nhập giá sản phẩm: ");
        while (true) {
            this.price = Float.parseFloat(scanner.nextLine());
            if (price > 0) {
                break;
            } else {
                System.err.println("Vui lòng nhập lại");
            }
        }
        // nhập description
        System.out.println("Nhập vào mô tả sản phẩm: ");
        while (true) {
            this.description = scanner.nextLine();
            if (this.description.isBlank()) {
                System.err.println("Vui lòng nhập lại");
            } else {
                break;
            }
        }
        System.out.println("mời bạn nhập ngày nhập sp");
        while (true) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                this.createdDate = sdf.parse(scanner.nextLine());
                break;
            } catch (ParseException e) {
                System.err.println("sai định dạng dd/MM/yyyy");
            }
        }
        System.out.println("mời bạn nhập id category");

        this.categoryId = selectCategoryId(scanner, arrCategories);

    }

    public String getInputProductId() {
        String regex = "^([CSA])\\d{3}$";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("nhap ma san pham");
            String productIdInput = scanner.nextLine();
            if (productIdInput.matches(regex)) {
                // kt trùng lặp
                if (!productIdInput.equals(this.productId)) {
                    return productIdInput;
                }
            } else {
                System.err.println("không đúng định dạng");
            }
        }
    }

    private int selectCategoryId(Scanner scanner, Categories[] arrCategories) {
        while (true) {
            
            System.out.println("Chọn danh mục sản phẩm:");
            for (int i = 0; i < arrCategories.length; i++) {
                if (arrCategories[i] != null) {
                    System.out.printf("%d. %s\n", i + 1, arrCategories[i].getCategoryName());
                }
            }
            System.out.print("Nhập số thứ tự của danh mục: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice >= 1 && choice <= arrCategories.length && arrCategories[choice - 1] != null) {
                return arrCategories[choice - 1].getCategoryId();
            } else {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }


    public void displayData() {
        System.out.printf(" | ID: %s |  ProductName:%s | Price: %.2f | description: %s | created: %s | categoryId: %d\n", this.productId, this.productName, this.price, this.description, this.createdDate.toString(), this.categoryId);
    }

}
