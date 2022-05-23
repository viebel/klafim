

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
    * Represent a [catalog](books, authors)
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



1. Write a `search` function (inc. tests) that returns book details of books whose title contains a string (title, ISBN, author names)
2. Refactor with thread macro
3. Create a catalog with zipmap and mapify
4. Write tests for search
    * Equality of sequences
5. **Exercice: Write `search`(inc. tests)**


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
2. Read catalog from a CSV files: [books.csv](https://docs.google.com/spreadsheets/u/0/d/1DdXArQ4g72-HAd4f0YC-nYouDe54a_xLt7HI0DHKA4c/edit) and [authors.csv](https://docs.google.com/spreadsheets/u/0/d/1EGHLI-kaIT5XYGh4nbb_XXWnF1SxXOQjbH0BKUYYE9I/edit) (Each participant is required to add 2 books) 
    * rename fields
    * parse fields with reduce (delay or cancel)
3. **Exercice: Create catalog from 2 CSV files and implement search (as JSON)**


### Sequences (1 hour)



1. Implement map using recursion 
2. Implement filter using recursion
3. Demonstrate laziness

```clojure
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



### Participants share their takeaways

1. What did you learn?
2. What was easy to learn?
3. What was difficult to learn?
4. How we could improve the workshop?
    

#### The benefits of Clojure

![Clojure](https://slides.klipse.tech/reveal/site/img/clojure-essence.svg)

#### The principles of DOP 

![Principles](https://slides.klipse.tech/reveal/site/img/do-principles-mind-map.png)

#### DOP not in Clojure

1. JSON schema instead of Malli
1. Persistent data structures 


| Language   | Library                  |
|------------|--------------------------|
| JavaScript | Immutable.js             |
| Java       | Paguro                   |
| Go         | Peds                     |
| Clojure    | native                   |
| C#         | provided by the language |
| Python     | Pyrsistent               |
| Ruby       | Hamster                  |



#### Stay in touch

1. [@viebel](https://twitter.com/viebel) on Twitter
1. [blog.klipse.tech](https://blog.klipse.tech/)
1. [Book](https://www.manning.com/books/data-oriented-programming?utm_source=viebel&utm_medium=affiliate&utm_campaign=book_sharvit2_data_1_29_21&a_aid=viebel&a_bid=d5b546b7)
