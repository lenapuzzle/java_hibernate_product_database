import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

  public static void main(String[] args) throws IOException {

     // using Map
    ClassLoader loader = Main.class.getClassLoader();
    File catalog = new File(loader.getResource("catalog.json").getFile());
    ObjectMapper mapper = new ObjectMapper();
    List<HashMap<String, String>> products;

    products = mapper.readValue(catalog, ArrayList.class);

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.launchacademy.products");
    EntityManager em = emf.createEntityManager();

    try {
    for(Map<String, String> productData : products) {
      System.out.println(productData);
      Product newProduct = new Product();
      newProduct.setName(productData.get("name"));
      newProduct.setDescription(productData.get("description"));
      newProduct.setPrice(Double.parseDouble(productData.get("price")));
      newProduct.setFeatured(Boolean.parseBoolean(productData.get("featured")));
      newProduct.setCategoryName(productData.get("category_name"));
      System.out.println(newProduct);

      em.persist(newProduct);
      System.out.println(newProduct);
    }
      em.getTransaction().begin();
      em.getTransaction().commit();
    }
    finally {
      em.close();
      emf.close();
    }

    // hardcode
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.launchacademy.products");
//    EntityManager em = emf.createEntityManager();
//
//    try {
//      Product product1 = new Product();
//      product1.setName("Rubber Duck");
//      product1.setDescription("Your resident conversationalist");
//      product1.setPrice(4.99);
//      product1.setFeatured(true);
//      product1.setCategoryName("Toys");
//      em.getTransaction().begin();
//      em.persist(product1);
//      em.getTransaction().commit();
//
//      Product product2 = new Product();
//      product2.setName("Engineering Journal");
//      product2.setDescription("Record your observations and thoughts as you work through coding projects");
//      product2.setPrice(7.99);
//      product2.setFeatured(true);
//      product2.setCategoryName("Productivity");
//      em.getTransaction().begin();
//      em.persist(product2);
//      em.getTransaction().commit();
//
//      Product product3 = new Product();
//      product3.setName("Sleep Mask");
//      product3.setDescription("Get your Z's in so that you can code well in the morning");
//      product3.setPrice(9.99);
//      product3.setFeatured(false);
//      product3.setCategoryName("Productivity");
//      em.getTransaction().begin();
//      em.persist(product3);
//      em.getTransaction().commit();
//    }
//    finally {
//      em.close();
//      emf.close();
//    }
  }
}
