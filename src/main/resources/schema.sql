CREATE TABLE voter(
	id LONG PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255),
	candidate VARCHAR(255)
);

INSERT into voter(name, candidate) VALUES
('Mike Spencer', 'Kang'),
('Jimmy Butler', 'Kangz'),
('Mike Dudley', 'Kodos'),
('Harry Potter', 'Antetekoumpo');
