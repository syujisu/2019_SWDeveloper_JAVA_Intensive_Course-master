## 제주에서 자바한잔

3조 프로젝트 YOUR Line

1. ERD - 기초

- USER : USERNO(PK) / ID / PW / 이름 / 이메일 / 닉네임 / 보유 포인트 / 등급(랭크) / 성별

```sql
CREATE TABLE USERT(
	USERNO NUMBER(10, 0) NOT NULL
    ,ID VARCHAR2(50 BYTE) NOT NULL
    ,PW VARCHAR2(21 BYTE) NOT NULL
    ,PHONE VARCHAR2(20 BYTE) NOT NULL
    ,NICKNAME VARCHAR2(20 BYTE) NOT NULL
    ,POINT NUMBER(10, 0) DEFAULT 0 NOT NULL
    ,GRADE NUMBER(10, 0) DEFAULT 1000 NOT NULL
    ,SEX NUMBER(1,0) NOT NULL
    ,NAME VARCHAR2(20 BYTE) NOT NULL
    ,CONSTRAINT USERT_PK PRIMARY KEY
        (
        USERNO 
        )
)

COMMENT ON COLUMN USERT.USERNO IS '회원 번호';
COMMENT ON COLUMN USERT.ID IS '아이디(이메일형식)';
COMMENT ON COLUMN USERT.PW IS '비밀번호';
COMMENT ON COLUMN USERT.PHONE IS '전화번호';
COMMENT ON COLUMN USERT.NICKNAME IS '닉네임';
COMMENT ON COLUMN USERT.POINT IS '보유한 포인트';
COMMENT ON COLUMN USERT.GRADE IS '점수';
COMMENT ON COLUMN USERT.SEX IS '성별';
COMMENT ON COLUMN USERT.NAME IS '이름';
```



```sql
ALTER TABLE USERT
ADD CONSTRAINT UNIQ_USERID UNIQUE(
	ID
)
```

-중복을 허용하지 않지만 널 값 중복은 가능



- POST : POSTNO(PK) / 제목 / 지역 (제주, 서귀포) / 작성일 / 내용(요구사항) / 제안 포인트 
               진행 상태 / 대행 날짜 / 게시글 유효 시간

```sql
CREATE TABLE POSTT(
	POSTNO NUMBER NOT NULL
    ,TITLE VARCHAR2(60 BYTE) NOT NULL
    ,REGION NUMBER(NOT NULL)
    ,POSTINGDATE VARCHAR2(20 BYTE) NOT NULL
    ,CONTENTS VARCHAR2(2000 BYTE)
    ,B_HOPEFULPOINT NUMBER NOT NULL
    ,STATE NUMBER NOT NULL
    ,REQUESTTIME VARCHAR2(20 BYTE) NOT NULL
    ,HOWMUCH VARCHAR2(20 BYTE) NOT NULL
    ,USERNO NUMBER NOT NULL
    ,CONSTRAINT POST_PK PRIMARY KEY
        (
        POSTNO 
      	)
)

COMMENT ON COLUMN POSTT.POSTNO IS '게시물 번호';
COMMENT ON COLUMN POSTT.TITLE IS '제목';
COMMENT ON COLUMN POSTT.REGION IS '서귀포시or제주시';
COMMENT ON COLUMN POSTT.POSTINGDATE IS ' 게시물작성날짜';
COMMENT ON COLUMN POSTT.CONTENTS IS '게시물내용';
COMMENT ON COLUMN POSTT.B_HOPEFULPOINT IS 'buyer희망 포인트 ';
COMMENT ON COLUMN POSTT.STATE IS '진행상태';
COMMENT ON COLUMN POSTT.REQUESTTIME IS '부탁시간';
COMMENT ON COLUMN POSTT.HOWMUCH IS '부탁 시간 이후 얼마나 기다려야하는지';
COMMENT ON COLUMN POSTT.USERNO IS '회원 번호';
```



```sql
ALTER TABLE POSTT
ADD CONSTRAINT FK_POSTT_USERNO FOREIGN KEY
(
  USERNO 
)
REFERENCES USERT
(
  USERNO 
)
ENABLE;
```



