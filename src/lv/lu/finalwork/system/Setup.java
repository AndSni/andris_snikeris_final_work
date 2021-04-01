package lv.lu.finalwork.system;

import lv.lu.finalwork.model.Product;
import lv.lu.finalwork.repository.ProductRepository;
import lv.lu.finalwork.ui.Launcher;

import java.io.*;;
import java.util.HashMap;
import java.util.Map;

public class Setup {
    private Map<Long, Product> productMap;
    private ProductRepository productRepository;

    public  void startUp() throws IOException, ClassNotFoundException {
        productMap = populateDbFromFile();
        productRepository = new ProductRepository(productMap);
        productRepository.setIdCounter((long) productMap.size());

    }

    public Map<Long, Product> getProductMap() {
        return productMap;
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

    private Map<Long, Product> populateDbFromFile() throws IOException, ClassNotFoundException {
        try {
            FileInputStream inputStream = new FileInputStream("db.tmp");
            ObjectInputStream objectStream = new ObjectInputStream(inputStream);
            productMap = (HashMap<Long, Product>) objectStream.readObject();
            objectStream.close();
            return productMap;
        } catch (Exception e) {
            System.out.println("File DB not loaded.");
        }
        return new HashMap<>();
    }

    private void saveDbToFile() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("db.tmp", false);
        ObjectOutputStream objectStream = new ObjectOutputStream(outputStream);

        objectStream.writeObject(productMap);
        objectStream.close();

        //byte[] myBytes = Launcher.setup.productMap.toString().getBytes();
        //outputStream.write(myBytes);
        //outputStream.close();
    }
}
