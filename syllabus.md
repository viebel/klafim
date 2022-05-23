

# Syllabus 


## Day 1: Just use maps


### Introduction (1 hour)

1. Participants present themselves
    1. Name
    2. Preferred programming language
    3. Years of experience in programming
    4. Biggest fear about Clojure


### Setup (30 min)



1. Create a leiningen project
2. Evaluate simple expressions
3. A word about LISP syntax
4. **Exercice: Ensure REPL is set up properly**


### First function and test (1 hour)



1. Data Representation
    * Represent a user (first name, last name, email)
    * Repres	ent a book (title, ISBN, author-ids, publication year)
    * Represent an author (first name, last name, book-isbns)
    * Represent a [catalog](https://klipse-embed.herokuapp.com/?src=KGRlZiUyMG1pa2UlMjAlN0IlM0FmaXJzdC1uYW1lJTIwJTIyTWljaGFlbCUyMiUwQSUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUzQWxhc3QtbmFtZSUyMCUyMktsZXltYW4lMjIlMEElMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlM0FlbWFpbCUyMCUyMm1pa2UlNDBtZS5jb20lMjIlN0QpJTBBJTBBKGRlZiUyMHdhdGNobWVuJTIwJTdCJTNBaXNibiUyMCUyMjEyMy00NTYlMjIlMEElMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlM0F0aXRsZSUyMCUyMldhdGNobWVuJTIyJTBBJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTNBYXV0aG9yLWlkcyUyMCU1QiUyMmFsYW4tbW9vcmUlMjIlMjAlMjJkYXZlLWdpYmJvbnMlMjIlNUQlN0QpJTBBJTBBKGRlZiUyMHNldmVuLWhhYml0cyUyMCU3QiUzQWlzYm4lMjAlMjIxNDUtNDIzJTIyJTBBJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTNBdGl0bGUlMjAlMjJTZXZlbiUyMEhhYml0cyUyMG9mJTIwSGlnaGx5JTIwRWZmZWN0aXZlJTIwUGVvcGxlJTIyJTBBJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTNBYXV0aG9yLWlkcyUyMCU1QiUyMnN0ZXBoZW4tY292ZXklMjIlNUQlN0QpJTBBJTBBJTBBKGRlZiUyMGFsYW4lMjAlN0IlM0FpZCUyMCUyMmFsYW4tbW9vcmUlMjIlMEElMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlM0FmaXJzdC1uYW1lJTIwJTIyQWxhbiUyMiUwQSUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUzQWxhc3QtbmFtZSUyMCUyMk1vb3JlJTIyJTBBJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTNBYm9vay1pc2JucyUyMCU1QiUyMjEyMy00NTYlMjIlNUQlN0QpJTBBJTBBKGRlZiUyMGRhdmUlMjAlN0IlM0FpZCUyMCUyMmRhdmUtZ2liYm9ucyUyMiUwQSUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUzQWZpcnN0LW5hbWUlMjAlMjJEYXZlJTIyJTBBJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTNBbGFzdC1uYW1lJTIwJTIyR2liYm9ucyUyMiUwQSUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUzQWJvb2staXNibnMlMjAlNUIlMjIxMjMtNDU2JTIyJTVEJTdEKSUwQSUwQShkZWYlMjBzdGVwaGVuJTIwJTdCJTNBaWQlMjAlMjJzdGVwaGVuLWNvdmV5JTIyJTBBJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTNBZmlyc3QtbmFtZSUyMCUyMlN0ZXBoZW4lMjIlMEElMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlM0FsYXN0LW5hbWUlMjAlMjJDb3ZleSUyMiUwQSUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUzQWJvb2staXNibnMlMjAlNUIlMjIxNDUtNDIzJTIyJTVEJTdEKSUwQSUwQShkZWYlMjBjYXRhbG9nJTIwJTdCJTNBYm9va3MlMjAlN0IlMjIxMjMtNDU2JTIyJTIwJTdCJTNBaXNibiUyMCUyMjEyMy00NTYlMjIlMEElMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlM0F0aXRsZSUyMCUyMldhdGNobWVuJTIyJTBBJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTNBYXV0aG9yLWlkcyUyMCU1QiUyMmFsYW4tbW9vcmUlMjIlMjAlMjJkYXZlLWdpYmJvbnMlMjIlNUQlN0QlMEElMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAoJTNBaXNibiUyMHNldmVuLWhhYml0cyklMjBzZXZlbi1oYWJpdHMlN0QlMEElMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlM0FhdXRob3JzJTIwJTdCJTIyYWxhbi1tb29yZSUyMiUyMGFsYW4lMEElMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjJkYXZlLWdpYmJvbnMlMjIlMjBkYXZlJTBBJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIyc3RlcGhlbi1jb3ZleSUyMiUyMHN0ZXBoZW4lN0QlN0Qp&lang=clojure) (books, authors)
2. **5 min Meditation session**
3. Functions
    * Write full-name that returns the full name of an author
    * Write a test for full-name
4. **Exercice: Write <code>full-name </code>(inc. tests)</strong>


### Functional programming (2 hours)



1. Intro
    * Write (map inc [1 2 3]) 
    * (defn mult-by-10 [x] (* x 10)) 
    * (map mult-by-10 [1 2 3]) 
    * Write (map (fn [x] (* x 10)) [1 2 3]) 
    * Write (filter odd? [1 2 3])
    * (defn greater-than-1 [x] (> x 1)) 
    * (filter greater-than-1 [1 2 3]) 
    * Write (filter (fn [x] (> x 1)) [1 2 3])
    * 
2. Sequences 
    * Write matching-books (filter) STRUGGLE (find a simpler example)
    * Write book-info (map)
3. Refactor matching-books with destructuring
4. Refactor book-info with partial
5. Refactor book-info with select-keys and update
6. **Exercice: Write <code>book-info </code>and <code>matching-books </code>(inc. tests)</strong>


### A mini data pipeline (2 hours)



1. Write a [search](https://klipse-embed.herokuapp.com/?multisnippets=1&src=KG5zJTIwbXkuY2F0YWxvZyUwQSUyMCUyMCglM0FyZXF1aXJlJTIwJTVCY2xvanVyZS5zdHJpbmclMjAlM0FyZWZlciUyMCU1QmluY2x1ZGVzJTNGJTVEJTVEKSklMEElMEEoZGVmJTIwbWlrZSUyMCU3QiUzQWZpcnN0LW5hbWUlMjAlMjJNaWNoYWVsJTIyJTBBJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTNBbGFzdC1uYW1lJTIwJTIyS2xleW1hbiUyMiUwQSUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUzQWVtYWlsJTIwJTIybWlrZSU0MG1lLmNvbSUyMiU3RCklMEElMEEoZGVmJTIwd2F0Y2htZW4lMjAlN0IlM0Fpc2JuJTIwJTIyMTIzLTQ1NiUyMiUwQSUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUzQXRpdGxlJTIwJTIyV2F0Y2htZW4lMjIlMEElMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlM0FhdXRob3ItaWRzJTIwJTVCJTIyYWxhbi1tb29yZSUyMiUyMCUyMmRhdmUtZ2liYm9ucyUyMiU1RCU3RCklMEElMEEoZGVmJTIwc2V2ZW4taGFiaXRzJTIwJTdCJTNBaXNibiUyMCUyMjE0NS00MjMlMjIlMEElMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlM0F0aXRsZSUyMCUyMlNldmVuJTIwSGFiaXRzJTIwb2YlMjBIaWdobHklMjBFZmZlY3RpdmUlMjBQZW9wbGUlMjIlMEElMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlM0FhdXRob3ItaWRzJTIwJTVCJTIyc3RlcGhlbi1jb3ZleSUyMiU1RCU3RCklMEElMEElMEEoZGVmJTIwYWxhbiUyMCU3QiUzQWlkJTIwJTIyYWxhbi1tb29yZSUyMiUwQSUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUzQWZpcnN0LW5hbWUlMjAlMjJBbGFuJTIyJTBBJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTNBbGFzdC1uYW1lJTIwJTIyTW9vcmUlMjIlMEElMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlM0Fib29rLWlzYm5zJTIwJTVCJTIyMTIzLTQ1NiUyMiU1RCU3RCklMEElMEEoZGVmJTIwZGF2ZSUyMCU3QiUzQWlkJTIwJTIyZGF2ZS1naWJib25zJTIyJTBBJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTNBZmlyc3QtbmFtZSUyMCUyMkRhdmUlMjIlMEElMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlM0FsYXN0LW5hbWUlMjAlMjJHaWJib25zJTIyJTBBJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTNBYm9vay1pc2JucyUyMCU1QiUyMjEyMy00NTYlMjIlNUQlN0QpJTBBJTBBKGRlZiUyMHN0ZXBoZW4lMjAlN0IlM0FpZCUyMCUyMnN0ZXBoZW4tY292ZXklMjIlMEElMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlM0FmaXJzdC1uYW1lJTIwJTIyU3RlcGhlbiUyMiUwQSUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUzQWxhc3QtbmFtZSUyMCUyMkNvdmV5JTIyJTBBJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTNBYm9vay1pc2JucyUyMCU1QiUyMjE0NS00MjMlMjIlNUQlN0QpJTBBJTBBKGRlZiUyMGNhdGFsb2clMjAlN0IlM0Fib29rcyUyMCU3QiUyMjEyMy00NTYlMjIlMjAlN0IlM0Fpc2JuJTIwJTIyMTIzLTQ1NiUyMiUwQSUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUzQXRpdGxlJTIwJTIyV2F0Y2htZW4lMjIlMEElMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlM0FhdXRob3ItaWRzJTIwJTVCJTIyYWxhbi1tb29yZSUyMiUyMCUyMmRhdmUtZ2liYm9ucyUyMiU1RCU3RCUwQSUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCglM0Fpc2JuJTIwc2V2ZW4taGFiaXRzKSUyMHNldmVuLWhhYml0cyU3RCUwQSUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUzQWF1dGhvcnMlMjAlN0IlMjJhbGFuLW1vb3JlJTIyJTIwYWxhbiUwQSUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMmRhdmUtZ2liYm9ucyUyMiUyMGRhdmUlMEElMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjJzdGVwaGVuLWNvdmV5JTIyJTIwc3RlcGhlbiU3RCU3RCklMEElMEEoZGVmbiUyMGZ1bGwtbmFtZSUyMCU1QiU3QiUzQWtleXMlMjAlNUJmaXJzdC1uYW1lJTIwbGFzdC1uYW1lJTVEJTdEJTVEJTBBJTIwJTIwKHN0ciUyMGZpcnN0LW5hbWUlMEElMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjIlMjAlMjIlMEElMjAlMjAlMjAlMjAlMjAlMjAlMjBsYXN0LW5hbWUpKSUwQSUwQShkZWZuJTIwbWF0Y2hpbmctYm9va3MlMjAlNUJjYXRhbG9nJTIwcXVlcnklNUQlMEElMjAlMjAoZmlsdGVyJTIwKGZuJTIwJTVCJTdCJTNBa2V5cyUyMCU1QnRpdGxlJTVEJTdEJTVEJTIwJTBBJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwKGNsb2p1cmUuc3RyaW5nJTJGaW5jbHVkZXMlM0YlMjB0aXRsZSUyMHF1ZXJ5KSklMjAlMEElMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAodmFscyUyMCglM0Fib29rcyUyMGNhdGFsb2cpKSkpJTBBJTBBKGRlZm4lMjBhdXRob3ItbmFtZSUyMCU1QiU3QiUzQWtleXMlMjAlNUJhdXRob3JzJTVEJTdEJTIwYXV0aG9yLWlkJTVEJTBBJTIwJTIwKC0lM0UlM0UlMjBhdXRob3ItaWQlMEElMjAlMjAlMjAlMjAoZ2V0JTIwYXV0aG9ycyklMEElMjAlMjAlMjAlMjAoZnVsbC1uYW1lKSkpJTBBJTBBKGRlZm4lMjBib29rLWluZm8lMjAlNUJjYXRhbG9nJTIwJTdCJTNBa2V5cyUyMCU1QmF1dGhvci1pZHMlMjB0aXRsZSU1RCU3RCU1RCUwQSUyMCUyMCU3QiUzQXRpdGxlJTIwdGl0bGUlMEElMjAlMjAlMjAlM0FhdXRob3ItbmFtZXMlMjAobWFwJTIwKGZuJTIwJTVCaWQlNUQlMjAlMEElMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAoYXV0aG9yLW5hbWUlMjBjYXRhbG9nJTIwaWQpKSUwQSUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMGF1dGhvci1pZHMpJTdEKSUwQSUwQShkZWZuJTIwc2VhcmNoJTIwJTVCY2F0YWxvZyUyMHF1ZXJ5JTVEJTBBJTIwJTIwKGxldCUyMCU1QmJvb2tzJTIwKG1hdGNoaW5nLWJvb2tzJTIwY2F0YWxvZyUyMHF1ZXJ5KSU1RCUwQSUyMCUyMCUyMCUyMChtYXAlMjAoZm4lMjAlNUJib29rJTVEJTBBJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwKGJvb2staW5mbyUyMGNhdGFsb2clMjBib29rKSklMEElMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjBib29rcykpKSUwQSUwQShzZWFyY2glMjBjYXRhbG9nJTIwJTIyV2F0JTIyKQ%3D%3D&lang=clojure) function (inc. tests) that returns book details of books whose title contains a string (title, ISBN, author names)
2. Refactor with thread macro
3. Create a catalog with zipmap and mapify
4. Write tests for search
    * Equality of sequences
5. **Exercice: Write <code>search </code>(inc. tests)</strong>


### Summary



1. Just use maps
2. sequences
    * filter
    * map
    * equality
3. functional programming
    * anonymous function
    * partial
    * thread macros
4. namespaces
    * require
    * refer
5. unit tests
6. Debug with local defs


## Day 2: Immutable data structures

Did I mention?



1. Klipse
2. Clojurians Slack
3. Clojuredocs
4. Clojureverse
5. FP intro


### Data Exchange (2 hours)



1. Serialize the search results to JSON Serialize the results
2. Read catalog from a CSV files: [books.csv](https://docs.google.com/spreadsheets/u/0/d/1DdXArQ4g72-HAd4f0YC-nYouDe54a_xLt7HI0DHKA4c/edit) and [authors.csv](https://docs.google.com/spreadsheets/u/0/d/1EGHLI-kaIT5XYGh4nbb_XXWnF1SxXOQjbH0BKUYYE9I/edit) (Each participant is required to add 2 books) using this [rows->maps converter](https://klipse-embed.herokuapp.com/?src=KHJlcXVpcmUlMjAnJTVCY2xvanVyZS5zZXQlMjAlM0FyZWZlciUyMCU1QnJlbmFtZS1rZXlzJTVEJTVEKSUwQSUwQShkZWZuJTIwaGVhZGVycy1hbmQtcm93cy0lM0VtYXBzJTBBJTIwJTIwJTVCaGVhZGVycyUyMHJvd3MlNUQlMEElMjAlMjAobWFwJTIwKHBhcnRpYWwlMjB6aXBtYXAlMjBoZWFkZXJzKSUyMHJvd3MpKSUwQSUwQShoZWFkZXJzLWFuZC1yb3dzLSUzRW1hcHMlMjAlNUIlMjJpZCUyMiUyMCUyMm5hbWUlMjIlNUQlMEElMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlNUIlNUIlMjIxJTIyJTIwJTIyZm9vJTIyJTVEJTBBJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTVCJTIyMiUyMiUyMCUyMmJhciUyMiU1RCU1RCklMEElMEEoLSUzRSUzRSUyMCUwQSUyMCUyMChoZWFkZXJzLWFuZC1yb3dzLSUzRW1hcHMlMjAlNUIlMjJpZCUyMiUyMCUyMm5hbWUlMjIlNUQlMEElMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlMjAlNUIlNUIlMjIxJTIyJTIwJTIyZm9vJTIyJTVEJTBBJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTIwJTVCJTIyMiUyMiUyMCUyMmJhciUyMiU1RCU1RCklMEElMjAlMjAobWFwJTIwJTIzKHJlbmFtZS1rZXlzJTIwJTI1JTIwJTdCJTIyaWQlMjIlMjAlMjJteS1pZCUyMiUwQSUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMm5hbWUlMjIlMjAlMjJ0aGUtbmFtZSUyMiU3RCkpKSUwQSUwQShtYXAlMjAlMjMoZ2V0JTIwJTdCJTIyaWQlMjIlMjAlMjJteS1pZCUyMiUwQSUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMCUyMm5hbWUlMjIlMjAlMjJ0aGUtbmFtZSUyMiU3RCUyMCUyNSklMEElMjAlMjAlMjAlMjAlMjAlNUIlMjJpZCUyMiUyMCUyMm5hbWUlMjIlNUQp&lang=clojure) and [https://github.com/clojure/data.csv](https://github.com/clojure/data.csv)
    * rename fields
    * parse fields with reduce (delay or cancel)
3. **Exercice: Create catalog from 2 CSV files and implement search (as JSON)**


### Sequences (1 hour)



1. Implement map using recursion 
2. Implement filter using recursion
3. Demonstrate laziness

    ```
(map print (range 100))
(def res (map inc (range 100))
```


4. **Exercice: Implement map and filter**


###  The benefits of immutability (1.5 hour)



1. Updating the publication year of Watchmen
2. The benefits of immutability
3. The secret of the persistent data structure efficiency


### Creating new version of data (1.5 hour)



1. Adding a book to the catalog
2. Adding an author
3. **Exercice: Write add-book and add-author**


### Reducing (2 hours)



1. Intro to reduce
    1. Summing numbers in a sequence
    2. Converting a sequence of pairs to a map
    3. Counting occurrences 


### Managing a catalog (2 hours)



1. Adding multiple authors
2. Adding book and its authors
3. Adding multiple books
4. **Exercice: Write add-books and add-authors**


### Atoms (1 hour)



1. **Game: Count from 1 to 20 as a team (when two people count together we lose points)**
2. Illustrate race conditions with  

```clojure
 (defn increment [counter]
  (let [current-val @counter
        next-val (inc current-val)]
    (reset! counter next-val)))

  (def c (atom 0))
  (dotimes [_ 100] (future (increment c)))
  @c
```


3. Separate calculation from state management
4. **Exercice: Write add-books that work on an atom**


### Summary



1. maps
    * update
    * zipmap
2. Data Exchange
    * CSV
    * JSON
3. immutability
    * benefits
    * efficiency
4. Reduce
5. atoms
6. Debug with local defs


## Day 3: Data validation



* Clojure records
* Malli
* Advanced data manipulation
* Multimethods?
* A taste of macros
* **Project: Validate catalog data before committing a mutation**


### Checkpoint


1. Participants share where they are
    1. Name
    2. What about your Clojure fear?
    3. Share an insight you had
    4. Share a concern you have


### Manual validation (1 hour)



1. validate author ids
2. validate isbns
3. validate catalog
4. **Exercice: Write valid-catalog?**


### Malli schemas (2 hours)



1. validation
2. explanation
3. humanization
4. Not only types (e.g publication year between 1455 [Gutenberg Bible] and 2100)
5. **Exercice: Create catalog schema**


### Validation at system boundaries (1 hour)



1. System boundaries
    1. Organize system endpoints (add-books, search)
        1. JSON input and output
        2. test only calculation


### Validation at system boundaries (1 hour)



1. **Games:**
    1. **[The influence of paradigms on perception](https://docs.google.com/presentation/d/1mK1gnBFhu5GA5lu0aa2E7Go6h8ujDCGOyYvGzepz_7o/edit?usp=sharing)**
    2. **[The 2 4 6 experiment](https://www.oxfordreference.com/view/10.1093/oi/authority.20110803100347298)**
2. Add malli validation (inc. humanization) in add-books and search
3. **Exercice: Validation in add-books and in search**


### Validation of function arguments (1 hour)



1. Validation inside add-books-and-authors
2. Disable in production
3. **Exercice: Add validation to full-name and book-info**


### Generative testing (1 hour)



1. data generation with malli
2. full-name
3. book-info
4. **Exercice: Write a generative test for book-info**


### A taste of macros (1 hour)



1. snoop macros
2. **Exercice: Play with snoop**


### Open schemas (1 hour)



1. Robustness principle: "Be conservative in what you send, be liberal in what you accept" 
2. Closing/Opening a schema
3. The fundamental difference between types and schemas


### Summary 



1. data validation
2. schema as data
3. generative testing
4. flexibility
5. validation at system boundaries
6. validation of function arguments


## Conclusion (1 hour)



1. Participants share their takeaways
    1. What did you learn
        1. data validation
        2. FP
        3. map/filter/reduce
        4. pair programming
        5. VSCode
        6. General feel of the language
        7. recursive stack overflow
        8. laziness
    2. What was easy to learn
        9. Nothing
        10. IDE
    3. What was difficult to learn
        11. How to break down a business log into map/filter and reduce
        12. map/filter/reduce
        13. FP
        14. IDE
        15. too many functions to remember!
        16. Lost in functions
        17. parentheses
        18. structure the code
    4. How we could improve the workshop
        19. Basic stuff about FP (map, filter, reduce, anonymous functions)
        20. Split lessons and exercise into morning and afternoon sessions
        21. Database, File systems, API, Web, Data pipeline,
        22. Review a real system
        23. How to apply in a QA team?
        24. Too late notice for reading chapters a about book (allow people to block time)
        25. Specify what exactly need to be read in the book
        26. Share the syllabus before hand
        27. Provide the built code (as a repo, with tags)
2. The benefits of Clojure \


<p id="gdcalert1" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/image1.png). Store image on your image server and adjust path/filename/extension if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert2">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/image1.png "image_tooltip")

3. The principles of DOP \


<p id="gdcalert2" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/image2.png). Store image on your image server and adjust path/filename/extension if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert3">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/image2.png "image_tooltip")

4. DOP not in Clojure
    5. JSON schemas
    6. Persistent data structures \


<p id="gdcalert3" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/image3.png). Store image on your image server and adjust path/filename/extension if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert4">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/image3.png "image_tooltip")

5. Stay in touch
    7. Twitter
    8. Blog
    9. Book