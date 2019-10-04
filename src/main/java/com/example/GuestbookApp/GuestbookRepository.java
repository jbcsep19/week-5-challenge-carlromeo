package com.example.GuestbookApp;

import org.springframework.data.repository.CrudRepository;

public interface GuestbookRepository extends CrudRepository<Guestbook, Long> {
}
