INSERT INTO category(id, name, category_id, create_at, update_at) VALUES(1, 'ACCIÓN', 'COD1', now(), now())
INSERT INTO category(id, name, category_id, create_at, update_at) VALUES(2, 'AVENTURA', 'COD2', now(), now())
INSERT INTO category(id, name, category_id, create_at, update_at) VALUES(3, 'CIENCIA FICCIÓN', 'COD3', now(), now())
INSERT INTO category(id, name, category_id, create_at, update_at) VALUES(4, 'TERROR', 'COD4', now(), now())

INSERT INTO director(id, name, director_id, create_at, update_at) VALUES(1, 'ADAM SANDLER', 'COD1', now(), now())
INSERT INTO director(id, name, director_id, create_at, update_at) VALUES(2, 'LEONARDO DICAPRIO', 'COD2', now(), now())
INSERT INTO director(id, name, director_id, create_at, update_at) VALUES(3, 'WILL SMITH', 'COD3', now(), now())

INSERT INTO movie(id, name, movie_id, create_at, update_at) VALUES(1, 'RESIDENT EVIL', 'COD1', now(), now())
INSERT INTO movie(id, name, movie_id, create_at, update_at) VALUES(2, 'BOLOCHO', 'COD2', now(), now())

INSERT INTO movie_category(movie_id, category_id) VALUES(1, 1)
INSERT INTO movie_category(movie_id, category_id) VALUES(1, 3)
INSERT INTO movie_category(movie_id, category_id) VALUES(2, 1)
INSERT INTO movie_category(movie_id, category_id) VALUES(2, 2)

INSERT INTO movie_director(movie_id, director_id) VALUES(1, 2)
INSERT INTO movie_director(movie_id, director_id) VALUES(1, 3)
INSERT INTO movie_director(movie_id, director_id) VALUES(2, 1)
INSERT INTO movie_director(movie_id, director_id) VALUES(2, 2)
INSERT INTO movie_director(movie_id, director_id) VALUES(2, 3)