- PAYCORDT : PAYNO(PK) / 결제 금액 / 결제일 -USER와 결제하다로 (1대N관계)

```sql
CREATE TABLE PAYRECORDT 
(
  PAYNO NUMBER NOT NULL 
, PAYAMOUNT NUMBER NOT NULL 
, PAYDATE VARCHAR2(20 BYTE) NOT NULL 
, USERNO NUMBER NOT NULL 
, CONSTRAINT PAYRECORDT_PK PRIMARY KEY 
  (
    PAYNO 
  )
)

COMMENT ON COLUMN PAYRECORDT.PAYNO IS '결제번호';
COMMENT ON COLUMN PAYRECORDT.PAYAMOUNT IS '결제금액';
COMMENT ON COLUMN PAYRECORDT.PAYDATE IS '결제일';
COMMENT ON COLUMN PAYRECORDT.USERNO IS '회원 번호';
```

```sql
ALTER TABLE PAYRECORDT
ADD CONSTRAINT FK_PAYRECORD_USERNO FOREIGN KEY
(
	USERNO
)
REFERENCES USERT
(
	USERNO
);
```



- COMMENT : COMMENTNO(PK) / 작성일 / 내용 / 선택 여부 / 요구 포인트 

```sql
CREATE TABLE COMMENTT 
(
  COMMENTNO NUMBER NOT NULL 
, WDATE VARCHAR2(20 BYTE) NOT NULL 
, CONTENTS VARCHAR2(1000 BYTE) NOT NULL 
, SELECTED NUMBER DEFAULT 0 NOT NULL 
, H_HOPEFULPOINT NUMBER NOT NULL 
, USERNO NUMBER NOT NULL 
, POSTNO NUMBER NOT NULL 
, CONSTRAINT COMMENTT_PK PRIMARY KEY 
  (
    COMMENTNO 
  )
)

COMMENT ON COLUMN COMMENTT.COMMENTNO IS '댓글번호';
COMMENT ON COLUMN COMMENTT.WDATE IS '댓글작성날짜';
COMMENT ON COLUMN COMMENTT.CONTENTS IS '댓글내용';
COMMENT ON COLUMN COMMENTT.SELECTED IS '선택되었는지구분';
COMMENT ON COLUMN COMMENTT.H_HOPEFULPOINT IS 'helper희망 포인트';
COMMENT ON COLUMN COMMENTT.USERNO IS '회원 번호';
COMMENT ON COLUMN COMMENTT.POSTNO IS '게시물 번호';
```

```sql
ALTER TABLE COMMENTT
ADD CONSTRAINT FK_COMMENT_POSTNO FOREIGN KEY
(
  POSTNO 
)
REFERENCES POSTT
(
  POSTNO 
)
ENABLE;

ALTER TABLE COMMENTT
ADD CONSTRAINT FK_COMMENT_USERNO FOREIGN KEY
(
  USERNO 
)
REFERENCES USERT
(
  USERNO 
)
ENABLE;
```

- 진행이 끝난 게시글 기록 보관소 
  - 필요한 이유  : 백업용 / 게시글 테이블을 가볍게 하기 위해
  - 용도 : 유효 시간이 지나거나 대행 절차가 끝난 것들에 대한 것을 기록
- 시퀀스 생성

```sql
CREATE SEQUENCE seq_userno;
CREATE SEQUENCE seq_postno;
CREATE SEQUENCE seq_commentno;
CREATE SEQUENCE sqe_payno;

```

2. DAO / DO / ROWMAPPER 

###### JSP는 컴파일시 자바로 변환 -> 서블릿 형태로 바꿔줌 그래서 JSP 사용 

<알아둬야 할 문법>

> DAO는?

- DB 질의를 통해 데이터에 접근하는 객체 / 한 테이블 당 - 한 개씩 만들면 쉬움
- DB와 JDBC를 연결 -> CONNECTION 생성
  - CONNECTION  생성 방법 (이클립스에서 JDBC 등록 -> conn 객체 생성 - >
    Statement로 객체 생성(질의 수행) -> 질의 결과를 Resultset 에 저장
    -> 추가적인 로직 후 close)
