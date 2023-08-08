package org.memo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MemoApplication {

    @Autowired
    private MemoRepository memoRepository;

    public static void main(String[] args) {
        SpringApplication.run(MemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return (args) -> {
            memoRepository.save(new Memo("A", "a"));
            memoRepository.save(new Memo("B", "b"));
            memoRepository.save(new Memo("C", "c"));
            memoRepository.save(new Memo("D", "d"));
            memoRepository.save(new Memo("E", "e"));
            memoRepository.save(new Memo("F", "f"));
            memoRepository.save(new Memo("G", "g"));
            memoRepository.save(new Memo("H", "h"));
        };
    }
}
