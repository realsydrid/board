
INSERT INTO users (user_id, user_name, password,phone_no) VALUES
                                          ('test1', '홍길동','a1234','01012345678'),
                                          ('test2', '김철수','a1234','01012123434'),
                                          ('test3', '김영희','a1234','01099997777');


INSERT INTO boards (title, content, user_no,user_name) VALUES
                                                   ('테스트 게시글입니다', '테스트 중입니다.', 1,'홍길동'),
                                                   ('테스트 게시글입니다22', '테스트 중입니다.2222', 2,'김철수'),
                                                   ('테스트 게시글입니다333', '테스트 중입니다.3333', 3,'김영희');