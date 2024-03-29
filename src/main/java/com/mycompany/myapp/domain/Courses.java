package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;

/**
 * A Courses.
 */
@Entity
@Table(name = "courses")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Courses implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "course_name", nullable = false)
    private String courseName;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Column(name = "price", nullable = false)
    private Double price;

    @NotNull
    @Column(name = "number_of_classes", nullable = false)
    private Long numberOfClasses;

    @NotNull
    @Column(name = "total_duration", nullable = false)
    private Long totalDuration;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category categoryId;

    @JsonIgnoreProperties(value = { "courseId" }, allowSetters = true)
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "courseId")
    private Orders orders;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Courses id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public Courses courseName(String courseName) {
        this.setCourseName(courseName);
        return this;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return this.description;
    }

    public Courses description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return this.price;
    }

    public Courses price(Double price) {
        this.setPrice(price);
        return this;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getNumberOfClasses() {
        return this.numberOfClasses;
    }

    public Courses numberOfClasses(Long numberOfClasses) {
        this.setNumberOfClasses(numberOfClasses);
        return this;
    }

    public void setNumberOfClasses(Long numberOfClasses) {
        this.numberOfClasses = numberOfClasses;
    }

    public Long getTotalDuration() {
        return this.totalDuration;
    }

    public Courses totalDuration(Long totalDuration) {
        this.setTotalDuration(totalDuration);
        return this;
    }

    public void setTotalDuration(Long totalDuration) {
        this.totalDuration = totalDuration;
    }

    public Category getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Category category) {
        this.categoryId = category;
    }

    public Courses categoryId(Category category) {
        this.setCategoryId(category);
        return this;
    }

    public Orders getOrders() {
        return this.orders;
    }

    public void setOrders(Orders orders) {
        if (this.orders != null) {
            this.orders.setCourseId(null);
        }
        if (orders != null) {
            orders.setCourseId(this);
        }
        this.orders = orders;
    }

    public Courses orders(Orders orders) {
        this.setOrders(orders);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Courses)) {
            return false;
        }
        return getId() != null && getId().equals(((Courses) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Courses{" +
            "id=" + getId() +
            ", courseName='" + getCourseName() + "'" +
            ", description='" + getDescription() + "'" +
            ", price=" + getPrice() +
            ", numberOfClasses=" + getNumberOfClasses() +
            ", totalDuration=" + getTotalDuration() +
            "}";
    }
}
