insert into passenger (id, first_name, sur_name, dob, sex, passport_number)
values
    (1, 'Ivan', 'Ivanov', '25.10.1983', 'male', 'HB6523882'),
    (2, 'Anna', 'Semenova', '22.12.1989', 'female', 'HB353567'),
    (3, 'Alex', 'Egorov', '15.04.1994', 'male', 'HB464667'),
    (4, 'Evgen', 'Kolos', '18.03.1981', 'male', 'HB5464667'),
    (5, 'Olga', 'Kukushkina', '25.06.1998', 'female', 'HB353567');

insert into city (id, title, country)
VALUES
    (1, 'Moscow', 'Russia'),
    (2, 'Minsk', 'Belarus'),
    (3, 'Warsaw', 'Poland'),
    (4, 'Berlin', 'Germany'),
    (5, 'Sochi', 'Russia');

insert into plane (id, model, manufacturer, number_of_seats)
VALUES
(1, 'Boeing 737-8', 'Boeing, USA', 174),
(2, 'Embraer 195', 'Embraer , Brazil', 107),
(3, 'Boeing 737-300', 'Boeing, USA', 148);

insert into crew (id, first_name, sur_name, post, plane_id)
VALUES
    (1, 'Victor', 'Shadrin','Pilot',1),
    (2, 'Sergey', 'Doronin','Pilot-1',1),
    (3, 'Fedor', 'Chepcov','Pilot-2',1),
    (4, 'Artem', 'Efreev','Engineer',1),
    (5, 'Anna', 'Subot','stewardes',1),
    (5, 'Elena', 'Gerasimova','stewardes',1);



/**
  Заполнение таблиц
 */
create table route
(
    id                int              not null auto_increment,
    title             varchar(256)     not null,
    arrival_date_time varchar(256)     not null,
    duration          DOUBLE PRECISION not null,
    departure_city_id int              not null,
    arrival_city_id   int              not null,
    primary key (id),
    FOREIGN KEY (departure_city_id) REFERENCES city (id),
    FOREIGN KEY (arrival_city_id) REFERENCES city (id)
);

create table plane_route
(
    id       int not null auto_increment,
    plane_id int not null,
    route_id int not null,
    primary key (id),
    FOREIGN KEY (plane_id) REFERENCES plane (id),
    FOREIGN KEY (route_id) REFERENCES route (id)
);

create table order_status
(
    id           int         not null auto_increment,
    status_order varchar(80) not null,
    primary key (id)
);


create table orders
(
    id              int          not null auto_increment,
    number_order    int          not null,
    date_order      varchar(256) not null,
    route_id        int          not null,
    plane_id        int          not null,
    passenger_id    int          not null,
    order_status_id int          not null,
    primary key (id),
    FOREIGN KEY (route_id) REFERENCES route (id),
    FOREIGN KEY (plane_id) REFERENCES plane (id),
    FOREIGN KEY (passenger_id) REFERENCES passenger (id),
    FOREIGN KEY (order_status_id) REFERENCES order_status (id)
);

create table payment_status
(
    id             int         not null auto_increment,
    status_payment varchar(80) not null,
    primary key (id)

);

create table payment
(
    id                int not null auto_increment,
    status_payment    bit not null,
    orders_id         int not null,
    payment_status_id int not null,
    primary key (id),
    FOREIGN KEY (orders_id) REFERENCES orders (id),
    FOREIGN KEY (payment_status_id) REFERENCES payment_status (id)
);



create table ticket
(
    id           int              not null auto_increment,
    number_order int              not null,
    number_place int              not null,
    cost_place   double precision not null,
    orders_id    int              not null,
    primary key (id),
    FOREIGN KEY (orders_id) REFERENCES orders (id)
);











