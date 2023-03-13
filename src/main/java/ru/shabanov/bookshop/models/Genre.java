package ru.shabanov.bookshop.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Genre parentId;

    @OneToMany(mappedBy = "parentId")
    private List<Genre> subgenres;

    @Column(name = "slug", nullable = false)
    private String slug;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "book2genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Book> books;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Genre getParentId() {
        return parentId;
    }

    public void setParentId(Genre parentId) {
        this.parentId = parentId;
    }

    public List<Genre> getSubgenres() {
        return subgenres;
    }

    public void setSubgenres(List<Genre> subgenres) {
        this.subgenres = subgenres;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
