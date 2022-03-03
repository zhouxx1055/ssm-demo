create schema `ssmdemo` default character set utf8 collate utf8_bin ;

use ssmdemo;

drop table if exists `sys_user`;
create table `sys_user` (
  `id` bigint(11) not null auto_increment,
  `user_name` varchar(32) not null default '' comment '用户名',
  `user_pwd` varchar(32) not null default '' comment '加盐后用户密码',
  `user_phone` varchar(20) not null default '' comment '手机号',
  `user_email` varchar(100) default '' comment '邮箱地址',
  `user_sex` tinyint(4) not null default 0 comment '性别，0-男；1-女',
  `create_time` timestamp  not null default CURRENT_TIMESTAMP comment '创建时间',
  `update_time` timestamp  not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '最后修改时间',
  `delete_flag` tinyint(4)  not null default 0 comment '是否删除，0-未删除；1-已删除',
  primary key (`id`)
) engine=innodb  default charset=utf8 comment='用户表';

insert into `sys_user`(`user_name`,`user_pwd`,`user_phone`,`user_email`,`user_sex`)
values ('root','123456123','13112341234','',0),('zhouxx','123456123','13112341234','',0);

