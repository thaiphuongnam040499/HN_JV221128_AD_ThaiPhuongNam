package Bai1.ra.run;

import Bai1.ra.bussinessImp.Catalog;
import Bai1.ra.bussinessImp.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    public static void main(String[] args) {
        List<Catalog> catalog = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục");
            System.out.println("2. Nhập số sản phẩm và nhập thông tin các sản phẩm");
            System.out.println("3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator)");
            System.out.println("4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm");
            System.out.println("5. Thoát");
            System.out.println("nhập vào lựa chọn của bạn:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    createCatalog(catalog, scanner);
                    break;
                case 2:
                    createProduct(products,scanner,catalog);
                    break;
                case 3:
                    sortProductByPrice(products);
                    break;
                case 4:
                    searchProduct(products,scanner);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.err.println("không có lựa chọn này");
                    break;
            }
        }while (choice!=5);
    }
    public static void createCatalog(List<Catalog> catalogs,Scanner scanner){
        System.out.println("nhập vào số danh mục");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("nhập danh mục thứ "+(i+1));
            Catalog newCatalog = new Catalog();
            newCatalog.inputData(scanner,catalogs);
            if (catalogs.size()==0){
                newCatalog.setCatalogId(1);
            }else {
                int newCatalogId = catalogs.get(catalogs.size()-1).getCatalogId()+1;
                newCatalog.setCatalogId(newCatalogId);
            }
            catalogs.add(newCatalog);
        }
        System.out.println("thêm mới thành công");
        displayCatalog(catalogs);
    }
    public static void displayCatalog(List<Catalog> catalogs){
        for (Catalog catalog:catalogs) {
            catalog.displayData();
        }
    }
    public static void displayProduct(List<Product> products){
        for (Product product:products) {
            product.displayData();
        }
    }
    public static void createProduct(List<Product> products,Scanner scanner,List<Catalog> catalogs){
        System.out.println("nhập vào số sản phẩm");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("sản phẩm thứ "+(i+1));
            Product newProduct = new Product();
            newProduct.inputData(scanner,catalogs);
            if (products.size()==0){
                newProduct.setProductId(1);
            }else {
                int newProductId = products.get(products.size()-1).getProductId()+1;
                newProduct.setProductId(newProductId);
            }
            products.add(newProduct);
        }
        System.out.println("thêm mới thành công");
        displayProduct(products);
    }
    public static void sortProductByPrice(List<Product> products){
        List<Product> sortProduct = new ArrayList<>(products);
        Collections.sort(sortProduct);
        displayProduct(sortProduct);
    }
    public static void searchProduct(List<Product> products,Scanner scanner){
        Boolean check =false;
        System.out.println("Nhập tên danh mục để tìm kiếm sản phẩm:");
        String search = scanner.nextLine();
        List<Product> listSearch = new ArrayList<>();
        for (Product product:products) {
            if (product.getCatalog().getCatalogName().contains(search)){
                listSearch.add(product);
                check = true;
            }
        }
        if (!check){
            System.out.println("không có danh mục này");
        }else {
            System.out.println("Sản phẩm tìm kiếm là:");
            displayProduct(listSearch);
        }
    }
}
