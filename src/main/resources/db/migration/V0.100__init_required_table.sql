CREATE TABLE cms_user (
  user_id int not null AUTO_INCREMENT,
  username varchar(255) not null unique,
  password varchar(255) not null,
  full_name varchar(255) not null,
  role_type smallint not null,
  is_available boolean default true not null,
  created_by int,
  created_at timestamp default CURRENT_TIMESTAMP not null,
  updated_by int,
  updated_at timestamp default CURRENT_TIMESTAMP not null,
  is_verify_email boolean default false not null,
   primary key (user_id)
);
INSERT INTO cms_user (user_id, username, password, full_name, role_type, is_available, created_by, updated_by, is_verify_email)
VALUES(1, 'root@cms.com', '$2a$12$cBAry4ODNW6s8Koyqr8fyuy0JHj/GW8oRpPvfNknjX9miL652vRFe', 'Root', 1, 1, 1, 1, 1);
CREATE TABLE cms_category (
  category_id int not null AUTO_INCREMENT,
  parent_id int,
  key_name varchar(255) not null unique,
  order_number int,
  is_available boolean default true not null,
  is_public boolean default true not null,
  created_by int,
  created_at timestamp default CURRENT_TIMESTAMP not null,
  updated_by int,
  updated_at timestamp default CURRENT_TIMESTAMP not null,
  primary key (category_id)
);
CREATE TABLE cms_category_ml (
  category_id int references cms_category,
  language_code varchar(5) not null,
  header text,
  title text,
  text text,
  primary key (category_id, language_code)
);
CREATE TABLE cms_content (
  content_id int not null AUTO_INCREMENT,
  category_id int references cms_category,
  parent_id int,
  order_number int,
  is_available boolean default true not null,
  is_public boolean default true not null,
  end_date date,
  created_by int, created_at timestamp default CURRENT_TIMESTAMP not null,
  updated_by int, updated_at timestamp default CURRENT_TIMESTAMP not null,
  primary key (content_id)
);
CREATE TABLE cms_content_ml (
  content_id int references cms_content_blog,
  language_code varchar(5) not null,
  title text,
  content text,
  primary key (content_id, language_code)
);
CREATE TABLE cms_resource (
  resource_id int not null AUTO_INCREMENT,
  is_available boolean default true not null,
  path text,
  type varchar(255),
  created_by int,
  created_at timestamp default CURRENT_TIMESTAMP not null,
  primary key (resource_id)
);
CREATE TABLE cms_content_resource (
  content_id int references cms_content,
  resource_id int references cms_resource,
  is_available boolean default true not null,
  primary key (content_id, resource_id)
);
CREATE TABLE cms_customer (
  customer_id int not null AUTO_INCREMENT,
  full_name varchar(255),
  phone_number varchar(20),
  email varchar(255),
  shop_name varchar(255),
  request text,
  is_synced boolean default false not null,
  is_available boolean default true not null,
  created_by int,
  created_at timestamp default CURRENT_TIMESTAMP not null,
  updated_by int,
  updated_at timestamp default CURRENT_TIMESTAMP not null,
  primary key (customer_id)
);
