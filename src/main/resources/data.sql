-- For H2
CREATE TABLE question(
id int NOT NULL AUTO_INCREMENT,
title varchar NOT NULL,
first_answer varchar NOT NULL,
second_answer varchar NOT NULL,
third_answer varchar NOT NULL,
fourth_answer varchar NOT NULL,
PRIMARY KEY (id)
);

INSERT INTO question (title, first_answer, second_answer, third_answer, fourth_answer)
VALUES('Between the following what do you most love to do?', 'Watch TV', 'Play the computer', 'Hanging out with friends', 'Travel the world'),
('Where is your preferred place to travel?', 'USA', 'France', 'South America', 'Thailand'),
('Which State of USA was once part of Mexico?', ' Texas', 'Maryland', 'New York', 'Alaska'),
('What is the number of states in USA?', '24', '50', '60', '49'),
('Which city is known as the Big Apple?', 'Los Angeles', 'Washington D.C.', 'Houston', 'New York'),
('Who had the longest tenure as President of USA?', 'John F. Kennedy', 'Franklin D. Roosevelt', 'George Washington', 'James Carter'),
('Which of the following cities is in Nevada?', 'Reno', 'Los Angeles', 'Montreal', 'Atlanta'),
('Which city was known as New Amsterdam?', 'New Orleans', 'Los Angeles', 'Seattle', 'New York'),
('How many stars are in the flag of USA?', '50', '20', '60', '75'),
(' If the President and Vice President of USA die at the same time who becomes the President?', 'Attorney General', 'Secretary of State', 'Speaker of the House of Representatives', 'Defence Secretary');


CREATE TABLE answer(
id int NOT NULL AUTO_INCREMENT,
answer_number int NOT NULL,
question_id int NOT NULL,
user_id int NOT NULL,
PRIMARY KEY (id)
);