- 화면 정보를 VO 객체로 받아 INSERT 쿼리 작성 

###### ex) USERT - USERDAO / POSTT - POSTDAO



> VO는?

- DB 한 테이블에 존재하는 칼럼을 멤버 변수로 작성, 테이블 컬럼 값을 객체로 다루기 위해 사용
- getter / setter : 변수 private를 getXX setXX 메서드로 만들어서 와리가리
  -> 매개변수로 가져와 return 에 값 집어넣기

###### ex) USERT - USERVO - ID / NAME / PHONE  ===>> GETTER / SETTER



<RowMapper.java>

```java
package com.urline.template;

import java.sql.ResultSet;

public interface RowMapper<T extends Object> {
	public T mapRow(ResultSet rs) throws Exception;
}//rowmapper 인스턴스를 생성해 resultset의 변수인 rs에 예외는 던지고 담는다

```



<JdbcTemplate.java>

```java
package com.urline.template;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.plaf.synth.SynthSeparatorUI;

public class JdbcTemplate {
    static {
        try {//오라클 연결
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection makeConn() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/XE", "TEST", "TEST");
        //소켓을 이용해서 접속한다 -> db 연결
        //connection 객체 생성
        return conn;
    }

    public int update(String sql, Object... args) throws Exception {
        int rc = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        /*preparedStatement와 사용해야하는 경우
        * 1. 사용자의 입력값으로 쿼리를 생성할 때
        * 2. 쿼리 반복 수행 작업일 경우(오라클의 경우 db 서버에 미리 준비된
        * SQL을 사용하게 되고 파싱과정을 생략하기 때문에 DB 리소스를 효율적으로 사용
        * => DB마다 SQL 캐싱할 수 있는 한계가 있기 떄문에 필요한 문장만 사용한다 .
        *
        * <Statement>

            1. 단일로 사용될 때 빠른 속도를 지닙니다.
            2. 쿼리에 인자를 부여할 수 없습니다.
            3. 매번 컴파일을 수행해야 합니다.

           <PreparedStatement>

            1. 쿼리에 인자를 부여할 수 있습니다.
            2. 처음 프리컴파일 된 후, 이후에는 컴파일을 수행하지 않습니다.
            3. 여러번 수행될 때 빠른 속도를 지닙니다.


        *
        * */
        try {
            // 커넥션 연결
            conn = makeConn();

            // 자동 커밋을 false로 한다.
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(sql);

            makingStatement(stmt, args);
            rc = stmt.executeUpdate();

            conn.commit(); //테이블에 올려버린다.

        } catch (ClassNotFoundException | NamingException | SQLException sqle){
            conn.rollback();
            //에러가 나면 앞에 있는 것도 몽땅 다 롤백
            //로그를 그냥 비운다 -> 테이블에 반영되지 않는다
            throw new RuntimeException(sqle.getMessage());
        } finally {
            // Connection, PreparedStatement를 닫는다.
            closer(conn, stmt);
        }
        return rc;
    }

    public static void closer(Connection conn, PreparedStatement stmt) {
        try{
            if ( stmt != null ){ stmt.close(); stmt=null; }
            if ( conn != null ){ conn.close(); conn=null; }
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    //객체를 statement로 받아오려 -> 배열 형태로 가져온다.
    private void makingStatement(PreparedStatement stmt, Object[] args) throws SQLException {
        for (int i = 0; i < args.length; i++) {
            if (args[i] == null) {
                stmt.setObject(i + 1, null);
            } else if (args[i] instanceof Integer) {
                //인트값으로 형변환
                stmt.setInt(i + 1, ((Integer) args[i]).intValue());
            } else if (args[i] instanceof Double) {
                stmt.setDouble(i + 1, ((Double) args[i]).doubleValue());
            } else if (args[i] instanceof String) {
                stmt.setString(i + 1, (String) args[i]);
            }
        }
    }

    public <T extends Object> T queryForObject(String sql, RowMapper<T> rowMapper, Object... args) throws Exception {
        //query에 객체를 row 한개만 가져오는 것
        T vo = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = makeConn();
            stmt = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]);
            }
            makingStatement(stmt, args);
            rs = stmt.executeQuery();
            //SQL 질의 겨과를 RESULTSET에 저장하기 위해

            if (rs.next()) {//결과가 1개 인 경우
                vo = rowMapper.mapRow(rs);
                if (rs.next()) {
                    throw new Exception("many records");
                }
            } else {
                throw new Exception("no record");
            }
            return vo;
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        }
    }

    public <T extends Object> List<T> query(String sql, RowMapper<T> rowMapper, Object... args) throws Exception {
        //query의 객체 전부를 리스트화해서 가져옴
        /*자료형을 가변적으로 사용할 떄 사용
        query라는 함수를 사용해 그 안의 객체를 자유롭게  받아오기 위해 제네릭 사용

         DB에 담겨있는 것을 리스트화 시키는데 안에 있는 객체 값을 가변적으로 받기 위해*/
        List<T> rl = new ArrayList<T>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = makeConn();
            stmt = conn.prepareStatement(sql);

            makingStatement(stmt, args);

            rs = stmt.executeQuery();
            while (rs.next()) {
                T vo = rowMapper.mapRow(rs);
                rl.add(vo);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        }
        return rl;
    }

}

```

