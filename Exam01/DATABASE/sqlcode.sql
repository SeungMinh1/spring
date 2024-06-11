

CREATE TABLE book_tbl_06 (
     book_no number not null primary key,
     book_name varchar2(50) not null,
     book_coverimg varchar2(20),
     book_date date ,
     book_price number,
     book_publisher varchar2(50),
     book_info varchar2(2000)
 );

SELECT book_no
    , book_name
    , book_coverimg
    , book_date
    , book_price
    , book_publisher
    , book_info
FROM book_tbl_06
ORDER BY book_no;


 INSERT INTO book_tbl_06  --100
 (
    book_no
    , book_name
    , book_coverimg
    , book_date
    , book_price
    , book_publisher
    , book_info
 )
 VALUES
 (
    100
    , '리눅스'
    , '100.jpg'
    , '15/09/02'
    , 24000
    , '나룩스'
    , '운영체제, DB기초, 네트워크기초, 개발환경구축'
 );
 
 INSERT INTO book_tbl_06  --101
 (
    book_no
    , book_name
    , book_coverimg
    , book_date
    , book_price
    , book_publisher
    , book_info
 )
 VALUES
 (
    101
    , '자바'
    , '101.jpg'
    , '16/01/10'
    , 20000
    , '이자바'
    , '프로그래밍 언어'
 );
 
  INSERT INTO book_tbl_06  --102
 (
    book_no
    , book_name
    , book_coverimg
    , book_date
    , book_price
    , book_publisher
    , book_info
 )
 VALUES
 (
    102
    , '자바웹프로그래밍'
    , '102.jpg'
    , '16/10/30'
    , 25000
    , '김프로'
    , '개발환경/서버프로그램/배치프로그램'
 );
 
  INSERT INTO book_tbl_06 --103
 (
    book_no
    , book_name
    , book_coverimg
    , book_date
    , book_price
    , book_publisher
    , book_info
 )
 VALUES
 (
    103
    , '오픈소스활용하기'
    , '103.jpg'
    , '17/09/01'
    , 30000
    , '박오픈'
    , '형상관리, 빌드, 배포'
 );
 
  INSERT INTO book_tbl_06 --104
 (
    book_no
    , book_name
    , book_coverimg
    , book_date
    , book_price
    , book_publisher
    , book_info
 )
 VALUES
 (
    104
    , 'HTML'
    , '104.jpg'
    , '18/04/04'
    , 10000
    , '홍길동'
    , 'HTML/CSS/JAVASCRIPT/JQUERY'
 );
 
 
 
 CREATE TABLE rent_tbl_06 (
     rent_no number NOT NULL PRIMARY KEY,
     book_no number NOT NULL,
     rent_price number NOT NULL,
     rent_date date NOT NULL,
     rent_status char(1) DEFAULT '0' NOT NULL
 );
 
 INSERT INTO rent_tbl_06  --10001
 (
    rent_no
    , book_no
    , rent_price
    , rent_date
    ,rent_status
)
VALUES
 (
    10001
    , 100
    , 2400
    , '18/07/02'
    , '1'
 );
 
  INSERT INTO rent_tbl_06  --10002
 (
    rent_no
    , book_no
    , rent_price
    , rent_date
    ,rent_status
)
VALUES
 (
    10002
    , 101
    , 2000
    , '18/07/04'
    , '1'
 );
 
  INSERT INTO rent_tbl_06  --10003
 (
    rent_no
    , book_no
    , rent_price
    , rent_date
    ,rent_status
)
VALUES
 (
    10003
    , 100
    , 2400
    , '18/08/02'
    , '1'
 );
 
  INSERT INTO rent_tbl_06  --10004
 (
    rent_no
    , book_no
    , rent_price
    , rent_date
    ,rent_status
)
VALUES
 (
    10004
    , 100
    , 2400
    , '18/08/12'
    , '1'
 );
 
  INSERT INTO rent_tbl_06  --10005
 (
    rent_no
    , book_no
    , rent_price
    , rent_date
    ,rent_status
)
VALUES
 (
    10005
    , 102
    , 2500
    , '18/08/13'
    , '1'
 );
 
  INSERT INTO rent_tbl_06  --10006
 (
    rent_no
    , book_no
    , rent_price
    , rent_date
    ,rent_status
)
VALUES
 (
    10006
    , 103
    , 3000
    , '18/08/13'
    , '1'
 );
 
   INSERT INTO rent_tbl_06  --10007
 (
    rent_no
    , book_no
    , rent_price
    , rent_date
    ,rent_status
)
VALUES
 (
    10007
    , 103
    , 3000
    , '18/08/20'
    , '0'
 );
 
   INSERT INTO rent_tbl_06  --10008
 (
    rent_no
    , book_no
    , rent_price
    , rent_date
    ,rent_status
)
VALUES
 (
    10008
    , 100
    , 2400
    , '18/09/03'
    , '1'
 );
 
INSERT INTO rent_tbl_06  --10009
 (
    rent_no
    , book_no
    , rent_price
    , rent_date
    ,rent_status
)
VALUES
 (
    10009
    , 100
    , 2400
    , '18/09/08'
    , '1'
 );
 
INSERT INTO rent_tbl_06  --10010
 (
    rent_no
    , book_no
    , rent_price
    , rent_date
    ,rent_status
)
VALUES
 (
    10010
    , 100
    , 2400
    , '18/09/14'
    , '0'
 );
 
 INSERT INTO rent_tbl_06  --10011
 (
    rent_no
    , book_no
    , rent_price
    , rent_date
    ,rent_status
)
VALUES
 (
    10011
    , 102
    , 2500
    , '18/09/14'
    , '0'
 );
 
 SELECT *
 FROM rent_tbl_06;
 
 commit;
 

drop table rent_tbl_06;

 
SELECT book_no as 도서번호, (SELECT book_name FROM book_tbl_06 b WHERE b.book_no = r.book_no)as 도서명, SUM(rent_price) as 대여총계, COUNT(1) as 대여횟수
FROM rent_tbl_06 r GROUP BY book_no ORDER BY book_no;
