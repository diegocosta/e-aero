INSERT INTO `companies` (`name`, `document`) VALUES ('Aerolito', '11001100111');

INSERT INTO `itineraries` (`code`,`departure`,`destination`,`duration`) VALUES ('SSASP','Salvador','São Paulo',300);
INSERT INTO `itineraries` (`code`,`departure`,`destination`,`duration`) VALUES ('SSAMA','Salvador','Manaus',500);
INSERT INTO `itineraries` (`code`,`departure`,`destination`,`duration`) VALUES ('SSARJ','Salvador','Rio de Janeiro',120);
INSERT INTO `itineraries` (`code`,`departure`,`destination`,`duration`) VALUES ('SPSSA','São Paulo','Salvador',120);
INSERT INTO `itineraries` (`code`,`departure`,`destination`,`duration`) VALUES ('MASSA','Manaus','Salvador',500);
INSERT INTO `itineraries` (`code`,`departure`,`destination`,`duration`) VALUES ('RJSSA','Rio de Janeiro','Salvador',120);

INSERT INTO `flights_routines` (`days`) VALUES ('Segundas');
INSERT INTO `flights_routines` (`days`) VALUES ('Terças');
INSERT INTO `flights_routines` (`days`) VALUES ('Quartas');
INSERT INTO `flights_routines` (`days`) VALUES ('Quintas');
INSERT INTO `flights_routines` (`days`) VALUES ('Sextas');
INSERT INTO `flights_routines` (`days`) VALUES ('Sábados');
INSERT INTO `flights_routines` (`days`) VALUES ('Domingos');
INSERT INTO `flights_routines` (`days`) VALUES ('Finais de Semana');
INSERT INTO `flights_routines` (`days`) VALUES ('Dias Úteis');

INSERT INTO `payments_methods` (`label`) VALUES ('Dinheiro');
INSERT INTO `payments_methods` (`label`) VALUES ('Pontos');

INSERT INTO `payments_statuses` (`label`) VALUES ('Pendente');
INSERT INTO `payments_statuses` (`label`) VALUES ('Pago');

INSERT INTO `notes_categories` (label) VALUES ('Geral');
INSERT INTO `notes_categories` (label) VALUES ('Alimentação');
INSERT INTO `notes_categories` (label) VALUES ('Atendimento');
INSERT INTO `notes_categories` (label) VALUES ('Reserva de Cadeira');