package Bai1.ra.bussinessImp;

import Bai1.ra.bussiness.IShop;

import java.util.List;
import java.util.Scanner;

public class Product implements IShop,Comparable<Product> {
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, String title, String descriptions, Catalog catalog, float importPrice, float exportPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData(Scanner scanner, List<Catalog> catalogs) {
        System.out.println("nhập vào tên sản phẩm:");
        productName = scanner.nextLine();
        System.out.println("nhập vào tiêu đề sản phẩm:");
        title = scanner.nextLine();
        System.out.println("nhập mô tả sản phẩm:");
        descriptions = scanner.nextLine();
        System.out.println("chọn danh mục sản phẩm theo mã danh mục:");
        for (Catalog catalog:catalogs) {
            catalog.displayData();
        }
        int idCatalog = Integer.parseInt(scanner.nextLine());
        for (Catalog catalog:catalogs) {
            if (catalog.getCatalogId()==idCatalog){
                this.catalog = catalog;
                break;
            }
        }
        System.out.println("Nhập giá nhập sản phẩm:");
        importPrice = Float.parseFloat(scanner.nextLine());
        exportPrice = importPrice * RATE;
        System.out.println("Nhập trạng thái sản phẩm:");
        productStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.printf("mã sản phẩm: %d\n ",productId);
        System.out.printf("tên sản phẩm: %s\n ",productName);
        System.out.printf("tiêu đề sản phẩm: %s\n ",title);
        System.out.printf("mô tả sản phẩm: %s\n ",descriptions);
        System.out.printf("tên danh mục sản phẩm: %s\n ",catalog.getCatalogName());
        System.out.printf("giá sản phẩm: %s\n ",exportPrice);
        System.out.printf("trạng thái sản phẩm: %s\n ",productStatus?"còn hàng":"hết hàng");
        System.out.println("++++++++++++++++++++++++++++++++++");
    }

    @Override
    public int compareTo(Product o) {
        return (int) (this.exportPrice - o.exportPrice);
    }
}