<b>User


1. USERDAO.java

```JAVA
package com.urline.dao;

import com.urline.rowMapper.UserRowMapper;
import com.urline.template.JdbcTemplate;
import com.urline.vo.UserVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserDAO {
    private static UserDAO instance;
    //유일한 인스턴스를 참조할 수 있는 자기 자신 타입에 참조형 변수
    private JdbcTemplate jdbcTemplate = null;
    //jdbcTemplate 가져오기

    public UserDAO() {
        this.jdbcTemplate = new JdbcTemplate();
    }

    public static UserDAO getInstance() {//private로 선언된 instance 참조 변수의 주소값을 얻기 위한 getter
        if (instance == null)
            instance = new UserDAO(); //참조 변수가 null인 경우에만 인스턴스화
        return instance; //참조변수값 리턴
    }

    public void insertUser(String sql, Object... args) throws Exception {
        jdbcTemplate.update(sql, args);
    }

    public void deleteUser(String sql, Object... args) throws Exception {
        jdbcTemplate.update(sql, args);
    }

    public void updateUser(String sql, Object... args) throws Exception {
        jdbcTemplate.update(sql, args);
    }
    //마이페이지에서 쓰일 것이여 ~
    public UserVO selectOneUser(String sql, Object... args) throws Exception {
        UserRowMapper urm = new UserRowMapper();//유저의 행을 mapping 형태로 가져오기 위해
        return (UserVO) jdbcTemplate.queryForObject(sql, urm, args);
    }

    /*관리자 아이디로 로그인 시, 마이페이지 버튼 대신 -> 회원 관리 버튼이 있고
    그 곳에 모든 사용자의 정보를 테이블에 보여주기위해 리스트화*/

    public List<UserVO> selectAllUser(String sql, Object... args) throws Exception {
        UserRowMapper urm = new UserRowMapper();
        return jdbcTemplate.query(sql, urm, args);
    }

    public int ID_PW_Check(String id, String pw) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String dbPW = "";
        int x = -1;

        try {
            conn = jdbcTemplate.makeConn();
            String sql = "SELECT pw,type FROM usert WHERE ID=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            /*execute VS executeQuery VS executeUpdate
            * 1. execute : 수행결과를 Boolean 타입의 값으로 반환 / 모든 구문을 수행 할 수 있다
            *   => 리턴값이 resultset일 경우에는 true, 이 외의 경우에는 false로 출력
            *   => 리턴값이 resultset 이라고 하여 resultset 객체에 결과 값을 담을 수 없다
            *
            * 2. exeuteQuery : 수행 결과를 ResultSet 객체의 값을 반환 / SELECT 구문을 수행할 때 사용되는 함수
            *   => ResultSet 객체에 결과값을 담음
            *
            * 3. executeUpdate : 수행 결과로 int 타입의 값을 반환 / SELECT 구문을 제외한 다른 구문을 수행할 때 사용
            *   => INSERT / DELETE / UPDATE 관련 구문에서는 반영된 레코드의 건수를 반환
            *   -> CREATE / DROP 관련 구문에서는 -1을 반환
            * */

            if (rs.next()) {
                dbPW = rs.getString("pw");

                if (dbPW.equals(pw)) {
                    x = rs.getInt("type");
                } else
                    x = 0;
            } else {
                x = -1;
            }

            return x;

        } catch (Exception sqle) {
            throw new RuntimeException(sqle.getMessage());
        } finally {
            closer(conn, pstmt);
        }
    }

    private void closer(Connection conn, PreparedStatement pstmt) {
        JdbcTemplate.closer(conn, pstmt);
    }

    public int confrimId(String id) { //아이디 중복확인
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int x = -1;
        try {
            conn = jdbcTemplate.makeConn();
            String sql = "SELECT * FROM usert WHERE ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                x = -1;
            } else {
                x = 1;
            }
            return x;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            closer(conn, pstmt);
        }
    }

    public Object getProperty(String id, String pr) { //pr이 뭐지? 난모르겠음
        //속성 가져올 때
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = jdbcTemplate.makeConn();
            String sql = "SELECT " + pr + " FROM usert WHERE ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            Object x = null;
            if (rs.next()) {
                if (pr.equals("name") || pr.equals("phone")||pr.equals("nickname")||pr.equals("pw"))//문자
                    x = rs.getString(1);
                else if (pr.equals("point") || pr.equals("grade") || pr.equals("sex"))//숫자
                    x = rs.getInt(1);
            }
            return x;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            closer(conn, pstmt);
        }
    }
}

```



