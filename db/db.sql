create table t_demo
(
    id   bigserial not null,
    name varchar(20),
    age  integer
        constraint check_age
            check ((age >= 18) AND (age <= 60))
);


create table t_user
(
    id        bigserial                                         not null,
    nick_name varchar(20)                                       not null,
    user_name varchar(20)                                       not null,
    user_pwd  varchar(50)                                       not null
);


create unique index t_user_name_uindex
    on t_user (user_name);