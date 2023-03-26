create table passenger
(
    id              int         not null auto_increment,
    first_name      varchar(40) not null,
    sur_name        varchar(40) not null,
    dob             varchar(40) not null,
    sex             varchar(40) not null,
    passport_number varchar(40) not null,
    primary key (id)
);

create table city
(
    id      int          not null auto_increment,
    title   varchar(256) not null,
    country varchar(256) not null,
    primary key (id)
);

create table plane
(
    id              int          not null auto_increment,
    model           varchar(256) not null,
    manufacturer    varchar(256) not null,
    number_of_seats int          not null,
    primary key (id)
);

create table crew
(
    id         int          not null auto_increment,
    first_name varchar(40)  not null,
    sur_name   varchar(40)  not null,
    post       varchar(256) not null,
    plane_id   int          not null,
    primary key (id),
    FOREIGN KEY (plane_id) REFERENCES plane (id)
);

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

create table orders
(
    id           int          not null auto_increment,
    number_order int          not null,
    date_order   varchar(256) not null,
    status_order bit          not null,
    route_id     int          not null,
    plane_id     int          not null,
    passenger_id int          not null,
    primary key (id),
    FOREIGN KEY (route_id) REFERENCES route (id),
    FOREIGN KEY (plane_id) REFERENCES plane (id),
    FOREIGN KEY (passenger_id) REFERENCES passenger (id)
);

create table payment
(
    id             int not null auto_increment,
    status_payment bit not null,
    orders_id      int not null,
    primary key (id),
    FOREIGN KEY (orders_id) REFERENCES orders (id)
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
