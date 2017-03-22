# programit_spring_course
Final version
# To fill database
 * Open de phpMyAdmin vanuit XAMP
 * Klik op de database 'spring_test'
 * Klik op SQL ergens bovenaan de pagina
 * Kopieer onderstaande regels in 1x en plak die in het SQL vak
 * Klik rechtsonder op GO

INSERT INTO `student` (`id`, `firstname`, `lastname`, `studie_richting`) VALUES (NULL, 'Bilbo', 'Baggins', 'Cooking'), (NULL, 'Jinn', 'Erso', 'Demolition');

INSERT INTO `student` (`id`, `firstname`, `lastname`, `studie_richting`) VALUES (NULL, 'Isaac', 'Newton', 'Natuurkunde'), (NULL, 'James', 'Maxwell', 'Electrotechniek');

INSERT INTO `student` (`id`, `firstname`, `lastname`, `studie_richting`) VALUES (NULL, 'Albert', 'Einstein', 'Natuurkunde'), (NULL, 'Clarice', 'Starling', 'Psychologie');

INSERT INTO `society` (`society_id`, `voorzitter_id`, `name`) VALUES (NULL, '1', 'De Kookclub');

INSERT INTO `society` (`society_id`, `voorzitter_id`, `name`) VALUES (NULL, '2', 'Astronauten');

INSERT INTO `society_students` (`vereniging_society_id`, `students_id`) VALUES ('1', '1'), ('2', '3'), ('2', '4');

INSERT INTO `society_oudleden` (`vereniging_society_id`, `oudleden_id`, `oudleden_key`) VALUES ('1', '6', '0'), ('2', '2', '0'), ('2', '5', '1');