2. USERVO.java

```java
package com.urline.vo;
//DB에 담겨져있는 것을 getter / setter 형태로 가져옴.
public class UserVO {
	private Integer userNo = null;
	private String id = null;
	private String pw = null;
	private String phone = null;
	private String nickname = null;
	private Integer point = null;
	private Integer grade = null;
	private Integer sex = null;
	private String name = null;
	private Integer type = null;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return userNo + " " + id + " " + pw + " "  + " " + phone + " " + nickname + " " + point + " " + grade;
	}

	public Integer getUserNo() {
		return userNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

}

```



3. UserRowMapper.java

```java
package com.urline.rowMapper;


import com.urline.template.RowMapper;
import com.urline.vo.UserVO;

import java.sql.ResultSet;

public class UserRowMapper implements RowMapper {
//DB에 담겨져있는 것을 rowMapper 형태로 가져온다.
	@Override
	public UserVO mapRow(ResultSet rs) throws Exception {
		UserVO vo = new UserVO();
		vo.setUserNo(rs.getInt(1));
		vo.setId(rs.getString(2));
		vo.setPw(rs.getString(3));
		vo.setPhone(rs.getString(4));
		vo.setNickname(rs.getString(5));
		vo.setPoint(rs.getInt(6));
		vo.setGrade(rs.getInt(7));
		vo.setSex(rs.getInt(8));
		vo.setName(rs.getString(9));
		vo.setType(rs.getInt(10));
		return vo;
	}

}

```
<b>comment



1. CommentDAO.java

```java
package com.urline.dao;

import com.urline.rowMapper.CommentRowMapper;
import com.urline.template.JdbcTemplate;
import com.urline.vo.CommentVO;

import java.util.List;

public class CommentDAO {
    private static CommentDAO instance;
    private JdbcTemplate jdbcTemplate = null;

    public CommentDAO() {
        this.jdbcTemplate = new JdbcTemplate();
    }

    public static CommentDAO getInstance() {
        if (instance == null)
            instance = new CommentDAO();
        return instance;
    }

    public void insertUser(String sql, Object... args) throws Exception {
        jdbcTemplate.update(sql, args);
    }

    public void deleteUser(String sql, Object... args) throws Exception {
        jdbcTemplate.update(sql, args);
    }

    public void updateUser(String sql, Object... args) throws Exception {
        jdbcTemplate.update(sql, args);
    }

    public CommentVO selectOneUser(String sql, Object... args) throws Exception {
        CommentRowMapper urm = new CommentRowMapper();
        return (CommentVO) jdbcTemplate.queryForObject(sql, urm, args);
    }

    public List<CommentVO> selectAllUser(String sql, Object... args) throws Exception {
        CommentRowMapper urm = new CommentRowMapper();
        return jdbcTemplate.query(sql, urm, args);
    }
}

```



