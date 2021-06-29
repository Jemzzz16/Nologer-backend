package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin
public class QuoteController {

    ArrayList<String> quotes = new ArrayList<>();

    // step two: in the constructor add you favourite quotes to the quote list
    public QuoteController() {
        String quote = "do or do not, there is no try";
        quotes.add(quote);
        String quoteTwo = "live laugh love";
        quotes.add(quoteTwo);
    }
@GetMapping("quote")
    public String getQuote() {
        // .. code goes here
        return this.quotes.get(0);
    }
@GetMapping("quotes")
        public ArrayList<String> getQuotes() {
        return this.quotes;
        }
//
//    public String createQuote() {
//
//    }
//
//    public String deleteQuote() {
//
//    }
}
