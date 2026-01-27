-- Database schema for Agri-POS Week 11
-- Create database (if not exists)
CREATE DATABASE IF NOT EXISTS agripos;

-- Switch to agripos database
\c agripos;

-- Create products table
CREATE TABLE IF NOT EXISTS products (
    code VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    stock INT NOT NULL
);

-- Clear existing data (optional, for testing)
-- DELETE FROM products;

-- Sample seed data (optional)
-- INSERT INTO products(code, name, price, stock) VALUES ('P01', 'Pupuk Organik', 25000, 10);
-- INSERT INTO products(code, name, price, stock) VALUES ('P02', 'Benih Padi', 15000, 20);
-- INSERT INTO products(code, name, price, stock) VALUES ('P03', 'Pestisida Organik', 35000, 5);
