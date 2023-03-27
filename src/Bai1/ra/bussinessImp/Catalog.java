package Bai1.ra.bussinessImp;

import Bai1.ra.bussiness.IShop;

import java.util.List;
import java.util.Scanner;

public class Catalog implements IShop {
   private int catalogId;
   private String catalogName;
   private int priority;
   private String descriptions;
   private Boolean catalogStatus;

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, int priority, String descriptions, Boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.priority = priority;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
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

    @Override
    public void inputData(Scanner scanner, List<Catalog> catalogs) {
        System.out.println("nhập vào catalogName:");
        catalogName = scanner.nextLine();
        System.out.println("nhập độ ưu tiên:");
        priority = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập mô tả danh mục:");
        descriptions = scanner.nextLine();
        System.out.println("nhập trạng thái danh mục");
        catalogStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("mã danh mục: %d\n",catalogId);
        System.out.printf("tên danh mục: %s\n",catalogName);
    }
}
