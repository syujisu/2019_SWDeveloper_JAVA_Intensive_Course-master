<%@ page import="com.urline.dao.UserDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="EUC-KR" %>
<%
    // ���ڵ� ó��
    request.setCharacterEncoding("UTF-8");
    String ctxPath = request.getContextPath();

    // �α��� ȭ�鿡 �Էµ� ���̵�� ��й�ȣ�� �����´�
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");

    // DB���� ���̵�, ��й�ȣ Ȯ��
    UserDAO dao = UserDAO.getInstance();
    int type = dao.ID_PW_Check(id, pw);

    // URL �� �α��ΰ��� ���� �޽���
    String msg = "";

    if (type == 1 || type == 2) // �α��� ����
    {
        String nickname = (String) dao.getProperty(id,"nickname");
        String name = (String) dao.getProperty(id,"name");
        String phone = (String) dao.getProperty(id,"phone");
        Integer point = (Integer) dao.getProperty(id,"point");
        Integer grade = (Integer) dao.getProperty(id,"grade");
        Integer sex = (Integer) dao.getProperty(id,"sex");

        // ���ǿ� ���� ����� ���� ����
        session.setAttribute("userId", id);
        session.setAttribute("userType",type);//������� Ÿ�� : �Ϲݻ����(2), ������(1)
        session.setAttribute("userNickname",nickname);
        session.setAttribute("userName",name);
        session.setAttribute("userPhone",phone);
        session.setAttribute("userPoint",point);
        session.setAttribute("userGrade",grade);
        session.setAttribute("userSex",sex);
        msg = ctxPath + "/Main.jsp";
    } else if (type == 0) // ��й�ȣ�� Ʋ�����
    {
        msg = ctxPath + "/Login.jsp?msg=0";
    } else // ���̵� Ʋ�����
    {
        msg = ctxPath + "/Login.jsp?msg=-1";
    }

    // sendRedirect(String URL) : �ش� URL�� �̵�
    // URL�ڿ� get��� ó�� �����͸� ���ް���
    response.sendRedirect(msg);
%>
