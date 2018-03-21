create table if not exists `title_type` (
   `id` int unsigned not null auto_increment,
   `name` varchar(64),

   primary key (`id`)
);

create table if not exists `title_basics` (
   `id` int unsigned not null auto_increment,
   `title_type_id` varchar(128) not null,
   `primary_title` varchar(128),
   `original_title` varchar(128),
   `is_adult` bit(1) not null,
   `start_year` int unsigned,
   `end_year` int unsigned,
   `runtime_minutes` int unsigned,

   primary key (`id`)
);

create table if not exists `genre` (
   `id` int unsigned not null auto_increment,
   `genre` varchar(32) not null,

   primary key (`id`)
);

create table if not exists `title_genre` (
   `id` int unsigned not null auto_increment,
   `title_id` int unsigned not null,
   `genre_id` int unsigned not null,

   foreign key (`title_id`) references `title_basics` (`id`)
      on update cascade
      on delete cascade,

   foreign key (`genre_id`) references `genre` (`id`)
      on update cascade
      on delete cascade,

   primary key (`id`)
);

create table if not exists `title_crew` (
   `id` int unsigned not null auto_increment,
   
   primary key (`id`)
);

create table if not exists `crew_director` (
   `id` int unsigned not null auto_increment,
   `title_crew_id` int unsigned not null,
   `name` varchar(64) not null,

   foreign key (`title_crew_id`) references `title_crew` (`id`)
      on update cascade
      on delete cascade,

   primary key (`id`)
);

create table if not exists `crew_writer` (
   `id` int unsigned not null auto_increment,
   `title_crew_id` int unsigned not null,
   `name` varchar(64) not null,

   foreign key (`title_crew_id`) references `title_crew` (`id`)
      on update cascade
      on delete cascade,

   primary key (`id`)
);
create table if not exists `title_episode` (
   `id` int unsigned not null auto_increment,
   `title_id` int unsigned not null,
   `season_number` int unsigned,
   `episode_number` int unsigned,

   foreign key (`title_id`) references `title_basics` (`id`)
      on update cascade
      on delete cascade,

   primary key (`id`)
);

create table if not exists `title_principal` (
   `id` int unsigned not null auto_increment,
   
   primary key (`id`)
);

create table if not exists `title_rating` (
   `id` int unsigned not null auto_increment,
   `average` float(2,2),
   `votes` int unsigned,

   primary key (`id`)
);

create table if not exists `name_basics` (
   `id` int unsigned not null auto_increment,
   `primary_name` varchar(128),
   `birth_year`  int unsigned,
   `death_year` int unsigned,

   primary key (`id`)
);

create table if not exists `name_basics_profession` (
   `id` int unsigned not null auto_increment,
   `profession` varchar(128) not null,
   
   primary key (`id`)
);

create table if not exists `name_basics_title` (
   `id` int unsigned not null auto_increment,
   `title_id` int unsigned not null,

   foreign key (`title_id`) references `title_basics` (`id`)
      on update cascade
      on delete cascade,

   primary key (`id`)
);
