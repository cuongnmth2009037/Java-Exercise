package com.example.product.t2009m1java.entity;

import com.example.product.t2009m1java.entity.base.BaseEntity;
import com.example.product.t2009m1java.entity.entityEnum.ObjectStatus;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Category extends BaseEntity {
    private int id;
    private String name;
    private ObjectStatus objectStatus;

    public Category() {
        this.name = "";
    }


    public Category(int id, String name, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, int createdBy, int updatedBy, int deletedBy, ObjectStatus objectStatus) {
        super(createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy, objectStatus);
        this.id = id;
        this.name = name;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name;}


    public static final class CategoryBuilder {
        public LocalDateTime createdAt;
        public LocalDateTime updatedAt;
        public LocalDateTime deletedAt;
        public int createdBy;
        public int updatedBy;
        public int deletedBy;
        public ObjectStatus status;
        private int id;
        private String name;
        private ObjectStatus objectStatus;

        private CategoryBuilder() {
            this.name = "";
            this.createdAt = LocalDateTime.now();
            this.updatedAt = LocalDateTime.now();
            this.status = ObjectStatus.ACTIVE;
        }

        public static CategoryBuilder aCategory() {
            return new CategoryBuilder();
        }

        public CategoryBuilder id(int id) {
            this.id = id;
            return this;
        }

        public CategoryBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CategoryBuilder objectStatus(ObjectStatus objectStatus) {
            this.objectStatus = objectStatus;
            return this;
        }

        public CategoryBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CategoryBuilder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public CategoryBuilder deletedAt(LocalDateTime deletedAt) {
            this.deletedAt = deletedAt;
            return this;
        }

        public CategoryBuilder createdBy(int createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public CategoryBuilder updatedBy(int updatedBy) {
            this.updatedBy = updatedBy;
            return this;
        }

        public CategoryBuilder deletedBy(int deletedBy) {
            this.deletedBy = deletedBy;
            return this;
        }

        public CategoryBuilder status(ObjectStatus status) {
            this.status = status;
            return this;
        }

        public Category build() {
            Category category = new Category(id, name, createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy, objectStatus);
            category.setStatus(status);
            return category;
        }
    }
}
