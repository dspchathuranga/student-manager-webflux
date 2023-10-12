-- Create the 'student' table if it does not exist
CREATE TABLE IF NOT EXISTS student (
  student_id serial PRIMARY KEY,
  student_first_name VARCHAR(50),
  student_last_name VARCHAR(50),
  student_age INT
);

-- Create the 'subject' table if it does not exist
CREATE TABLE IF NOT EXISTS subject (
  subject_id serial PRIMARY KEY,
  subject_name VARCHAR(100)
);

-- Create a bridge table to establish a many-to-many relationship between 'student' and 'subject' if it does not exist
CREATE TABLE IF NOT EXISTS student_subject (
  student_id INT,
  subject_id INT,
  FOREIGN KEY (student_id) REFERENCES student(student_id),
  FOREIGN KEY (subject_id) REFERENCES subject(subject_id),
  PRIMARY KEY (student_id, subject_id)
);
