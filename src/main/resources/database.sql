
mvn archetype:generate -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false -DgroupId=com.hdy -DartifactId=springmvc-mybatis-rest

/*Create DATABASE db1;
USE db1;
*/
DROP TABLE IF EXISTS t_usermx;
CREATE TABLE t_usermx (
  user_id int NOT NULL auto_increment,
  user_name varchar(128) DEFAULT NULL,
  user_sex int(4),
  user_birthday date DEFAULT NULL,
  user_salary double DEFAULT NULL,
  user_other blob DEFAULT NULL,
  PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
