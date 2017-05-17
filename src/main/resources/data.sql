-- roles
INSERT INTO `role` (`name`) VALUES
('formateur');
INSERT INTO `role` (`name`) VALUES
('tuteur');
INSERT INTO `role` (`name`) VALUES
('administrateur');
INSERT INTO `role` (`name`) VALUES
('apprenant');
-- promo
INSERT INTO `promo` (`name`,`start_date`,`end_date`) VALUES
('laposte1','2016-11-01','2017-07-30');
-- diary
INSERT INTO `diary` (`name`,`start_date`,`end_date`,`introduction`,`promo_id`) VALUES
('session1','2017-01-01','2017-01-15','ceci sera ma premiere introduction',1);
INSERT INTO `diary` (`name`,`start_date`,`end_date`,`introduction`,`promo_id`) VALUES
('session2 sans conclusions','2017-01-16','2017-01-31','ceci sera ma deuxieme introduction',1);
INSERT INTO `diary` (`name`,`start_date`,`end_date`,`introduction`,`promo_id`) VALUES
('session3 sans conclusion','2017-02-01','2017-02-15','ceci sera ma troisieme introduction',1);
INSERT INTO `diary` (`name`,`start_date`,`end_date`,`introduction`,`promo_id`) VALUES
('session4 sans reponse','2017-02-15','2017-02-28','ceci sera ma quatrieme introduction',1);
INSERT INTO `diary` (`name`,`start_date`,`end_date`,`introduction`,`promo_id`) VALUES
('session5 sans reponse','2017-02-01','2017-02-15','ceci sera ma cinquieme introduction',1);
-- users :
-- apprenant
INSERT INTO `user` (`firstname`,`lastname`, `password`,`email`,`pair_id`,`role_id`,`promo_id` ) VALUES
('abdel', 'dupont1', 'azerty', 'abdel@simplon.co', null, 4, 1); 
INSERT INTO `user` (`firstname`,`lastname`, `password`,`email`,`pair_id`,`role_id`,`promo_id` ) VALUES
('damien', 'dupont2', 'azerty', 'damien@simplon.co', null, 4, 1);
-- formateur
INSERT INTO `user` (`firstname`,`lastname`, `password`,`email`,`pair_id`,`role_id`,`promo_id` ) VALUES
('manu', 'dupont3', 'azerty', 'manu@simplon.co', null, 1, 1);
INSERT INTO `user` (`firstname`,`lastname`, `password`,`email`,`pair_id`,`role_id`,`promo_id` ) VALUES
('nico', 'dupont4', 'azerty', 'nico@simplon.co', null, 1, 1);
-- tuteur
INSERT INTO `user` (`firstname`,`lastname`, `password`,`email`,`pair_id`,`role_id`,`promo_id` ) VALUES
('michael', 'dupont5', 'azerty', 'michael@simplon.co', 1, 2, null);
INSERT INTO `user` (`firstname`,`lastname`, `password`,`email`,`pair_id`,`role_id`,`promo_id` ) VALUES
('ali', 'dupont6', 'azerty', 'ali@simplon.co', 2, 2, null);
-- administrateur
INSERT INTO `user` (`firstname`,`lastname`, `password`,`email`,`pair_id`,`role_id`,`promo_id` ) VALUES
('laeticia', 'dupont7', 'azerty', 'laeticia@simplon.co', null, 3, null);

-- answers

-- carnet 1
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 1 du carnet 1 du tuteur d'abdel",5);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 2 du carnet 1 du tuteur d'abdel",5);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 3 du carnet 1 du tuteur d'abdel",5);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 4 du carnet 1 du tuteur d'abdel",5);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 5 du carnet 1 du tuteur d'abdel",5);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 1 du carnet 1 d'abdel",1);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 2 du carnet 1 d'abdel",1);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 3 du carnet 1 d'abdel",1);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 4 du carnet 1 d'abdel",1);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 5 du carnet 1 d'abdel",1);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 1 du carnet 1 du tuteur de Damien",6);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 2 du carnet 1 du tuteur de Damien",6);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 3 du carnet 1 du tuteur de Damien",6);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 4 du carnet 1 du tuteur de Damien",6);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 5 du carnet 1 du tuteur de Damien",6);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 1 du carnet 1 de Damien",2);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 2 du carnet 1 de Damien",2);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 3 du carnet 1 de Damien",2);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 4 du carnet 1 de Damien",2);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 5 du carnet 1 de Damien",2);

