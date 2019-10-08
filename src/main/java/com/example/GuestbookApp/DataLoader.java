package com.example.GuestbookApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    GuestbookRepository repository;
    @Override
    public void run(String... strings) throws Exception{
        Guestbook guestbook;
        guestbook = new Guestbook();
        guestbook.setWishes("g);
        guestbook.setName("Romeo");
//        guestbook.setDate(01/01/2001);
        repository.save(guestbook);

    }


}
