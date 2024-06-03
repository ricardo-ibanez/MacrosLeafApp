# ProyectoComunJava

Para ejecutar el proyecto debes crear una base de datos en MySQL Work Bench "Te dejo el Script aqui debajo":
Asegurate de configurar el puerto 3306 en la conexión o cambiar la clase Conexion dentro del proyecto Java, para enlazar bien el loclahost con la bbdd.

-- SCRIPT

CREATE DATABASE IF NOT EXISTS macrosleaf ;
USE macrosleaf;

DROP TABLE IF EXISTS alimento;
CREATE TABLE alimento (
  id int NOT NULL AUTO_INCREMENT,
  nombre varchar(255) NOT NULL,
  calorias int NOT NULL,
  grasas decimal(5,2) DEFAULT NULL,
  hidratos decimal(5,2) DEFAULT NULL,
  proteinas int DEFAULT NULL,
  id_usuario int DEFAULT NULL,
  PRIMARY KEY (id),
  KEY fk_usuario (id_usuario),
  CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios (id)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS dia;
CREATE TABLE dia (
  id int NOT NULL AUTO_INCREMENT,
  id_usuario int DEFAULT NULL,
  gramos decimal(10,2) DEFAULT NULL,
  proteinas decimal(10,2) DEFAULT NULL,
  hidratos decimal(10,2) DEFAULT NULL,
  grasas decimal(10,2) DEFAULT NULL,
  calorias decimal(10,2) DEFAULT NULL,
  fecha date DEFAULT NULL,
  nombre varchar(25) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY id_usuario (id_usuario),
  CONSTRAINT dia_ibfk_1 FOREIGN KEY (id_usuario) REFERENCES usuarios (id)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS receta;
CREATE TABLE receta (
  id int NOT NULL AUTO_INCREMENT,
  nombre varchar(255) NOT NULL,
  calorias int NOT NULL,
  grasas decimal(5,2) DEFAULT NULL,
  hidratos decimal(5,2) DEFAULT NULL,
  gramos int DEFAULT NULL,
  proteina int DEFAULT NULL,
  id_usuario int DEFAULT NULL,
  PRIMARY KEY (id),
  KEY id_usuario_fk (id_usuario),
  CONSTRAINT id_usuario_fk FOREIGN KEY (id_usuario) REFERENCES usuarios (id)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS receta_alimento;
CREATE TABLE receta_alimento (
  receta_id int NOT NULL,
  alimento_id int NOT NULL,
  PRIMARY KEY (receta_id,alimento_id),
  KEY alimento_id (alimento_id),
  CONSTRAINT receta_alimento_ibfk_1 FOREIGN KEY (receta_id) REFERENCES receta (id) ON DELETE CASCADE,
  CONSTRAINT receta_alimento_ibfk_2 FOREIGN KEY (alimento_id) REFERENCES alimento (id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS usuarios;
CREATE TABLE usuarios (
  id int NOT NULL AUTO_INCREMENT,
  nombre varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  contraseña varchar(255) NOT NULL,
  altura int DEFAULT NULL,
  peso int DEFAULT NULL,
  objetivo int NOT NULL,
  Sexo varchar(20) DEFAULT NULL,
  pesoActual int DEFAULT NULL,
  edad int DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY email (email)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

