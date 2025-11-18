-- Таблица товаров
CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price INTEGER NOT NULL,
    image_url VARCHAR(255),
    description TEXT,
    category VARCHAR(50),
    in_stock BOOLEAN DEFAULT true,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Наполняем товарами
INSERT INTO products (name, price, image_url, description, category) VALUES
('Футболка хлопковая', 990, 'https://placehold.co/400x400/4F46E5/FFFFFF?text=👕', 'Мягкая хлопковая футболка', 'Одежда'),
('Куртка демисезонная', 5490, 'https://placehold.co/400x400/059669/FFFFFF?text=🧥', 'Тёплая куртка на весну/осень', 'Одежда'),
('Кроссовки спортивные', 3290, 'https://placehold.co/400x400/DC2626/FFFFFF?text=👟', 'Удобные кроссовки для бега', 'Обувь'),
('Джинсы классические', 2990, 'https://placehold.co/400x400/7C3AED/FFFFFF?text=👖', 'Прямые джинсы синего цвета', 'Одежда'),
('Шапка вязаная', 1290, 'https://placehold.co/400x400/EA580C/FFFFFF?text=🧢', 'Тёплая вязаная шапка', 'Аксессуары');