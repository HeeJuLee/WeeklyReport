create table tbl_reply (
	rno INT NOT NULL AUTO_INCREMENT,
	bno INT NOT NULL,
	replytext VARCHAR(1000) NOT NULL,
	replyer VARCHAR(50) NOT NULL,
	regdate TIMESTAMP NOT NULL DEFAULT now(),
	updatedate TIMESTAMP NOT NULL DEFAULT now(),
	PRIMARY KEY (rno)
);

alter table tbl_reply add constraint tbl_board
foreign key (bno) references tbl_board (bno);

insert into tbl_reply (bno, replytext, replyer)
values (1, '댓글입니다', 'user00');

select * 
from tbl_reply 
where bno = 1;

update tbl_reply
set title = '수정된 댓글'
where rno = 1;

delete from tbl_reply
where rno = 1;