2.CommentVO.java

```java
package com.urline.vo;

public class CommentVO {
	private Integer userNo = null;
	private Integer postNo = null;
	private Integer commentNo = null;
	private String wDate = null;
	private String contents = null;
	private Integer selected = null;
	private Integer h_hopefulPoint = null;

	public Integer getUserNo() {
		return userNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public Integer getPostNo() {
		return postNo;
	}

	public void setPostNo(Integer postNo) {
		this.postNo = postNo;
	}

	public Integer getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(Integer commentNo) {
		this.commentNo = commentNo;
	}

	public String getwDate() {
		return wDate;
	}

	public void setwDate(String wDate) {
		this.wDate = wDate;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Integer getSelected() {
		return selected;
	}

	public void setSelected(Integer selected) {
		this.selected = selected;
	}

	public Integer getH_hopefulPoint() {
		return h_hopefulPoint;
	}

	public void setH_hopefulPoint(Integer h_hopefulPoint) {
		this.h_hopefulPoint = h_hopefulPoint;
	}
}

```

3. CommentRowMapper.java

```java
package com.urline.rowMapper;

import com.urline.template.RowMapper;
import com.urline.vo.CommentVO;

import java.sql.ResultSet;

public class CommentRowMapper implements RowMapper {

	@Override
	public CommentVO mapRow(ResultSet rs) throws Exception {
		CommentVO vo = new CommentVO();
		vo.setUserNo(rs.getInt(1));
		vo.setPostNo(rs.getInt(2));
		vo.setCommentNo(rs.getInt(3));
		vo.setwDate(rs.getString(4));
		vo.setContents(rs.getString(5));
		vo.setSelected(rs.getInt(6));
		vo.setH_hopefulPoint(rs.getInt(7));
		return vo;
	}

}

```



<b>Post

1. PostingVO.java

```java
package com.urline.vo;

public class PostingVO {
	// 이 VO는 USER 테이블과 POST테이블을 JOIN한 결과 테이블에 대한 것이다.
	// 만든 이유는 게시판에 보여주기위한 데이터들이 USER와 POST에 산재되어 있기때문에 JOIN을
	// 통해 합치고 게시글에서 보여줄 필요한 데이터만 추출하기 위해서다.
	private Integer userNo = null;
	private Integer postNo = null;
	private String nickName = null;
	private Integer grade = null;
	private String title = null;
	private String region = null;
	private String postingDate = null;
	private String contents = null;
	private Integer b_hopefulPoint = null;//buyer가 희망하는 포인트
	private Integer state = null;
	private String requestTime = null;
	private String howMuch = null;

	public Integer getUserNo() {
		return userNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public Integer getPostNo() {
		return postNo;
	}

	public void setPostNo(Integer postNo) {
		this.postNo = postNo;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Integer getB_hopefulPoint() {
		return b_hopefulPoint;
	}

	public void setB_hopefulPoint(Integer b_hopefulPoint) {
		this.b_hopefulPoint = b_hopefulPoint;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public String getHowMuch() {
		return howMuch;
	}

	public void setHowMuch(String howMuch) {
		this.howMuch = howMuch;
	}

	public String getValidTime() {
		return validTime;
	}

	public void setValidTime(String validTime) {
		this.validTime = validTime;
	}

	private String validTime = null;

}

```



2. PostingDAO.java

```java
package com.urline.dao;


import com.urline.rowMapper.PostingRowMapper;
import com.urline.template.JdbcTemplate;
import com.urline.vo.PostingVO;

import java.util.List;


public class PostingDAO {
    private static PostingDAO instance;
    private JdbcTemplate jdbcTemplate = null;


    public PostingDAO() {
        this.jdbcTemplate = new JdbcTemplate();
    }

    public static PostingDAO getInstance() {
        if (instance == null)
            instance = new PostingDAO();
        return instance;
    }

    public void insertPosting(String sql, Object... args) throws Exception {
        jdbcTemplate.update(sql, args);
    }

    public void deletePosting(String sql, Object... args) throws Exception {
        jdbcTemplate.update(sql, args);
    }

    public void updatePosting(String sql, Object... args) throws Exception {
        jdbcTemplate.update(sql, args);
    }

    public PostingVO selectOnePosting(String sql, Object... args) throws Exception {
        PostingRowMapper urm = new PostingRowMapper();
        return (PostingVO) jdbcTemplate.queryForObject(sql, urm, args);
    }

    public List selectAllPosting(String sql, Object... args) throws Exception {
        PostingRowMapper urm = new PostingRowMapper();
        return jdbcTemplate.query(sql, urm, args);
    }
}

```



