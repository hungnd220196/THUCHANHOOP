package ra.entity;

import java.util.Scanner;

public class Categories {

    private int categoryId;
    private String categoryName;
    private String descriptions;
    private Boolean catalogStatus = true;
    static int nextId = 1;

    public Categories() {
        this.categoryId = nextId++;
    }

    public Categories(int categoryId, String categoryName, String descriptions, Boolean catalogStatus) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Boolean getCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(Boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public void inputData(Scanner scanner, Categories[] arrCategories) {
        while (true) {
            System.out.println("mời bạn nhập tên");
            this.categoryName = scanner.nextLine();
            //kt
            if (this.categoryName.isBlank()) {
                System.err.println("vui lòng nhập lại");
            } else {
                break;
            }
        }
        // nhập description
        while (true) {
            System.out.println("mời bạn nhập mô tả");
            this.descriptions = scanner.nextLine();
            // kiểm tra bỏ trống hay không và check trùng lên
            if (this.descriptions.trim().isEmpty()) {
                System.err.println("Vui lòng nhập lại: ");
            } else {
                break;
            }
        }
    }

    public void displayData() {
        System.out.printf(" | ID: %d |  CategoryName:%-10s | Description: %s |  CategoryStatus: %-10s\n", this.categoryId, this.categoryName, this.descriptions, this.catalogStatus ? "Đang hoạt động" : "không hoạt động");

    }
}
