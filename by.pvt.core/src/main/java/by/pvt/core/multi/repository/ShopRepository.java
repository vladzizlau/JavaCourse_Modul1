package by.pvt.core.multi.repository;

import by.pvt.core.multi.domain.ShopCart;
import by.pvt.core.multi.repository.Interface.IShop;

import java.io.*;
import java.util.ArrayList;

public class ShopRepository implements IShop {
    public String pathBase = "D:\\Project Java\\shopCart.txt";
//public String pathBase = "D:\\Development Programs\\JavaProject\\shopCart.txt";

    // Сохраняет товар в файл
    @Override
    public void addOrder(ShopCart shopCart) {
        saveToFile(shopCart);
        // Здесь место под функцию сохранения ордера в базу данных
    }

    @Override
    public void saveToFile(ShopCart shopCart) //сохранение в файл
    {
        ArrayList<ShopCart> newlist = getCartList();
        newlist.add(shopCart);

        try {
            FileOutputStream FOS = new FileOutputStream(pathBase);
            ObjectOutputStream OOS = new ObjectOutputStream(FOS);
            OOS.writeObject(newlist);
            OOS.close();
            FOS.close();
        } catch (Throwable e) {
            System.out.println("addShopCart: " + e.getMessage());
        }
    }
    @Override
    public ArrayList<ShopCart> getCartList() {
        ArrayList<ShopCart> shopC = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(pathBase);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            shopC = (ArrayList<ShopCart>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
        }
        return shopC;
    }

}
