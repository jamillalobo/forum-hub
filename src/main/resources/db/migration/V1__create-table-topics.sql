create table topics (
    id bigint not null auto_increment,
    title varchar(255) not null,
    message text not null,
    creation_date datetime not null,
    topic_status varchar(50) not null,
    author varchar(255) not null,
    course varchar(255) not null,

    primary key(id)
);
