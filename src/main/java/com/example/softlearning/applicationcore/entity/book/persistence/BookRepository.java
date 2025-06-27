package com.example.softlearning.applicationcore.entity.book.persistence;

import java.util.List;
import java.util.Optional;

import com.example.softlearning.applicationcore.entity.book.dtos.BooksDTO;

public interface BookRepository {
    public Optional<BooksDTO> findByCode(int code);

    public List<BooksDTO> findByTitle(String title);

    public List<BooksDTO> findByPartialTitle(String title);

    public Integer countByPartialTitle(String title);

    public BooksDTO save(BooksDTO book);

    public void deleteByCode(int id);
}
