
-- database for whole game.
create database word_scrumble;
use word_scrumble;


-- table to store users information
create table user_account(
    id int(100) auto_increment,
    username varchar(100) unique, 
    primary key(id));


-- In addition to that, we will have this two tables 
    -- table to store words prepared for game, and
    -- table to store users progress in a game that linked to their account.

    