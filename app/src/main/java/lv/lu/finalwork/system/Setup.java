package lv.lu.finalwork.system;

import lv.lu.finalwork.model.Product;
import lv.lu.finalwork.repository.ProductRepository;
import lv.lu.finalwork.ui.Launcher;

import java.io.*;;
import java.util.HashMap;

public class Setup {

    private ProductRepository productRepository;

    public  void startUp() throws IOException, ClassNotFoundException {
        productRepository = populateDbFromFile();

    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public void exit() throws IOException {
        saveDbToFile();
        System.out.println();
        System.out.println("DB saved. Closing application.");
        System.exit(1);
    }


    private ProductRepository populateDbFromFile() throws IOException, ClassNotFoundException {
        try {
            FileInputStream inputStream = new FileInputStream("db.tmp");
            ObjectInputStream objectStream = new ObjectInputStream(inputStream);
            productRepository = (ProductRepository) objectStream.readObject();
            objectStream.close();
            System.out.println("File DB successfully loaded.");
            return productRepository;
        } catch (Exception e) {
            System.out.println("File DB not loaded.");
        }
        return new ProductRepository(new HashMap<>());
    }

    private void saveDbToFile() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("db.tmp", false);
        ObjectOutputStream objectStream = new ObjectOutputStream(outputStream);

        objectStream.writeObject(productRepository);
        objectStream.close();


    }
}
