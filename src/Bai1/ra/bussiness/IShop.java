package Bai1.ra.bussiness;

import Bai1.ra.bussinessImp.Catalog;

import java.util.List;
import java.util.Scanner;

public interface IShop {
    public static final float RATE = 1.3F;
    void inputData(Scanner scanner, List<Catalog> catalogs);
    void displayData();
}
