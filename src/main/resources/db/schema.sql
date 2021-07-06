DROP TABLE IF EXISTS products;

CREATE TABLE products (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  price NUMERIC (8, 2) NOT NULL,
  featured BOOLEAN NOT NULL,
  category_name VARCHAR(255) NOT NULL
  );
