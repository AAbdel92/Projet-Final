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
-- rajouter les pairs pour les apprenants
UPDATE `user` SET `pair_id`=5 WHERE `id`=1;
UPDATE `user` SET `pair_id`=6 WHERE `id`=2;
-- administrateur
INSERT INTO `user` (`firstname`,`lastname`, `password`,`email`,`pair_id`,`role_id`,`promo_id` ) VALUES
('laeticia', 'dupont7', 'azerty', 'laeticia@simplon.co', null, 3, null);

-- answer
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 1 du tuteur d'abdel",5);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 2 du tuteur d'abdel",5);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 3 du tuteur d'abdel",5);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 4 du tuteur d'abdel",5);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 5 du tuteur d'abdel",5);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 1 d'abdel",1);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 2 d'abdel",1);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 3 d'abdel",1);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 4 d'abdel",1);
INSERT INTO `answer` (`content`,`user_id`) VALUES
("ceci est la  reponse 5 d'abdel",1);

-- question
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 1ere question du tuteur" ,1,2,1);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 2eme question du tuteur" ,1,2,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 3eme question du tuteur" ,1,2,3);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 4eme question du tuteur" ,1,2,4);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 5eme question du tuteur" ,1,2,5);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 1ere question de l'apprenant" ,1,4,6);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 2eme question de l'apprenant" ,1,4,7);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 3eme question de l'apprenant" ,1,4,8);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 4eme question de l'apprenant" ,1,4,9);
INSERT INTO `question` (`content`,`diary_id`,`role_id`,`answer_id`) VALUES
("Ceci sera la 5eme question de l'apprenant" ,1,4,10);

-- conclusion
INSERT INTO `conclusion` (`content`,`user_id`,`diary_id`) VALUES
("ceci est la conclusion de la session 1 du carnet d'abdel",1,1);