-- carnet 2
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 1 du carnet 2 du tuteur d'abdel",5);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 2 du carnet 2 du tuteur d'abdel",5);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 3 du carnet 2 du tuteur d'abdel",5);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 4 du carnet 2 du tuteur d'abdel",5);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 5 du carnet 2 du tuteur d'abdel",5);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 1 du carnet 2 d'abdel",1);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 2 du carnet 2 d'abdel",1);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 3 du carnet 2 d'abdel",1);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 4 du carnet 2 d'abdel",1);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 5 du carnet 2 d'abdel",1);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 1 du carnet 2 du tuteur de Damien",6);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 2 du carnet 2 du tuteur de Damien",6);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 3 du carnet 2 du tuteur de Damien",6);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 4 du carnet 2 du tuteur de Damien",6);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 5 du carnet 2 du tuteur de Damien",6);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 1 du carnet 2 de Damien",2);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 2 du carnet 2 de Damien",2);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 3 du carnet 2 de Damien",2);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 4 du carnet 2 de Damien",2);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 5 du carnet 2 de Damien",2);

-- questions

-- carnet 1
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 1ere question du carnet 1 du tuteur" ,1,2,1);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 2eme question du carnet 1 du tuteur" ,1,2,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 3eme question du carnet 1 du tuteur" ,1,2,3);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 4eme question du carnet 1 du tuteur" ,1,2,4);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 5eme question du carnet 1 du tuteur" ,1,2,5);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 1ere question du carnet 1 de l'apprenant" ,1,4,6);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 2eme question du carnet 1 de l'apprenant" ,1,4,7);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 3eme question du carnet 1 de l'apprenant" ,1,4,8);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 4eme question du carnet 1 de l'apprenant" ,1,4,9);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 5eme question du carnet 1 de l'apprenant" ,1,4,10);

-- carnet 2
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 1ere question du carnet 2 du tuteur" ,2,2,11);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 2eme question du carnet 2 du tuteur" ,2,2,12);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 3eme question du carnet 2 du tuteur" ,2,2,13);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 4eme question du carnet 2 du tuteur" ,2,2,14);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 5eme question du carnet 2 du tuteur" ,2,2,15);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 1ere question du carnet 2 de l'apprenant" ,2,4,16);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 2eme question du carnet 2 de l'apprenant" ,2,4,17);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 3eme question du carnet 2 de l'apprenant" ,2,4,18);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 4eme question du carnet 2 de l'apprenant" ,2,4,19);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 5eme question du carnet 2 de l'apprenant" ,2,4,20);

-- carnet 3
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 1ere question du carnet 3 du tuteur" ,3,2,21);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 2eme question du carnet 3 du tuteur" ,3,2,22);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 3eme question du carnet 3 du tuteur" ,3,2,23);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 4eme question du carnet 3 du tuteur" ,3,2,24);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 5eme question du carnet 3 du tuteur" ,3,2,25);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 1ere question du carnet 3 de l'apprenant" ,3,4,26);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 2eme question du carnet 3 de l'apprenant" ,3,4,27);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 3eme question du carnet 3 de l'apprenant" ,3,4,28);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 4eme question du carnet 3 de l'apprenant" ,3,4,29);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 5eme question du carnet 3 de l'apprenant" ,3,4,30);

-- carnet 4
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 1ere question du carnet 4 du tuteur" ,4,2,null);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 2eme question du carnet 4 du tuteur" ,4,2,null);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 3eme question du carnet 4 du tuteur" ,4,2,null);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 4eme question du carnet 4 du tuteur" ,4,2,null);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 5eme question du carnet 4 du tuteur" ,4,2,null);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 1ere question du carnet 4 de l'apprenant" ,4,4,null);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 2eme question du carnet 4 de l'apprenant" ,4,4,null);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 3eme question du carnet 4 de l'apprenant" ,4,4,null);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 4eme question du carnet 4 de l'apprenant" ,4,4,null);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 5eme question du carnet 4 de l'apprenant" ,4,4,null);

-- carnet 5
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 1ere question du carnet 5 du tuteur" ,5,2,null);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 2eme question du carnet 5 du tuteur" ,5,2,null);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 3eme question du carnet 5 du tuteur" ,5,2,null);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 4eme question du carnet 5 du tuteur" ,5,2,null);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 5eme question du carnet 5 du tuteur" ,5,2,null);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 1ere question du carnet 5 de l'apprenant" ,5,4,null);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 2eme question du carnet 5 de l'apprenant" ,5,4,null);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 3eme question du carnet 5 de l'apprenant" ,5,4,null);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 4eme question du carnet 5 de l'apprenant" ,5,4,null);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 5eme question du carnet 5 de l'apprenant" ,5,4,null);

-- conclusions

-- carnet 1
INSERT INTO `conclusion` (`content`,`user_id`,`diary_id`) VALUES
("ceci est la conclusion de la session 1 du carnet d'abdel",1,1);
INSERT INTO `conclusion` (`content`,`user_id`,`diary_id`) VALUES
("ceci est la conclusion de la session 1 du carnet de Damien",2,1);

