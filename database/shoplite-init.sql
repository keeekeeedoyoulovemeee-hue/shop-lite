-- Создаём таблицу товаров
CREATE TABLE products (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  price DECIMAL(10, 2) NOT NULL,
  image TEXT NOT NULL,
  description TEXT
);

-- Добавляем тестовые товары
INSERT INTO products (name, price, image, description) VALUES
  ('Футболка', 990.00, 'https://placehold.co/200x200/4F46E5/FFFFFF?text=👕', 'Мягкая хлопковая футболка'),
  ('Куртка', 5490.00, 'https://placehold.co/200x200/059669/FFFFFF?text=🧥', 'Тёплая зимняя куртка'),
  ('Кроссовки', 3290.00, 'https://placehold.co/200x200/DC2626/FFFFFF?text=👟', 'Спортивные кроссовки');