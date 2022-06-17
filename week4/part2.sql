ALTER TABLE brands ADD FOREIGN KEY (country_id) REFERENCES countries(id);
ALTER TABLE warehouses ADD FOREIGN KEY (manager_id) REFERENCES employees(id);
ALTER TABLE employees ADD FOREIGN KEY (country_id) REFERENCES countries(id);
ALTER TABLE phones ADD FOREIGN KEY (country_made_in_id) REFERENCES countries(id);
ALTER TABLE phones ADD FOREIGN KEY (warehouse_id) REFERENCES warehouses(id);
ALTER TABLE phones ADD FOREIGN KEY (brand_id) REFERENCES brands(id);