3. PostingRowMapper.java

```java
package com.urline.rowMapper;

import com.urline.template.RowMapper;
import com.urline.vo.PostingVO;

import java.sql.ResultSet;

public class PostingRowMapper implements RowMapper {

	@Override
	public PostingVO mapRow(ResultSet rs) throws Exception {
		//mapper을 굳이 쓰는이유는 ? : 이렇게 안 빼놓으면 객체 속성을 가져올 때 dao에 계속 써줘야함
		PostingVO vo = new PostingVO();
		vo.setUserNo(rs.getInt(1));
		vo.setPostNo(rs.getInt(2));
		vo.setNickName(rs.getString(3));
		vo.setGrade(rs.getInt(4));
		vo.setTitle(rs.getString(5));
		vo.setRegion(rs.getString(6));
		vo.setPostingDate(rs.getString(7));
		vo.setContents(rs.getString(8));
		vo.setB_hopefulPoint(rs.getInt(9));
		vo.setState(rs.getInt(10));
		vo.setRequestTime(rs.getString(11));
		vo.setHowMuch(rs.getString(12));
		return vo;
	}

}

```



<b>PayRecord

1. PayRecordDAO.java

```java
package com.urline.dao;

import com.urline.rowMapper.PayRecordRowMapper;
import com.urline.template.JdbcTemplate;
import com.urline.vo.PayRecordVO;

import java.util.List;

public class PayRecordDAO {
    private static PayRecordDAO instance;
    private JdbcTemplate jdbcTemplate = null;
//paypal 때문에 DB로 저장해줬어야했음
    public PayRecordDAO() {
        this.jdbcTemplate = new JdbcTemplate();
    }

    public static PayRecordDAO getInstance() {
        if (instance == null)
            instance = new PayRecordDAO();
        return instance;
    }

    public void insertPayRecord(String sql, Object... args) throws Exception {
        jdbcTemplate.update(sql, args);
    }

    public void deletePayRecord(String sql, Object... args) throws Exception {
        jdbcTemplate.update(sql, args);
    }

    public void updatePayRecord(String sql, Object... args) throws Exception {
        jdbcTemplate.update(sql, args);
    }

    public PayRecordVO selectOnePayRecord(String sql, Object... args) throws Exception {
        PayRecordRowMapper urm = new PayRecordRowMapper();
        return (PayRecordVO) jdbcTemplate.queryForObject(sql, urm, args);
    }

    public List<PayRecordVO> selectAllPayRecord(String sql, Object... args) throws Exception {
        PayRecordRowMapper urm = new PayRecordRowMapper();
        return jdbcTemplate.query(sql, urm, args);
    }
}

```

2. PayRecordVO.java

```java
package com.urline.vo;

public class PayRecordVO {
    private Integer userNo = null;
    private Integer payNo = null;
    private Integer payAmount = null;
    private String payDate = null;

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public Integer getPayNo() {
        return payNo;
    }

    public void setPayNo(Integer payNo) {
        this.payNo = payNo;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }
}

```

3. PayRecordRowMapper.java

```java
package com.urline.rowMapper;

import com.urline.template.RowMapper;
import com.urline.vo.PayRecordVO;

import java.sql.ResultSet;

public class PayRecordRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs) throws Exception {
        PayRecordVO vo = new PayRecordVO();
        vo.setPayNo(rs.getInt(1));
        vo.setPayAmount(rs.getInt(2));
        vo.setPayDate(rs.getString(3));
        vo.setUserNo(rs.getInt(4));
        return null;
    }
}

```




