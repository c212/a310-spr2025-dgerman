package com.devcases.springboot.crud.library.model;

import com.devcases.springboot.crud.library.entity.Quote;
import com.devcases.springboot.crud.library.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class QuoteService {
    @Autowired
    private QuoteRepository repository;

    @PostConstruct
    public void init() {
        try {
            if (repository.count() == 0) {  // Only load if repository is empty
                ClassPathResource resource = new ClassPathResource("quotes.txt");
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(resource.getInputStream())
                );
                
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    if (parts.length == 2) {
                        Quote quote = new Quote();
                        quote.setAuthor(parts[0].trim());
                        quote.setQuoteText(parts[1].trim());
                        repository.save(quote);
                    }
                }
                reader.close();
            }
        } catch (Exception e) {
            System.err.println("Error loading quotes: " + e.getMessage());
        }
    }

    public List<Quote> findAll() {
        List<Quote> quotes = new ArrayList<>();
        repository.findAll().forEach(quotes::add);
        return quotes;
    }

    public Optional<Quote> findById(Long id) {
        return repository.findById(id);
    }

    public Quote save(Quote quote) {
        return repository.save(quote);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Quote getRandomQuote() {
        List<Quote> quotes = findAll();
        if (quotes.isEmpty()) {
            return null;
        }
        return quotes.get(new Random().nextInt(quotes.size()));
    }
}
