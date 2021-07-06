import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
  @Id
  @SequenceGenerator(name = "product_generator", sequenceName = "products_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")

  @Column(name="id", nullable = false, unique = true)
  private long id;

  @Column(name="name", nullable = false)
  private String name;

  @Column(name="description", nullable = false)
  private String description;

  @Column(name="price", nullable = false)
  private Double price;

  @Column(name="featured", nullable = false)
  private Boolean featured;

  @Column(name="category_name", nullable = false)
  private String categoryName;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Boolean getFeatured() {
    return featured;
  }

  public void setFeatured(Boolean featured) {
    this.featured = featured;
  }

  public String getCategory_name() {
    return categoryName;
  }

  public void setCategoryName(String category_name) {
    this.categoryName = category_name;
  }
}
